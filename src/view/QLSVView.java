package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;
import model.AccountModel;
import model.QLSVModel;
import model.ScoreModel;
import model.Student;


import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class QLSVView extends JFrame {

    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
    private static AccountModel accModel;
    private static QLSVModel qlsvModel;
    private static ScoreModel scoreModel;
    private DefaultTableModel tableModel = new DefaultTableModel()
    {
        // Không cho phép chỉnh sửa các ô
        public boolean isCellEditable(int row, int column) {
            return false; 
        }
    };


    private String prio;
    private QLSVController qlsvController = new QLSVController(this);
    private JTable table = new JTable(tableModel);


    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public JTable getTable() {
        return table;
    }

    public QLSVView(String prio, AccountModel accModel, QLSVModel qlsvModel, ScoreModel scoreModel) throws ParseException {
        this.prio = prio;
        this.accModel = accModel;
        this.qlsvModel = qlsvModel;
        this.scoreModel = scoreModel;
        init(prio);
        loadData();
    }

    public void setReset() {
        for(int i = 1; i <= tableModel.getRowCount(); i++){
            tableModel.removeRow(i);
        }
        
    }

    public static QLSVModel getQlsvModel() {
        return qlsvModel;
    }

    public static ScoreModel getScoreModel() {
        return scoreModel;
    }

    public void setQLSVModel(QLSVModel qlsvModel) throws ParseException {
        tableModel.setRowCount(0);
        loadData(qlsvModel);
    }

    private void init(String prio) {
        
        this.setTitle("Quản lý sinh viên");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Font sansSerifFont = new Font("SansSerif", Font.PLAIN, 12);

        JPanel JPanel_main = new JPanel(new BorderLayout());
        
        //Tạo controller -> addActionListener

        // Header

        // Center  
        tableModel.addColumn("Mã sinh viên");
        tableModel.addColumn("Tên sinh viên");
        tableModel.addColumn("Địa chỉ");
        tableModel.addColumn("Ngày sinh");

        table.getSelectionModel().addListSelectionListener(qlsvController.getMouseListener());

        JScrollPane scrollPane = new JScrollPane(table);
        
        
        
        JButton filterButton = new JButton("Lọc");
        filterButton.addActionListener(qlsvController);

        JButton scoreButton = new JButton("Bảng điểm");
        scoreButton.addActionListener(qlsvController);

        JButton logOutButton = new JButton("Đăng xuất");
        logOutButton.addActionListener(qlsvController);

        JPanel buttonPanel = new JPanel(new GridLayout(1,3));   
        
        buttonPanel.add(filterButton);
        buttonPanel.add(scoreButton);
        buttonPanel.add(logOutButton);
        if(prio.equals("root")){
            buttonPanel.setLayout(new GridLayout(2, 3));

            JButton crudButton = new JButton("Thêm/Sửa/Xóa");
            crudButton.addActionListener(qlsvController);
            buttonPanel.add(crudButton);

            JButton createAccButton = new JButton("Tạo tài khoản");
            createAccButton.addActionListener(qlsvController);
            buttonPanel.add(createAccButton);

            JButton deleteAccButton = new JButton("Xóa tài khoản");
            deleteAccButton.addActionListener(qlsvController);
            buttonPanel.add(deleteAccButton);
        } 

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
                    student.getDateOfBirth(),
            };
            tableModel.addRow(rowData);
        }
    }

    private void loadData(QLSVModel qlsvModel_o) throws ParseException {
     
        ArrayList<Student> students = qlsvModel_o.getStuList();
        for (Student student : students) {
            Object[] rowData = {
                    student.getStuCode(),
                    student.getStuName(),
                    student.getHomeTown(),
                    student.getDateOfBirth(),
            };
            tableModel.addRow(rowData);
        }
    }

    public CrudView switchToCrudView() throws ParseException {
        // Tạo một crudView mới 
        return new CrudView(qlsvModel, scoreModel, this);
    }

    public CrudView switchToCrudAccView(){
        return new CrudView(accModel, this);
    }

    public void switchToFilterView() throws ParseException {
        // Tạo một Filter View mới
        FilterView filterView = new FilterView(qlsvModel, this);
    }

    public void switchToScoreView() throws ParseException {
        // Tạo một Filter View mới
        ScoreView scoreView = new ScoreView(prio, qlsvModel, scoreModel);
    }

    public void logout(){
        this.setVisible(false);
        AuthView authView = new AuthView(accModel, qlsvModel, scoreModel);
    }


}
