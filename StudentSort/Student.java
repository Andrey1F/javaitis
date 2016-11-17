
public class Student {

    public static final int NUMBER_OF_MARKS;

    static {
        NUMBER_OF_MARKS = 4;
    }

    private String name;
    public double[] marks;

    public Student() {
        this.name = "DEFAULT_NAME";
        this.marks = new double[NUMBER_OF_MARKS];
    }

    public Student(String name, double[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double averageMark() {
        double a = 0;
        double s = 0;

        for (int i = 0; i < NUMBER_OF_MARKS; i++) s = s + marks[i];
        a = s/NUMBER_OF_MARKS;
        return a;
    }


    }
