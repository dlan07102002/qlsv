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

    //Set List Selection Listener
    
}


    

