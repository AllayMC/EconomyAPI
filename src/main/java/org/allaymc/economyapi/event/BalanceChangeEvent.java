package org.allaymc.economyapi.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.allaymc.api.eventbus.event.CancellableEvent;
import org.allaymc.economyapi.Account;
import org.allaymc.economyapi.Currency;

import java.math.BigDecimal;

/**
 * Represents an event triggered when a change occurs in the balance of an {@link Account}.
 * This event involves a specific {@link Currency} and tracks both the previous and updated
 * amounts associated with it.
 *
 * @author daoge_cmd
 */
@Getter
@AllArgsConstructor
public class BalanceChangeEvent extends EconomyEvent implements CancellableEvent {
    /**
     * The specific {@link Account} associated with this event.
     */
    protected final Account account;
    /**
     * The {@link Currency} associated with this event.
     */
    protected final Currency currency;
    /**
     * The old amount of the currency.
     */
    protected final BigDecimal oldAmount;
    /**
     * The new amount of the currency.
     */
    protected final BigDecimal newAmount;
}
