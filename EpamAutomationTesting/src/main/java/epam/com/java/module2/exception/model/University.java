package epam.com.java.module2.exception.model;

import epam.com.java.module2.exception.exceptions.NoFacultyException;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class University {
    private String universityName;
    private List<Faculty> faculties;

    public University(String universityName){
        this.universityName = universityName;
        faculties = new ArrayList<>();
    }

    public String getUniversityName() {
        return universityName;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public void addFaculty(Faculty faculty){
        faculties.add(faculty);
    }

    public void calculateAverageMarkOfSubjectForUniversity(Subject subject) throws NoFacultyException {
        if(faculties.isEmpty()){
            throw new NoFacultyException ("University '"+universityName+"' has no faculty(ies)!");
        }
        int count=0;
        double sum=0;
        for (Faculty faculty: faculties ) {
            for (Group group: faculty.getGroups()) {
                for (Student student: group.getStudents() ) {
                    for (Mark mark: student.getMarks()) {
                        if(mark.getSubject().equals(subject)){
                            sum += mark.getMark();
                            count++;
                        }
                    }
                }
            }
        }
        if (sum == 0) {
            System.out.println("University '"+universityName+"' has no subject '"+subject.name()+"'!");
        }else {
            NumberFormat formatter = new DecimalFormat("#0.00");
            System.out.println("University '"+universityName+"' has average mark = "+formatter.format(sum/count)+
                    " for subject '"+subject.name()+"'.");
        }
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + universityName + '\'' +
                ", faculties=" + faculties +
                '}';
    }
}
