package model;

public class Score {
    private int stuCode;
    private double matScore = 0;
    private double phyScore = 0;
    private double cheScore = 0;
    private double total = 0;

    public Score(int stuCode, double matScore, double phyScore, double cheScore){
        this.stuCode = stuCode;
        this.matScore = matScore;
        this.phyScore = phyScore;
        this.cheScore = cheScore;
        this.total = matScore + phyScore + cheScore;
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
    
    public double getTotal() {
        return total;
    }

    public String classification(){
        if(this.total >= 24){
            return "Giỏi";
        }else if(this.total >= 15){
            return "Khá";
        } else return "Bốc cứt";
    }

}
