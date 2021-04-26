package com.gamesense.client.module.modules.render;

//I'm going to kill myself
import com.gamesense.api.setting.values.ModeSetting;
import com.gamesense.client.module.Category;
import com.gamesense.client.module.Module;

import java.util.Arrays;

@Module.Declaration(name = "Capes", category = Category.Render, drawn = false)
public class CapesModule extends Module {

    public ModeSetting capeMode = registerMode("Type", Arrays.asList("black", "white", "phobos", "mars"), "black");
}
