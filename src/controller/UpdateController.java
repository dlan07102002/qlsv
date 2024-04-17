package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

import model.QLSVModel;
import view.QLSVView;
import view.UpdateView;

public class UpdateController implements ActionListener{
    private UpdateView updateView;
    public UpdateController(UpdateView updateView){
        this.updateView = updateView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("Lưu")){
            try {
                this.updateView.saveUpdatedStudentData();
                this.updateView.switchToQLSVView();
            } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }else if(src.equals("Thêm")){
            try {
                this.updateView.saveCreatedStudentData();
                this.updateView.switchToQLSVView();
            } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
}
