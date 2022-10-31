package node;

public class Frame {
    public static final String STRIKE = "STRIKE";
    public static final String SPARE = "SPARE";
    public static final String OPEN = "OPEN";

    private String status;

    private int first, second;
    private int bonusScore;
    private int score;


    public Frame(int first, int second) {
        this(first, second, 0);
    }


    public Frame(int first, int second, int bonus) {
        this.first = first;
        this.second = second;
        this.bonusScore = bonus;

        setScore();
        setStatus();
    }


    public String getStatus() {
        return status;
    }


    public int getFirst() {
        return this.first;
    }


    public int getSecond() {
        return this.second;
    }


    public int getScore() {
        return score;
    }


    public int getBonusScore() {
        return this.bonusScore;
    }


    private void setStatus() {
        if (first + second == 10) {
            status = first == 10 ? STRIKE : SPARE;
            return;
        }

        status = OPEN;
    }


    private void setScore() {
        score = first + second + bonusScore;
    }


    public void setBonusScore(int num) {
        this.bonusScore = num;
        setScore();
    }


}
