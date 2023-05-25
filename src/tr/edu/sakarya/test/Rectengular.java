package tr.edu.sakarya.test;

public class Rectengular extends RectengularShapeAbstract {
    public Rectengular(int x, int y) {
        super(x, y);
    }

    @Override
    protected int doSpecificCalculation(int area) {
        return area + 5;
    }
}
