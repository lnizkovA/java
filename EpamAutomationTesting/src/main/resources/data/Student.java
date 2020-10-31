package epam.com.java.module1.classes.student;

import epam.com.java.module1.classes.Course;
import epam.com.java.module1.classes.Department;
import epam.com.java.module1.classes.Group;

import java.text.SimpleDateFormat;
import java.util.*;

public class Student {

    private UUID id;
    private String surname = "";
    private String name = "";
    private String middleName;
    private Date dateOfBirth;
    private Adress adress;
    private String phoneNumber;
    private Department department;
    private Course course;
    private Group group;

    public Student(String surname, String name, String middleName, Date dateOfBirth, String phoneNumber, Department department, Course course, Group group) {
        id = UUID.randomUUID();
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.course = course;
        this.group = group;
    }

    public Student(String surname, String name, String middleName) {
        this(surname, name, middleName, null, "", null, null, null);
    }

    public Student(String surname, String name, String middleName, Date dateOfBirth) {
        this(surname, name, middleName, null, "", null, null, null);
    }

    public Student(String surname, String name, String middleName, Date dateOfBirth, String phoneNumber) {
        this(surname, name, middleName, dateOfBirth, "", null, null, null);
    }

    public Student(String surname, String name, String middleName, Date dateOfBirth, Department department) {
        this(surname, name, middleName, dateOfBirth, "", department, null, null);
    }

    public Student(String surname, String name, String middleName, Date dateOfBirth, Department department, Course course) {
        this(surname, name, middleName, dateOfBirth, "", department, course, null);
    }

    public Student(String surname, String name, String middleName, Date dateOfBirth, Department department, Course course, Group group) {
        this(surname, name, middleName, dateOfBirth, "", department, course, group);
    }


    public UUID getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public String getCountry() {
        return adress.country;
    }

    public void setCountry(String country) {
        this.adress.country = country;
    }

    public String getCity() {
        return adress.city;
    }

    public void setCity(String city) {
        this.adress.city = city;
    }

    public String getStreet() {
        return adress.city;
    }

    public void setStreet(String street) {
        this.adress.street = street;
    }

    public String getStreetNumber() {
        return adress.streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.adress.streetNumber = streetNumber;
    }

    public int getApartmentNumber() {
        return adress.apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.adress.apartmentNumber = apartmentNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String toString() {
        return "Student: " + " id = " + getUUIDtoString(id) +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", dateOfBirth='" + getFormattedBirthDate(dateOfBirth) + '\'' +
                ", adress='" + adress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", department='" + department + '\'' +
                ", course='" + course + '\'' +
                ", group='" + group + '\'';
    }


    public String getFormattedBirthDate(Date dateOfBirth) {
        if (dateOfBirth != null) {
            String pattern = "dd MMMMM yyyy";
            SimpleDateFormat simpleFormat = new SimpleDateFormat(pattern, new Locale("en-us"));
            return simpleFormat.format(dateOfBirth);
        } else return "";
    }

    public String getUUIDtoString(UUID uuid){
        return uuid.toString().replace("-","").toUpperCase();
    }

    public class Adress {
        private String country;
        private String city;
        private String street;
        private String streetNumber;
        private int apartmentNumber;

        public Adress(String country, String city, String street, String streetNumber, int apartmentNumber) {
            this(country, city, street, streetNumber);
            this.apartmentNumber = apartmentNumber;
        }

        public Adress(String country, String city, String street, String streetNumber) {
            this(country, city, street);
            this.streetNumber = streetNumber;
        }

        public Adress(String country, String city, String street) {
            this.country = country;
            this.city = city;
            this.street = street;
        }

        public Adress(String country, String city) {
            this(country, city, "");
        }

        public Adress(String country) {
            this(country, "", "");
        }

        public Adress() {
            this("", "", "");
        }

        public String toString() {
            return country + ", " + city + ", " + street + " " + streetNumber + "-" + apartmentNumber;
        }
    }
}
