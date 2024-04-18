package model;

public class ScoreModel {
    private int stuCode;
    private double matScore = 0;
    private double phyScore = 0;
    private double cheScore = 0;

    public ScoreModel(double matScore, double phyScore, double cheScore){
        this.matScore = matScore;
        this.phyScore = phyScore;
        this.cheScore = cheScore;
    }

    public void setCheScore(double cheScore) {
        this.cheScore = cheScore;
    }

    public void setMatScore(double matScore) {
        this.matScore = matScore;
    }

    public void setPhyScore(double phyScore) {
        this.phyScore = phyScore;
    }

    public void setStuCode(int stuCode) {
        this.stuCode = stuCode;
    }

    public double getCheScore() {
        return cheScore;
    }

    public double getMatScore() {
        return matScore;
    }

    public double getPhyScore() {
        return phyScore;
    }

    public int getStuCode() {
        return stuCode;
    }
    


}
