import node.Frame;

public final class NationalScoring extends AbstractBowling {

    private int count = 2;

    public NationalScoring() {
        frames = new Frame[10];

        scoreCache = NOT_CACHE;
    }


    @Override
    public int getScore() {
        return totalScore;
    }


    @Override
    public int getScore(int stageIndex) throws Exception {
        if (isCheckOverNowIndex(stageIndex)) {
            throw new Exception();
        }

        return frames[stageIndex].getScore();
    }


    @Override
    public Frame getFrame(int stageIndex) throws Exception {
        if (isCheckOverNowIndex(stageIndex)) {
            throw new Exception();
        }

        return frames[stageIndex];
    }


    @Override
    public int getStageIndex() {
        return stage;
    }


    @Override
    public void setScore(int number) {
        // Range Check

        // setting bonus score
        if (stage == LAST_STAGE) {
            setBonuseScore10Frame(number);
        } else {
            setBonusScore(number);
        }

        // setting frame score
        if (count == 0) {
            setScore(scoreCache, number);
            scoreCache = NOT_CACHE;
            count = 2;

            return;
        }

        // is Strike ?
        if (number == 10 && stage < LAST_STAGE - 1) {
            setScore(number, 0);
            count = 2;
            return;
        }

        scoreCache = number;
        count = 0;
    }


    @Override
    public void setScore(int first, int second) {
        if (stage >= LAST_STAGE) {
            return;
        }

        stage++;

        frames[stage] = new Frame(first, second);

        totalScore += frames[stage].getScore();
    }


    private boolean isCheckOverNowIndex(int stageIndex) {
        if (stage < stageIndex) {
            return true;
        }
        return false;
    }


    private void setBonusScore(int num) {
        if (stage < 0) {
            return;
        }

        String beforeStatus = frames[stage].getStatus();

        if (count == 2 && beforeStatus.equals(Frame.SPARE)) {

            frames[stage].setBonusScore(num);
            totalScore += num;
        }
        if (beforeStatus.equals(Frame.STRIKE)) {

            //  frame first shot after "Double"
            if (count == 2 && stage > 0 && frames[stage - 1].getStatus().equals(Frame.STRIKE)) {
                num += frames[stage].getFirst();
                frames[stage - 1].setBonusScore(num);

                totalScore += num;
            }
            
            // "Open" or "Spare" frame after "Strike"
            if (count == 0) {
                num += scoreCache;
                frames[stage].setBonusScore(num);

                totalScore += num;
            }
        }
    }

    private void setBonuseScore10Frame(int num) {
        if (frames[LAST_STAGE] != null) {
            frames[stage].setBonusScore(num);
            totalScore += num;
            return;
        }

        String beforeStatus = frames[stage].getStatus();

        if (count == 2 && beforeStatus.equals(Frame.SPARE)) {
            frames[stage].setBonusScore(num);
            totalScore += num;

        } else if (count == 0 && beforeStatus.equals(Frame.STRIKE)) {
            frames[stage].setBonusScore(scoreCache + num);
            totalScore += scoreCache + num;
        } 
    }
}
