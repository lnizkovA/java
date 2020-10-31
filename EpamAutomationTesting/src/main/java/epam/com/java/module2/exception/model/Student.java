package epam.com.java.module2.exception.model;

import epam.com.java.module2.exception.exceptions.IncorrectMarkException;
import epam.com.java.module2.exception.exceptions.NoSubjectException;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String surname;
    private Group group;
    private List<Mark> marks;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        marks = new ArrayList<>();
    }

    public Student(String name, String surname, Group group) {
        this(name, surname);
        this.group = group;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void addMark(Subject subject, int mark) throws IncorrectMarkException {
        if (mark < 0 || mark > 10) {
            throw new IncorrectMarkException("Mark should be between 0 and 10");
        }
        marks.add(new Mark(subject, mark));
    }

    public void calculateStudentAverageMark() throws NoSubjectException {
        if (marks.isEmpty()){
            throw new NoSubjectException("Student " + name + " " + surname + " has not any subject!");
        }
        else {
            NumberFormat formatted = new DecimalFormat("#0.00");
            marks.stream().mapToInt(Mark::getMark)
                    .average()
                    .ifPresent(average -> System.out.println("Student " + name + " " + surname + " has average mark =" +
                            formatted.format(average)));
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                " name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", marks=" + marks +
                '}';
    }
}
