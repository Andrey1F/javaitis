
public class Main {

    public static void main(String[] args) {

        double[] marksofMarsel = {5.0, 4.0, 5.0, 4.0};
        Student Marsel = new Student("Marsel", marksofMarsel);

        double[] marksofAlex = {5.0, 4.0, 4.0, 4.0};
        Student Alex = new Student("Alex", marksofAlex);

        double[] marksofIvan = {4.0, 4.0, 4.0, 3.0};
        Student Ivan = new Student("Ivan", marksofIvan);

        double[] marksofMary = {5.0, 5.0, 5.0, 5.0};
        Student Mary = new Student("Mary", marksofMary);

        double[] marksofKatya = {5.0, 4.0, 3.0, 4.0};
        Student Katya = new Student("Katya", marksofKatya);

        Student[] arrayOfStudents = {Ivan, Marsel, Katya, Mary, Alex};

        Student[] sorted = QuickSort.quickSort(arrayOfStudents);

        for (int i = 0; i < 5; i++) System.out.println(sorted[i].getName() + ' ' + sorted[i].averageMark());

    }
}
