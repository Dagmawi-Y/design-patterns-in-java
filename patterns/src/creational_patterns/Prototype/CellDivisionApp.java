package creational_patterns.Prototype;

// Step 1: Create a prototype interface with the clone method
interface Cell {
    Cell clone();
    void performCellFunction();
}

// Step 2: Define a concrete prototype class with an alternative constructor for cloning
class MitoticCell implements Cell {
    // Fields representing cell properties
    private String type;

    // Constructor for creating a new cell
    public MitoticCell(String type) {
        this.type = type;
    }

    // Alternative constructor for cloning
    public MitoticCell(MitoticCell source) {
        this.type = source.type;
    }

    // Step 3: Clone method for creating a copy of the cell
    @Override
    public Cell clone() {
        return new MitoticCell(this);
    }

    // Step 4: Method to perform cell-specific functions
    @Override
    public void performCellFunction() {
        System.out.println("Performing cell function of type: " + type);
    }
}

// Step 5: Client class using the prototype pattern
public class CellDivisionApp {
    public static void main(String[] args) {
        // Step 6: Create a cell prototype
        Cell cellPrototype = new MitoticCell("Normal");

        // Step 7: Perform cell division to create a new cell
        Cell newCell = cellPrototype.clone();

        // Step 8: Perform cell-specific functions on the new cell
        newCell.performCellFunction();
    }
}
