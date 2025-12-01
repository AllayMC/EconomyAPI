package org.allaymc.economyapi;

import org.allaymc.api.AllayAPI;
import org.allaymc.economyapi.event.AccountDeleteEvent;

import java.util.Set;
import java.util.UUID;

/**
 * The EconomyAPI serves as the primary interface for interacting with the economy system.
 * It provides methods for managing currencies, accounts, and performing operations
 * such as account creation, deletion.
 *
 * @author daoge_cmd
 */
public interface EconomyAPI {

    /**
     * Holds the singleton instance of the {@link EconomyAPI}. EconomyAPI implementation
     * is expected to set this value when loaded.
     */
    AllayAPI.APIInstanceHolder<EconomyAPI> API = AllayAPI.APIInstanceHolder.create();

    /**
     * Retrieves the instance of the economy api implementation.
     *
     * @return the instance of the economy api implementation.
     */
    static EconomyAPI getAPI() {
        return API.get();
    }

    /**
     * Retrieves the default currency used by the economy. The default currency should
     * never be {@code null}.
     *
     * @return the default {@link Currency} instance
     */
    Currency getDefaultCurrency();

    /**
     * Retrieves the set of all currencies supported by the current economy implementation.
     *
     * @return a set of {@link Currency} instances representing all supported currencies
     */
    Set<Currency> getSupportedCurrencies();

    /**
     * Checks if an account exists for the given unique identifier.
     *
     * @param uuid the unique identifier of the account to check
     * @return {@code true} if the account exists, otherwise {@code false}
     */
    boolean hasAccount(UUID uuid);

    /**
     * Retrieves an {@link Account} associated with the given unique identifier.
     * If no account exists for the specified UUID, a new account will be created.
     *
     * @param uuid the unique identifier of the account to retrieve or create
     * @return the existing or newly created {@link Account} associated with the specified UUID
     */
    Account getOrCreateAccount(UUID uuid);

    /**
     * Retrieves a set of all accounts currently managed by the economy implementation.
     *
     * @return a set of {@link Account} instances representing all managed accounts
     */
    Set<Account> getAccounts();

    /**
     * Deletes an account associated with the specified unique identifier. If an account
     * with the given UUID exists, it will be permanently removed. Event {@link AccountDeleteEvent}
     * will be called when this method is called.
     *
     * @param uuid the unique identifier of the account to delete
     * @return {@code true} if the account was successfully deleted, otherwise {@code false}
     */
    boolean deleteAccount(UUID uuid);
}
