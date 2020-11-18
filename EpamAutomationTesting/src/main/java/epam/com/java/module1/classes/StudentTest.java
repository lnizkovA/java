package epam.com.java.module1.classes;

import epam.com.java.module1.classes.student.StudentListUtils;
import epam.com.java.module1.classes.student.Student;

import java.util.Calendar;
import java.util.GregorianCalendar;

/*
Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти данные на консоль.
В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.

1. Student: id, Фамилия, Имя, Отчество, Дата рождения, Адрес, Телефон, Факультет, Курс, Группа.

Создать массив объектов. Вывести:

a) список студентов заданного факультета;

b) списки студентов для каждого факультета и курса;

c) список студентов, родившихся после заданного года;

d) список учебной группы.
 */

public class StudentTest {
    public static void main(String[] args)  {
        Student st1 = new Student("Ivanov",
                "Ivan",
                "Petrov");
        Student st2 = new Student("Petrov", "Peter", "Vasilevich",
                new GregorianCalendar(2000, Calendar.JULY, 11).getTime());
        Student st3 = new Student("Petrov", "Peter", "Vasilevich",
                new GregorianCalendar(2000, Calendar.MARCH, 20).getTime());
        Student.Adress st3Adress = st3.new Adress("Belarus", "", "", "");
        st3.setAdress(st3Adress);
        st2.setAdress(st2.new Adress("Belarus", "Minsk", "Zhukova", ""));
        Student st4 = new Student("Semenov", "Igor", "Vladimirovich",
                new GregorianCalendar(2000, Calendar.FEBRUARY, 5).getTime(), Department.MATHEMATICS);
        Student.Adress st4Adress = st4.new Adress("Belarus", "Minsk", "Ponomarenko", "62");
        st4.setAdress(st4Adress);
        st4.setApartmentNumber(88);
        Student st5 = new Student("Andreeva", "Anna", "Petrovna",
                new GregorianCalendar(1999, Calendar.AUGUST, 11).getTime(),Department.MATHEMATICS, Course.SECOND, Group.GROUP1);
        Student.Adress st5Adress = st5.new Adress("Belarus");
        st5.setAdress(st5Adress);
        Student st6 = new Student("Glebka", "Sergei", "Igorovich",
                new GregorianCalendar(1999, Calendar.AUGUST, 15).getTime(), Department.MATHEMATICS, Course.FIRST);
        st6.setAdress(st6.new Adress("Belarus", "Brest"));
        Student st7 = new Student("Blonova", "Diana", "Valerevna",
                new GregorianCalendar(2001, Calendar.MARCH, 8).getTime(), Department.BIOLOGY, Course.FIRST, Group.GROUP1);
        Student st8 = new Student("Blinov", "Pavel", "Igorovich",
                new GregorianCalendar(1998, Calendar.JANUARY, 1).getTime(), Department.PSYCHOLOGY, Course.THIRD, Group.GROUP3);
        Student st9 = new Student("Luzhkova", "Kate", "Petrovna",
                new GregorianCalendar(2000, Calendar.MARCH, 3).getTime(),Department.MATHEMATICS, Course.SECOND, Group.GROUP2);
        Student st10 = new Student("Ashenko", "Tanya", "Denisovna",
                new GregorianCalendar(2000, Calendar.FEBRUARY, 2).getTime(),Department.BIOLOGY, Course.FIRST, Group.GROUP2);
        Student st11 = new Student("Tarasevich", "Denis", "Petrov",
                new GregorianCalendar(1999, Calendar.MARCH, 8).getTime(),Department.MATHEMATICS, Course.SECOND, Group.GROUP1);
        Student st12 = new Student("Andreeva", "Angilina", "Petrovna",
                new GregorianCalendar(2000, Calendar.AUGUST, 11).getTime(),Department.MATHEMATICS, Course.SECOND, Group.GROUP1);
        st12.setAdress(st12.new Adress("Belarus"));

        StudentListUtils students = new StudentListUtils();
        students.addStudent(st1);
        students.addStudent(st2);
        students.addStudent(st3);
        students.addStudent(st4);
        students.addStudent(st5);
        students.addStudent(st6);
        students.addStudent(st7);
        students.addStudent(st8);
        students.addStudent(st9);
        students.addStudent(st10);
        students.addStudent(st11);
        students.addStudent(st12);
        students.printStudents(students.getStudentsList());
        students.printStudentsByDepartment(Department.MATHEMATICS);
        students.printStudentByDepartmentAndCourse(Department.MATHEMATICS, Course.SECOND);
        students.printStudentsByGroup(Group.GROUP1);
        students.printStudentByYearBirth(2000);

    }
}
