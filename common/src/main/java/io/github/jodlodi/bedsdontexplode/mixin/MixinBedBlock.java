package io.github.jodlodi.bedsdontexplode.mixin;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.NonNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BedBlock.class)
@MethodsReturnNonnullByDefault
public class MixinBedBlock {
    @Inject(method = "useWithoutItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;removeBlock(Lnet/minecraft/core/BlockPos;Z)Z", ordinal = 0), cancellable = true)
    private void explodeCancel(BlockState state, Level level, BlockPos pos, @NonNull Player player, BlockHitResult result, @NonNull CallbackInfoReturnable<InteractionResult> cir) {
        cir.cancel();
        player.sendOverlayMessage(Component.translatable("block.minecraft.bed.wrong"));
        cir.setReturnValue(InteractionResult.SUCCESS_SERVER);
    }
}