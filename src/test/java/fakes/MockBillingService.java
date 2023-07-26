package fakes;

import service.BillingService;

public class MockBillingService extends BillingService {
    public int noOfTimesInvoked =0;

    @Override
    public void billDetails(double amount) {
        noOfTimesInvoked++ ;
    }
}
