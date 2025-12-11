package org.allaymc.economyapi;

import lombok.extern.slf4j.Slf4j;
import org.allaymc.api.plugin.Plugin;
import org.allaymc.papi.PlaceholderAPI;

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
        registerPlaceholders();
    }

    @Override
    public void onDisable() {
        this.pluginLogger.info("EconomyAPI is disabled!");
    }

    protected void registerPlaceholders() {
        var papi = PlaceholderAPI.getAPI();
        papi.registerPlaceholder(this, "balance", (player, params) -> {
            if (player == null) {
                return "player is null";
            }

            var api = EconomyAPI.getAPI();
            var account = api.getOrCreateAccount(player.getUniqueId());
            Currency currency;
            if (params == null) {
                currency = api.getDefaultCurrency();
            } else {
                currency = api.getCurrency(params);
            }

            if (currency == null) {
                return "unknown currency: " + params;
            }

            var balance = account.getBalance(currency);
            return currency.format(balance);
        });
        papi.registerPlaceholder(this, "currency_name", (player, params) -> {
            return EconomyAPI.getAPI().getDefaultCurrency().getName();
        });
        papi.registerPlaceholder(this, "currency_plural_name", (player, params) -> {
            var api = EconomyAPI.getAPI();
            if (params == null) {
                return api.getDefaultCurrency().getPluralName();
            } else {
                var currency = api.getCurrency(params);
                if (currency == null) {
                    return "unknown currency: " + params;
                }

                return currency.getPluralName();
            }
        });
        papi.registerPlaceholder(this, "currency_symbol", (player, params) -> {
            var api = EconomyAPI.getAPI();
            if (params == null) {
                return api.getDefaultCurrency().getSymbol();
            } else {
                var currency = api.getCurrency(params);
                if (currency == null) {
                    return "unknown currency: " + params;
                }

                return currency.getSymbol();
            }
        });
    }
}