package creational_patterns.AbstractFactory;

// Abstract Character interface
interface Character {
    void display();
}


// Concrete character classes
class Warrior implements Character {
    @Override
    public void display() {
        System.out.println("Warrior character created!");
    }
}


class Mage implements Character {
    @Override
    public void display() {
        System.out.println("Mage character created!");
    }
}



// Abstract Weapon interface
interface Weapon {
    void attack();
}

// Concrete weapon classes
class Sword implements Weapon {
    @Override
    public void attack() {
        System.out.println("Sword attack!");
    }
}


class Staff implements Weapon {
    @Override
    public void attack() {
        System.out.println("Staff attack!");
    }
}

// Abstract Factory for creating characters and weapons
interface GameFactory {
    Character createCharacter();
    Weapon createWeapon();
}


// Concrete Factory for creating warrior characters and related weapons
class WarriorFactory implements GameFactory {
    @Override
    public Character createCharacter() {
        return new Warrior();
    }

    @Override
    public Weapon createWeapon() {
        return new Sword();
    }
}

// Concrete Factory for creating mage characters and related weapons
class MageFactory implements GameFactory {
    @Override
    public Character createCharacter() {
        return new Mage();
    }

    @Override
    public Weapon createWeapon() {
        return new Staff();
    }
}

// Client code (Game implementation)
public class Game {
    public static void main(String[] args) {
        // Select factory based on game level, environment, or player's choice
        GameFactory factory = new WarriorFactory(); // or new MageFactory();

        // Create character and weapon using the selected factory
        Character character = factory.createCharacter();
        Weapon weapon = factory.createWeapon();

        // Display the created character and perform an attack using the weapon
        character.display();
        weapon.attack();
    }
}
