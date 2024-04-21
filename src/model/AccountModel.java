package model;

import java.util.ArrayList;

import dao.AuthModelDAO;

public class AccountModel {
    //list tk, root -> sửa, kphai root -> xem
    private static ArrayList<Account> accList = new ArrayList<Account>();
    private String rootUsername = "duclan0710";
    private String rootPassword = "duclan0710";

    public AccountModel(){
        try {
            ArrayList<Account> list = AuthModelDAO.getInstance().selectAll();
            for (Account account : list) {
                System.out.println(account);
            }
            this.setAccList(list);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Create");
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
    }

    public void deleteAccount(Account acc){
        accList.remove(acc);
    }

    public Account searchAccountByUserName(String username){
        for (Account account : accList) {
            if(account.getUsername() == username){
                return account;
            }
        }
        return null;
    }

    
}
