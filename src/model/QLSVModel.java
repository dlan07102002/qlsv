package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class QLSVModel {
    private static ArrayList<Student> stuList;

    public QLSVModel() throws ParseException{
        Student s1 = new Student(1,"Đức Lân", "Hà Nội", new SimpleDateFormat("dd/MM/yyyy").parse("07/10/2002") ,true);
        Student s2 = new Student(2,"Bá Phúc", "Hải Dương", new SimpleDateFormat("dd/MM/yyyy").parse("26/11/2002") ,true);
        Student s3 = new Student(3,"Hoàng Giang", "Địa Ngục", new SimpleDateFormat("dd/MM/yyyy").parse("15/05/2002") ,true);
        Student s4 = new Student(4,"Bạch Lân", "Hà Nội", new SimpleDateFormat("dd/MM/yyyy").parse("07/10/2002") ,true);
     
        this.stuList = new ArrayList<Student>();
        
        System.out.println("Create");

        this.insert(s1);
        this.insert(s2);
        this.insert(s3);
        this.insert(s4);
   
 
        
        Collections.sort(this.stuList);

    }

    public QLSVModel(ArrayList<Student> stuList){
        this.stuList = stuList;
    }

    public void setStuList(ArrayList<Student> stuList){
        this.stuList = stuList;
    }

    public ArrayList<Student> getStuList() {
        return stuList;
    }


    //Các tính năng thêm, sửa, xóa sinh viên
    public void insert(Student student){
        this.stuList.add(student);
    }

    public void delete(Student student){
        this.stuList.remove(student);
    }

    public void update(Student stuSrc, Student stuDist){
        this.stuList.remove(stuSrc);
        this.stuList.add(stuDist);
    }

    //Lọc danh sách sinh viên theo tên
    public ArrayList<Student> searchStudent(String ten){
        ArrayList<Student> listTemp = new ArrayList<Student>();
        for(Student i : stuList){
            if(i.getStuName().indexOf(ten)>=0){
                listTemp.add(i);
            }
        }

        return listTemp;
    }

    //Lọc danh sách sinh viên theo ID
    public Student searchStudentById(int id){
        for(Student i : stuList){
            if(i.getStuCode() == id){
                return i;
            }
        }
        return null;
    }

    public boolean isStuCodeExist(int stuCode){
        for(Student i : stuList){
            if(i.getStuCode() == stuCode){
                return true;
            }
        }
        return false;
    }

    public boolean isStudentExist(Student sv){
        return this.stuList.contains(sv);
    }



}
