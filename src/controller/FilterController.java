package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

import model.QLSVModel;
import view.QLSVView;
import view.CrudView;
import view.FilterView;

public class FilterController implements ActionListener{
    private FilterView filterView;
    public FilterController(FilterView filterView){
        this.filterView = filterView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("Lọc")){
            try{
                this.filterView.filteredStudent();
                this.filterView.switchToQLSVView();
            }catch (ParseException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                }
        }
    }
}
