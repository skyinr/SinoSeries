package games.moegirl.sinocraft.sinodivination.client.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import games.moegirl.sinocraft.sinocore.client.GLSwitcher;
import games.moegirl.sinocraft.sinocore.client.TextureMapClient;
import games.moegirl.sinocraft.sinocore.utility.texture.TextureEntry;
import games.moegirl.sinocraft.sinodivination.blockentity.SilkwormPlaqueEntity;
import games.moegirl.sinocraft.sinodivination.menu.SilkwormPlaqueMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

import static games.moegirl.sinocraft.sinodivination.menu.SilkwormPlaqueMenu.TEXTURE;

public class SilkwormPlaqueScreen extends AbstractContainerScreen<SilkwormPlaqueMenu> {

    private static final TextureMapClient CLIENT = new TextureMapClient(TEXTURE);
    private static final TextureEntry TAIL = TEXTURE.textures().ensureGet("texture_nutrition_tail");
    private static final TextureEntry BODY = TEXTURE.textures().ensureGet("texture_nutrition_body");

    public SilkwormPlaqueScreen(SilkwormPlaqueMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        TextureEntry entry = TEXTURE.textures().ensureGet("background");
        width = entry.w();
        height = entry.h();
    }

    @Override
    protected void init() {
        super.init();
        System.out.println("This is " + this.menu.entity());
        TEXTURE.points().get("title").ifPresent(p -> {
            titleLabelX = p.x();
            titleLabelY = p.y();
        });
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        CLIENT.blitTexture(graphics, "background", this);
        SilkwormPlaqueEntity entity = menu.entity();
        // 进度
        for (int i = 0; i < SilkwormPlaqueEntity.SILKWORM_COUNT; i++) {
            CLIENT.blitProgress(graphics, "progress" + i, this, entity.silkworm(i).progress());
        }
        float progress = entity.nutrition() / 100f;
        if (progress > 0) {
            GLSwitcher switcher = GLSwitcher.blend().enable();
            CLIENT.blitTexture(graphics, "texture_nutrition_tail", this);
            CLIENT.blitProgress(graphics, "nutrition_progress", this, progress);
            CLIENT.blitTexture(graphics, "texture_nutrition_head", TAIL.x(), (int) (TAIL.y() - TAIL.h() - BODY.h() * progress), this);
            switcher.resume();
        }
        renderTooltip(graphics, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(GuiGraphics graphics, int mouseX, int mouseY) {
        graphics.drawString(font, this.title, this.titleLabelX, this.titleLabelY, 0x404040);
    }
}
