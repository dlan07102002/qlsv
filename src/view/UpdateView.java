package view;

import javax.swing.*;

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
    private JButton btnSave;

    public UpdateView() {
        this.qlsvModel = new QLSVModel();
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
        btnSave = new JButton("Save");

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    saveUpdatedStudentData();
                } catch (ParseException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

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
        add(btnSave);

        this.setVisible(true);

    }

    private void saveUpdatedStudentData() throws ParseException {
        int stuCode = Integer.parseInt(txtStuCode.getText());
        String stuName = txtStuName.getText();
        String homeTown = txtHomeTown.getText();
        Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(txtDateOfBirth.getText());
        boolean sex = Boolean.parseBoolean(txtSex.getText());
        Student temp = new Student(stuCode, stuName, homeTown, dateOfBirth, sex);
        qlsvModel.update(temp);

        JOptionPane.showMessageDialog(this, "Student information updated successfully.");
    }

    
}


