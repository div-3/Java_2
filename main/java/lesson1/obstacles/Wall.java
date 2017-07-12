package lesson1.obstacles;

import lesson1.competitors.Competitor;

public class Wall extends Obstacle {
    private final static int MAX_HEIGHT = 5;
    private static String name = "Стена";

    public Wall(int height) {
        super(name, height);
    }

    public static int getMAX() {
        return MAX_HEIGHT;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(this.getLenghtOrHeight());
    }
}
