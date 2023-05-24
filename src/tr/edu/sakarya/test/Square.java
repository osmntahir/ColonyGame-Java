package tr.edu.sakarya.test;

public class Square extends RectengularShapeAbstract {
    public Square(int x) {
        super(x, x);
    }

    @Override
    protected int doSpecificCalculation(int area) {
        return area - 3;
    }
}
