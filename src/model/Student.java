package model;

import java.util.Date;
import java.util.Objects;


public class Student implements Comparable<Student> {
    private int stuCode;
    private String stuName;
    private String homeTown;
    private Date dateOfBirth;
    private boolean sex; //1: Male, 0: Female


    public Student(int stuCode, String stuName, String homeTown, Date dateOfBirth, boolean sex){
        this.stuCode = stuCode;
        this.stuName = stuName;
        this.homeTown = homeTown;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }

    public Student()  {
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public int getStuCode() {
        return stuCode;
    }

    public String getStuName() {
        return stuName;
    }

    public boolean getSex(){
        return sex;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setStuCode(int stuCode) {
        this.stuCode = stuCode;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    @Override
    public String toString() {
        return "Student{" + "\n"
            +"- Student Name: " + stuName + "\n"
            +"- Student Code: " + stuCode + "\n"
            +"- Date of Birth: " + dateOfBirth + "\n"
            +"- Home Town: " + homeTown + "\n"
            +"- Sex: " + sex + "\n";
    }

   
    public int hashCode() {
        // TODO Auto-generated method stub
        return Objects.hash(stuCode,sex,stuName, homeTown, dateOfBirth);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return stuCode == student.stuCode &&
                sex == student.sex &&
                Objects.equals(stuName, student.stuName) &&
                Objects.equals(homeTown, student.homeTown) &&
                Objects.equals(dateOfBirth, student.dateOfBirth);
    }

    @Override
    public int compareTo(Student o) {
        if(this.getStuCode() > o.getStuCode()){
            return 1;
        }
        else if(this.getStuCode() == o.getStuCode()){
            return 0;
        }
        else return -1;
    }

}

