package dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Student;

import java.util.ArrayList;

public class ScoreModelDAO implements DAOInterface{

    public static ScoreModelDAO getInstance(){
        return new ScoreModelDAO();
    }

    @Override
    public int insert(Object t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


    @Override
    public int update(Object t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int drop(Object t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drop'");
    }

    @Override
    public ArrayList selectAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectAll'");
    }

    @Override
    public Object selectByID(Object t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectByID'");
    }

    @Override
    public ArrayList selectByCondition(String condition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectByCondition'");
    }
    
}
