package io.github.jodlodi.bedsdontexplode.mixin;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.ParametersAreNonnullByDefault;

@Mixin(BedBlock.class)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class MixinBedBlock {
    @Inject(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;removeBlock(Lnet/minecraft/core/BlockPos;Z)Z", ordinal = 0), cancellable = true)
    private void explodeCancel(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result, CallbackInfoReturnable<InteractionResult> cir) {
        cir.cancel();
        player.displayClientMessage(Component.translatable("block.minecraft.bed.wrong"), true);
        cir.setReturnValue(InteractionResult.SUCCESS);
    }
}