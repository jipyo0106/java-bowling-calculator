import node.Frame;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NationalScoringTest {

    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    void perfectGameTest () throws Exception {
        Bowling bowling = new NationalScoring();

        for (int i = 0; i < 12; i++) {
            bowling.setScore(10);
        }

        assertEquals(bowling.getScore(), 300);
    }


    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    void spareGameTest () {
        Bowling bowling = new NationalScoring();

        for (int i = 0; i < 10; i++) {
            bowling.setScore(9);
            bowling.setScore(1);
        }
        bowling.setScore(10);

        assertEquals(bowling.getScore(), 191);
    }


    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    void openGameTest() {
        Bowling bowling = new NationalScoring();

        for (int i = 0; i < 10; i++) {
            bowling.setScore(5, 4);
        }

        assertEquals(bowling.getScore(), 90);
    }


    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    void nomalCaseGameTest () {
        Bowling bowling = new NationalScoring();

        // 1 Frame - strike
        bowling.setScore(10);
        // 2 Frame - spare
        bowling.setScore(7);
        bowling.setScore(3);
        // 3 Frame - open
        bowling.setScore(5);
        bowling.setScore(4);
        // 4 Frame - strike
        bowling.setScore(10);
        // 5 Frame - open
        bowling.setScore(0);
        bowling.setScore(0);
        // 6 Frame - strike
        bowling.setScore(10);
        // 7 Frame - spare
        bowling.setScore(9);
        bowling.setScore(1);
        // 8 Frame - spare
        bowling.setScore(7);
        bowling.setScore(3);
        // 9 Frame - spare
        bowling.setScore(2);
        bowling.setScore(8);
        // 10 Frame
        bowling.setScore(7);
        bowling.setScore(2);

        assertEquals(bowling.getScore(), 129);
    }


    void eachNodeScorePrint(Bowling bowling) {
        try {
            for (int i = 0; i <= bowling.getStageIndex(); i++) {
                eachNodeScorePrint(bowling.getFrame(i), i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    void eachNodeScorePrint(Frame frame, int index) throws Exception {
        System.out.println("===" + index + "===");
        System.out.println("score : " + frame.getScore());
        System.out.println("first : " + frame.getFirst());
        System.out.println("second : " + frame.getSecond());
        System.out.println("bonus : " + frame.getBonusScore());
        System.out.println("status : " + frame.getStatus());
    }

}