package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import view.ScoreView;
import view.SubjectView;

public class ScoreController implements ActionListener{
    // private QLSVModel model;
    private ScoreView scoreView;
    private ScoreMouseListener mouseListener;

    public ScoreMouseListener getMouseListener(){
        return mouseListener;
    }
    
    public ScoreController(ScoreView scoreView){
        this.scoreView = scoreView;
        this.mouseListener = new ScoreMouseListener(scoreView);
        // gán View cho Mouse sau khi đã gán cho Score Controller
        
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

class ScoreMouseListener implements ListSelectionListener{
    private ScoreView scoreView;
    public ScoreMouseListener(ScoreView scoreView){
        this.scoreView = scoreView;
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                int selectedColumn = this.scoreView.getTable().getSelectedColumn();
                if(selectedColumn != -1){
                    System.out.println("column " + selectedColumn);
                    if(selectedColumn == 2 || selectedColumn == 3 || selectedColumn == 4){
                        new SubjectView(scoreView.getScoreModel(), selectedColumn);
                    }
                }
            }
        } 
}


    

