package antush.com.lesson1.StudentList;
import java.util.ArrayList;
import java.util.List;

/**
 * Дан список студентов с полями:
 * - Имя
 * - Фамилия
 * - Номер курса в университете
 * - Список оценок за учебу
 */

public class Student2 {

    private String firstName;
    private String lastName;
    private int numberCourse;
    private List<Integer> grades = new ArrayList<>();

    public Student2(String firstName, String lastName, int numberCourse, List<Integer> grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberCourse = numberCourse;
        this.grades = grades;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public int getNumberCourse() {
        return numberCourse;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", numberCourse=" + numberCourse +
                ", average=" + grades +
                '}';
    }
}