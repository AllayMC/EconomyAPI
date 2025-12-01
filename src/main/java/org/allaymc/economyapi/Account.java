package org.allaymc.economyapi;

import org.allaymc.economyapi.event.BalanceChangeEvent;
import org.allaymc.economyapi.event.BalanceTransferEvent;
import org.jetbrains.annotations.Unmodifiable;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

/**
 * Represents an account, which stores amounts of various {@link Currency currencies}.
 * <p>
 * Every account is bound to a {@link UUID}, it usually should be same to the player's
 * uuid if the account belongs to a player, or a random uuid in other cases.
 *
 * @author daoge_cmd
 */
public interface Account {

    /**
     * Gets the unique id of this account.
     *
     * @return the unique id of this account
     */
    UUID getUniqueId();

    /**
     * Gets the name of this account.
     *
     * @return the name of this account
     */
    String getName();

    /**
     * Gets a {@link BigDecimal} representative of the balance for the given {@link Currency}.
     *
     * @param currency the currency to get the balance for
     * @return the balance of the currency
     */
    BigDecimal getBalance(Currency currency);

    /**
     * Retrieves an unmodifiable map of all balances associated with this account. Each entry
     * in the map represents a {@link Currency} and its corresponding balance as a {@link BigDecimal}.
     *
     * @return an unmodifiable map containing currencies as keys and their respective balances as values
     */
    @Unmodifiable
    Map<Currency, BigDecimal> getBalances();

    /**
     * Sets the balance for the given currency to the specified amount. Event {@link BalanceChangeEvent}
     * will be called when this method is called.
     *
     * @param currency the {@link Currency} for which the balance is being set
     * @param amount   the {@link BigDecimal} value representing the new balance
     * @return {@code true} if the balance was successfully set, otherwise {@code false}
     */
    boolean setBalance(Currency currency, BigDecimal amount);

    /**
     * Deposits a specified amount of the given currency into the account.
     * The new balance is calculated by adding the deposit amount to the current balance.
     *
     * @param currency the {@link Currency} being deposited
     * @param amount   the {@link BigDecimal} value of the amount to deposit
     * @return {@code true} if the new balance was successfully updated, otherwise {@code false}
     */
    default boolean deposit(Currency currency, BigDecimal amount) {
        return setBalance(currency, getBalance(currency).add(amount));
    }

    /**
     * Withdraws a specified amount of the given currency from the account.
     * The new balance is calculated by subtracting the withdrawal amount
     * from the current balance.
     *
     * @param currency the {@link Currency} from which the amount is being withdrawn
     * @param amount   the {@link BigDecimal} value of the amount to withdraw
     * @return {@code true} if the new balance was successfully updated, otherwise {@code false}
     */
    default boolean withdraw(Currency currency, BigDecimal amount) {
        return setBalance(currency, getBalance(currency).subtract(amount));
    }

    /**
     * Transfers a specified amount of a given currency from this account to another account.
     * Event {@link BalanceTransferEvent} will be called when this method is called.
     *
     * @param to       the recipient {@link Account} to which the amount will be transferred
     * @param currency the {@link Currency} of the amount being transferred
     * @param amount   the {@link BigDecimal} value representing the amount to be transferred
     * @return {@code true} if the transfer was successful, otherwise {@code false}
     */
    boolean transfer(Account to, Currency currency, BigDecimal amount);
}
