/**
 * Created by Анна on 11.11.2016.
 */
public class Circle extends Figure implements Area {

    double r;

    public Circle(double x, double y, double r) {
        super(x, y);
        this.r = r;
    }

    public double getArea() {

        double s = 3.14 * r * r;
        return s;

    }
}
