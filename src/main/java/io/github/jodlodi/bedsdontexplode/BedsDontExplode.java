package io.github.jodlodi.bedsdontexplode;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(BedsDontExplode.MOD_ID)
public class BedsDontExplode
{
    public static final String MOD_ID = "bedsdontexplode";
    public static final Logger LOGGER = LogUtils.getLogger();

    public BedsDontExplode() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
    }
}