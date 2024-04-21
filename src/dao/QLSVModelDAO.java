package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Student;

import java.util.ArrayList;

public class QLSVModelDAO implements DAOInterface<Student> {

    public static QLSVModelDAO getInstance(){
        return new QLSVModelDAO();
    }

    @Override
    public int insert(Student t) {
        try {
            Connection con = JDBCUtil.getConnection();

            Statement st = con.createStatement();

            String sql = "INSERT INTO `qlsv`.`stulist` (`stu_code`, `stu_name`, `home_town`, `dob`, `gender`)"
                        + "VALUES ( " + t.getStuCode() +" , '" + t.getStuName() +  "' , '" +  t.getHomeTown() + "' , '" + t.getDateOfBirth() + "' , " + t.getGender()  + ")";

            int res = st.executeUpdate(sql);
                        
            System.out.println("Ban da thuc thi " + sql);

            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Student t) {
        // TODO Auto-generated method stub

        // UPDATE `qlsv`.`stulist` SET `gender` = '0' WHERE (`stu_code` = '5');
        try {
            Connection con = JDBCUtil.getConnection();

            Statement st = con.createStatement();

            String sql = "UPDATE `qlsv`.`stulist` SET `stu_name` = '" + t.getStuName() +"' , `home_town` = '" + t.getHomeTown() +"', `dob` = '" + t.getDateOfBirth() +"' , `gender` = " + t.getGender() 
                        +" WHERE (`stu_code` ="+t.getStuCode()+" )";

            System.out.println(sql);

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
    public int drop(Student t) {
        // TODO Auto-generated method stub

        // DELETE FROM `qlsv`.`stulist` WHERE (`stu_code` = '6');
        try {
            Connection con = JDBCUtil.getConnection();

            Statement st = con.createStatement();

            String sql = "DELETE FROM `qlsv`.`stulist` WHERE (`stu_code` =" + t.getStuCode() +")";

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
    public ArrayList<Student> selectAll() {
        ArrayList<Student> stuList = new ArrayList<Student>();
        try {
            
            Connection con = JDBCUtil.getConnection();

            Statement st = con.createStatement();

            String sql = "SELECT * FROM stulist";

            //Khi execute query sẽ trả về object ResultSet, giống như một table, 
            // có nhiều dòng
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                int stuCode = rs.getInt("stu_code");
                String stuName = rs.getString("stu_name");
                String homeTown = rs.getString("home_town");
                Date dateOfBirth = rs.getDate("dob");
                boolean gender = rs.getBoolean("gender");
                Student obj = new Student(stuCode, stuName, homeTown, dateOfBirth, gender);
                stuList.add(obj);
            }

            System.out.println("Ban da thuc thi " + sql);

            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return stuList;
    }

    @Override
    public Student selectByID(Student t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectByID'");
    }

    @Override
    public ArrayList<Student> selectByCondition(String condition) {
        // TODO Auto-generated method stub
        return null;
        // throw new UnsupportedOperationException("Unimplemented method 'selectByCondition'");
    }
    
}
