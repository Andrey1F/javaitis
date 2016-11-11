/**
 * Created by Анна on 11.11.2016.
 */
public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(2.0);
        Rectangle rect = new Rectangle(4.0, 5.0);
        Square square = new Square(5.0);

        System.out.println(circle.getArea());
        System.out.println(rect.getArea());
        System.out.println(square.getArea());
    }
}
