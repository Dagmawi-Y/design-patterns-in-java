package structural_patterns.adapter;

// Target interface (expected by the client)
interface PaymentProcessor {
    void processPayment(double amount);
}

// Adaptee (new payment gateway with a different interface)
class NewPaymentGateway {
    void performPayment(double totalAmount) {
        // Perform payment processing using the new gateway
        System.out.println("Processing payment of " + totalAmount + " via new payment gateway.");
    }
}

// Adapter implementing the PaymentProcessor interface
class PaymentGatewayAdapter implements PaymentProcessor {
    private NewPaymentGateway newGateway;

    public PaymentGatewayAdapter(NewPaymentGateway newGateway) {
        this.newGateway = newGateway;
    }

    @Override
    public void processPayment(double amount) {
        // Adapt the method call to the new payment gateway's format
        newGateway.performPayment(amount);
    }
}

// Client code (existing e-commerce platform)
public class ECommercePlatform {
    public static void main(String[] args) {
        // Existing code using the PaymentProcessor interface
        PaymentProcessor paymentProcessor = new PaymentGatewayAdapter(new NewPaymentGateway());
        paymentProcessor.processPayment(100.0); // Process payment using the adapted interface
    }
}

