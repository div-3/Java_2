package lesson1.obstacles;

import lesson1.competitors.*;

public abstract class Obstacle {
    private String name;    //название препятствия
    private int lenghtOrHeight;    //максимальное значение для препятствия



    public Obstacle(String _name, int _lenghtOrHeight){
        this.name = _name;
        this.lenghtOrHeight = _lenghtOrHeight;
    }

    public abstract void doIt(Competitor competitor);

    public void info() {
        System.out.println(this.name + ' ' + this.lenghtOrHeight);
    }

    public int getLenghtOrHeight(){
        return this.lenghtOrHeight;
    }
}
