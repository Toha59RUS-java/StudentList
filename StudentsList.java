package antush.com.lesson1;
import java.util.*;
import java.util.stream.Collectors;

public class StudentsList {

    public static void main(String[] args) {
        Student student1 = new Student("Bob", "Terner", 123, List.of(4, 5, 3, 4, 4, 5));
        Student student2 = new Student("Bob2", "Terner2", 123, List.of(4, 5, 3, 4, 4, 5));
        Student student3 = new Student("Sveta", "Sveticova", 321, List.of(4, 4, 5));
        Student student4 = new Student("Petr", "Petrov", 43, List.of(4, 4, 5, 4));
        Student student5 = new Student("Nikolay", "Nikolaev", 12, List.of(4, 3, 3, 4, 4, 5));
        Student student6 = new Student("Nikolay2", "Nikolaev2", 12, List.of(4, 3, 4, 4, 5));
        Student student7 = new Student("Nikolay3", "Nikolaev3", 12, List.of(4, 4, 5));
        Student student8 = new Student("Anton", "Ushakov", 26, List.of(5, 5, 4, 5, 4, 5));
        Student student9 = new Student("Anton2", "Ushakov2", 26, List.of(5, 5, 4, 5, 4, 5));
        Student student10 = new Student("Anton3", "Ushakov3", 26, List.of(5, 5, 4, 5, 5));
        Student student11 = new Student("Anton5", "Ushakov5", 26, List.of(5, 4, 5));

        List<Student> students = new ArrayList<>(List.of(student1, student2, student3, student4, student5, student6,
                student7, student8, student9, student10, student11));


//        students.stream()
//                .filter(student -> student.getGrades().size() > 3)
//                .collect(Collectors.toList());
//
//
//        List<Integer> listGrades = new ArrayList<>();
//        for (Student student : students) {
//            listGrades.addAll(student.getGrades());
//        }
//        listGrades.stream()
//                .mapToDouble(grade -> grade++).average().ifPresent(System.out::println);

        System.out.println(toMap(students));
    }

    public static Map toMap(List<Student> students) {
        Map<Integer, Double> averageStudentMap = students
                .stream()
                .filter(student -> student.getGrades().size() > 3)
                .collect(Collectors.groupingBy(Student::getNumberCourse),
                        Collectors.averagingInt(averageList(Student::getGrades));
        return averageStudentMap;
    }

    public static List<Integer> averageList(List<Student> students){
        List<Integer> gradesAll = new ArrayList<>();

        for (Student student : students) {
            gradesAll.addAll(student.getGrades());
        }
        return gradesAll;
    }


    static double average (List<Integer> listStudent) {

        double sum = 0;
        for(int i=0;i<listStudent.size();i++) {
            sum+=listStudent.get(i);
        }
        return sum/listStudent.size();
    }
}
