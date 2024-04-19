package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

import model.QLSVModel;
import view.QLSVView;

public class QLSVController implements ActionListener{
    // private QLSVModel model;
    private QLSVView qlsvView;
    public QLSVController(QLSVView qlsvView){
        this.qlsvView = qlsvView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("Thêm/Sửa/Xóa")){
            try {
                this.qlsvView.switchToCrudView();
            } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } else if(src.equals("Lọc")){
            try {
                this.qlsvView.switchToFilterView();
            } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
}
