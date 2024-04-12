package model;

import java.util.ArrayList;

public class QLSVModel {
    private ArrayList<Student> stuList;

    public QLSVModel(){
        this.stuList = new ArrayList<Student>();
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

    public void insert(Student student){
        this.stuList.add(student);
    }

    public void delete(Student student){
        this.stuList.remove(student);
    }

    public void update(Student student){
        this.stuList.remove(student);
        this.stuList.add(student);
    }

}
