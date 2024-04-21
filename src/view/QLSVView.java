package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.dsig.spec.XPathType.Filter;

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
    private DefaultTableModel tableModel ;
    private String prio;

    private JTable table ;

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

    public void setQlsvModel(QLSVModel qlsvModel) throws ParseException {
        this.qlsvModel = qlsvModel;
        // init();
        tableModel.setRowCount(0);
        loadData(qlsvModel);
    }

    public void setQLSVModelRender(ArrayList<Student>  list){
        // init();
        tableModel.setRowCount(0);
        loadData(list);
    }

    private void init(String prio) {
        
        this.setTitle("Quản lý sinh viên");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Font sansSerifFont = new Font("SansSerif", Font.PLAIN, 12);

        JPanel JPanel_main = new JPanel(new BorderLayout());
        
        //Tạo controller -> addActionListener
        QLSVController qlsvController = new QLSVController(this);

        // Header
        // JPanel JPanel_header = new JPanel(new FlowLayout());
        // JLabel jLabel_header = new JLabel("");

        // Center
        tableModel = new DefaultTableModel()
        {
            // Không cho phép chỉnh sửa các ô
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        table = new JTable(tableModel);
        
        tableModel.addColumn("Mã sinh viên");
        tableModel.addColumn("Tên sinh viên");
        tableModel.addColumn("Địa chỉ");
        tableModel.addColumn("Ngày sinh");
        // tableModel.addColumn("Giới tính");

        table.getSelectionModel().addListSelectionListener(qlsvController.getMouseListener());

        JScrollPane scrollPane = new JScrollPane(table);
        
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        if(prio.equals("root")){
            JButton crudButton = new JButton("Thêm/Sửa/Xóa");
            crudButton.addActionListener(qlsvController);
            buttonPanel.add(crudButton);
        }
       

        JButton filterButton = new JButton("Lọc");
        filterButton.addActionListener(qlsvController);
        buttonPanel.add(filterButton);

        JButton scoreButton = new JButton("Bảng điểm");
        scoreButton.addActionListener(qlsvController);
        buttonPanel.add(scoreButton);

        JButton logOutButton = new JButton("Đăng xuất");
        logOutButton.addActionListener(qlsvController);
        buttonPanel.add(logOutButton);

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
                    // student.getSex()
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

    private void loadData(ArrayList<Student> list){
        
        for (Student student : list) {
            Object[] rowData = {
                    student.getStuCode(),
                    student.getStuName(),
                    student.getHomeTown(),
                    student.getDateOfBirth(),
            };
            tableModel.addRow(rowData);
        }
    }

    public void switchToCrudView() throws ParseException {
        // Tạo một crudView mới 
        CrudView crudView = new CrudView(qlsvModel, this);
        // this.setVisible(false);
    }

    public void switchToFilterView() throws ParseException {
        // Tạo một Filter View mới
        FilterView filterView = new FilterView(qlsvModel, this);
        // this.setVisible(false);
    }

    public void switchToScoreView() throws ParseException {
        // Tạo một Filter View mới
        ScoreView scoreView = new ScoreView(prio, qlsvModel, scoreModel);
        // this.setVisible(false);
    }

    public void logout(){
        this.setVisible(false);
        AuthView authView = new AuthView(accModel, qlsvModel, scoreModel);
    }

}
