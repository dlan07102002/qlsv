package view;

import javax.swing.*;

import controller.AuthController;

import java.awt.*;
import java.text.ParseException;
import java.util.ArrayList;

import model.Account;
import model.AccountModel;
import model.QLSVModel;
import model.ScoreModel;

public class AuthView extends JFrame {
    private AccountModel accountModel;
    private QLSVModel qlsvModel;
    private QLSVView qlsvView;
    private ScoreModel scoreModel;

    private JLabel lblUsername, lblPassword;
    private JTextField txtUsername;
    private JButton jButton_login;
    private JPasswordField txtPassword;


    public AuthView(AccountModel accountModel, QLSVModel qlsvModel, ScoreModel scoreModel){
        this.accountModel = accountModel;
        this.qlsvModel = qlsvModel;
        this.scoreModel = scoreModel;

        ArrayList<Account> list = accountModel.getAccList();
        init();
    }

    
    private void init() {
        this.setLayout(new BorderLayout());
        this.setSize(300, 150);
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //Tạo controller
        AuthController authController = new AuthController(this);

        JPanel jPanel_center = new JPanel(new GridLayout(2,2));
        lblUsername = new JLabel("Tên đăng nhập: ");
        txtUsername = new JTextField();
        lblPassword = new JLabel("Mật khẩu: ");
        txtPassword = new JPasswordField();

        //Tạo Controller
        jButton_login  = new JButton("Đăng nhập");
        jButton_login.addActionListener(authController);

        jPanel_center.add(lblUsername);
        jPanel_center.add(txtUsername);
        jPanel_center.add(lblPassword);
        jPanel_center.add(txtPassword);

        this.add(jPanel_center, BorderLayout.CENTER);
        this.add(jButton_login, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public void login(){
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        //Instance tk
        ArrayList<Account> list = this.accountModel.getAccList();
        Account newAcc = null;
        // Account root = new Account(accountModel.g, password)
        for (Account account : list) {
            //String - reference data, k dùng == , phải dùng equals
            if(username.equals(account.getUsername() )&& password.equals(account.getPassword())){
                newAcc = new Account(username, password);
            }
        }
        //TK 
        if(accountModel.isRoot(username, password)){
            try {
                this.setVisible(false);

                new QLSVView("root",accountModel, qlsvModel, scoreModel);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
        }
        else if(newAcc == null){
            JOptionPane.showMessageDialog(this, "tên đăng nhập hoặc mật khẩu không đúng");
        }
        else {
            try {
                this.setVisible(false);

                new QLSVView("not root", accountModel, qlsvModel, scoreModel);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
        }
    }
}
