package test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.QLSVModelDAO;
import model.QLSVModel;
import model.ScoreModel;
import model.Student;
import view.QLSVView;
import view.ScoreView;
import view.CrudView;

public class Test {
    public static void main(String[] args) throws ParseException {

        QLSVModel qlsvModel = new QLSVModel();
        ScoreModel scoreModel = new ScoreModel();
        // String startDate= "07/10/2002";
        // SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        // java.util.Date date = sdf1.parse(startDate);
        // java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
        // Student s2 = new Student(6, "Xúc Xích xinh", "Hà Nội",  sqlDate, false);
        // QLSVModelDAO.getInstance().update(s2);
        new QLSVView(qlsvModel, scoreModel); 
    }
}
