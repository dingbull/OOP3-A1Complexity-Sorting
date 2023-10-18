package shapes;

public abstract class Shape implements Comparable<Shape> {
    
    // Abstract methods to be implemented by subclasses
    public abstract double getVolume();
    public abstract double getBaseArea();
    public abstract double getHeight();

    // Implement the Comparable interface
    @Override
    public int compareTo(Shape other) {
        if (this.getHeight() < other.getHeight()) {
            return -1;
        } else if (this.getHeight() > other.getHeight()) {
            return 1;
        }
        return 0;
    }

    // Implement the Comparator interface to sort shapes by base area or volume
    public static int compare(Shape a, Shape b, String type) {
        switch (type) {
            case "v":
                return Double.compare(a.getVolume(), b.getVolume());
            case "a":
                return Double.compare(a.getBaseArea(), b.getBaseArea());
            default:
                return a.compareTo(b); // Defaults to comparing by height
        }
    }
}
