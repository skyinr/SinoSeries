package games.moegirl.sinocraft.sinocore.mixins.mixin;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockEntityType.class)
public abstract class BlockEntityTypeMixin {

    @Inject(at = @At("HEAD"), method = "isValid", cancellable = true)
    private void sino$beforeIsValid(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        //noinspection DataFlowIssue
        if (BlockEntityType.getKey((BlockEntityType<?>) (Object) this)
                .equals(new ResourceLocation("minecraft", "sign"))) {
            if (state.getBlock() instanceof SignBlock) {
                cir.setReturnValue(true);
            }
        }
    }
}
