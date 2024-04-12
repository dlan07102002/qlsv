package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.QLSVModel;
import model.Student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class QLSVView extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    private QLSVModel model;
    private JPanel contentPane;

    public QLSVView(){
        this.model = new QLSVModel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,450,300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
    }

    // private void initComponents() {
    //     JPanel mainPanel = new JPanel(new BorderLayout());

    //     // Table
    //     tableModel = new DefaultTableModel();
    //     tableModel.addColumn("Mã sinh viên");
    //     tableModel.addColumn("Tên sinh viên");
    //     tableModel.addColumn("Địa chỉ");
    //     tableModel.addColumn("Ngày sinh");
    //     tableModel.addColumn("Giới tính");
    //     table = new JTable(tableModel);
    //     JScrollPane scrollPane = new JScrollPane(table);
    //     mainPanel.add(scrollPane, BorderLayout.CENTER);

    //     // Buttons
    //     JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    //     JButton addButton = new JButton("Thêm");
    //     addButton.addActionListener(new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             // Xử lý sự kiện thêm sinh viên
    //         }
    //     });
    //     JButton deleteButton = new JButton("Xóa");
    //     deleteButton.addActionListener(new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             // Xử lý sự kiện xóa sinh viên
    //         }
    //     });
    //     buttonPanel.add(addButton);
    //     buttonPanel.add(deleteButton);
    //     mainPanel.add(buttonPanel, BorderLayout.SOUTH);

    //     add(mainPanel);
    // }

    // private void loadData() {
    //     ArrayList<Student> students = model.getAllStudents();
    //     for (Student student : students) {
    //         Object[] rowData = {
    //                 student.getStuCode(),
    //                 student.getStuName(),
    //                 student.getHomeTown(),
    //                 student.getDateOfBirth(),
    //                 student.getSex()
    //         };
    //         tableModel.addRow(rowData);
    //     }
    // }
    public static void main(String[] args) {
        
    }
}
