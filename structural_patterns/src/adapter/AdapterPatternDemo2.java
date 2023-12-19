package adapter;

// Target interface
interface ElectricSocket {
    void supplyElectricity();
}

// Adaptee class
class USPlug {
    void plugIntoUSOutlet() {
        System.out.println("Plugged into a US outlet");
    }
}

// Object Adapter class
class USPlugAdapter implements ElectricSocket {
    private USPlug usPlug;

    public USPlugAdapter(USPlug usPlug) {
        this.usPlug = usPlug;
    }

    @Override
    public void supplyElectricity() {
        usPlug.plugIntoUSOutlet(); // Delegating the method call to the USPlug class
        // Additional operations, if necessary, to adapt to the ElectricSocket interface
        System.out.println("Converting USPlug to supply electricity through an adapter");
    }
}

public class AdapterPatternDemo2 {
    public static void main(String[] args) {
        USPlug usPlug = new USPlug();
        ElectricSocket adapter = new USPlugAdapter(usPlug);

        // Using the adapter to supply electricity
        adapter.supplyElectricity();
    }
}

