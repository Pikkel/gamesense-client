package com.gamesense.client.module.modules.misc;

import com.gamesense.client.module.Category;
import com.gamesense.client.module.Module;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;

import java.util.Random;

@Module.Declaration(name = "Funny", category = Category.Misc)
public class Funny extends Module {

    private final Random random = new Random();

    public void onEnable() {
        EntityPlayerSP player = mc.player;
        WorldClient world = mc.world;

        if (player == null || mc.world == null) return;

        ItemStack itemStack = player.getHeldItemMainhand();

        if (itemStack.isEmpty()) {
            setDisabledMessage("You need to hold an item in hand to dupe!");
            disable();
            return;
        }

        int count = random.nextInt(50000) + 60;

        for (int i = 0; i <= count; i++) {
            EntityItem entityItem = player.dropItem(itemStack.copy(), false, true);
            if (entityItem != null) world.addEntityToWorld(entityItem.entityId, entityItem);
        }

        int total = count * itemStack.getCount();
        disable();
    }
}
// ____ ___ _  ___  _______ _
//|  _ \_ _| |/ / |/ / ____| |
//| |_) | || ' /| ' /|  _| | |
//|  __/| || . \| . \| |___| |___
//|_|  |___|_|\_\_|\_\_____|_____|
//100% not skidded code
