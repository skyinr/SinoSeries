package games.moegirl.sinocraft.sinocore.utility.texture;

import com.electronwill.nightconfig.core.CommentedConfig;
import com.electronwill.nightconfig.core.Config;
import com.electronwill.nightconfig.toml.TomlParser;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.fml.ModList;
import org.apache.commons.lang3.ArrayUtils;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class TextureParser {

    private static final Map<ResourceLocation, TextureMap> MAPS = new HashMap<>();
    private static final List<ResourceLocation> NAMES = new ArrayList<>();

    public static List<ResourceLocation> names() {
        return List.copyOf(NAMES);
    }

    public static TextureMap get(ResourceLocation name) {
        return MAPS.get(name);
    }

    public static TextureMap parse(ResourceLocation texture) {
        TextureMap map = new TextureMap(texture);
        reload(map);
        MAPS.put(texture, map);
        NAMES.add(texture);
        return map;
    }

    public static void reload(TextureMap m) {
        ResourceLocation texture = m.texture();
        String modid = texture.getNamespace();
        String texPath = texture.getPath();
        String texName = texPath.substring(0, texPath.length() - 3) + "toml";
        String[] paths = ArrayUtils.insert(0, texName.split("/"), "assets", modid);
        Path toml = ModList.get().getModFileById(modid).getFile().findResource(paths);
        try (InputStream reader = Files.newInputStream(toml)) {
            CommentedConfig config = new TomlParser().parse(reader);
            int width = config.getIntOrElse("width", 256);
            int height = config.getIntOrElse("height", 256);
            List<PointEntry> points = new ArrayList<>();
            Map<String, PointEntry> pointMap = new HashMap<>();
            List<TextEntry> texts = new ArrayList<>();
            Map<String, TextEntry> textMap = new HashMap<>();
            List<TextureEntry> textures = new ArrayList<>();
            Map<String, TextureEntry> textureMap = new HashMap<>();
            List<SlotEntry> slot = new ArrayList<>();
            Map<String, SlotEntry> slotMap = new HashMap<>();
            List<SlotsEntry> slots = new ArrayList<>();
            Map<String, SlotsEntry> slotsMap = new HashMap<>();
            List<ProgressEntry> progress = new ArrayList<>();
            Map<String, ProgressEntry> progressMap = new HashMap<>();
            List<ButtonEntry> buttons = new ArrayList<>();
            Map<String, ButtonEntry> buttonMap = new HashMap<>();
            List<EditBoxEntry> editBoxes = new ArrayList<>();
            Map<String, EditBoxEntry> editBoxMap = new HashMap<>();
            for (CommentedConfig.Entry entry : config.entrySet()) {
                String name = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof List<?> list) {
                    buildPoint(name, list, points, pointMap);
                } else if (value instanceof Config map) {
                    switch (((String) map.get("type")).toLowerCase(Locale.ROOT)) {
                        case "point" -> buildPoint(name, map, points, pointMap);
                        case "text" -> buildText(name, map, texts, textMap);
                        case "texture" -> buildTexture(name, map, textures, textureMap);
                        case "slot" -> buildSlot(name, map, slot, slotMap);
                        case "slots" -> buildSlots(name, map, slots, slotsMap);
                        case "progress" -> buildProgress(name, map, progress, progressMap);
                        case "button" -> buildButton(name, map, buttons, buttonMap);
                        case "editbox" -> buildEditBox(name, map, editBoxes, editBoxMap);
                    }
                }
            }
            m.width = width;
            m.height = height;
            m.points().set(points, pointMap);
            m.texts().set(texts, textMap);
            m.textures().set(textures, textureMap);
            m.slot().set(slot, slotMap);
            m.slots().set(slots, slotsMap);
            m.progress().set(progress, progressMap);
            m.buttons().set(buttons, buttonMap);
            m.editBoxes().set(editBoxes, editBoxMap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void buildEditBox(String name, Config data, List<EditBoxEntry> editBoxes, Map<String, EditBoxEntry> editBoxMap) {
        int[] p = getPoint(data, "position");
        int[] size = getPoint(data, "size");
        String title = getString(data, "title");
        String hint = getString(data, "hint");
        int maxLength = getInt(data, "max_length", 32);
        String suggestion = getString(data, "suggestion");
        String defVal = getString(data, "default", "");
        int color = getInt(data, "color", 0xE0E0E0);
        int uneditableColor = getInt(data, "color_uneditable", 0xE0E0E0);
        int fgColor = getInt(data, "color_fg", -1);
        float alpha = getFloat(data, "alpha", 0, 1, 1);
        String tooltip = getString(data, "tooltip");
        boolean bordered = getBoolean(data, "bordered", true);
        EditBoxEntry entry = new EditBoxEntry(name, p[0], p[1], size[0], size[1], title, hint, maxLength, suggestion,
                defVal, color, uneditableColor, fgColor, alpha, tooltip, bordered);
        editBoxes.add(entry);
        editBoxMap.put(name, entry);
    }

    private static void buildButton(String name, Config data, List<ButtonEntry> buttons, Map<String, ButtonEntry> buttonsMap) {
        int[] position = getPoint(data, "position");
        int[] size = getPoint(data, "size");
        List<String> texture = getStrings(data, "texture");
        List<String> textureHover = getStrings(data, "texture_hover", texture);
        List<String> texturePressed = getStrings(data, "texture_pressed", textureHover);
        List<String> textureDisable = getStrings(data, "texture_disable", texture);
        String tooltip = getString(data, "tooltip");
        ButtonEntry entry = new ButtonEntry(name, position[0], position[1], size[0], size[1], texture, textureHover, texturePressed, textureDisable, tooltip);
        buttons.add(entry);
        buttonsMap.put(name, entry);
    }

    private static void buildProgress(String name, Config data, List<ProgressEntry> progress, Map<String, ProgressEntry> progressMap) {
        int[] position = getPoint(data, "position");
        String texture = getString(data, "texture");
        String textureFilled = data.get("texture_filled");
        boolean isVertical, isOpposite;
        if (data.contains("direction")) {
            String direction = ((String) data.get("direction")).trim().toLowerCase(Locale.ROOT);
            isVertical = direction.endsWith("vertical");
            isOpposite = direction.startsWith("-");
        } else {
            isVertical = false;
            isOpposite = false;
        }
        ProgressEntry entry = new ProgressEntry(name, position[0], position[1], texture, textureFilled, isVertical, isOpposite);
        progress.add(entry);
        progressMap.put(name, entry);
    }

    private static void buildSlots(String name, Config data, List<SlotsEntry> slots, Map<String, SlotsEntry> slotsMap) {
        boolean isVertical = "vertical".equals(data.get("direction"));
        int size = getInt(data, "size", 18);
        int[] count = getPoint(data, "count", 1, isVertical);
        int[] position = getPoint(data, "position");
        int[] offset = getPoint(data, "offset", 0, !isVertical);
        List<SlotEntry> s = new ArrayList<>(count[0] * count[1]);
        for (int x = 0; x < count[0]; x++) {
            for (int y = 0; y < count[1]; y++) {
                SlotEntry entry = new SlotEntry(name, size,
                        position[0] + y * size + y * offset[0],
                        position[1] + x * size + x * offset[1]);
                s.add(entry);
            }
        }
        SlotsEntry entry = new SlotsEntry(name, List.copyOf(s));
        slots.add(entry);
        slotsMap.put(name, entry);
    }

    private static void buildSlot(String name, Config data, List<SlotEntry> slot, Map<String, SlotEntry> slotMap) {
        int size = getInt(data, "size", 18);
        int[] position = getPoint(data, "position");
        SlotEntry entry = new SlotEntry(name, size, position[0], position[1]);
        slot.add(entry);
        slotMap.put(name, entry);
    }

    private static void buildTexture(String name, Config data, List<TextureEntry> textures, Map<String, TextureEntry> textureMap) {
        int[] size = getPoint(data, "size");
        int[] uvSize = getPoint(data, "uv_size", size);
        int[] uv = getPoint(data, "uv", new int[]{0, 0});
        int[] position = getPoint(data, "position", uv);
        TextureEntry entry = new TextureEntry(name, position[0], position[1], size[0], size[1], uv[0], uv[1], uvSize[0], uvSize[1]);
        textures.add(entry);
        textureMap.put(name, entry);
    }

    private static void buildText(String name, Config data, List<TextEntry> texts, Map<String, TextEntry> textMap) {
        String text = getString(data, "text");
        String rawText = getString(data, "rawText");
        int[] position = getPoint(data, "position");
        int color = getInt(data, "color", 0x808080);
        boolean shadow = getBool(data, "shadow");
        boolean center = getBool(data, "center");
        TextEntry entry = new TextEntry(name, position[0], position[1], color, text, rawText, shadow, center);
        texts.add(entry);
        textMap.put(name, entry);
    }

    private static void buildPoint(String name, Config data, List<PointEntry> points, Map<String, PointEntry> pointMap) {
        buildPoint(name, (List<?>) data.get("position"), points, pointMap);
    }

    private static void buildPoint(String name, List<?> data, List<PointEntry> points, Map<String, PointEntry> pointMap) {
        PointEntry entry = new PointEntry(name, (int) data.get(0), (int) data.get(1));
        points.add(entry);
        pointMap.put(name, entry);
    }

    private static int[] getPoint(Config data, String name, int[] defaultValue) {
        return data.contains(name) ? getPoint(data, name) : defaultValue;
    }

    private static int[] getPoint(Config data, String name) {
        List<?> list = data.get(name);
        return new int[]{(int) list.get(0), (int) list.get(1)};
    }

    private static int[] getPoint(Config data, String name, int defaultValue, boolean vertical) {
        Object obj = data.get(name);
        if (obj instanceof Integer i) {
            return vertical ? new int[]{i, defaultValue} : new int[]{defaultValue, i};
        } else if (obj instanceof List<?>) {
            return getPoint(data, name);
        } else {
            return new int[]{defaultValue, defaultValue};
        }
    }

    private static int getInt(Config data, String name, int defaultValue) {
        return data.get(name) instanceof Integer i ? i : defaultValue;
    }

    private static boolean getBool(Config data, String name) {
        return data.get(name) instanceof Boolean b ? b : false;
    }

    @Nullable
    private static String getString(Config data, String name) {
        return (data.get(name) instanceof String s && !s.isEmpty()) ? s : null;
    }

    @Nullable
    private static String getString(Config data, String name, @Nullable String defaultValue) {
        return (data.get(name) instanceof String s && !s.isEmpty()) ? s : defaultValue;
    }

    private static List<String> getStrings(Config data, String name, List<String> defaultValue) {
        Object o = data.get(name);
        if (o instanceof List<?> lst) {
            List<String> ss = new ArrayList<>(lst.size());
            for (int i = lst.size() - 1; i >= 0; i--) {
                ss.add(String.valueOf(lst.get(i)));
            }
            return Collections.unmodifiableList(ss);
        } else if (o instanceof String str) return List.of(str);
        else return List.copyOf(defaultValue);
    }

    private static List<String> getStrings(Config data, String name) {
        return getStrings(data, name, List.of());
    }

    private static float getFloat(Config data, String name, float min, float max, float defaultValue) {
        return Mth.clamp(data.get(name) instanceof Double db ? ((float) db.doubleValue()) : defaultValue, min, max);
    }

    private static boolean getBoolean(Config data, String name, boolean defaultValue) {
        return data.get(name) instanceof Boolean b ? b : defaultValue;
    }
}
