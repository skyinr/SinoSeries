package games.moegirl.sinocraft.sinodivination.data;

import games.moegirl.sinocraft.sinocore.tree.Tree;
import games.moegirl.sinocraft.sinocore.tree.TreeBlockType;
import games.moegirl.sinocraft.sinodivination.SinoDivination;
import games.moegirl.sinocraft.sinodivination.block.SDBlocks;
import games.moegirl.sinocraft.sinodivination.item.SDItems;
import games.moegirl.sinocraft.sinodivination.recipe.CarvingTableRecipe;
import games.moegirl.sinocraft.sinodivination.recipe.ChangeSoupRecipe;
import games.moegirl.sinocraft.sinodivination.recipe.KettlePotRecipe;
import games.moegirl.sinocraft.sinodivination.tree.SDTrees;
import games.moegirl.sinocraft.sinofoundation.item.SFDItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

class ProviderRecipe extends RecipeProvider {

    public ProviderRecipe(DataGenerator pGenerator) {
        super(pGenerator.getPackOutput());
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        shaped(SDBlocks.KETTLE_POT, Blocks.CAULDRON)
                .pattern("Y Y")
                .pattern("ZAZ")
                .pattern("ZZZ")
                .define('A', Blocks.CAULDRON)
                .define('Y', Tags.Items.INGOTS_IRON)
                .define('Z', Tags.Items.STONE)
                .save(consumer);
        KettlePotRecipe.builder(SDItems.CHANGE_SOUP, 3)
                .input(3, Items.BONE_MEAL)
                .input(Items.EGG)
                .input(Items.FERMENTED_SPIDER_EYE)
                .save(consumer);
        KettlePotRecipe.builder(SDItems.STICK_RICE, 1)
                .input(3, SDItems.RICE)
                .input(SDItems.JUJUBE)
                .input(SDItems.WORMWOOD_LEAF)
                .save(consumer);
        ChangeSoupRecipe.builder(Blocks.BIRCH_SAPLING, SDTrees.COTINUS.getBlock(TreeBlockType.SAPLING)).save(consumer);
        ChangeSoupRecipe.builder(Blocks.OAK_SAPLING, SDTrees.JUJUBE.getBlock(TreeBlockType.SAPLING)).save(consumer);
        ChangeSoupRecipe.builder(Blocks.SPRUCE_SAPLING, SDTrees.SOPHORA.getBlock(TreeBlockType.SAPLING)).save(consumer);
        ChangeSoupRecipe.builder(Blocks.POPPY, SDBlocks.ZHU_CAO.get()).save(consumer);
        ChangeSoupRecipe.builder(Blocks.CAVE_VINES, SDBlocks.BRIGHT_STEM_GRASS.get()).save(consumer);
        addStick(SDTrees.COTINUS, SDItems.STICK_COTINUS, consumer);
        addStick(SDTrees.JUJUBE, SDItems.STICK_JUJUBE, consumer);
        addStick(SDTrees.SOPHORA, SDItems.STICK_SOPHORA, consumer);
        shaped(SDItems.HOOK, Items.STICK)
                .pattern("YY")
                .pattern("Y ")
                .pattern("Y ")
                .define('Y', Items.STICK)
                .save(consumer);
        shaped(Blocks.BLAST_FURNACE, Blocks.FURNACE)
                .pattern("YYY")
                .pattern("YXY")
                .pattern("ZZZ")
                .define('X', Blocks.FURNACE)
                .define('Y', Blocks.STONE)
                .define('Z', Blocks.SMOOTH_STONE)
                .save(consumer);
        shaped(SDBlocks.BELLOWS, Items.STICK)
                .pattern("AYY")
                .pattern("A Z")
                .pattern("AYY")
                .define('A', ItemTags.PLANKS)
                .define('Y', Items.STICK)
                .define('Z', Tags.Items.CHESTS)
                .save(consumer);
        shaped(SDBlocks.CARVING_TABLE, SFDItems.JADE.get())
                .pattern("XYX")
                .pattern("XZX")
                .pattern("AAA")
                .define('A', Tags.Items.OBSIDIAN)
                .define('X', Tags.Items.INGOTS_COPPER)
                .define('Y', SFDItems.JADE.get())
                .define('Z', Blocks.STONECUTTER)
                .save(consumer);
        shaped(SDBlocks.SILKWORM_PLAQUE, SDItems.SILKWORM_BABY.get())
                .pattern("A A")
                .pattern("AYA")
                .pattern("ZZZ")
                .define('A', Items.STICK)
                .define('Y', Items.STRING)
                .define('Z', ItemTags.PLANKS)
                .save(consumer);
        shaped(SDBlocks.ALTAR, 2, Blocks.STONE)
                .pattern("XXX")
                .pattern("YYY")
                .define('X', ItemTags.WOOL_CARPETS)
                .define('Y', Tags.Items.STONE)
                .save(consumer);
        shaped(SDBlocks.TRIPOD, Items.COPPER_INGOT)
                .pattern("Y Y")
                .pattern("YYY")
                .pattern("Z Z")
                .define('Y', Tags.Items.INGOTS_COPPER)
                .define('Z', Tags.Items.STORAGE_BLOCKS_COPPER)
                .save(consumer);
        CarvingTableRecipe.builder(SDItems.CANG_BI)
                .pattern(" XX ")
                .pattern("X  X")
                .pattern(" XX ")
                .define('X', SFDItems.JADE)
                .dye(DyeColor.BLUE)
                .save(consumer);
        CarvingTableRecipe.builder(SDItems.HUANG_CONG)
                .pattern(" X ")
                .pattern(" X ")
                .pattern("X X")
                .pattern("XXX")
                .define('X', SFDItems.JADE)
                .dye(DyeColor.GRAY)
                .save(consumer);
        CarvingTableRecipe.builder(SDItems.QING_GUI)
                .pattern(" X ")
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', SFDItems.JADE)
                .dye(DyeColor.CYAN)
                .save(consumer);
        CarvingTableRecipe.builder(SDItems.CHI_ZHANG)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', SFDItems.JADE)
                .dye(DyeColor.WHITE)
                .save(consumer);
        CarvingTableRecipe.builder(SDItems.BAI_HU)
                .pattern("XX  ")
                .pattern(" X X")
                .pattern(" XXX")
                .pattern("XX X")
                .define('X', SFDItems.JADE)
                .dye(DyeColor.RED)
                .save(consumer);
        CarvingTableRecipe.builder(SDItems.XUAN_HUANG)
                .pattern("X  X")
                .pattern("XXXX")
                .pattern(" XX ")
                .define('X', SFDItems.JADE)
                .dye(DyeColor.BLACK)
                .save(consumer);
        CarvingTableRecipe.builder(SDItems.COPPER_GOBLET)
                .pattern("XX X")
                .pattern(" XXX")
                .pattern("  X ")
                .pattern(" X X")
                .define('X', Items.COPPER_INGOT)
                .save(consumer);
        CarvingTableRecipe.builder(SDItems.COPPER_DAGGER_AXE)
                .pattern("X   ")
                .pattern("XXXX")
                .pattern("XX  ")
                .pattern("X   ")
                .define('X', Items.COPPER_INGOT)
                .save(consumer);
        CarvingTableRecipe.builder(SDItems.COPPER_MIRROR)
                .pattern(" XX ")
                .pattern("XXXX")
                .pattern("XXXX")
                .pattern(" XX ")
                .define('X', Items.COPPER_INGOT)
                .save(consumer);
        CarvingTableRecipe.builder(SDItems.COPPER_MASK)
                .pattern("XXX ")
                .pattern(" X  ")
                .pattern("XXX ")
                .pattern("X X ")
                .define('X', Items.COPPER_INGOT)
                .save(consumer);
        CarvingTableRecipe.builder(SDItems.COPPER_LAMP)
                .pattern(" XX ")
                .pattern("X  X")
                .pattern("XXXX")
                .define('X', Items.COPPER_INGOT)
                .save(consumer);
        CarvingTableRecipe.builder(SDItems.COPPER_BEAST)
                .pattern("XX  ")
                .pattern(" X X")
                .pattern(" XXX")
                .pattern("XX X")
                .define('X', Items.COPPER_INGOT)
                .save(consumer);
    }

    private ShapedRecipeBuilder shaped(RegistryObject<? extends ItemLike> result, ItemLike unlockedBy) {
        return shaped(result.get(), unlockedBy);
    }

    private ShapedRecipeBuilder shaped(ItemLike result, ItemLike unlockedBy) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result)
                .group(SinoDivination.MODID)
                .unlockedBy("has_block", has(unlockedBy));
    }

    private ShapedRecipeBuilder shaped(RegistryObject<? extends ItemLike> result, int count, ItemLike unlockedBy) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.get(), count)
                .group(SinoDivination.MODID)
                .unlockedBy("has_block", has(unlockedBy));
    }

    private ShapelessRecipeBuilder shapeless(ItemLike result, int count, RegistryObject<? extends ItemLike> unlockedBy) {
        return ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result, count)
                .group(SinoDivination.MODID)
                .unlockedBy("has_block", has(unlockedBy.get()));
    }

    private <T extends Item> void addStick(Tree tree, RegistryObject<T> stick, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, stick.get())
                .group(SinoDivination.MODID)
                .pattern("X")
                .pattern("Y")
                .pattern("X")
                .define('X', tree.getItem(TreeBlockType.PLANKS))
                .define('Y', Items.STICK)
                .unlockedBy("has_block", has(tree.getBlock(TreeBlockType.PLANKS)))
                .save(pFinishedRecipeConsumer);
    }
}
