package Factory;


interface Draw {
    void drawShape();
}

class Triangle implements  Draw {
    @Override
    public void drawShape() {
        System.out.println("Drawing Triangle");
    }
}

class Quadrilateral implements  Draw {
    @Override
    public void drawShape() {
        System.out.println("Drawing Quadrilateral");
    }
}

class Pentagon implements  Draw {
    @Override
    public void drawShape() {
        System.out.println("Drawing Pentagon");
    }
}


interface  PolygonFactory {
    Draw drawShape(int side1, int side2, int side3, int side4, int side5);
}

class DrawPolygonFactory implements PolygonFactory {
    @Override
    public Draw drawShape(int side1, int side2, int side3, int side4, int side5) {
        int numberOfSides = countSides(side1, side2, side3, side4, side5);

        switch (numberOfSides) {
            case 3:
                return new Triangle();
            case 4:
                return new Quadrilateral();
            case 5:
                return new Pentagon();
            default:
                throw new IllegalArgumentException("Unsupported number of sides: " + numberOfSides);
        }
    }

    // Helper method to count non-zero sides
    private int countSides(int... sides) {
        int count = 0;
        for (int side : sides) {
            if (side > 0) {
                count++;
            }
        }
        return count;
    }
}
public class Polygon {
    public static void main(String[] args) {
        int side1 = 40;
        int side2 = 50;
        int side3 = 50;
        int side4 = 0;
        int side5 = 0;

        PolygonFactory pf = new DrawPolygonFactory();

        Draw draw = pf.drawShape(side1, side2, side3, side4, side5);

        draw.drawShape();
    }
}
