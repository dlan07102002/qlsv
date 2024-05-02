package model;

import java.util.ArrayList;

import dao.AuthModelDAO;

public class AccountModel {
    //list tk, root -> sửa, kphai root -> xem
    private static ArrayList<Account> accList = new ArrayList<Account>();
    final String rootUsername = "root";
    final String rootPassword = "root";


    public AccountModel(){
        try {
            ArrayList<Account> list = AuthModelDAO.getInstance().selectAll();
            for (Account account : list) {
                System.out.println(account);
            }
            this.accList = list;
            this.setAccList(list);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Create");
    }

    

    public boolean isRoot(String username, String password){
        if(username.equals(this.rootUsername) && password.equals(this.rootPassword)){
            return true;
        }

        return false;
    }

    public void setAccList(ArrayList<Account> accList){
        this.accList = accList;
    }

    public ArrayList<Account> getAccList() {
        return accList;
    }
    // String rootUsername, String rootPassword,
    public void createAccount( String username, String password){
        Account newAcc = new Account(username, password);
        accList.add(newAcc);
        setAccList(accList);

        AuthModelDAO.getInstance().insert(newAcc);
    }

    public void deleteAccount(Account acc){
        accList.remove(acc);

        AuthModelDAO.getInstance().drop(acc);
    }

    public Account searchAccountByUserName(String username){
        for (Account account : accList) {
            if(account.getUsername().equals(username)){
                return account;
            }
        }
        return null;
    }

    
}
