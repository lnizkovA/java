package epam.com.java.module1.classes.student;

import epam.com.java.module1.classes.Course;
import epam.com.java.module1.classes.Group;
import epam.com.java.module1.classes.Department;

import java.util.*;

public class StudentListUtils {
    private List<Student> studentsList = new ArrayList<>();

    public void addStudent(Student student) {
        studentsList.add(student);
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void printStudents(List<Student> students) {
        sortStudentsInAlphabeticalOrder(students);
        students.forEach(student -> System.out.println(student.toString()));
    }

    public void sortStudentsInAlphabeticalOrder(List<Student> students) {
        students.sort((o1, o2) -> {
            int surnameCompareResult = o1.getSurname().compareTo(o2.getSurname());
            return ((surnameCompareResult == 0) ? o1.getName().compareTo(o2.getName()) : surnameCompareResult);
        });
    }


    public void printStudentsByDepartment(Department department) {
        List<Student> students = new ArrayList<>();
        System.out.println("Students of " + department + " department:");
        for (Student student : studentsList) {
            if (student.getDepartment() != null && student.getDepartment().equals(department)) {
                students.add(student);
            }
        }
        if (!students.isEmpty()) {
            printStudents(students);
        } else {
            System.out.println("No students in " + department + " department!");
        }
    }

    public void printStudentByDepartmentAndCourse(Department department, Course course) {
        List<Student> students = new ArrayList<>();
        System.out.println("Students of " + department + " department  and " + course + " course:");
        for (Student student : studentsList) {
            if (student.getDepartment() != null && student.getDepartment().equals(department)) {
                if (student.getCourse() != null && student.getCourse().equals(course)) {
                    students.add(student);
                }
            }
        }
        if (!students.isEmpty()) {
            printStudents(students);
        } else {
            System.out.println("No students in " + department + " department and " + course + " course!");
        }
    }

    public void printStudentsByGroup(Group group) {
        List<Student> students = new ArrayList<>();
        System.out.println("Students of " + group + " group:");
        for (Student student : studentsList) {
            if (student.getGroup() != null && student.getGroup().equals(group)) {
                students.add(student);
            }
        }
        if (!students.isEmpty()) {
            printStudents(students);
        } else {
            System.out.println("No students in " + group + " group!");
        }
    }

    public void printStudentByYearBirth(int year) {
        List<Student> students = new ArrayList<>();
        System.out.println("Students who were born after " + year + " year:");
        for (Student student : studentsList) {
            if (student.getDateOfBirth() != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(student.getDateOfBirth());
                int studentBirthYear = calendar.get(Calendar.YEAR);
                if (studentBirthYear > year){
                    students.add(student);
                }
            }
        }
        if (!students.isEmpty()) {
            printStudents(students);
        } else {
            System.out.println("No student(s) who was born after " + year + " year!");
        }
    }

}
