package vendingmachine.util;

public class RandomUtil {

    public static int generateRandomNumber(int minimum, int maximum) {
        return (int) (Math.random() * (maximum + 1)) + minimum;
    }
}
