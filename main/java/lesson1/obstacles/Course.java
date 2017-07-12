package lesson1.obstacles;

import lesson1.competitors.Competitor;
import lesson1.competitors.Team;

import java.util.Random;

public class Course {
    private final int NUM_OF_OBSTACLES = 4;
    Obstacle[] obstacles = new Obstacle[NUM_OF_OBSTACLES];
    private String name = "";

    public Course(String _name) {
        this.name = _name;

        //Генератор текущей полосы препятствий
        for (int i = 0; i < NUM_OF_OBSTACLES; i++) {
            Random rnd = new Random();
            int currentObstacle = rnd.nextInt(3);
            switch (currentObstacle) {
                case 0: //Если сгенерировалась вода
                    obstacles[i] = new Water(rnd.nextInt(Water.getMAX()));
                    break;
                case 1: //Если сгенерировалась стена
                    obstacles[i] = new Wall(rnd.nextInt(Wall.getMAX()));
                    break;
                case 2: //Если сгенерировался бег
                    obstacles[i] = new Cross(rnd.nextInt(Cross.getMAX()));
                    break;
            }
        }
    }

    //Вывод информации о всей полосе препятствий
    public void info() {
        System.out.println("\nТекущая полоса препятствий: " + this.name);
        for (Obstacle o : obstacles) {
            o.info();
        }
    }

    //Прохождение командой полосы препятствий
    public void doCourse(Team team) {
        for (Competitor c : team.getCompetitors()) {
            for (Obstacle o : obstacles) {
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
    }
}
