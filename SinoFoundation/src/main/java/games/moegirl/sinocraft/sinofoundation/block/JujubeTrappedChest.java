package games.moegirl.sinocraft.sinofoundation.block;

import games.moegirl.sinocraft.sinocore.block.TrappedChestBlockBase;
import games.moegirl.sinocraft.sinofoundation.SFDTrees;
import games.moegirl.sinocraft.sinofoundation.block.entity.SFDBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraft.world.phys.BlockHitResult;

public class JujubeTrappedChest extends TrappedChestBlockBase {

    public JujubeTrappedChest() {
        super(SFDBlockEntities.JUJUBE_TRAPPED_CHEST, SFDTrees.JUJUBE.name);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (noSignal(pState, pLevel, pPos)) {
            return InteractionResult.CONSUME;
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    private boolean noSignal(BlockState pState, Level pLevel, BlockPos pPos) {
        if (pLevel.hasNeighborSignal(pPos)) {
            return false;
        }
        ChestType value = pState.getValue(TYPE);
        Direction direction = pState.getValue(FACING);
        if (value == ChestType.LEFT) {
            return !pLevel.hasNeighborSignal(pPos.relative(direction.getClockWise()));
        } else if (value == ChestType.RIGHT) {
            return !pLevel.hasNeighborSignal(pPos.relative(direction.getCounterClockWise()));
        }
        return true;
    }
}
