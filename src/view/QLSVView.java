package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.dsig.spec.XPathType.Filter;

import controller.QLSVController;
import model.QLSVModel;
import model.Student;


import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class QLSVView extends JFrame {

    SimpleDateFormat dF = new SimpleDateFormat("dd-MM-yyyy");

    private static QLSVModel qlsvModel;
    private JTable table;
    private DefaultTableModel tableModel;

    public QLSVView(QLSVModel qlsvModel) throws ParseException {
        this.qlsvModel = qlsvModel;
        init();
        loadData();
    }

    public void setQlsvModel(QLSVModel qlsvModel) throws ParseException {
        this.qlsvModel = qlsvModel;
        init();
        loadData(qlsvModel);
    }

    public void setQLSVModelRender(ArrayList<Student>  list){
        init();
        loadData(list);
    }

    private void init() {
        
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
        table.setEnabled(false);

        JScrollPane scrollPane = new JScrollPane(table);
        
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        JButton crudButton = new JButton("Thêm/Sửa/Xóa");
        crudButton.addActionListener(qlsvController);
        buttonPanel.add(crudButton);

        JButton filterButton = new JButton("Lọc");
        filterButton.addActionListener(qlsvController);
        buttonPanel.add(filterButton);

        JPanel_main.add(scrollPane, BorderLayout.CENTER);
        JPanel_main.add(buttonPanel, BorderLayout.SOUTH);

        this.add(JPanel_main);
        this.setVisible(true);
    }

    private void loadData() throws ParseException {
        ArrayList<Student> students = qlsvModel.getStuList();
        for (Student student : students) {
            Object[] rowData = {
                    student.getStuCode(),
                    student.getStuName(),
                    student.getHomeTown(),
                    dF.format(student.getDateOfBirth()),
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

    private void loadData(ArrayList<Student> list){
        for (Student student : list) {
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



    public void switchToCrudView() throws ParseException {
        // Tạo một UpdateView mới và ẩn view hiện tại
        CrudView crudView = new CrudView(qlsvModel, this);
        // this.setVisible(false);
    }

    public void switchToFilterView() throws ParseException {
        // Tạo một UpdateView mới và ẩn view hiện tại
        FilterView filterView = new FilterView(qlsvModel, this);
        // this.setVisible(false);
    }
}
