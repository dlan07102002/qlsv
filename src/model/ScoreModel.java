package model;

import java.util.ArrayList;
import java.util.Comparator;

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
        ScoreModelDAO.getInstance().insert(score);
    }

    public void delete(Score score){
        this.scoreList.remove(score);
        ScoreModelDAO.getInstance().drop(score);
    }

    public void update(Score scoSrc, Score scoDist){
        this.scoreList.remove(scoSrc);
        this.scoreList.add(scoDist);
        ScoreModelDAO.getInstance().update(scoDist);
    }

    // public ArrayList<Score> sort(){
    //     try {
    //         //JDBC - JAVA DB connectivity
    //         //MVC - model view controller
    //         //sql -> list đã sắp xếp
    //         //set list đấy ra view
    //         ArrayList<Score> list = ScoreModelDAO.getInstance().selectByCondition("sort");
    //         // this.setScoreList(list);
    //         return list;
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //     }
    //     System.out.println("Created score");
    //     return null;
    // }

    public ScoreModel sort(){
        scoreList.sort((Comparator<? super Score>) new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                if(o2.getTotal() > o1.getTotal() ){
                    return 1;
                } else return -1;
               
            }
        });
        return this;
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
