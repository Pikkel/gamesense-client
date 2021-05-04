//ngl, I should make this have options

package com.gamesense.client.module.modules.misc;

import java.util.ArrayList;
import java.util.List;

import com.gamesense.api.util.misc.MessageBus;
import com.gamesense.client.module.Category;
import com.gamesense.client.module.Module;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

/**
 * A module that sends a message to a player when they come into render distance
 * 
 * @author JetbladeDevsStuff
 */

@Module.Declaration(name = "AutoGroom", category = Category.Misc)
public class AutoGroom extends Module {
    public String msg = "♥ hey kitten ♥";
    private List<EntityPlayer> lastTickPlayers;

    @Override
    public void onUpdate() {
        List<EntityPlayer> thisTickPlayers = collectPlayersInRenderDistance();

        // see if there are any new players this tick
        List<EntityPlayer> newPlayers = new ArrayList<>();
        for (EntityPlayer e : thisTickPlayers) {
            if (!lastTickPlayers.contains(e)) {
                // if the last tick doesnt have this player
                newPlayers.add(e);
            }
        }

        for (EntityPlayer e : newPlayers) {
            MessageBus.sendServerMessage("/msg " + msg);
        }

        lastTickPlayers = thisTickPlayers;
    }

    /**
     * A helper function to get any players in render distance
     * 
     * @return the players in render distance
     */
    private List<EntityPlayer> collectPlayersInRenderDistance() {
        List<Entity> entities = mc.world.loadedEntityList;
        List<EntityPlayer> players = new ArrayList<>();
        for (Entity e : entities) {
            if (e instanceof EntityPlayer) {
                players.add((EntityPlayer) e);
            }
        }

        return players;
    }
}
