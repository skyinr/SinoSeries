package games.moegirl.sinocraft.sinodivination.block;

import games.moegirl.sinocraft.sinocore.block.ILootableBlock;
import games.moegirl.sinocraft.sinocore.utility.BlockLootables;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraftforge.common.IForgeShearable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * 朱草
 */
public class ZhuCao extends Block implements IForgeShearable, ILootableBlock {

    public ZhuCao() {
        super(Properties.copy(Blocks.POPPY));
    }

    @NotNull
    @Override
    public List<ItemStack> onSheared(@Nullable Player player, @NotNull ItemStack item, Level level, BlockPos pos, int fortune) {
        return List.of(new ItemStack(this));
    }

    @Override
    public LootTable.Builder createLootBuilder(BlockLootables helper) {
        return LootTable.lootTable().withPool(LootPool.lootPool()
                // 剪刀 or 精准采集
                .when(BlockLootables.HAS_SHEARS_OR_SILK_TOUCH)
                .add(LootItem.lootTableItem(this)));
    }
}
