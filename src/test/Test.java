package test;

import java.text.ParseException;
import javax.swing.UIManager;
import model.AccountModel;
import model.QLSVModel;
import model.ScoreModel;
import view.AuthView;

public class Test {
    public static void main(String[] args) throws ParseException {
        // MVC - Model, View, Controller
        // Model - Đối tượng, Dữ liệu về đối tượng mà mình tạo ra
        // View - cho người dùng thấy, giao diện
        // Controller - bộ điều khiển, nhận hành động/ sự kiện của ng dùng, chọc vào
        // model (database), sau khi xử lý sẽ phản hồi đến người dùng

        QLSVModel qlsvModel = new QLSVModel();
        ScoreModel scoreModel = new ScoreModel();
        AccountModel accModel = new AccountModel();

        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new AuthView(accModel, qlsvModel, scoreModel);

    }
}
