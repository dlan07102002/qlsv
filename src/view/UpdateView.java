package view;

import javax.swing.*;

import controller.UpdateController;
import model.QLSVModel;
import model.Student;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateView extends JFrame {
    private QLSVModel qlsvModel;

    private JLabel lblStuCode, lblStuName, lblHomeTown, lblDateOfBirth, lblSex;
    private JTextField txtStuCode, txtStuName, txtHomeTown, txtDateOfBirth, txtSex;
    private JButton jButton_save, jButton_create;

    public UpdateView(QLSVModel qlsvModel) throws ParseException {
        this.qlsvModel = qlsvModel;
        initializeComponents();
    }

    private void initializeComponents() {
        this.setLayout(new GridLayout(6, 2));
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lblStuCode = new JLabel("Student Code:");
        txtStuCode = new JTextField();
        lblStuName = new JLabel("Student Name:");
        txtStuName = new JTextField();
        lblHomeTown = new JLabel("Home Town:");
        txtHomeTown = new JTextField();
        lblDateOfBirth = new JLabel("Date of Birth:");
        txtDateOfBirth = new JTextField();
        lblSex = new JLabel("Sex:");
        txtSex = new JTextField();

        UpdateController updateController = new UpdateController(this);

        jButton_create = new JButton("Thêm");
        jButton_create.addActionListener(updateController);


        jButton_save = new JButton("Lưu");
        jButton_save.addActionListener(updateController);

        add(lblStuCode);
        add(txtStuCode);
        add(lblStuName);
        add(txtStuName);
        add(lblHomeTown);
        add(txtHomeTown);
        add(lblDateOfBirth);
        add(txtDateOfBirth);
        add(lblSex);
        add(txtSex);
        add(jButton_save);
        add(jButton_create);

        this.setVisible(true);

    }
    public Student info() throws ParseException{
        int stuCode = Integer.parseInt(txtStuCode.getText());
        String stuName = txtStuName.getText();
        String homeTown = txtHomeTown.getText();
        Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(txtDateOfBirth.getText());
        boolean sex = Boolean.parseBoolean(txtSex.getText());
        Student temp = new Student(stuCode, stuName, homeTown, dateOfBirth, sex);
        return temp;
    }

    public void saveUpdatedStudentData() throws ParseException  {
        Student temp = this.info();
        if( qlsvModel.isStuCodeExist(temp.getStuCode()) || qlsvModel.isStudentExist(temp) ){
            JOptionPane.showMessageDialog(this, "Mã sinh viên đã tồn tại! Vui lòng nhập mã sinh viên khác");
        }
        else {
            qlsvModel.insert(temp);
            JOptionPane.showMessageDialog(this, "Thông tin sinh viên đã được thêm thành công!");
        }
    }

    public void saveCreatedStudentData() throws ParseException  {
        Student temp = this.info();
        if( qlsvModel.isStuCodeExist(temp.getStuCode()) || qlsvModel.isStudentExist(temp) ){
            JOptionPane.showMessageDialog(this, "Mã sinh viên đã tồn tại! Vui lòng nhập mã sinh viên khác");
        }
        else {
            qlsvModel.insert(temp);
            JOptionPane.showMessageDialog(this, "Thông tin sinh viên đã được thêm thành công!");
        }
    }
    
    public void switchToQLSVView() throws ParseException {
        // Tạo một UpdateView mới và ẩn view hiện tại
        QLSVView qlsvView = new QLSVView(qlsvModel);
        this.setVisible(false);
    }
    
}


