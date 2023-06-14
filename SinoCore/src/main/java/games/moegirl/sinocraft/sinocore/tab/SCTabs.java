package games.moegirl.sinocraft.sinocore.tab;

import games.moegirl.sinocraft.sinocore.SinoCore;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luqin2007
 */
public class SCTabs {

    private static final Map<ResourceLocation, TabItemGenerator> GENERATORS = new HashMap<>();

    /**
     * 要添加物品从这里拿 TabItemGenerator
     * @param tab tab
     * @return TabItemGenerator
     */
    public static TabItemGenerator items(RegistryObject<CreativeModeTab> tab) {
        return GENERATORS.get(tab.getId());
    }

    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SinoCore.MODID);

    public static final RegistryObject<CreativeModeTab> CORE = tab("sinocore", "tab");

    // =================================================================================================================

    public static RegistryObject<CreativeModeTab> tab(String name, String langKey) {
        TabItemGenerator generator = new TabItemGenerator();
        RegistryObject<CreativeModeTab> object = REGISTRY.register(name, () -> CreativeModeTab.builder()
                .title(Component.translatable(langKey))
                .displayItems(generator)
                .icon(generator::displayItem)
                .build());
        GENERATORS.put(object.getId(), generator);
        return object;
    }

    public static void register(IEventBus bus) {
        REGISTRY.register(bus);
    }
}
