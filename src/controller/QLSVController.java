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
import view.StudentView;

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
    //Hai kiểu dữ liệu reference type, so sánh bằng equal, primitive
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("Thêm/Sửa/Xóa")){
            try {
                //Chuyển sang khung nhìn crud
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
        } else if(src.equals("Đăng xuất")){
            try {
                this.qlsvView.logout();
            } catch (Exception e1) {
                // TODO: handle exception
                e1.printStackTrace();


            }
        } else if(src.equals("Sinh Viên")){
            try{
                // this.qlsvView.
            }
            catch (Exception e1) {
                // TODO: handle exception
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
                String stuCodeStr =  this.qlsvView.getTable().getValueAt(selectedRow, 0).toString();
                System.out.println("row" + selectedRow);
                // new StudentView(Integer.parseInt(stuCodeStr) , qlsvView.getQlsvModel(), qlsvView.getScoreModel());
                if (selectedRow != -1) {
                  System.out.println(stuCodeStr);
                }
            }
        } 
}
    

