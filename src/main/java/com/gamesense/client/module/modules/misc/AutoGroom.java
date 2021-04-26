package com.gamesense.client.module.modules.misc;

import com.gamesense.api.util.misc.MessageBus;
import com.gamesense.client.module.Category;
import com.gamesense.client.module.Module;
import com.gamesense.api.setting.values.*;
import com.gamesense.api.setting.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraftforge.client.event.ClientChatReceivedEvent;

import java.util.Arrays;

/*
    @Author NB419
    @Since 04/22/21
 */

@Module.Declaration(name = "AutoGroom", category = Category.Misc)
public class AutoGroom extends Module {
    
    ModeSetting msgmode = registerMode("Mode", Arrays.asList("Kitten", "Princess"), "Kitten");

    @SuppressWarnings("unused")
    @EventHandler
    private final Listener<ClientChatReceivedEvent> listener = new Listener<>(event -> {
        if (event.getMessage().getUnformattedText().contains("whispers: ") && !event.getMessage().getUnformattedText().startsWith(mc.player.getName())) {
           
            if (msgmode.getValue().equalsIgnoreCase("Kitten")) {
                MessageBus.sendServerMessage("/r hi kitten :)");
            }
            else{
                MessageBus.sendServerMessage("/r hi princess <3");
            }
            
            
        }
    });

}
