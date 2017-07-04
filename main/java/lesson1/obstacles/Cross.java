package lesson1.obstacles;

import lesson1.competitors.Competitor;

public class Cross extends Obstacle {
    private static String name = "Бег";
    private final static int MAX_LENGTH = 500;

    public static int getMAX() {
        return MAX_LENGTH;
    }

    public Cross(int length) {
        super(name, length);
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(this.getLenghtOrHeight());
    }
}
