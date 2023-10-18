package shapes;

public class Pyramid extends Shape {
    
    private double height;
    private double edgeLength;
    
    public Pyramid(double height, double edgeLength) {
        this.height = height;
        this.edgeLength = edgeLength;
    }

    // Implement the abstract methods from Shape
    @Override
    public double getVolume() {
        return (1.0 / 3) * getBaseArea() * height;
    }

    @Override
    public double getBaseArea() {
        return Math.pow(edgeLength, 2);
    }

    @Override
    public double getHeight() {
        return height;
    }


}
