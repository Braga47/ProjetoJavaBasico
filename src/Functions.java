import entities.Student;

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
}
