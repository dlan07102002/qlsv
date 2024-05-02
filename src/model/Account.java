package model;

public class Account {
    private int rootPriority = 1 ;

    private String username;
    private String password;
    private int priority;

    public Account(String username, String password){
        this.username = username;
        this.password = password;
        this.priority = 2;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

   
    public boolean userAccess(String username, String password){
        if(this.username == username && this.password == password ){
            return true;
        }   
        return false;
    }


}
