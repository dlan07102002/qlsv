package view;

import javax.swing.*;

import controller.FilterController;
import model.QLSVModel;
import model.Student;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FilterView extends JFrame {
    private QLSVModel qlsvModel;
    private QLSVModel qlsvModel_temp = new QLSVModel();


    private JLabel lblStuCode, lblStuName;
    private JTextField txtStuCode, txtStuName;
    private JButton jButton_filter;

    public FilterView(QLSVModel qlsvModel) throws ParseException {
        this.qlsvModel = qlsvModel;
        init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setSize(400, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);


        JPanel jPanel_center = new JPanel(new GridLayout(2,2));
        lblStuCode = new JLabel("Mã Sinh Viên:");
        txtStuCode = new JTextField();
        lblStuName = new JLabel("Họ và Tên:");
        txtStuName = new JTextField();

        //Tạo Controller
        FilterController filterController = new FilterController(this);

        jButton_filter = new JButton("Lọc");
        jButton_filter.addActionListener(filterController);        


        jPanel_center.add(lblStuCode);
        jPanel_center.add(txtStuCode);
        jPanel_center.add(lblStuName);
        jPanel_center.add(txtStuName);

        this.add(jPanel_center, BorderLayout.CENTER);
        this.add(jButton_filter, BorderLayout.SOUTH);


        this.setVisible(true);

    }

    public void filteredStudent() throws ParseException{
        String inputStuName = txtStuName.getText();
        String inputStuCode = txtStuCode.getText();
        if(!inputStuName.isEmpty()){
            ArrayList<Student> filteredList = qlsvModel.searchStudent(txtStuName.getText());
            qlsvModel_temp.setStuList(filteredList);
        } else
        {
            ArrayList<Student> filteredList = new ArrayList<Student>();
            Student temp = qlsvModel.searchStudentById(Integer.parseInt(inputStuCode));
            filteredList.add(temp);
            qlsvModel_temp.setStuList(filteredList);
        }
    }



    public void switchToQLSVView() throws ParseException {
        // Tạo một UpdateView mới và ẩn view hiện tại
        QLSVView qlsvView = new QLSVView(qlsvModel_temp);
        this.setVisible(false);
    }
    
}


