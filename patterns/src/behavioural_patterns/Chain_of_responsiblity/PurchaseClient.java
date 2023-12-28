package behavioural_patterns.Chain_of_responsiblity;

// Handler Interface
interface PurchaseHandler {
    void handleRequest(PurchaseRequest request);
}

// Concrete Handlers
class Manager implements PurchaseHandler {
    private double approvalLimit;
    private PurchaseHandler nextHandler;
    private String managerName;

    public Manager(double limit, String name) {
        this.approvalLimit = limit;
        this.managerName = name;
    }

    public void setNextHandler(PurchaseHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(PurchaseRequest request) {
        if (request.getAmount() <= approvalLimit) {
            System.out.println(managerName + " approved the purchase.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("No one can approve this purchase.");
        }
    }
}

// Client/Sender
public class PurchaseClient {
    public static void main(String[] args) {
        Manager manager1 = new Manager(1000, "Manager 1");
        Manager manager2 = new Manager(5000, "Manager 2");
        Manager manager3 = new Manager(10000, "Manager 3");

        manager1.setNextHandler(manager2);
        manager2.setNextHandler(manager3);

        PurchaseRequest request = new PurchaseRequest(8000);
        manager1.handleRequest(request);
    }
}

// Purchase Request class
class PurchaseRequest {
    private double amount;

    public PurchaseRequest(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
