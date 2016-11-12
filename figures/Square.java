/**
 * Created by Анна on 11.11.2016.
 */
public class Square extends Figure implements Area {

    double a;

    public Square(double x, double y, double a) {
        super(x, y);
        this.a = a;
    }

    public double getArea() {
        double s = a * a;
        return s;

    }
}
