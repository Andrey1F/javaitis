/**
 * Created by Анна on 11.11.2016.
 */
public class Main {

    public static void main(String[] args) {
        Area figure[] = new Area[3];
        figure[0] = new Circle(1.0, 1.0, 2.0);
        figure[1] = new Rectangle(1.0, 1.0, 4.0, 5.0);
        figure[2] = new Square(1.0, 1.0, 5.0);

        for (int i = 0; i < 3; i++) {

            System.out.println(figure[i].getArea());
        }

    }
}
