package test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.QLSVModel;
import model.Student;
import view.QLSVView;
import view.CrudView;

public class Test {
    public static void main(String[] args) throws ParseException {
       QLSVModel qlsvModel = new QLSVModel();
       new QLSVView(qlsvModel);
    }
}
