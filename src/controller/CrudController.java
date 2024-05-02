package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import view.CrudView;

public class CrudController implements ActionListener{
    private CrudView crudView;
    private CrudScoreController crudScoreController;
    private CrudAccController crudAccController;

    public CrudScoreController getCrudScoreController() {
        return crudScoreController = new CrudScoreController(this.crudView);
    }

    public CrudAccController getCrudAccController(){
        return crudAccController = new CrudAccController(this.crudView);
    }

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

class CrudScoreController implements ActionListener{
    private CrudView crudView;

    public CrudScoreController(CrudView crudView) {
        //TODO Auto-generated constructor stub
        this.crudView = crudView;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("Thay đổi")){
            try {
                this.crudView.saveUpdatedScoreData();
                this.crudView.updateScoreView();
            } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }else if(src.equals("Thêm")){
            try {
                this.crudView.saveCreatedScoreData();
                this.crudView.updateScoreView();
            } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }else if(src.equals("Xóa")){
            try {
                this.crudView.deleteScoreData();
                this.crudView.updateScoreView();
            } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
    
}

class CrudAccController implements ActionListener{
    private CrudView crudView;

    public CrudAccController(CrudView crudView) {
        //TODO Auto-generated constructor stub
        this.crudView = crudView;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("Tạo")){
            try {
                this.crudView.createAcc();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }else if(src.equals("Xóa")){
            try {
                this.crudView.deleteAcc();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
    
}