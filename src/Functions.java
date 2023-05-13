import entities.Student;

import java.util.List;

public class Functions {
    //class for calculate average
    public static float Average(Student x) {
        float average = (x.getTestOne() + x.getTestTwo() + x.getTestThree()) / 3;
        return average;
    }

    //This class returns the highest or the lowest grade of the passed student.
    public static float lowestHighest(Student y, char op) {
        float n = 0;
        switch (op) {
            case 'l':
                n = 100f;
                if (y.getTestOne() < n) {
                    n = y.getTestOne();
                }
                if (y.getTestTwo() < n) {
                    n = y.getTestTwo();
                }
                if (y.getTestThree() < n) {
                    n = y.getTestThree();
                }
                break;

            case 'h':
                n = 0;
                if (y.getTestOne() > n) {
                    n = y.getTestOne();
                } else if (y.getTestTwo() > n) {
                    n = y.getTestTwo();
                } else if (y.getTestThree() > n) {
                    n = y.getTestThree();
                }
                break;
        }
        return n;
    }

    public static void AprovedReproved(List<Student> ls, char ar) {
        for (Student s : ls){
            Student c = null;
            if (Functions.Average(s) >= 7.0 && ar == 'a') {
                System.out.printf("%d - %s : Média = %.2f\n", s.getCode(), s.getName(), Functions.Average(s));
            } else if (Functions.Average(s) < 7.0 && ar == 'r'){
                float missed = 7.0f - Functions.Average(s);
                System.out.printf("%d - %s : Média = %.2f (faltou = %.2f)\n", s.getCode(), s.getName(), Functions.Average(s), missed);
            }
        }
    }
}
