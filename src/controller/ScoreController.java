package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.QLSVModel;
import view.ScoreView;

public class ScoreController implements ActionListener{
    // private QLSVModel model;
    private ScoreView scoreView;
        
   

    public ScoreController(ScoreView scoreView){
        this.scoreView = scoreView;
        // gán View cho Mouse sau khi đã gán cho QLSV Controller
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("Thêm/Sửa/Xóa")){
            try {
                this.scoreView.switchToCrudView();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } 
        else if(src.equals("Sắp xếp")){
            try {
                this.scoreView.sort();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
}

// class MouseListener implements ListSelectionListener{
//     private ScoreView scoreView;
//     public MouseListener(ScoreView scoreView){
//         this.scoreView = scoreView;
//     }
//     @Override
//     public void valueChanged(ListSelectionEvent e) {
//             if (!e.getValueIsAdjusting()) {
//                 int selectedRow = this.scoreView.getTable().getSelectedRow();
              
//                 if (selectedRow != -1) {
//                     System.out.println("row" + selectedRow);
//                     String stuCodeStr =  this.scoreView.getTable().getValueAt(selectedRow, 0).toString();
//                     new ScoreV(Integer.parseInt(stuCodeStr) , scoreView.getQlsvModel(), scoreView.getScoreModel());
//                     System.out.println(stuCodeStr);
//                 } 
//             }
//         } 
// }


    

