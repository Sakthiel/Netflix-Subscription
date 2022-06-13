package netflix;

import payment.IPaymentGateway;
import service.BillingService;

public class Subscription {
    int id;
    SubscriptionPlan subscriptionPlan;
    BillingService billingService;
    IPaymentGateway paymentGateway;

    public Subscription(int id, SubscriptionPlan subscriptionPlan) {
        this.id = id;
        this.subscriptionPlan = subscriptionPlan;
    }

    public void activate() {
        // write code to display bill details
    }
}
