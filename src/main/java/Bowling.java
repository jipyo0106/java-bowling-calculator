import node.Frame;

public interface Bowling {
    int getScore();

    int getScore(int stageIndex) throws Exception;
    Frame getFrame(int stageIndex) throws Exception;

    int getStageIndex();

    void setScore(int number);
    void setScore(int first, int second);
}
