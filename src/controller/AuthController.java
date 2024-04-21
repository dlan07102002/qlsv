package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

import model.QLSVModel;
import view.QLSVView;
import view.AuthView;
import view.CrudView;
import view.FilterView;

public class AuthController implements ActionListener{
    private AuthView authView;
    //constructor
    public AuthController(AuthView authView){
        this.authView = authView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("Đăng nhập")){
            this.authView.login();
        }
    }
}

// AuthController authController = new AuthController(this);
