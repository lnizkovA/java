package epam.com.java.module2.exception;

import epam.com.java.module2.exception.exceptions.*;
import epam.com.java.module2.exception.model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IncorrectMarkException, NoStudentsInGroupException, NoGroupForFacultyException {

        University bgu = new University("BGU");

        Faculty fpm = new Faculty("FPM", bgu);
        Faculty mathematics = new Faculty("Mathematics");
        Faculty biology = new Faculty("Biology");
        mathematics.setUniversity(bgu);
        biology.setUniversity(bgu);

        bgu.addFaculty(fpm);
        bgu.addFaculty(mathematics);
        bgu.addFaculty(biology);

        List<Group> fpmGroups = new ArrayList<>();
        Group group1 = new Group("Group1",fpm);
        Group group2 = new Group("Group2");

        fpmGroups.add(group1);
        fpmGroups.add(group2);

        fpm.setGroups(fpmGroups);

        group2.setFaculty(fpm);

        List<Student> fpmGroup1Students = new ArrayList<>();
        Student st1 = new Student("Ivan", "Ivanov");
        Student st2 = new Student("Peter", "Sidorov");
        Student st3 = new Student("Nick", "Semenov", group1);
        fpmGroup1Students.add(st3);
        group1.setStudents(fpmGroup1Students);
        group1.addStudent(st1);
        group1.addStudent(st2);

        st1.setGroup(group1);
        st2.setGroup(group1);

        //--------- add mark for subject to student ------
        st2.addMark(Subject.MATH, 6);
        st2.addMark(Subject.MATH, 8);
        st2.addMark(Subject.MATH, 3);
        st1.addMark(Subject.MATH, 5);
        st1.addMark(Subject.MATH, 8);
        st1.addMark(Subject.ENGLISH, 7);
        st1.addMark(Subject.MATH, 7);
        st1.addMark(Subject.MATH, 7);
        st1.addMark(Subject.MATH, 7);
        st1.addMark(Subject.MATH, 7);
        try {
            st1.addMark(Subject.MATH, 11);
        } catch (IncorrectMarkException ex){
            System.out.println(ex.getMessage());
        }

       //----------------------- calculate average mark for student -------------------
        System.out.println("\nMethod -> Calculate average mark of student");
        //--------- 1. Student has subject and marks -------------
        try {
            st1.calculateStudentAverageMark();
        } catch (NoSubjectException e) {
            System.out.println(e.getMessage());
        }
        //-----------2.  No Subject Exception ----------------
        try {
            st3.calculateStudentAverageMark();
        } catch (NoSubjectException e) {
            System.out.println(e.getMessage());
        }

        //--------- calculate average mark for faculty, group and subject ------------
        //------ 1. Faculty has group, students and subject ---------
        System.out.println("\nMethod -> Calculate average mark for faculty, group and subject");
//        System.out.println("\n1. Faculty has group, students and subject");
        try {
            fpm.calculateAverageMarkForGroupAndSubject(group1, Subject.MATH);
        } catch (NoGroupForFacultyException | NoStudentsInGroupException ex) {
            System.out.println(ex.getMessage());
        }
        //------  2. Faculty has group, student , NOT subject -----
//        System.out.println("\n2. Faculty has group, student , NOT subject  ");
        try {
            fpm.calculateAverageMarkForGroupAndSubject(group1, Subject.HISTORY);
        } catch (NoGroupForFacultyException | NoStudentsInGroupException ex) {
            System.out.println(ex.getMessage());
        }
        //---------- 3. Exception NoStudentsInGroup --- Faculty has group , NOT students -------------------------
//        System.out.println("\n3.Exception NoStudentsInGroup --- Faculty has group , NOT students");
        Group group3 = new Group("Group3", mathematics);
        mathematics.addGroup(group3);
        List<Student> group3Students = new ArrayList<>();
        group3.setStudents(group3Students);
        try{
            mathematics.calculateAverageMarkForGroupAndSubject(group3, Subject.MATH);
        } catch (NoStudentsInGroupException | NoGroupForFacultyException ex) {
            System.out.println(ex.getMessage());
        }
        //---------- 4. exception NoGroupForFaculty -------------------------------------
//        System.out.println("\n4. exception NoGroupForFaculty");
        try{
        biology.calculateAverageMarkForGroupAndSubject(group1, Subject.BIOLOGY);
        } catch (NoGroupForFacultyException | NoStudentsInGroupException ex){
            System.out.println(ex.getMessage());
        }
        //--------- 5. Faculty has group, students and subject, BUT putted param incorrect group for faculty
//        System.out.println("\n5. Faculty has group, students and subject, BUT putted param incorrect group for faculty");
        try{
           mathematics.calculateAverageMarkForGroupAndSubject(group1, Subject.MATH);
        } catch (NoStudentsInGroupException | NoGroupForFacultyException ex){
            System.out.println(ex.getMessage());
        }

        //---------------- calculate average mark of subject to university -----------
        //---------- 1. University has faculties, groups, students and subject ---------------
        System.out.println("\nMethod -> Calculate average mark of University for subject");
        try {
            bgu.calculateAverageMarkOfSubjectForUniversity(Subject.MATH);
        } catch (NoFacultyException ex) {
            System.out.println(ex.getMessage());
        }
        //--------- 2. University has faculties, group, student , NOT subject
        University bsuir = new University("BSUIR");
        Faculty information = new Faculty("Information", bsuir);
        bsuir.addFaculty(information);
        Group group4 = new Group("Group4", information);
        information.addGroup(group4);
        Student st4 = new Student("Peter", "Petrov", group4);
        group4.addStudent(st4);
        st4.addMark(Subject.INFORMATION, 9);
        try{
            bsuir.calculateAverageMarkOfSubjectForUniversity(Subject.MATH);
        } catch (NoFacultyException ex){
            System.out.println(ex.getMessage());
        }
        //-----------3. exception NoFacultyException in university ------------------------
        University bntu = new University("BNTU");
        try {
            bntu.calculateAverageMarkOfSubjectForUniversity(Subject.MATH);
        } catch (NoFacultyException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
