package view;

import javax.swing.*;

import controller.CrudController;
import model.QLSVModel;
import model.Score;
import model.ScoreModel;
import model.Student;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class CrudView extends JFrame {
    private QLSVModel qlsvModel;
    private QLSVView qlsvView;
    private ScoreModel scoreModel;
    private ScoreView scoreView;

  
   
    private JLabel lblStuCode, lblStuName, lblHomeTown, lblDateOfBirth, lblGender, lblMathScore, lblPhyScore, lblCheScore;
    private JTextField txtStuCode, txtStuName, txtHomeTown, txtDateOfBirth, txtGender, txtMathScore, txtPhyScore, txtCheScore;
    private JButton jButton_save, jButton_create, jButton_delete;

    public CrudView(QLSVModel qlsvModel, ScoreModel scoreModel, QLSVView qlsvView) throws ParseException {
        this.qlsvModel = qlsvModel;
        this.scoreModel = scoreModel;
        this.qlsvView = qlsvView;
        init("qlsv_table");
    }

    public CrudView(QLSVModel qlsvModel, ScoreModel scoreModel, ScoreView scoreView) {
        this.qlsvModel = qlsvModel;
        this.scoreModel = scoreModel;
        System.out.println(scoreModel.searchScoreById(1));
        this.scoreView = scoreView;
        init("score_table");
    }

    public ScoreModel getScoreModel() {
        return scoreModel;
    }

    private void init(String option) {

        this.setLayout(new BorderLayout());
        this.setSize(400, 300);
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //Thêm sửa xóa sinh viên
        if(option.equals("qlsv_table")){
            JPanel jPanel_center = new JPanel(new GridLayout(5,2));
            lblStuCode = new JLabel("Mã Sinh Viên:");
            txtStuCode = new JTextField();
            lblStuName = new JLabel("Họ và Tên:");
            txtStuName = new JTextField();
            lblHomeTown = new JLabel("Quê quán:");
            txtHomeTown = new JTextField();
            lblDateOfBirth = new JLabel("Ngày sinh:");
            txtDateOfBirth = new JTextField();
            lblGender = new JLabel("Giới tính:");
            txtGender = new JTextField();

            CrudController crudController = new CrudController(this);

            JPanel jPanel_footer = new JPanel(new FlowLayout());
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    

            jButton_create = new JButton("Thêm");
            jButton_create.addActionListener(crudController);


            jButton_save = new JButton("Thay đổi");
            jButton_save.addActionListener(crudController);

            jButton_delete = new JButton("Xóa");
            jButton_delete.addActionListener(crudController);

            jPanel_footer.add(jButton_create);
            jPanel_footer.add(jButton_save);
            jPanel_footer.add(jButton_delete);


            jPanel_center.add(lblStuCode);
            jPanel_center.add(txtStuCode);
            jPanel_center.add(lblStuName);
            jPanel_center.add(txtStuName);
            jPanel_center.add(lblHomeTown);
            jPanel_center.add(txtHomeTown);
            jPanel_center.add(lblDateOfBirth);
            jPanel_center.add(txtDateOfBirth);
            jPanel_center.add(lblGender);
            jPanel_center.add(txtGender);

            this.add(jPanel_center, BorderLayout.CENTER);
            this.add(jPanel_footer, BorderLayout.SOUTH);
        } 
      
        //Thêm sửa xóa điểm
        else{
            JPanel jPanel_center = new JPanel(new GridLayout(5,2));
            lblStuCode = new JLabel("Mã Sinh Viên:");
            txtStuCode = new JTextField();
            lblMathScore = new JLabel("Điểm Toán:");
            txtMathScore = new JTextField();
            lblPhyScore = new JLabel("Điểm Lý:");
            txtPhyScore = new JTextField();
            lblCheScore = new JLabel("Điểm Hóa:");
            txtCheScore = new JTextField();

            CrudController crudController = new CrudController(this);
            
            JPanel jPanel_footer = new JPanel(new FlowLayout());
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    

            jButton_create = new JButton("Thêm");
            jButton_create.addActionListener(crudController.getCrudScoreController());

            jButton_save = new JButton("Thay đổi");
            jButton_save.addActionListener(crudController.getCrudScoreController());

            jButton_delete = new JButton("Xóa");
            jButton_delete.addActionListener(crudController.getCrudScoreController());

            jPanel_footer.add(jButton_create);
            jPanel_footer.add(jButton_save);
            jPanel_footer.add(jButton_delete);


            jPanel_center.add(lblStuCode);
            jPanel_center.add(txtStuCode);
            jPanel_center.add(lblMathScore);
            jPanel_center.add(txtMathScore);
            jPanel_center.add(lblPhyScore);
            jPanel_center.add(txtPhyScore);
            jPanel_center.add(lblCheScore);
            jPanel_center.add(txtCheScore);

            this.add(jPanel_center, BorderLayout.CENTER);
            this.add(jPanel_footer, BorderLayout.SOUTH);
        }

        

        this.setVisible(true);

    }

    public Student info(String type) throws ParseException{
        int stuCode = Integer.parseInt(txtStuCode.getText());
        String dateOfBirthStr = txtDateOfBirth.getText();
        String genderStr = txtGender.getText();
        boolean gender;

        String stuName = txtStuName.getText();
        String homeTown = txtHomeTown.getText();

        if(genderStr.trim().toLowerCase().equals("nam")){
            gender = true;
        }else gender = false;

        boolean check = this.qlsvModel.isStuCodeExist(stuCode);
        Student temp = new Student(stuCode, stuName, homeTown, null, gender);

        if(type == "created"){
            if(check == false){
                    System.out.println("temp");
                    String startDate=dateOfBirthStr;
                    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                    java.util.Date date = sdf1.parse(startDate);
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
                    Date dateOfBirth = sqlDate;
                    System.out.println("name: " + stuName);
                temp = new Student(stuCode, stuName, homeTown, dateOfBirth, gender);
            } else temp = this.qlsvModel.searchStudentById(stuCode);
        }
        else if(type == "updated"){
            temp = this.qlsvModel.searchStudentById(temp.getStuCode());

            if(!stuName.isEmpty()){
                temp.setStuName(stuName);
            } 

            if(!homeTown.isEmpty()){
                temp.setHomeTown(homeTown);
            } 

            if(!dateOfBirthStr.isEmpty()){
                String startDate=dateOfBirthStr;
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date date = sdf1.parse(startDate);
                java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
                Date dateOfBirth = sqlDate;
               
                temp.setDateOfBirth(dateOfBirth);
            } 

            if(!genderStr.isEmpty()){
                temp.setGender(gender);
            } 
        }
        
        return temp;
    }

    public Score info(String type, String option) throws ParseException{
        int stuCode = Integer.parseInt(txtStuCode.getText());
        String matScoreString = txtMathScore.getText();
        String phyScoreString = txtPhyScore.getText();
        String cheScoreString = txtCheScore.getText();

        Score temp = scoreModel.searchScoreById(stuCode);

        if(type == "created"){
            if(temp == null){
                Double matScore = Double.parseDouble(matScoreString);
                Double phyScore = Double.parseDouble(phyScoreString);
                Double cheScore = Double.parseDouble(cheScoreString);
                temp = new Score( stuCode, matScore, phyScore, cheScore);
            } 
        }
        else if(type == "updated"){
            if(temp == null){
                JOptionPane.showMessageDialog(this, "Sinh viên này chưa có điểm, vui lòng thêm điểm cho sinh viên!");
            }else{
                if(!matScoreString.isEmpty()){
                    Double matScore = Double.parseDouble(matScoreString);
                    temp.setMatScore(matScore);
                }
                
                if(!phyScoreString.isEmpty()){
                    Double phyScore = Double.parseDouble(phyScoreString);
                    temp.setPhyScore(phyScore);
                } 
                
                if(!cheScoreString.isEmpty()){
                    Double cheScore = Double.parseDouble(cheScoreString);
                    temp.setCheScore(cheScore);
                } 
                temp.setTotal();
            }
        }
        
        return temp;
    }


    //Crud Sinh Viên

    public void saveCreatedStudentData() throws ParseException  {
        Student temp = this.info("created");

        if( qlsvModel.isStuCodeExist(temp.getStuCode()) ){
            JOptionPane.showMessageDialog(this, "Mã sinh viên đã tồn tại! Vui lòng nhập mã sinh viên khác");
        }
        else {
            qlsvModel.insert(temp);
            System.out.println(qlsvModel.getStuList());
            this.setVisible(false);
            JOptionPane.showMessageDialog(this, "Thông tin sinh viên đã được thêm thành công!");
        }
    }

    public void saveUpdatedStudentData() throws ParseException  {
        Student temp = this.info("updated");
        if( qlsvModel.isStuCodeExist(temp.getStuCode()) || qlsvModel.isStudentExist(temp) ){
            Student stuSrc = qlsvModel.searchStudentById(temp.getStuCode());
            qlsvModel.update(stuSrc, temp);
            this.setVisible(false);
            JOptionPane.showMessageDialog(this, "Thông tin sinh viên đã được cập nhật thành công!");
        }
        else {
            JOptionPane.showMessageDialog(this, "Thông tin sinh viên không tồn tại, không thể thay đổi!");
        }
    }

    public void deleteStudentData(){
        int delStuCode = Integer.parseInt(txtStuCode.getText());
        Student delStu = qlsvModel.searchStudentById(delStuCode);
        Score delSco = scoreModel.searchScoreById(delStuCode);
        if(qlsvModel.isStudentExist(delStu)){
            //Must delete sco before stu to void e
            scoreModel.delete(delSco);
            qlsvModel.delete(delStu);
            this.setVisible(false);
            JOptionPane.showMessageDialog(this, "Sinh viên: " + delStu.getStuName()+  " đã được xóa khỏi danh sách!");
        }else{
            JOptionPane.showMessageDialog(this, "Thông tin sinh viên không tồn tại, không thể xóa!");

        }
    }

    //Crud Điểm
    public void saveCreatedScoreData() throws ParseException  {

        Score temp = this.info("created", "score");
    
        if( scoreModel.searchScoreById(temp.getStuCode()) != null ){
            JOptionPane.showMessageDialog(this, "Sinh viên này đã có điểm!");
        }
        else {
            if(qlsvModel.isStuCodeExist(temp.getStuCode()) == true){
                scoreModel.insert(temp);
                this.setVisible(false);

            JOptionPane.showMessageDialog(this, "Điểm số của sinh viên đã được thêm thành công!");
            } 
            else 
            {
            JOptionPane.showMessageDialog(this, "Mã sinh viên không tồn tại!");

            }
            
        }
    }

    public void saveUpdatedScoreData() throws ParseException  {

        Score temp = this.info("updated", "score");

        if( scoreModel.searchScoreById(temp.getStuCode()) != null ){
            Score stuChange = scoreModel.searchScoreById(temp.getStuCode());
            temp.setTotal();
            scoreModel.update(stuChange, temp);
            this.setVisible(false);
            JOptionPane.showMessageDialog(this, "Điểm số của sinh viên đã được cập nhật thành công!");
        }
        else {
            scoreModel.insert(temp);
            JOptionPane.showMessageDialog(this, "Thông tin sinh viên không tồn tại, không thể thay đổi!");
        }
    }

    public void deleteScoreData(){
        int stuCode = Integer.parseInt(txtStuCode.getText());
        Score target = scoreModel.searchScoreById(stuCode);
        Student stuTar = qlsvModel.searchStudentById(stuCode);

                if(qlsvModel.searchStudentById(stuCode) == null){
                    JOptionPane.showMessageDialog(this, "Mã sinh viên không tồn tại!");
                }else {
                    if(target!=null){
                        target.setCheScore(stuCode);
                        target.setMatScore(stuCode);
                        target.setPhyScore(stuCode);
                        target.setTotal();
                        Score scoDist = new Score (target.getStuCode(), 0, 0, 0);
                        scoreModel.update(target, scoDist);
                        this.setVisible(false);
                        JOptionPane.showMessageDialog(this, "Điểm số của sinh viên đã được xóa!");
                    }
                    JOptionPane.showMessageDialog(this, "Sinh viên này không có điểm số!");
                }
            }
    

    public void switchToQLSVView() throws ParseException {
        // Tạo một UpdateView mới và ẩn view hiện tại
        this.qlsvView.setQLSVModel(qlsvModel);
    }

    public void updateScoreView() throws ParseException {
        // Tạo một Filter View mới
        this.scoreView.setScoreModel(scoreModel);
    }
    
}


