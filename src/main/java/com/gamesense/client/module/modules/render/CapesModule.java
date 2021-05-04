package com.gamesense.client.module.modules.render;

import com.gamesense.api.setting.values.ModeSetting;
import com.gamesense.client.module.Category;
import com.gamesense.client.module.Module;

import java.util.Arrays;

@Module.Declaration(name = "Capes", category = Category.Render, drawn = false)
public class CapesModule extends Module {

    //this new shit should work
    public ModeSetting capeMode = registerMode("Type", Arrays.asList("femboycock", "black", "white", "phobos", "mars", "lofi", "debian white", "debian black", "gentowo", "zane", "tux", "flushed", "boba", "nhs", "namiix", "tails"), "femboycock");
}
