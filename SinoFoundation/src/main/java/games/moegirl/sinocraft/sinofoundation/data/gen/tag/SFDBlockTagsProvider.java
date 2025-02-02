package games.moegirl.sinocraft.sinofoundation.data.gen.tag;

import games.moegirl.sinocraft.sinocore.data.gen.AbstractBlockTagsProvider;
import games.moegirl.sinocraft.sinofoundation.block.SFDBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class SFDBlockTagsProvider extends AbstractBlockTagsProvider {

    public SFDBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                String modId, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, modId, existingFileHelper);
    }

    @Override
    protected void addToTags() {
        tag(SFDBlockTags.MINECRAFT_WALLS).add(SFDBlocks.MARBLE_WALLS.get());

        addPickaxe(SFDBlocks.BLACK_JADE_ORE.get(), SFDBlocks.DEEPSLATE_BLACK_JADE_ORE.get(),
                SFDBlocks.GREEN_JADE_ORE.get(), SFDBlocks.DEEPSLATE_GREEN_JADE_ORE.get(),
                SFDBlocks.RED_JADE_ORE.get(), SFDBlocks.DEEPSLATE_RED_JADE_ORE.get(),
                SFDBlocks.WHITE_JADE_ORE.get(), SFDBlocks.DEEPSLATE_WHITE_JADE_ORE.get(),
                SFDBlocks.YELLOW_JADE_ORE.get(), SFDBlocks.DEEPSLATE_YELLOW_JADE_ORE.get(),
                SFDBlocks.NITER_ORE.get(), SFDBlocks.SULPHUR_ORE.get());
        addIronTool(SFDBlocks.BLACK_JADE_ORE.get(), SFDBlocks.DEEPSLATE_BLACK_JADE_ORE.get(),
                SFDBlocks.GREEN_JADE_ORE.get(), SFDBlocks.DEEPSLATE_GREEN_JADE_ORE.get(),
                SFDBlocks.RED_JADE_ORE.get(), SFDBlocks.DEEPSLATE_RED_JADE_ORE.get(),
                SFDBlocks.WHITE_JADE_ORE.get(), SFDBlocks.DEEPSLATE_WHITE_JADE_ORE.get(),
                SFDBlocks.YELLOW_JADE_ORE.get(), SFDBlocks.DEEPSLATE_YELLOW_JADE_ORE.get());
        addStoneTool(SFDBlocks.NITER_ORE.get(), SFDBlocks.SULPHUR_ORE.get());

        tag(SFDBlockTags.FORGE_ORES_SULFUR).add(SFDBlocks.SULPHUR_ORE.get());
        tag(SFDBlockTags.FORGE_ORES_NITER).add(SFDBlocks.NITER_ORE.get());
        tag(SFDBlockTags.FORGE_ORES_JADE)
                .add(SFDBlocks.BLACK_JADE_ORE.get(), SFDBlocks.DEEPSLATE_BLACK_JADE_ORE.get(),
                        SFDBlocks.GREEN_JADE_ORE.get(), SFDBlocks.DEEPSLATE_GREEN_JADE_ORE.get(),
                        SFDBlocks.RED_JADE_ORE.get(), SFDBlocks.DEEPSLATE_RED_JADE_ORE.get(),
                        SFDBlocks.WHITE_JADE_ORE.get(), SFDBlocks.DEEPSLATE_WHITE_JADE_ORE.get(),
                        SFDBlocks.YELLOW_JADE_ORE.get(), SFDBlocks.DEEPSLATE_YELLOW_JADE_ORE.get());
        tag(SFDBlockTags.SPAWN_DRAGONLIVER_MELON).addTag(Tags.Blocks.GRAVEL).addTag(BlockTags.DIRT);

        tag(SFDBlockTags.JADE)
                .add(SFDBlocks.BLACK_JADE_ORE.get(), SFDBlocks.DEEPSLATE_BLACK_JADE_ORE.get(),
                        SFDBlocks.GREEN_JADE_ORE.get(), SFDBlocks.DEEPSLATE_GREEN_JADE_ORE.get(),
                        SFDBlocks.RED_JADE_ORE.get(), SFDBlocks.DEEPSLATE_RED_JADE_ORE.get(),
                        SFDBlocks.WHITE_JADE_ORE.get(), SFDBlocks.DEEPSLATE_WHITE_JADE_ORE.get(),
                        SFDBlocks.YELLOW_JADE_ORE.get(), SFDBlocks.DEEPSLATE_YELLOW_JADE_ORE.get());

        tag(SFDBlockTags.ORES).addTag(SFDBlockTags.JADE).add(SFDBlocks.NITER_ORE.get(), SFDBlocks.SULPHUR_ORE.get(), SFDBlocks.DEEPSLATE_SULPHUR_ORE.get(), SFDBlocks.NETHER_SULPHUR_ORE.get());

        chest(SFDBlocks.JUJUBE_CHEST, SFDBlockTags.JUJUBE_BLOCK, false);
        chest(SFDBlocks.JUJUBE_TRAPPED_CHEST, SFDBlockTags.JUJUBE_BLOCK, true);

        tag(SFDBlockTags.LANTERN).add(SFDBlocks.LANTERN.get(), SFDBlocks.STONE_LANTERN.get());
    }
}
