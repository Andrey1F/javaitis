
public class QuickSort {

    public static Student[] quickSort(Student[] students) {



           class SortStage {
              SortStage (int m, int n) {

                  int d = m;
              for (int i = n; i < (m-1); i++) {

                  if (students[i].averageMark() > students[m-1].averageMark()) {

                      Student temp = new Student();
                      temp = students[m - 1];
                      students[m-1] = students[i];
                      students[i] = students[m - 2];
                      students[m - 2] = temp;
                      m = m -1;
                      i--;

                  }
              }

                  //debug

                  for (int i = 0; i < students.length; i++)

                  {
                      System.out.println(students[i].getName() + ' ' + students[i].averageMark());

                  }

                  System.out.println("---------------");
              // end of debug

              if (d > m+1) {SortStage right = new SortStage(d, m);}
                if (m > 1) {SortStage left = new SortStage(m-1, 0);}


              }
          }


          SortStage stage = new SortStage(students.length, 0);

        return students;




    }
}
