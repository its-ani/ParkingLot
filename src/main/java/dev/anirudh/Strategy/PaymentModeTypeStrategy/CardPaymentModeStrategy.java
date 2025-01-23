package dev.anirudh.Strategy.PaymentModeTypeStrategy;

import dev.anirudh.Models.Payments;

public class CardPaymentModeStrategy implements PaymentModeStrategy {

    @Override
    public Payments makePayment(Payments payments) {
        return new Payments();
    }
}
