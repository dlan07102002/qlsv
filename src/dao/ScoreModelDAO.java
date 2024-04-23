package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Score;

import java.util.ArrayList;

public class ScoreModelDAO implements DAOInterface<Score>{

    public static ScoreModelDAO getInstance(){
        return new ScoreModelDAO();
    }

    @Override
    public int insert(Score t) {
        try {
            Connection con = JDBCUtil.getConnection();

            Statement st = con.createStatement();

           
                    
            String sqlInsert = "INSERT INTO `qlsv`.`scorelist` (`stu_code`, `mat_score`, `phy_score`, `che_score`)"
                        + "VALUES ('" + t.getStuCode() + "', '" + t.getMatScore() + "', '" + t.getPhyScore() + "', '" + t.getCheScore() + "');";
        
            String sqlUpdate = "UPDATE `qlsv`.`scorelist` SET `total_score` = `mat_score` + `phy_score` + `che_score` WHERE `stu_code` = '" + t.getStuCode() + "';";

            int res = st.executeUpdate(sqlInsert);
            int res1 = st.executeUpdate(sqlUpdate);
            
                        
            System.out.println("Ban da thuc thi " + sqlInsert);
            System.out.println("Ban da thuc thi " + sqlUpdate);

            System.out.println("Có " + res +  " dòng thay đổi");

            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public int update(Score t) {
        // TODO Auto-generated method stub
        try {
            Connection con = JDBCUtil.getConnection();

            Statement st = con.createStatement();

            String sql = "UPDATE `qlsv`.`scorelist` SET `mat_score` = '" + t.getMatScore() +"' , `phy_score` = '" 
                        + t.getPhyScore() +"', `che_score` = '" + t.getCheScore()  
                        + "', `total_score` = '" + t.getTotal() 
                        +"' WHERE (`stu_code` ="+ t.getStuCode()+")";

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
    public int drop(Score t) {
        try {
            Connection con = JDBCUtil.getConnection();

            Statement st = con.createStatement();

            String sql = "DELETE FROM `qlsv`.`scorelist` WHERE (`stu_code` =" + t.getStuCode() +")";

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
    public ArrayList selectAll() {
        ArrayList<Score> scoreList = new ArrayList<Score>();
        try {
            Connection con = JDBCUtil.getConnection();

            Statement st = con.createStatement();

            String sql = "SELECT * FROM scorelist";

            //Khi execute query sẽ trả về object ResultSet, giống như một table, 
            // có nhiều dòng
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                int stuCode = rs.getInt("stu_code");
                double matScore = rs.getDouble("mat_score");
                double phyScore = rs.getDouble("phy_score");
                double cheScore = rs.getDouble("che_score");
                Score obj = new Score(stuCode, matScore,phyScore, cheScore);
                scoreList.add(obj);
            }

            System.out.println("Ban da thuc thi " + sql);

            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return scoreList;
    }

    @Override
    public Score selectByID(Score t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectByID'");
    }

    @Override
    public ArrayList<Score> selectByCondition(String condition) {
        ArrayList<Score> scoreList = new ArrayList<Score>();
        try {
            Connection con = JDBCUtil.getConnection();

            Statement st = con.createStatement();

            String sql = "SELECT * FROM scorelist ORDER BY total_score DESC";

            //Khi execute query sẽ trả về object ResultSet, giống như một table, 
            // có nhiều dòng
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                int stuCode = rs.getInt("stu_code");
                double matScore = rs.getDouble("mat_score");
                double phyScore = rs.getDouble("phy_score");
                double cheScore = rs.getDouble("che_score");
                Score obj = new Score(stuCode, matScore,phyScore, cheScore);
                scoreList.add(obj);
            }

            System.out.println("Ban da thuc thi " + sql);

            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return scoreList;
    }

}
