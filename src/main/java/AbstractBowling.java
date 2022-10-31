import node.Frame;

public abstract class AbstractBowling implements Bowling {
    protected static final int NOT_CACHE = -1;
    protected static final int LAST_STAGE = 9;

    protected Frame[] frames;
    protected int totalScore;

    protected int scoreCache;
    protected int stage;

    protected AbstractBowling () {
        stage = -1;
    }


}
