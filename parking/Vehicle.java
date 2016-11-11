/**
 * Created by Анна on 10.11.2016.
 */
public class Vehicle {
    protected int wheels;
    protected String brand;
    protected String color;

    public Vehicle( String brand, String color) {

        this.brand = brand;
        this.color = color;
    }

    public int getWheels() {
        return wheels;
    }

    public String getBrand() {
        return brand;
    }


    public String getColor() {
        return color;
    }

    public void roll() {
        System.out.println(this.color + " " + brand + " is rollin' on " + wheels + " wheels");
    }
}
