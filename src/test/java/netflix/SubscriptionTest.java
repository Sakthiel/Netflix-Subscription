package netflix;

import fakes.MockBillingService;
import fakes.MockPaymentGateway;
import org.junit.jupiter.api.Test;
import payment.AxisCard;
import payment.IPaymentGateway;
import service.BillingService;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.mockito.Mockito.* ;


class SubscriptionTest {
    @Test
    void dummyTest() {
        assertThat(1, is(equalTo(1)));
    }

    @Test
    void shouldBeAbleToSeeBillingDetailsBeforeMakingPayment(){
        BillingService mockBillingService = mock(BillingService.class);
        IPaymentGateway paymentGateway = new AxisCard();
        Subscription subscription = new Subscription(SubscriptionPlan.MONTHLY,mockBillingService , paymentGateway);
        subscription.activate();

        verify(mockBillingService).billDetails(SubscriptionPlan.MONTHLY.getPrice());

    }
/*
    @Test
    void shouldActivateSubscriptionWhenTransactionIsDone(){
        BillingService mockBillingService = mock(BillingService.class);
        IPaymentGateway mockPaymentGateway = mock(AxisCard.class);
        Subscription subscription = new Subscription(SubscriptionPlan.MONTHLY,mockBillingService , mockPaymentGateway);
        subscription.activate();

        when(mockPaymentGateway.pay())


    }*/
    @Test

    void shouldAbleToSeeBillingDetailsBeforeMakingPayment(){
        MockBillingService mockBillingService = new MockBillingService();
        MockPaymentGateway mockPaymentGateway = new MockPaymentGateway();
        Subscription subscription =  new Subscription(SubscriptionPlan.MONTHLY,mockBillingService , mockPaymentGateway);
        int expectedValue = 1;

        subscription.activate();

        assertThat(mockBillingService.noOfTimesInvoked , is(equalTo(expectedValue)));

    }
    @Test
    void shouldActivateSubscriptionWhenPaymentIsDone(){
        MockBillingService mockBillingService = new MockBillingService();
        MockPaymentGateway mockPaymentGateway = new MockPaymentGateway();
        Subscription subscription =  new Subscription(SubscriptionPlan.MONTHLY,mockBillingService , mockPaymentGateway);

        subscription.pay();

        assertThat();

    }


}
