/**
 * Created by Анна on 10.11.2016.
 */
public class Bicycle extends Vehicle{

    private final int WHEELS = 2;

    public Bicycle(String brand, String color) {
        super(brand, color);
        this.wheels = WHEELS;
    }
}
