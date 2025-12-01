package org.allaymc.economyapi;

import java.math.BigDecimal;

/**
 * Represents a form of currency. At least one type of currency is always
 * supported and can be got via {@link EconomyAPI#getDefaultCurrency()}.
 * <p>
 * Depending on the implementation of the {@link EconomyAPI}, more currencies
 * may be available.
 *
 * @author daoge_cmd
 */
public interface Currency {

    /**
     * Gets the currency's name, in singular form. Ex: Dollar.
     *
     * @return the name of the currency singular
     */
    String getName();

    /**
     * Gets the currency's name in plural form. Ex: Dollars.
     * <p>
     * Not all currencies will have a plural name that differs from the normal name.
     *
     * @return the name of the currency plural
     */
    default String getPluralName() {
        return getName();
    }

    /**
     * Gets the currency's symbol. Ex. $
     *
     * @return the symbol of the currency
     */
    String getSymbol();

    /**
     * Gets the default number of fractional digits that is used for
     * formatting purposes.
     *
     * @return the default number of fractional digits
     */
    int getDefaultFractionDigits();

    /**
     * Formats the given amount using the default number of fractional digits. The symbol
     * should be included if present
     *
     * @param amount The amount to format
     * @return formatted amount
     */
    default String format(BigDecimal amount) {
        return format(amount, getDefaultFractionDigits());
    }

    /**
     * Formats the given amount using the specified number of fractional digits. The symbol
     * should be included if present
     *
     * @param amount            The amount to format
     * @param numFractionDigits The number of fractional digits to use
     * @return formatted amount.
     */
    String format(BigDecimal amount, int numFractionDigits);

    /**
     * Check if this currency is the default currency for the economy.
     *
     * @return {@code true} if this is the default currency, otherwise {@code false}
     */
    boolean isDefault();
}
