import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class StudentSorter {
    public static class Student {
        String name;
        Map<String, Integer> courseGrades;

        public Student(String name) {
            // Please provide your solution in the space below
            this.name = name;
            this.courseGrades = new HashMap<String, Integer>();
        }

        public void addCourseGrade(String course, int grade) {
            // Please provide your solution in the space below
            courseGrades.put(course, grade);
        }

        public double getGPA() {
           // Please provide your solution in the space below
            double sum = 0;

            for (Integer i : courseGrades.values()) {
                sum += i;
            }

            return sum / (double) courseGrades.size();
        }

        public String getName() {
            // Please provide your solution in the space below
            return name;
        }
    }

    public static class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            // Please provide your solution in the space below
            return Double.compare(s1.getGPA(), s2.getGPA());
        }
    }

    public static List<Student> sortStudentsByGPA(List<Student> students) {
        // Please provide your solution in the space below
        Collections.sort(students, new StudentComparator());
        return students;
    }
}