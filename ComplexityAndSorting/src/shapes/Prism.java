package shapes;

public class Prism extends Shape {
    
    private double height;
    private double edgeLength;
    private String basePolygon;
    
    public Prism(double height, double edgeLength, String basePolygon) {
        this.height = height;
        this.edgeLength = edgeLength;
        this.basePolygon = basePolygon;
    }

    // Implement the abstract methods from Shape
    @Override
    public double getVolume() {
        double baseArea = getBaseArea();
        return baseArea * height;
    }

    @Override
    public double getBaseArea() {
        switch (basePolygon) {
            case "Square":
                return Math.pow(edgeLength, 2);
            case "Triangle":
                return (Math.sqrt(3) / 4) * Math.pow(edgeLength, 2);
            case "Pentagon":
                return (5.0 / 4) * Math.pow(edgeLength, 2) / Math.tan(Math.PI / 5);
            case "Octagon":
                return 2 * (1 + Math.sqrt(2)) * Math.pow(edgeLength, 2);
            default:
                return 0;
        }
    }

    @Override
    public double getHeight() {
        return height;
    }

    // Additional methods specific to Prism can be added here
}
