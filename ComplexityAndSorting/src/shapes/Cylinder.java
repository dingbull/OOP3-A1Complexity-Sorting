package shapes;

public class Cylinder extends Shape {
    
    private double height;
    private double radius;
    
    public Cylinder(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }

    // Implement the abstract methods from Shape
    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public double getBaseArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getHeight() {
        return height;
    }


}
