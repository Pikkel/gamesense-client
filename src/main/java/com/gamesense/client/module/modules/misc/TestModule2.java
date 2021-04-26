package com.gamesense.client.module.modules.misc;

import com.gamesense.api.setting.values.BooleanSetting;
import com.gamesense.api.setting.values.IntegerSetting;
import com.gamesense.api.util.misc.MessageBus;
import com.gamesense.client.module.Category;
import com.gamesense.client.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;

import java.text.DecimalFormat;

@Module.Declaration(name = "TestModule2", category = Category.Misc)
public class TestModule2 extends Module {

    public void onEnable() {
        MessageBus.sendServerMessage("I'm gay and I love sucking cock");
        disable();
    }
}
