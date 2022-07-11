package io.github.jodlodi.bedsdontexplode;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class ASMHooks {
    /**
     * Injection Point:<br>
     * {@link BedBlock#use(BlockState, Level, BlockPos, Player, InteractionHand, BlockHitResult)}<br>
     * [AFTER INVOKEVIRTUAL {@link Level#removeBlock(BlockPos, boolean)}]
     */
    public static void cantuse() {
        BedsDontExplode.LOGGER.error("ASM WORKS");
    }
}
