/**
 * Created by Анна on 10.11.2016.
 */
public class Main {

    public static void main(String[] args) {

        Jeep jeep = new Jeep ("UAZ PATRIOT", "red");
        Motorcycle moto = new Motorcycle("Java", "black");

        Vehicle[] parked = {jeep, moto};

        for (int i = 0; i < parked.length; i++) {
            parked[i].roll();
        }


    }
}
