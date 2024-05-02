package view;

import javax.swing.*;

import dao.ScoreModelDAO;
import model.ScoreModel;

import java.awt.*;
import java.util.ArrayList;

public class SubjectView extends JFrame {

    private ScoreModel scoreModel;
    private ArrayList<Double> scoreList;
    private JLabel titleLabel, highScoreLabel, lowScoreLabel, averageScoreLabel;
   
    public SubjectView(ScoreModel scoreModel, int subjectCode) {
        this.scoreModel = scoreModel;
        this.scoreList = ScoreModelDAO.getInstance().selectScore(subjectCode);
        init(subjectCode);
       
    }

    public void init(int subjectCode){
        this.setTitle("Môn học");
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);

        
        if(subjectCode == 2){
            titleLabel = new JLabel("MÔN HỌC: TOÁN");
        } 
        else if(subjectCode == 3){
            titleLabel = new JLabel("MÔN HỌC: LÝ");
        }
        else if(subjectCode == 4){
            titleLabel = new JLabel("MÔN HỌC: HÓA");
        }

        highScoreLabel = new JLabel("Highest Score: ");
        lowScoreLabel = new JLabel("Lowest Score: ");
        averageScoreLabel = new JLabel("Average Score: ");

        JPanel panel = new JPanel(new BorderLayout());
        Font fontTitle = new Font("Arial", Font.PLAIN, 20);
        Font fontContent = new Font("Arial", Font.PLAIN, 15);

        highScoreLabel.setFont(fontContent);

        lowScoreLabel.setFont(fontContent);
        lowScoreLabel.setBackground(new Color(220 , 220 , 220));

        averageScoreLabel.setFont(fontContent);


        JPanel titlePanel = new JPanel();
        titleLabel.setFont(fontTitle);
        titlePanel.setBackground(Color.LIGHT_GRAY);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
        titlePanel.add(Box.createHorizontalGlue());
        titlePanel.add(titleLabel);
        titlePanel.add(Box.createHorizontalGlue());

        JPanel labelsPanel = new JPanel(new GridLayout(0, 1)); 
                
        labelsPanel.add(highScoreLabel);
        labelsPanel.add(lowScoreLabel);
        labelsPanel.add(averageScoreLabel);

        for (int i = 0; i < labelsPanel.getComponentCount(); i++) {
            JLabel label = (JLabel) labelsPanel.getComponent(i);
            label.setOpaque(true);
            Color backgroundColor = (i % 2 == 1) ? Color.LIGHT_GRAY : new Color(230 , 230 , 230); // Chọn màu nền xen kẽ
            label.setBackground(backgroundColor);
            label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        }

        panel.add(titlePanel, BorderLayout.NORTH);
        panel.add(Box.createVerticalStrut(10)); // Khoảng cách giữa tiêu đề và các nhãn
        panel.add(labelsPanel, BorderLayout.CENTER);


        this.add(panel);
        this.setScores(scoreList);
        this.setVisible(true);
    }

    public void setScores(ArrayList<Double> scoreList) {
        double highestScore = scoreList.get(scoreList.size() -1);
        double lowestScore = scoreList.get(0);
        double sum = 0;
        
        for (double num : scoreList) {
            sum += num;
        }
        // Chia tổng cho số lượng phần tử để tính trung bình
       double averageScore = (double) sum / scoreList.size();
       String formattedNumber = String.format("%.2f", averageScore);

        highScoreLabel.setText("Highest Score: " + highestScore);
        lowScoreLabel.setText("Lowest Score: " + lowestScore);
        averageScoreLabel.setText("Average Score: " + formattedNumber);
    }

}

 
