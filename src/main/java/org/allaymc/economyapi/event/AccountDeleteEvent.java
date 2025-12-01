package org.allaymc.economyapi.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.allaymc.api.eventbus.event.CancellableEvent;
import org.allaymc.economyapi.Account;

/**
 * Represents an event triggered when an {@link Account} is deleted.
 *
 * @author daoge_cmd
 */
@Getter
@AllArgsConstructor
public class AccountDeleteEvent extends EconomyEvent implements CancellableEvent {
    /**
     * The {@link Account} associated with this event.
     */
    protected final Account account;
}
