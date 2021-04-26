package com.gamesense.client.module.modules.misc;

import java.util.Random;
import java.util.ArrayList;
import com.gamesense.client.module.Category;
import com.gamesense.api.setting.Setting;
import com.gamesense.client.module.Module;
import com.gamesense.api.util.misc.MessageBus;
import com.gamesense.api.setting.values.BooleanSetting;
import com.gamesense.api.setting.values.IntegerSetting;

/*
    @Author NB419
    @Since 04/22/21
 */

@Module.Declaration(name = "TestModule", category = Category.Misc)
public class TestModule extends Module {

    IntegerSetting range = registerInteger("Range", 10, 1, 10);
    BooleanSetting punctuate = registerBoolean("Punctuate", false);
    
     public void onEnable() {
        final ArrayList<String> msg = new ArrayList<String>();
        msg.add("0");
        msg.add("1");
        msg.add("2");
        msg.add("3");
        msg.add("4");
        msg.add("5");
        msg.add("6");
        msg.add("7");
        msg.add("8");
        msg.add("9");
         
         
            if (punctuate.getValue()) {
                MessageBus.sendServerMessage(msg.get(new Random().nextInt(range.getValue()) + 0) + "!");
            }
            else {
                MessageBus.sendServerMessage(msg.get(new Random().nextInt(range.getValue()) + 0));
            }
         
            this.disable();
        
    }
    
}
