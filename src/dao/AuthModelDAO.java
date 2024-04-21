package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Account;

import java.util.ArrayList;

public class AuthModelDAO implements DAOInterface<Account> {

    public static AuthModelDAO getInstance(){
        return new AuthModelDAO();
    }

    @Override
    public int insert(Account t) {
       return 0;
    }


    @Override
    public int drop(Account t) {
       
        return 0;
    }

    @Override
    public ArrayList<Account> selectAll() {
        ArrayList<Account> accList = new ArrayList<Account>();
        try {
            //Khởi tạo kết nối
            Connection con = JDBCUtil.getConnection();

            //Câu lệnh
            Statement st = con.createStatement();

            String sql = "SELECT * FROM acclist";

            //Khi execute query sẽ trả về object ResultSet, giống như một table, 
            // có nhiều dòng
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                int accNum = rs.getInt("accnum");
                String username = rs.getString("username");
                String password = rs.getString("passwrd");
                Account newAcc = new Account(username, password);
                accList.add(newAcc);
                
            }


            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return accList;
    }

    @Override
    public Account selectByID(Account t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectByID'");
    }

    @Override
    public ArrayList<Account> selectByCondition(String condition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectByCondition'");
    }

    @Override
    public int update(Account t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
