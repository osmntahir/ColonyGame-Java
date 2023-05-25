package tr.edu.sakarya.test;

public abstract class RectengularShapeAbstract implements RectengularShape {

    // SOLID
    // S ->
    // Complexity (time and space)
    private final int x;
    private final int y;

    public RectengularShapeAbstract(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int area() {
        return x * y;
    }

    @Override
    public int perimeter() {
        return 2 * (x + y);
    }

    public int someCalculation() {
        int area = area();
        return doSpecificCalculation(area);
    }

    protected abstract int doSpecificCalculation(int area);

}
