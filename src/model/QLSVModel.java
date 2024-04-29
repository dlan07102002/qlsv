package model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import dao.QLSVModelDAO;

public class QLSVModel {
    //Danh sách các sinh viên, những hàm thêm sửa xóa 
    private static ArrayList<Student> stuList = new ArrayList<Student>();
    
    public QLSVModel() {
        try {
            ArrayList<Student> list = QLSVModelDAO.getInstance().selectAll();
            this.setStuList(list);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Create");
        
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
        QLSVModelDAO.getInstance().insert(student);
    }

    public void delete(Student student){
        this.stuList.remove(student);
        QLSVModelDAO.getInstance().drop(student);

    }

    public void update(Student stuSrc, Student stuDist){
        stuSrc.setStuName(stuDist.getStuName());
        stuSrc.setHomeTown(stuDist.getHomeTown());
        stuSrc.setDateOfBirth(stuDist.getDateOfBirth());
        stuSrc.setGender(stuDist.getGender());

        QLSVModelDAO.getInstance().update(stuDist);
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

    //Tìm sinh viên theo ID
    public Student searchStudentById(int id){
        Student target =  QLSVModelDAO.getInstance().selectByID(id);
        if(target!=null){
            return target;
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
