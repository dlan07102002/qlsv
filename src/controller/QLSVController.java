package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.QLSVModel;
import view.QLSVView;

public class QLSVController implements ActionListener{
    // private QLSVModel model;
    private QLSVView qlsvView;
    private MouseListener mouseListener;
        
    public MouseListener getMouseListener() {
        return new MouseListener(qlsvView);
    }

    public QLSVController(QLSVView qlsvView){
        this.qlsvView = qlsvView;
        // gán View cho Mouse sau khi đã gán cho QLSV Controller
        
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
        } else if(src.equals("Bảng điểm")){
            try {
                this.qlsvView.switchToScoreView();
            } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    //Set List Selection Listener
    
}

class MouseListener implements ListSelectionListener{
    private QLSVView qlsvView;
    public MouseListener(QLSVView qlsvView){
        this.qlsvView = qlsvView;
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = this.qlsvView.getTable().getSelectedRow();
                if (selectedRow != -1) {
                  System.out.println(this.qlsvView.getTable().getValueAt(selectedRow, 0));
                }
            }
        } 
}
    

