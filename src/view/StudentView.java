package view;

import javax.swing.*;

import model.QLSVModel;
import model.Score;
import model.ScoreModel;
import model.Student;

import java.awt.*;


public class StudentView extends JFrame {
    private QLSVModel qlsvModel;
    private ScoreModel scoreModel;
    // private boolean flag = false;

    private JLabel lblStuCode, lblStuName, lblHomeTown, lblDob, lblGender, lblMatScore, lblPhyScore, lblCheScore, lblTotalScore, lblType;
    private JLabel txtStuCode, txtStuName, txtHomeTown, txtDob, txtGender, txtMatScore, txtPhyScore, txtCheScore, txtTotalScore, txtType;

    public StudentView(int stuCode, QLSVModel qlsvModel, ScoreModel scoreModel){
        this.qlsvModel =  qlsvModel;
        this.scoreModel = scoreModel;
        Student stu = this.qlsvModel.searchStudentById(stuCode);
        Score sco = this.scoreModel.searchScoreById(stuCode);
        // if(flag == true){
        //     this.removeAll();
        //     flag = false;
        // }
        if(sco == null){
            sco = new Score(stuCode, 0, 0, 0);
        }
        init(stu, sco);
        
    }

    private void init(Student stu, Score sco) {
        this.setTitle("Thông tin sinh viên");

        this.setLayout(new BorderLayout());
        JPanel jpanel_center = new JPanel(new GridLayout(9  , 2));
        this.setBackground(Color.BLACK);
       
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);

        Font fontTitlle = new Font("Arial", Font.BOLD, 12);

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


        boolean j = true; 
        for (int i = 0; i < jpanel_center.getComponentCount(); i++) {
            JLabel label = (JLabel) jpanel_center.getComponent(i);
            
            label.setOpaque(true);
            label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
            Color backgroundColor = (j) ? Color.LIGHT_GRAY : new Color(230 , 230 , 230); // Chọn màu nền xen kẽ
            label.setBackground(backgroundColor);

            if(i%2==1){ 
                j = !j;
            }
            else {
                label.setFont(fontTitlle);
            }
            System.out.println(" " + j);
            
        }

        this.add(jpanel_center, BorderLayout.CENTER);
        
        this.setVisible(true);  
    }
    
}


