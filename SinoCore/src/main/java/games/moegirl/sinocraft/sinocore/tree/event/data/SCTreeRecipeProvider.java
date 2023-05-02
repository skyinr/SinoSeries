package games.moegirl.sinocraft.sinocore.tree.event.data;

import games.moegirl.sinocraft.sinocore.tree.Tree;
import games.moegirl.sinocraft.sinocore.tree.TreeBlockType;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;

import java.util.List;
import java.util.function.Consumer;

public class SCTreeRecipeProvider extends RecipeProvider {
    protected final List<Tree> treeTypes;

    public SCTreeRecipeProvider(PackOutput output, List<Tree> treeTypes) {
        super(output);

        this.treeTypes = treeTypes;
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> writer) {
        for (var tree : treeTypes) {
            planksFromLog(writer, tree.getItem(TreeBlockType.PLANKS), ItemTags.create(tree.getDefaultLogTag()), 4);
            woodFromLogs(writer, tree.getBlock(TreeBlockType.LOG_WOOD), tree.getBlock(TreeBlockType.LOG));
            woodFromLogs(writer, tree.getBlock(TreeBlockType.STRIPPED_LOG_WOOD), tree.getBlock(TreeBlockType.STRIPPED_LOG));
            // woodenBoat(writer, tree.getItem(TreeBlockType.BOAT), tree.getItem(TreeBlockType.PLANKS));
            // chestBoat(writer, tree.getItem(TreeBlockType.CHEST_BOAT), tree.getItem(TreeBlockType.BOAT));

            var family = new BlockFamily.Builder(tree.getBlock(TreeBlockType.PLANKS))
                    .stairs(tree.getBlock(TreeBlockType.STAIRS))
                    .slab(tree.getBlock(TreeBlockType.SLAB))
                    .sign(tree.getBlock(TreeBlockType.SIGN), tree.getBlock(TreeBlockType.WALL_SIGN))
                    .button(tree.getBlock(TreeBlockType.BUTTON))
                    .pressurePlate(tree.getBlock(TreeBlockType.PRESSURE_PLATE))
                    .fence(tree.getBlock(TreeBlockType.FENCE))
                    .fenceGate(tree.getBlock(TreeBlockType.FENCE_GATE))
                    .door(tree.getBlock(TreeBlockType.DOOR))
                    .trapdoor(tree.getBlock(TreeBlockType.TRAPDOOR))
                    .recipeGroupPrefix("wooden")
                    .recipeUnlockedBy("has_planks")
                    .dontGenerateModel()
                    .getFamily();
            generateRecipes(writer, family);
        }
    }
}
