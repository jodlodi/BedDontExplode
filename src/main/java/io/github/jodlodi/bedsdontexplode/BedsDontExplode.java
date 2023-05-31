package io.github.jodlodi.bedsdontexplode;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(BedsDontExplode.MOD_ID)
public class BedsDontExplode
{
    public static final String MOD_ID = "bedsdontexplode";

    public BedsDontExplode() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}