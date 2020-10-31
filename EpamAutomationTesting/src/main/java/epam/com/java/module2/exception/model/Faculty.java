package epam.com.java.module2.exception.model;

import epam.com.java.module2.exception.exceptions.NoGroupForFacultyException;
import epam.com.java.module2.exception.exceptions.NoStudentsInGroupException;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private University university;
    private String facultyName;
    private List<Group> groups;

    public Faculty(String facultyName) {
        this.facultyName = facultyName;
        groups = new ArrayList<>();
    }

    public Faculty(String facultyName, University university) {
        this(facultyName);
        this.university = university;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public void calculateAverageMarkForGroupAndSubject(Group group, Subject subject) throws NoGroupForFacultyException, NoStudentsInGroupException {
        if (groups.isEmpty()) {
            throw new NoGroupForFacultyException("Faculty '" + facultyName + "' has not groups!");
        }
        if (group.getStudents().isEmpty()) {
            throw new NoStudentsInGroupException("Faculty '"+facultyName+"', group '" + group.getGroupName() + "' has no student!");
        }
        if (groups.contains(group)) {
            List<Integer> studentsMarks = new ArrayList<>();
            group.getStudents().
                    forEach(student -> student.getMarks().stream()
                            .filter(mark -> mark.getSubject().equals(subject)).map(Mark::getMark).forEachOrdered(studentsMarks::add));

            double averageMark = studentsMarks.stream().mapToDouble(a -> a).average().orElse(0.0);
            if (averageMark != 0.0) {
                NumberFormat formatted = new DecimalFormat("#0.00");
                System.out.println("Faculty '" + facultyName + "', group '" + group.getGroupName() + "' has average mark " +
                        formatted.format(averageMark) + " for subject '" + subject.name() + "'.");
            } else {
                System.out.println("Faculty '" + facultyName + "', group '" + group.getGroupName() + "' has not subject '" + subject.name() + "'.");
            }
        } else {
            System.out.println("Faculty '"+facultyName+"' has not '" + group.getGroupName() + "'!");
        }
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyName='" + facultyName + '\'' +
                ", groups=" + groups +
                '}';
    }
}
