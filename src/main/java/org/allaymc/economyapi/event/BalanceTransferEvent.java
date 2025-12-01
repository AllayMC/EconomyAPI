package org.allaymc.economyapi.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.allaymc.api.eventbus.event.CancellableEvent;
import org.allaymc.economyapi.Currency;
import org.allaymc.economyapi.Account;

import java.math.BigDecimal;

/**
 * Represents an event triggered when a balance transfer occurs between two accounts.
 * This event involves a specific {@link Currency} and tracks the amount being transferred.
 * The transfer includes a source {@link Account} from which the balance is deducted
 * and a target {@link Account} to which the balance is added.
 *
 * @author daoge_cmd
 */
@Getter
@AllArgsConstructor
public class BalanceTransferEvent extends EconomyEvent implements CancellableEvent {
    /**
     * The account that is being transferred from.
     */
    protected final Account account;
    /**
     * The account that is being transferred to.
     */
    protected final Account to;
    /**
     * The currency being transferred.
     */
    protected final Currency currency;
    /**
     * The amount being transferred.
     */
    protected final BigDecimal amount;
}
