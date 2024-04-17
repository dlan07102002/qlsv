package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.QLSVModel;
import model.Student;


import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class QLSVView extends JFrame {
    private QLSVModel qlsvModel;
    private JTable table;
    private DefaultTableModel tableModel;

    public QLSVView() throws ParseException {
        this.qlsvModel = new QLSVModel();
        initComponents();
        loadData();
    }


    private void initComponents() {
        
        this.setTitle("Quản lý sinh viên");
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Font sansSerifFont = new Font("SansSerif", Font.PLAIN, 12);
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Table
        tableModel = new DefaultTableModel();
        
        tableModel.addColumn("Mã sinh viên");
        tableModel.addColumn("Tên sinh viên");
        tableModel.addColumn("Địa chỉ");
        tableModel.addColumn("Ngày sinh");
        // tableModel.addColumn("Giới tính");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton addButton = new JButton("Thêm");

        JButton updateButton = new JButton("Sửa");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchToUpdateView();
            }
        });

        JButton deleteButton = new JButton("Xóa");
      
        
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(mainPanel);
        this.setVisible(true);
    }

    private void loadData() throws ParseException {
        Student s1 = new Student(1,"Đức Lân", "Hà Nội", new SimpleDateFormat("dd/MM/yyyy").parse("07/10/2002") ,true);
        Student s2 = new Student(2,"Bá Phúc", "Hải Dương", new SimpleDateFormat("dd/MM/yyyy").parse("26/11/2002") ,true);
        Student s3 = new Student(3,"Hoàng Giang", "Địa Ngục", new SimpleDateFormat("dd/MM/yyyy").parse("15/05/2002") ,true);
        Student s4 = new Student(4,"Đức Lân", "Hà Nội", new SimpleDateFormat("dd/MM/yyyy").parse("07/10/2002") ,true);
        Student s5 = new Student(5,"Bá Phúc", "Hải Dương", new SimpleDateFormat("dd/MM/yyyy").parse("26/11/2002") ,true);
        Student s6 = new Student(6,"Hoàng Giang", "Địa Ngục", new SimpleDateFormat("dd/MM/yyyy").parse("15/05/2002") ,true);

        QLSVModel qlsvModel = new QLSVModel();
        qlsvModel.insert(s1);
        qlsvModel.insert(s2);
        qlsvModel.insert(s3);
        qlsvModel.insert(s4);
        qlsvModel.insert(s5);
        qlsvModel.insert(s6);
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

    private void switchToUpdateView() {
        // Tạo một UpdateView mới và ẩn view hiện tại
        UpdateView updateView = new UpdateView();
        this.setVisible(false);
    }
}
