package org.example.models;

import java.time.LocalDateTime;

public class Payment extends BaseModel{
    private double billAmount;
    private LocalDateTime billingTime;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public LocalDateTime getBillingTime() {
        return billingTime;
    }

    public void setBillingTime(LocalDateTime billingTime) {
        this.billingTime = billingTime;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
}
