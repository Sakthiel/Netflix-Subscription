package fakes;

import payment.IPaymentGateway;
import payment.TransactionStatus;

public class MockPaymentGateway implements IPaymentGateway {

    @Override
    public TransactionStatus pay(double amount) {
        return TransactionStatus.SUCCESS;
    }
}
