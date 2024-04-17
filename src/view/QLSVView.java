package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;
import model.QLSVModel;
import model.Student;


import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class QLSVView extends JFrame {
    private static QLSVModel qlsvModel;
    private JTable table;
    private DefaultTableModel tableModel;

    public QLSVView() throws ParseException {
        this.qlsvModel = new QLSVModel();
        initComponents();
        loadData();
    }

    public QLSVView(QLSVModel qlsvModel) throws ParseException {
        this.qlsvModel = qlsvModel;
        initComponents();
        loadData(qlsvModel);
    }


    private void initComponents() {
        
        this.setTitle("Quản lý sinh viên");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Font sansSerifFont = new Font("SansSerif", Font.PLAIN, 12);

        JPanel JPanel_main = new JPanel(new BorderLayout());
        
        //Tạo controller
        QLSVController qlsvController = new QLSVController(this);

        // Header
        // JPanel JPanel_header = new JPanel(new FlowLayout());
        // JLabel jLabel_header = new JLabel("");

        // Center
        tableModel = new DefaultTableModel();
        
        tableModel.addColumn("Mã sinh viên");
        tableModel.addColumn("Tên sinh viên");
        tableModel.addColumn("Địa chỉ");
        tableModel.addColumn("Ngày sinh");
        // tableModel.addColumn("Giới tính");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        JButton addButton = new JButton("Thêm");
        addButton.addActionListener(qlsvController);

        
        JButton updateButton = new JButton("Sửa");
        updateButton.addActionListener(qlsvController);
        
        JButton deleteButton = new JButton("Xóa");
        
        
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        JPanel_main.add(scrollPane, BorderLayout.CENTER);
        JPanel_main.add(buttonPanel, BorderLayout.SOUTH);

        this.add(JPanel_main);
        this.setVisible(true);
    }

    private void loadData() throws ParseException {
  
        QLSVModel qlsvModel = new QLSVModel();
     
        ArrayList<Student> students = qlsvModel.getStuList();
        for (Student student : students) {
            Object[] rowData = {
                    student.getStuCode(),
                    student.getStuName(),
                    student.getHomeTown(),
                    student.getDateOfBirth(),
                    // student.getSex()
            };
            tableModel.addRow(rowData);
            
        }
    }

    private void loadData(QLSVModel qlsvModel) throws ParseException {
     
        ArrayList<Student> students = qlsvModel.getStuList();
        for (Student student : students) {
            Object[] rowData = {
                    student.getStuCode(),
                    student.getStuName(),
                    student.getHomeTown(),
                    student.getDateOfBirth(),
                    // student.getSex()
            };
            tableModel.addRow(rowData);
            
        }
    }

    public void switchToUpdateView() throws ParseException {
        // Tạo một UpdateView mới và ẩn view hiện tại
        UpdateView updateView = new UpdateView(qlsvModel);
        this.setVisible(false);
    }
}
