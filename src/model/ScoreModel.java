package model;

import java.util.ArrayList;

public class ScoreModel {
    private static ArrayList<Score> scoreList;

    public ScoreModel(){
        Score s1 = new Score(1, 10 ,10, 10);
        Score s2 = new Score(2, 8 ,10, 10);
        Score s4 = new Score(4, 1 ,1, 1);



        this.scoreList = new ArrayList<Score>();
        System.out.println("Created score");
        this.insert(s1);
        this.insert(s2);
        this.insert(s4);




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
