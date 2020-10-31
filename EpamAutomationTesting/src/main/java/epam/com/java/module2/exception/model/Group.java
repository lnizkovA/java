package epam.com.java.module2.exception.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupName;
    private Faculty faculty;
    private List<Student> students;

    public Group(String groupName){
        this.groupName = groupName;
        students = new ArrayList<>();
    }
    public Group(String groupName, Faculty faculty){
        this(groupName);
        this.faculty = faculty;
    }

    public String getGroupName() {
        return groupName;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", students=" + students +
                '}';
    }
}
