package io.github.jodlodi.bedsdontexplode;


import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class BedsDontExplode {

    public BedsDontExplode() {

        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.

        // Use NeoForge to bootstrap the Common mod.
        CommonClass.init();

    }
}