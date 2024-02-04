package structural_patterns.bridge;

// Abstraction - RemoteControl
interface RemoteControl {
    void powerOn();
    void powerOff();
    void increaseVolume();
    void decreaseVolume();
}

// Refined Abstraction - BasicRemote
class BasicRemote implements RemoteControl {
    private Device device;

    public BasicRemote(Device device) {
        this.device = device;
    }

    @Override
    public void powerOn() {
        System.out.println("Turning on the device.");
        device.powerOn();
    }

    @Override
    public void powerOff() {
        System.out.println("Turning off the device.");
        device.powerOff();
    }

    @Override
    public void increaseVolume() {
        System.out.println("Increasing volume.");
        device.adjustVolume(1);
    }

    @Override
    public void decreaseVolume() {
        System.out.println("Decreasing volume.");
        device.adjustVolume(-1);
    }
}

// Implementation - Device
interface Device {
    void powerOn();
    void powerOff();
    void adjustVolume(int steps);
}

// Concrete Implementation - TV
class TV implements Device {
    private boolean poweredOn;
    private int volume;

    @Override
    public void powerOn() {
        poweredOn = true;
        System.out.println("TV is powered on.");
    }

    @Override
    public void powerOff() {
        poweredOn = false;
        System.out.println("TV is powered off.");
    }

    @Override
    public void adjustVolume(int steps) {
        if (poweredOn) {
            volume += steps;
            System.out.println("TV volume adjusted to " + volume);
        } else {
            System.out.println("Can't adjust volume, TV is powered off.");
        }
    }
}

// Concrete Implementation - Radio
class Radio implements Device {
    private boolean poweredOn;
    private int volume;

    @Override
    public void powerOn() {
        poweredOn = true;
        System.out.println("Radio is powered on.");
    }

    @Override
    public void powerOff() {
        poweredOn = false;
        System.out.println("Radio is powered off.");
    }

    @Override
    public void adjustVolume(int steps) {
        if (poweredOn) {
            volume += steps;
            System.out.println("Radio volume adjusted to " + volume);
        } else {
            System.out.println("Can't adjust volume, Radio is powered off.");
        }
    }
}

// Client code
public class BridgePatternExample {
    public static void main(String[] args) {
        // Using the BasicRemote to control a TV
        Device tv = new TV();
        RemoteControl tvRemote = new BasicRemote(tv);

        tvRemote.powerOn();
        tvRemote.increaseVolume();
        tvRemote.decreaseVolume();
        tvRemote.powerOff();

        System.out.println("---------------------");

        // Using the BasicRemote to control a Radio
        Device radio = new Radio();
        RemoteControl radioRemote = new BasicRemote(radio);

        radioRemote.powerOn();
        radioRemote.increaseVolume();
        radioRemote.decreaseVolume();
        radioRemote.powerOff();
    }
}
