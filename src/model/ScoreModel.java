package model;

import java.util.ArrayList;

import dao.ScoreModelDAO;

public class ScoreModel {
    private static ArrayList<Score> scoreList = new ArrayList<Score>();

    public ScoreModel(){
           
        try {
            ArrayList<Score> list = ScoreModelDAO.getInstance().selectAll();
            this.setScoreList(list);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Created score");
    
    }

    public void setScoreList(ArrayList<Score> scoreList) {
        this.scoreList = scoreList;
    }

    public ArrayList<Score> getScoreList() {
        return scoreList;
    }

    public void insert(Score score){
        this.scoreList.add(score);
    }

    public void delete(Score score){
        this.scoreList.remove(score);
    }

    public void update(Score scoSrc, Score scoDist){
        this.scoreList.remove(scoSrc);
        this.scoreList.add(scoDist);
    }

    //Lọc danh sách điểm theo ID
    public Score searchScoreById(int id){
        for(Score i : scoreList){
            if(i.getStuCode() == id){
                return i;
            }
        }
        return null;
    }

}
