package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.dsig.spec.XPathType.Filter;

import controller.QLSVController;
import controller.ScoreController;
import model.QLSVModel;
import model.Score;
import model.ScoreModel;
import model.Student;


import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class ScoreView extends JFrame {
    private static QLSVModel qlsvModel;
    private static ScoreModel scoreModel;
    private DefaultTableModel tableModel ;

    private JTable table ;

    public JTable getTable() {
        return table;
    }

    public ScoreView(String prio, QLSVModel qlsvModel, ScoreModel scoreModel) throws ParseException {
        this.qlsvModel = qlsvModel;
        this.scoreModel = scoreModel;
        init(prio);
        loadData();
    }

    public void setScoreModel(ScoreModel scoreModel) throws ParseException {
        this.scoreModel = scoreModel;
        System.out.println(scoreModel.getScoreList());
        tableModel.setRowCount(0);
        loadData(scoreModel);
    }

    private void init(String prio) {
        
        this.setTitle("Bảng điểm sinh viên");
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);

        // Font sansSerifFont = new Font("SansSerif", Font.PLAIN, 12);

        JPanel JPanel_main = new JPanel(new BorderLayout());
        
        //Tạo controller
        ScoreController scoreController = new ScoreController(this);

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

        tableModel.addColumn("Điểm toán");
        tableModel.addColumn("Điểm Lý");
        tableModel.addColumn("Điểm Hóa");   
        tableModel.addColumn("Tổng điểm");      
        tableModel.addColumn("Xếp loại");        

        JScrollPane scrollPane = new JScrollPane(table);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        if(prio.equals("root")){
            JButton crudButton = new JButton("Thêm/Sửa/Xóa");
            crudButton.addActionListener(scoreController);
            buttonPanel.add(crudButton);
        }
        
        JButton sortButton = new JButton("Sắp xếp");
        sortButton.addActionListener(scoreController);
        buttonPanel.add(sortButton);

        JPanel_main.add(scrollPane, BorderLayout.CENTER);
        JPanel_main.add(buttonPanel, BorderLayout.SOUTH);

        this.add(JPanel_main);
        this.setVisible(true);
    }

    private void loadData() throws ParseException {
        ArrayList<Score> scores = scoreModel.getScoreList();
        for (Score score : scores) {
            if(qlsvModel.searchStudentById(score.getStuCode()) != null){
                Object[] rowData = {
                    score.getStuCode(),
                    qlsvModel.searchStudentById(score.getStuCode()).getStuName(),
                    score.getMatScore(),
                    score.getPhyScore(),
                    score.getCheScore(),
                    score.getTotal(),
                    score.classification()
                };
                tableModel.addRow(rowData);
            }
        }
    }

    private void loadData(ScoreModel scoreModel_o) throws ParseException {
        ArrayList<Score> scores = scoreModel_o.getScoreList();
        for (Score score : scores) {
            Object[] rowData = {
                  score.getStuCode(),
                  qlsvModel.searchStudentById(score.getStuCode()).getStuName(),
                  score.getMatScore(),
                  score.getPhyScore(),
                  score.getCheScore(),
                  score.getTotal(),
                  score.classification()
            };
            tableModel.addRow(rowData);
        }
    }

    public void switchToCrudView() throws ParseException {
        // Tạo một crudView mới 
        CrudView crudView = new CrudView(qlsvModel, scoreModel, this);
        // this.setVisible(false);
    }

    public void sort() throws ParseException{
        this.setScoreModel(scoreModel.sort());
    }
}
