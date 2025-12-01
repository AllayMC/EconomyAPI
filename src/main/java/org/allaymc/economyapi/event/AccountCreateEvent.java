package org.allaymc.economyapi.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.allaymc.api.eventbus.event.CancellableEvent;
import org.allaymc.economyapi.Account;

/**
 * Represents an event triggered when an {@link Account} is created.
 *
 * @author daoge_cmd
 */
@Getter
@AllArgsConstructor
public class AccountCreateEvent extends EconomyEvent implements CancellableEvent {
    /**
     * The {@link Account} associated with this event.
     */
    protected final Account account;
}
