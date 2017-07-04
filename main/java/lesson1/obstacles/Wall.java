package lesson1.obstacles;

import lesson1.competitors.Competitor;

public class Wall extends Obstacle {
    private static String name = "Стена";
    private final static int MAX_HEIGHT = 5;

    public static int getMAX() {
        return MAX_HEIGHT;
    }

    public Wall(int height) {
        super(name, height);
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(this.getLenghtOrHeight());
    }
}
