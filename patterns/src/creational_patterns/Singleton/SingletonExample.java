package creational_patterns.Singleton;

public class SingletonExample {
    private static SingletonExample instance;

    private SingletonExample(){};

    public void add(int x, int y){
        System.out.println(x + y);
    }

    public void sub(int x, int y){
        System.out.println(x - y);
    }

    public void mul(int x, int y){
        System.out.println(x * y);
    }

    public void div(int x, int y){
        System.out.println(x / y);
    }

    public void mod(int x, int y){
        System.out.println(x % y);
    }

    public static SingletonExample getInstance() {
        // Lazy initialization: create the instance only if it doesn't exist yet
        if (instance == null) {
            instance = new SingletonExample();
        }
        return instance;
    }

    public static void main(String[] args) {
        // Create an instance of the Singleton.DialogManager
        SingletonExample singletonExample = SingletonExample.getInstance();

        // Show information and error dialogs using the Singleton.DialogManager
        singletonExample.add(5, 8);
        singletonExample.sub(5, 9);
        singletonExample.div(5, 9);
        singletonExample.mul(9, 9);
        singletonExample.div(7, 9);

    }
}
