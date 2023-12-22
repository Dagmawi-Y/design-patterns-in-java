package creational_patterns.Factory;

interface Transport {
    void deliver();
}

class Car implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by Factory.Car.");
    }
}

class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by Factory.Truck.");
    }
}

class Bicycle implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by Factory.Bicycle.");
    }
}

interface TransportFactory {
    Transport createTransport(int size, int weight);
}

class DeliveryTransportFactory implements TransportFactory {
    @Override
    public Transport createTransport(int size, int weight) {
        if (size < 10 && weight < 20) {
            return new Bicycle();
        } else if (size < 50 && weight < 500) {
            return new Car();
        } else {
            return new Truck();
        }
    }
}

public class DeliveryBusiness {
    public static void main(String[] args) {
        // Package characteristics (size and weight)
        int packageSize = 40;
        int packageWeight = 400;

        TransportFactory transportFactory = new DeliveryTransportFactory();

        Transport transport = transportFactory.createTransport(packageSize, packageWeight);

        transport.deliver();
    }
}
