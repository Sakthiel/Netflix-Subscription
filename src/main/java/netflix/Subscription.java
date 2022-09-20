package netflix;

import payment.IPaymentGateway;
import service.BillingService;

public class Subscription {
    SubscriptionPlan subscriptionPlan;
    BillingService billingService;
    IPaymentGateway paymentGateway;

    public Subscription(SubscriptionPlan subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    public void activate() {
        // write code to display bill details
    }
}
