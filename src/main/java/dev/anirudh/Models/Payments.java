package dev.anirudh.Models;

public class Payments {
    private int id;

    public void makePayment(int id) {
        this.id = id;
        System.out.println("Payment is received");
    };
}
