package basic_oop;



class Animal {
    String name;
    int age;
    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    void eat() {
        System.out.printf("%s is eating%n", this.name);
    }

    void bark() {
        System.out.printf("%s is barking%n", this.name);
    }
}

public class OOP_Concepts {
    public static void main(String[] args) {
        Dog puppy = new Dog("puppy", 12);
        puppy.eat();
        puppy.bark();
    }

}

