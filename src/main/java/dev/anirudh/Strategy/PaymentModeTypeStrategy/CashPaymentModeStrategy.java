package dev.anirudh.Strategy.PaymentModeTypeStrategy;

import dev.anirudh.Models.Payments;

public class CashPaymentModeStrategy implements PaymentModeStrategy {

    @Override
    public Payments makePayment(Payments payments) {
        return new Payments();
    }
}
