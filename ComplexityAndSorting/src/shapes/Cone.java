package shapes;

public class Cone extends Shape {
    
    private double height;
    private double radius;
    
    public Cone(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }

    // Implement the abstract methods from Shape
    @Override
    public double getVolume() {
        return (1.0 / 3) * Math.PI * Math.pow(radius, 2) * height;
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
