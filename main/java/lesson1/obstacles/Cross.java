package lesson1.obstacles;

import lesson1.competitors.Competitor;

public class Cross extends Obstacle {
    private final static int MAX_LENGTH = 500;
    private static String name = "Бег";

    public Cross(int length) {
        super(name, length);
    }

    public static int getMAX() {
        return MAX_LENGTH;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(this.getLenghtOrHeight());
    }
}
