package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.dsig.spec.XPathType.Filter;

import controller.QLSVController;
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

    public ScoreView(QLSVModel qlsvModel, ScoreModel scoreModel) throws ParseException {
        this.qlsvModel = qlsvModel;
        this.scoreModel = scoreModel;
        init();
        loadData();
    }

    public void setScoreModel(ScoreModel scoreModel) throws ParseException {
        this.scoreModel = scoreModel;
        init();
        loadData(scoreModel);
    }

    public void setScoreModelRender(ArrayList<Score>  list){
        init();
        loadData(list);
    }

    private void init() {
        
        this.setTitle("Bảng điểm sinh viên");
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);

        // Font sansSerifFont = new Font("SansSerif", Font.PLAIN, 12);

        JPanel JPanel_main = new JPanel(new BorderLayout());
        
        //Tạo controller
        // QLSVController qlsvController = new QLSVController(this);

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
        
        JButton crudButton = new JButton("Thêm/Sửa/Xóa");
        buttonPanel.add(crudButton);

        JButton filterButton = new JButton("Lọc");
        buttonPanel.add(filterButton);

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

    private void loadData(ArrayList<Score>  list){
        for (Score score : list) {
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
