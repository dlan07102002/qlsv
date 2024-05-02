package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Account;


public class AuthModelDAO implements DAOInterface<Account> {

    public static AuthModelDAO getInstance(){
        return new AuthModelDAO();
    }

    @Override
    public int insert(Account t) {
        try {
            Connection con = JDBCUtil.getConnection();

            Statement st = con.createStatement();

            String sqlInsert = "INSERT INTO `qlsv`.`acclist` (`username`, `passwrd`)"
                            + "VALUES ('" + t.getUsername() + "', '" + t.getPassword() + "');";
        
            int res = st.executeUpdate(sqlInsert);
                        
            System.out.println("Ban da thuc thi " + sqlInsert);

            System.out.println("Có " + res +  " dòng thay đổi");

            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public int drop(Account t) {
        try {
            Connection con = JDBCUtil.getConnection();

            Statement st = con.createStatement();

            String sql = "DELETE FROM `qlsv`.`acclist` WHERE (`username` = '" + t.getUsername() +"')";

            int res = st.executeUpdate(sql);
                        
            System.out.println("Ban da thuc thi " + sql);
            System.out.println("Có " + res +  " dòng thay đổi");

            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
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
    public Account selectByID(int t) {
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
