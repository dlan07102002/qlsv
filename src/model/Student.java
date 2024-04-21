package model;

import java.sql.Date;
import java.util.Objects;


public class Student implements Comparable<Student> {
    private int stuCode;
    private String stuName;
    private String homeTown;
    private Date dateOfBirth;
    private boolean gender; //1: Male, 0: Female
    // private Score scoreTable;

    //Tạo ra một instance, overloading - nạp chồng
    public Student(int stuCode, String stuName, String homeTown, Date dateOfBirth, boolean gender){
        this.stuCode = stuCode;
        this.stuName = stuName;
        this.homeTown = homeTown;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public Student(int stuCode, String stuName, String homeTown, Date dateOfBirth, boolean gender, Score scoreTable){
        this.stuCode = stuCode;
        this.stuName = stuName;
        this.homeTown = homeTown;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        // this.scoreTable = scoreTable;
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

    public boolean getGender(){
        return gender;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
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
            +"- Gender: " + gender + "\n";
    }

   
    public int hashCode() {
        // TODO Auto-generated method stub
        return Objects.hash(stuCode,gender,stuName, homeTown, dateOfBirth);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return stuCode == student.stuCode &&
                gender == student.gender &&
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

