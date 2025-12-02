# EconomyAPI

![Maven Central Version](https://img.shields.io/maven-central/v/org.allaymc/economy-api?label=economy-api)

EconomyAPI is a plugin that unifies all economy plugins under one single API. The API can be used by both economy plugins
providing the API, and other plugins using the API (i.e. shop plugins). This allows for all plugins that require an economy
to work with any economy plugin.

> [!NOTE]
> EconomyAPI cannot be used alone! It only provides abstract APIs for uniform calls and requires another economy plugin to
> implement it. You must use an economy plugin that provides the EconomyAPI implementation.

## Usages

### Use in Gradle

```kts
repositories {
    mavenCentral()
}

dependencies {
    compileOnly(group = "org.allaymc", name = "economy-api", version = "0.1.0")
}
```

### Use the API

```java
import org.allaymc.economyapi.EconomyAPI;
import org.allaymc.economyapi.Account;
import org.allaymc.economyapi.Currency;
import java.math.BigDecimal;
import java.util.UUID;

public class Example {
    public void example() {
        // Get the api instance
        EconomyAPI api = EconomyAPI.get();
        // Create an account
        UUID uuid = UUID.randomUUID();
        Account account = api.getOrCreateAccount(uuid);
        // Get the balance of the account for the default currency
        Currency currency = api.getDefaultCurrency();
        BigDecimal balance = account.getBalance(currency);
        // Convert it to a string
        String formattedBalance = currency.format(balance);
        // More...
    }
}
```

### Implement the API

```java
import org.allaymc.api.plugin.Plugin;
import org.allaymc.economyapi.EconomyAPI;

public class MyEconomyAPI extends Plugin implements EconomyAPI {
    @Override
    public void onLoad() {
        // Set the api instance, note that EconomyAPI#API can only be set once
        EconomyAPI.API.set(this);
    }
}
```

### Available Events

- [x] AccountCreateEvent: Called when an account is created.
- [x] AccountDeleteEvent: Called when an account is deleted.
- [x] BalanceChangeEvent: Called when a change occurs in the balance of an account.
- [x] BalanceTransferEvent: Called when a balance transfer occurs between two accounts.

## Requirement

Java: 21+

Allay: 0.17.0+

## Contributing

Contributions are welcome! Feel free to fork the repository, improve the code, and submit pull requests with your
changes.

## License

This project is licensed under the LGPL v3 License - see the [LICENSE](LICENSE) file for details.