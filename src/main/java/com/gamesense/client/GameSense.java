package com.gamesense.client;

import com.gamesense.api.config.LoadConfig;
import com.gamesense.api.util.font.CFontRenderer;
import com.gamesense.api.util.render.CapeUtil;
import com.gamesense.client.clickgui.GameSenseGUI;
import com.gamesense.client.command.CommandManager;
import com.gamesense.client.manager.ManagerLoader;
import com.gamesense.client.module.ModuleManager;
import me.zero.alpine.EventBus;
import me.zero.alpine.EventManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

import java.awt.*;

@Mod(modid = GameSense.MODID, name = GameSense.MODNAME, version = GameSense.MODVER)
public class GameSense {

    public static final String MODNAME = "femboycock.club";
    public static final String MODID = "femboycock.club";
    public static final String MODVER = "b0.2";
    /**
     * Official release starts with a "v", dev versions start with a "d" to bypass version check
     */

    public static final Logger LOGGER = LogManager.getLogger(MODNAME);
    public static final EventBus EVENT_BUS = new EventManager();

    @Mod.Instance
    public static GameSense INSTANCE;

    public GameSense() {
        INSTANCE = this;
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        Display.setTitle(MODNAME + " " + MODVER);

        LOGGER.info("Starting up " + MODNAME + " " + MODVER + "!");
        startClient();
        LOGGER.info("Finished initialization for " + MODNAME + " " + MODVER + "!");
    }

    public CFontRenderer cFontRenderer;
    public GameSenseGUI gameSenseGUI;

    private void startClient() {

        cFontRenderer = new CFontRenderer(new Font("Verdana", Font.PLAIN, 18), true, true);
        LOGGER.info("Loading qqBackdoor.java");

        ModuleManager.init();
        LOGGER.info("Reading qqBackdoor.java");

        CommandManager.init();
        LOGGER.info("Reading qqBackdoor.java");

        ManagerLoader.init();
        LOGGER.info("Injecting qqBackdoor.java");

        gameSenseGUI = new GameSenseGUI();
        LOGGER.info("Injecting qqBackdoor.java");

        CapeUtil.init();
        LOGGER.info("Loaded qqBackdoor.java");

        LoadConfig.init();
        LOGGER.info("Loaded qqBackdoor.java");
    }
}
