package varvara.laba1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void updateStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3.0) {
                iterator.remove();
            } else {
                student.incrementCourse();
            }
        }
    }

    public static void printStudents(List<Student> students, int course) {
        System.out.println("Студенты на курсе " + course + ":");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Тимофей", "М-Б20", 2, List.of(4, 5, 3)));
        students.add(new Student("Варвара", "М-Б20", 1, List.of(2, 2, 3)));
        students.add(new Student("Николай", "М2-М24", 3, List.of(4, 3, 5)));
        students.add(new Student("Надежда", "М2-М24", 1, List.of(1, 2, 2)));

        updateStudents(students);

        printStudents(students, 3);
    }
}
