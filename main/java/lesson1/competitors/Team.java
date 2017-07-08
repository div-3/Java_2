package lesson1.competitors;

public class Team {
    private String name;   // Название команды
    private final static int MAX_NUM_COMPETITORS = 4;   //Размер команды
    private Competitor[] competitors;// = new Competitor[MAX_NUM_COMPETITORS];    //Члены команды

    public Team(String _name ,Competitor[] _competitors){
        this.name = _name;
        for (int i = 0; i < _competitors.length && i < MAX_NUM_COMPETITORS; i++) {
            this.competitors[i] = _competitors[i];
        }
    }

    public Competitor[] getCompetitors() {
        return competitors;
    }

    //Вывод информации о составе команды
    public void info(){
        System.out.println("\nТекущая команда: " + this.name);
        for (Competitor c: this.competitors) {
            c.info();
        }
    }

    //Вывод информации о прошедших полосу препятствия членах команды
    public void winnerInfo(){
        System.out.println("\nПрошли полосу препятствий: ");
        for (Competitor c: competitors) {
            if(c.isOnDistance()) c.info();
        }
    }
}
