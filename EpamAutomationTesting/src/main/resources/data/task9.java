package epam.com.java.module2.exception.model;

import java.util.ArrayList;
import java.util.List;

/**
 * comm1
 *
 *
 *
 */

/* comm2 */

public class Group { /// class group
    // class params
    private String groupName;
    int b; /* 1213 */ int a;
    private Faculty faculty;
    int c; /* test */
    /* test3 */ int e = 100;
    private List<Student> students; // jira-1234
    int d; /* test2
     *
     *
     */

    public Group(){
    }

    /**
     * comm3
     * @param groupName       1
     */
    public Group(String groupName){
        this.groupName = groupName;
        students = new ArrayList<>();
    }
    //12345
    public Group(String groupName, Faculty faculty){
        /* aaaa */
        this(groupName);
        this.faculty = faculty;
    }
    //12345
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
