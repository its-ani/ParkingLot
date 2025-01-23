package dev.anirudh.Strategy.PaymentModeTypeStrategy;

import dev.anirudh.Models.Payments;

public interface PaymentModeStrategy {
    Payments makePayment(Payments payments);
}
