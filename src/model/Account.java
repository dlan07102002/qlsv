package model;

public class Account {
    private String rootUsername = "duclan0710";
    private String rootPassword = "duclan0710";
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

    public boolean rootAccess(String username, String password){
        if(username == rootUsername && password == rootPassword ){
            return true;
        }   
        return false;
    }

    public boolean userAccess(String username, String password){
        if(this.username == username && this.password == password ){
            return true;
        }   
        return false;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "username: " + username;
    }

}
