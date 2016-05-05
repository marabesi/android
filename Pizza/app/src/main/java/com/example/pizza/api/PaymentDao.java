package com.example.pizza.api;


import java.util.ArrayList;

public class PaymentDao {

    public ArrayList<Payment> list()
    {
        ArrayList<Payment> payments = new ArrayList<Payment>();
        payments.add(0, new Payment(1, "Paypal"));
        payments.add(1, new Payment(2, "PagSeguro"));
        payments.add(2, new Payment(3, "CreditCard"));

        return payments;
    }
}
