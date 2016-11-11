/**
 * Created by Анна on 11.11.2016.
 */
public class Rectangle extends Figure implements Area{
    double a,b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getArea() {
        double s = a * b;
        return s;
    }
}
