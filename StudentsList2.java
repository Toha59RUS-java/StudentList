package antush.com.lesson1.StudentList;
import antush.com.lesson1.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StudentsList2 {

    public static void main(String[] args) {
        Student2 student1 = new Student2("Bob", "Terner", 123, List.of(4, 5, 3, 4, 4, 5));
        Student2 student2 = new Student2("Bob2", "Terner2", 123, List.of(4, 5, 3, 4, 4, 5));
        Student2 student3 = new Student2("Sveta", "Sveticova", 321, List.of(4, 4, 5));
        Student2 student4 = new Student2("Petr", "Petrov", 43, List.of(4, 4, 5, 4));
        Student2 student5 = new Student2("Nikolay", "Nikolaev", 12, List.of(4, 3, 3, 4, 4, 5));
        Student2 student6 = new Student2("Nikolay2", "Nikolaev2", 12, List.of(4, 3, 4, 4, 5));
        Student2 student7 = new Student2("Nikolay3", "Nikolaev3", 12, List.of(4, 4, 5));
        Student2 student8 = new Student2("Anton", "Ushakov", 26, List.of(5, 5, 4, 5, 4, 5));
        Student2 student9 = new Student2("Anton2", "Ushakov2", 26, List.of(5, 5, 4, 5, 4, 5));
        Student2 student10 = new Student2("Anton3", "Ushakov3", 26, List.of(5, 5, 4, 5, 5));
        Student2 student11 = new Student2("Anton5", "Ushakov5", 26, List.of(5, 4, 5));

        List<Student2> students = new ArrayList<>(List.of(student1, student2, student3, student4, student5, student6,
                student7, student8, student9, student10, student11));

        Map<Integer, String> numberCourseAndFullName = students.stream()
                .filter(student -> student.getGrades().size() > 3)
                .collect(Collectors.groupingBy(Student2::getNumberCourse,
                        Collectors.mapping(Student2::getFullName,
                                Collectors.joining(", ", "{","}"))));

        Map<Integer, String> numberCourseAndFullNameSorted = new TreeMap<>(numberCourseAndFullName);
        numberCourseAndFullNameSorted.entrySet().forEach(System.out::println);
        System.out.println();

        Map<Integer, List<Student2>> averageStudentMap = students.stream()
                .filter(student -> student.getGrades().size() > 3)
                .collect(Collectors.groupingBy(Student2::getNumberCourse));

        Map<Integer, List<Student2>> averageStudentMapSorted = new TreeMap<>(averageStudentMap);
        averageStudentMapSorted.entrySet();
        averageStudentMapSorted.forEach(((course, student) -> {
            System.out.println(course);
            List<Integer> gradesAllCourse = student.stream()
                    .map(stud -> averageList(student))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
            System.out.println(averageGrades(gradesAllCourse));
            System.out.println();
        }));
    }


    public static List<Integer> averageList(List<Student2> students){
        List<Integer> gradesAll = new ArrayList<>();

        for (Student2 student : students) {
            gradesAll.addAll(student.getGrades());
        }
        return gradesAll;
    }

    public static double averageGrades (List<Integer> listStudent) {
        double sum = 0;
        for(int i=0;i<listStudent.size();i++) {
            sum+=listStudent.get(i);
        }
        return sum/listStudent.size();
    }
}
