/**
 * Java. Level 2. Lesson 1.
 *
 * @author Ivan Dudorov
 **/

package lesson1;

import lesson1.competitors.*;
import lesson1.obstacles.*;

public class Main {
    public static void main(String[] args) {
        Competitor[] competitors = {new Human("Боб"), new Human("Василий"), new Cat("Барсик"), new Dog("Бобик")};
        Team team = new Team("Друзья", competitors);
        Course course = new Course("К2");
        course.info();
        team.info();
        System.out.println();
        course.doCourse(team);
        team.winnerInfo();
    }
}