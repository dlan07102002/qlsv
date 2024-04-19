package view;

import javax.swing.*;

import controller.CrudController;
import model.QLSVModel;
import model.Student;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CrudView extends JFrame {
    private QLSVModel qlsvModel;
    private QLSVView qlsvView;

    private JLabel lblStuCode, lblStuName, lblHomeTown, lblDateOfBirth, lblSex;
    private JTextField txtStuCode, txtStuName, txtHomeTown, txtDateOfBirth, txtSex;
    private JButton jButton_save, jButton_create, jButton_delete;

    public CrudView(QLSVModel qlsvModel, QLSVView qlsvView) throws ParseException {
        this.qlsvModel = qlsvModel;
        this.qlsvView = qlsvView;
        init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setSize(400, 300);
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);


        JPanel jPanel_center = new JPanel(new GridLayout(5,2));
        lblStuCode = new JLabel("Mã Sinh Viên:");
        txtStuCode = new JTextField();
        lblStuName = new JLabel("Họ và Tên:");
        txtStuName = new JTextField();
        lblHomeTown = new JLabel("Quê quán:");
        txtHomeTown = new JTextField();
        lblDateOfBirth = new JLabel("Ngày sinh:");
        txtDateOfBirth = new JTextField();
        lblSex = new JLabel("Giới tính:");
        txtSex = new JTextField();

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
        jPanel_center.add(lblSex);
        jPanel_center.add(txtSex);

        this.add(jPanel_center, BorderLayout.CENTER);
        this.add(jPanel_footer, BorderLayout.SOUTH);

        this.setVisible(true);

    }

    public Student info() throws ParseException{
        int stuCode = Integer.parseInt(txtStuCode.getText());
        String dateOfBirthStr = txtDateOfBirth.getText();
        String stuCodeStr = txtStuCode.getText();
        String sexStr = txtSex.getText();

        String stuName = txtStuName.getText();
        String homeTown = txtHomeTown.getText();
        boolean sex = Boolean.parseBoolean(sexStr);
        Student temp = qlsvModel.searchStudentById(Integer.parseInt(stuCodeStr));

        if(temp == null){
            temp = new Student(stuCode, stuName, homeTown, new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirthStr), sex);
        }

        if(!stuName.isEmpty()){
            temp.setStuName(stuName);
        } 

        if(!homeTown.isEmpty()){
            temp.setHomeTown(homeTown);
        } 

        if(!dateOfBirthStr.isEmpty()){
            Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirthStr);
            temp.setDateOfBirth(dateOfBirth);
        }

        if(!sexStr.isEmpty()){
            temp.setSex(sex);
        } 

        return temp;
    }

    public void saveUpdatedStudentData() throws ParseException  {
        Student temp = this.info();
        if( qlsvModel.isStuCodeExist(temp.getStuCode()) || qlsvModel.isStudentExist(temp) ){
            Student stuChange = qlsvModel.searchStudentById(temp.getStuCode());
            qlsvModel.update(stuChange, temp);
            this.setVisible(false);
            JOptionPane.showMessageDialog(this, "Thông tin sinh viên đã được cập nhật thành công!");
        }
        else {
            qlsvModel.insert(temp);
            JOptionPane.showMessageDialog(this, "Thông tin sinh viên không tồn tại, không thể thay đổi!");
        }
    }

    public void saveCreatedStudentData() throws ParseException  {
        Student temp = this.info();
        if( qlsvModel.isStuCodeExist(temp.getStuCode()) || qlsvModel.isStudentExist(temp) ){
            JOptionPane.showMessageDialog(this, "Mã sinh viên đã tồn tại! Vui lòng nhập mã sinh viên khác");
        }
        else {
            qlsvModel.insert(temp);

            System.out.println(qlsvModel.getStuList());
            this.setVisible(false);
            JOptionPane.showMessageDialog(this, "Thông tin sinh viên đã được thêm thành công!");
        }
    }

    public void deleteStudentData(){
        int delStuCode = Integer.parseInt(txtStuCode.getText());
        Student delStu = qlsvModel.searchStudentById(delStuCode);
        if(qlsvModel.isStudentExist(delStu)){
            qlsvModel.delete(delStu);
            this.setVisible(false);
            JOptionPane.showMessageDialog(this, "Sinh viên: " + delStu.getStuName()+  " đã được xóa khỏi danh sách!");
        }else{
            JOptionPane.showMessageDialog(this, "Thông tin sinh viên không tồn tại, không thể xóa!");

        }
    }
    
    public void switchToQLSVView() throws ParseException {
        // Tạo một UpdateView mới và ẩn view hiện tại
        System.out.println(qlsvModel.getStuList());
        this.qlsvView.setQlsvModel(qlsvModel);
        // this.setVisible(false);
    }
    
}


