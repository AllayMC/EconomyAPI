package org.allaymc.economyapi;

import lombok.extern.slf4j.Slf4j;
import org.allaymc.api.plugin.Plugin;

@Slf4j
public class Entrance extends Plugin {

    public static Entrance instance;

    {
        instance = this;
    }

    @Override
    public void onLoad() {
        this.pluginLogger.info("EconomyAPI is loaded!");
    }

    @Override
    public void onEnable() {
        this.pluginLogger.info("EconomyAPI is enabled!");
    }

    @Override
    public void onDisable() {
        this.pluginLogger.info("EconomyAPI is disabled!");
    }
}