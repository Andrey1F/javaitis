/**
 * Created by Анна on 10.11.2016.
 */
public class Motorcycle extends Vehicle{

    private final int WHEELS = 2;

    public Motorcycle(String brand, String color) {
        super(brand, color);
        this.wheels = WHEELS;
    }
}
