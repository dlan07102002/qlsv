package test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

       new QLSVView(qlsvModel, scoreModel); 
    }
}
