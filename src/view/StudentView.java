package view;

import javax.swing.*;

import controller.FilterController;
import model.QLSVModel;
import model.Score;
import model.ScoreModel;
import model.Student;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StudentView extends JFrame {
    private QLSVModel qlsvModel;
    private ScoreModel scoreModel;
    private boolean flag = false;

    private JLabel lblStuCode, lblStuName, lblHomeTown, lblDob, lblGender, lblMatScore, lblPhyScore, lblCheScore, lblTotalScore, lblType;
    private JLabel txtStuCode, txtStuName, txtHomeTown, txtDob, txtGender, txtMatScore, txtPhyScore, txtCheScore, txtTotalScore, txtType;
    private JButton jButton_filter;

    public StudentView(int stuCode, QLSVModel qlsvModel, ScoreModel scoreModel){
        this.qlsvModel =  qlsvModel;
        this.scoreModel = scoreModel;
        Student stu = this.qlsvModel.searchStudentById(stuCode);
        Score sco = this.scoreModel.searchScoreById(stuCode);
        // System.out.println(stu, sco);
        if(flag == true){
            this.removeAll();
            flag = false;
        }
        init(stu, sco);
        
    }

    private void init(Student stu, Score sco) {
        flag = true;
        this.setLayout(new BorderLayout());
        JPanel jpanel_center = new JPanel(new GridLayout(9  , 2));
        this.setBackground(Color.BLACK);
       
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        

        lblStuCode = new JLabel("Mã Sinh Viên: ");
        txtStuCode =  new JLabel(stu.getStuCode()+"");
        lblStuName = new JLabel("Họ và Tên:");
        txtStuName =  new JLabel(stu.getStuName()+"");
        lblHomeTown = new JLabel("Quê quán: ");
        txtHomeTown =  new JLabel(stu.getHomeTown()+"");
        lblDob = new JLabel("Ngày sinh:");
        txtDob =  new JLabel(stu.getDateOfBirth()+"");
        lblGender = new JLabel("Giới tính: ");
        if(stu.getGender()){
            txtGender =  new JLabel("Nam");
        } else txtGender = new JLabel("Nữ");
        lblMatScore = new JLabel("Điểm toán: ");
        txtMatScore = new JLabel(sco.getMatScore() + "");
        lblPhyScore = new JLabel("Điểm Lý: ");
        txtPhyScore = new JLabel(sco.getPhyScore() + "");
        lblCheScore = new JLabel("Điểm hóa: ");
        txtCheScore = new JLabel(sco.getCheScore() + "");
        lblType = new JLabel("Xếp loại: ");
        txtType = new JLabel(sco.classification());


        jpanel_center.add(lblStuCode);
        jpanel_center.add(txtStuCode);
        jpanel_center.add(lblStuName);
        jpanel_center.add(txtStuName);
        jpanel_center.add(lblHomeTown);
        jpanel_center.add(txtHomeTown);
        jpanel_center.add(lblDob);
        jpanel_center.add(txtDob);
        jpanel_center.add(lblGender);
        jpanel_center.add(txtGender);
        jpanel_center.add(lblMatScore);
        jpanel_center.add(txtMatScore);
        jpanel_center.add(lblPhyScore);
        jpanel_center.add(txtPhyScore);
        jpanel_center.add(lblCheScore);
        jpanel_center.add(txtCheScore);
        jpanel_center.add(lblType);
        jpanel_center.add(txtType);

        this.add(jpanel_center, BorderLayout.CENTER);
        
        this.setVisible(true);  
    }
    
}


