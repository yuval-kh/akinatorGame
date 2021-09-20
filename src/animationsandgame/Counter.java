package animationsandgame;

/**
 * game_and_main.Counter class.
 * basic class that count some values.
 * @author Yuval Khanimov
 * <yuval953@gmail.com>
 * ID 318970902 */
public class Counter {
    private int counter;

    /**
     * constructor to count.first makes it 0.
     */
    public Counter() {
        counter = 0;
    }

    /**
     * add number to current count.
     * @param number the number which is added.
     */
    public void increase(int number) {
        counter += number;
    }

    /**
     * subtract number from current count.
     * @param number  the number which is subtracted.
     */
    public void decrease(int number) {
        counter -= number;
    }

    /**
     * get current count.
     * @return current count.
     */
    public int getValue() {
        return counter;
    }
}