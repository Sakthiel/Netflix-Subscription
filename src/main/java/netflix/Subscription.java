package netflix;

import payment.IPaymentGateway;
import payment.TransactionStatus;
import service.BillingService;

public class Subscription {
    SubscriptionPlan subscriptionPlan;
    BillingService billingService;
    IPaymentGateway paymentGateway;

    SubscriptionStatus subscriptionStatus;
    public Subscription(SubscriptionPlan subscriptionPlan , BillingService billingService , IPaymentGateway paymentGateway) {
        this.subscriptionPlan = subscriptionPlan;
        this.billingService = billingService;
        this.paymentGateway = paymentGateway;
    }

    public void activate() {
        double amount = subscriptionPlan.getPrice();
        billingService.billDetails(amount);
        pay();
        // write code to display bill details
    }
    private void pay(){
        if(paymentGateway.pay(subscriptionPlan.getPrice()) == TransactionStatus.SUCCESS)
            subscriptionStatus = SubscriptionStatus.ACTIVE;
        else
            subscriptionStatus = SubscriptionStatus.INACTIVE;
    }

    public SubscriptionStatus getSubscriptionStatus(){
        return subscriptionStatus;
    }

}
