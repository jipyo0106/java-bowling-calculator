# 자바 볼링 계산기

## 사용법

### setScore(number)
```java
public class Main {
    public static void main(String[] args) {
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
        // 10 Frame - open
        bowling.setScore(7);
        bowling.setScore(2);
    }
}
```

### setScore(number1, number2)
```java
public class Main {
    public static void main(String[] args) {
        Bowling bowling = new NationalScoring();

        // 1 Frame - strike
        bowling.setScore(10, 0);
        // 2 Frame - spare
        bowling.setScore(7, 3);
        // 3 Frame - open
        bowling.setScore(5, 4);
        // 4 Frame - strike
        bowling.setScore(10, 0);
        // 5 Frame - open
        bowling.setScore(0, 0);
        // 6 Frame - strike
        bowling.setScore(10);
        // 7 Frame - spare
        bowling.setScore(9, 1);
        // 8 Frame - spare
        bowling.setScore(7, 3);
        // 9 Frame - spare
        bowling.setScore(2, 8);
        // 10 Frame - open
        bowling.setScore(7, 2);
    }
}
```
