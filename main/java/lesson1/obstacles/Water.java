package lesson1.obstacles;

import lesson1.competitors.Competitor;

public class Water extends Obstacle {
    private static String name = "Вода";
    private final static int MAX_LENGTH = 200;

    public static int getMAX() {
        return MAX_LENGTH;
    }

    public Water(int length) {
        super(name, length);
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(this.getLenghtOrHeight());
    }

}
