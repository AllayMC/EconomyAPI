package org.allaymc.economyapi;

import lombok.extern.slf4j.Slf4j;
import org.allaymc.api.plugin.Plugin;

@Slf4j
public class Entrance extends Plugin {
    @Override
    public void onLoad() {
        log.info("EconomyAPI is loaded!");
    }

    @Override
    public void onEnable() {
        log.info("EconomyAPI is enabled!");
    }

    @Override
    public void onDisable() {
        log.info("EconomyAPI is disabled!");
    }
}