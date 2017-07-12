package lesson1.obstacles;

import lesson1.competitors.Competitor;

public class Water extends Obstacle {
    private final static int MAX_LENGTH = 200;
    private static String name = "Вода";

    public Water(int length) {
        super(name, length);
    }

    public static int getMAX() {
        return MAX_LENGTH;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(this.getLenghtOrHeight());
    }

}
