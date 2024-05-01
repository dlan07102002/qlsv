package view;

import javax.swing.*;

import dao.ScoreModelDAO;
import model.ScoreModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

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
        setTitle("Rank View");
        setSize(300, 200);
        
        if(subjectCode == 2){
            titleLabel = new JLabel("Môn học: Toán");
        } 
        else if(subjectCode == 3){
            titleLabel = new JLabel("Môn học: Lý");
        }
        else if(subjectCode == 4){
            titleLabel = new JLabel("Môn học: Hóa");
        }

        highScoreLabel = new JLabel("Highest Score: ");
        lowScoreLabel = new JLabel("Lowest Score: ");
        averageScoreLabel = new JLabel("Average Score: ");

        JPanel panel = new JPanel(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
        titlePanel.add(Box.createHorizontalGlue());
        titlePanel.add(titleLabel);
        titlePanel.add(Box.createHorizontalGlue());

        JPanel labelsPanel = new JPanel(new GridLayout(0, 1)); 
        labelsPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 10)); // Đặt lề cho panel

        labelsPanel.add(highScoreLabel);
        labelsPanel.add(lowScoreLabel);
        labelsPanel.add(averageScoreLabel);

        panel.add(titlePanel, BorderLayout.NORTH);
        panel.add(Box.createVerticalStrut(10)); // Khoảng cách giữa tiêu đề và các nhãn
        panel.add(labelsPanel, BorderLayout.CENTER);

        getContentPane().add(panel);
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

        highScoreLabel.setText("Highest Score: " + highestScore);
        lowScoreLabel.setText("Lowest Score: " + lowestScore);
        averageScoreLabel.setText("Average Score: " + averageScore);
    }
}
