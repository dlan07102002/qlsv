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
        // stuSrc.setStuName(stuDist.getStuName());
        // stuSrc.setHomeTown(stuDist.getHomeTown());
        // stuSrc.setDateOfBirth(stuDist.getDateOfBirth());
        // stuSrc.setGender(stuDist.getGender());
        int indexSrc = 0;
        for (int i = 0; i < stuList.size(); i++) {
            if(stuList.get(i).getStuCode() == stuSrc.getStuCode()){
                indexSrc = i;
                stuList.set(indexSrc, stuDist);
                QLSVModelDAO.getInstance().update(stuDist);
                return;
            }
        }
    }

    //Lọc danh sách sinh viên theo tên
    public ArrayList<Student> searchStudent(String name){
        ArrayList<Student> listTemp = QLSVModelDAO.getInstance().selectByName(name);
        if(listTemp.size() != 0){
            return listTemp;
        }
        return null;
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
