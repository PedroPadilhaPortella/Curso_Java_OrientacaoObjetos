package model.services;

public interface OnlinePaymentService 
{
    double PaymentFee(double amount);
    double Interest(double amount, Integer months);
}
