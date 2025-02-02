package games.moegirl.sinocraft.sinofoundation.block;

import games.moegirl.sinocraft.sinocore.tree.Tree;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;

public class JujubeTrapdoor extends TrapDoorBlock {

    public JujubeTrapdoor(Tree tree, Properties properties) {
        super(properties, tree.getBlockSetType());
    }

    @Override
    public int getSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return state.getValue(OPEN) ? 1 : 0;
    }
}
