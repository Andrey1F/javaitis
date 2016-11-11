/**
 * Created by Анна on 10.11.2016.
 */
public class Jeep extends Vehicle {

    private final int WHEELS = 4;

    public Jeep(String brand, String color) {
        super(brand, color);
        this.wheels = WHEELS;
    }
}
