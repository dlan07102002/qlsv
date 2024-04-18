package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

import model.QLSVModel;
import view.QLSVView;
import view.CrudView;

public class CrudController implements ActionListener{
    private CrudView crudView;
    public CrudController(CrudView crudView){
        this.crudView = crudView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("Thay đổi")){
            try {
                this.crudView.saveUpdatedStudentData();
                this.crudView.switchToQLSVView();
            } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }else if(src.equals("Thêm")){
            try {
                this.crudView.saveCreatedStudentData();
                this.crudView.switchToQLSVView();
            } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }else if(src.equals("Xóa")){
            try {
                this.crudView.deleteStudentData();
                this.crudView.switchToQLSVView();
            } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
}
