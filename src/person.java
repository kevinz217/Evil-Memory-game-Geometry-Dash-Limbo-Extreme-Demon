import java.util.ArrayList;

public class person {
    int score = 0;
    int matches = 0;
    ArrayList<String> inv = new ArrayList<>();
    public void Person() {}

    public int getScore() {
        return score;
    }

    public void addScore() {
        this.score ++;
    }
    public int getMatches() {
        return matches;
    }

    public void addMatches() {
        this.matches ++;
    }
    public void removeScore(){
        this.score --;
    }

    public ArrayList<String> getInv() {
        return inv;
    }

    public void addInv(String item) {
        this.inv.add(item);
    }
    public void removeInv(String item){
        this.inv.remove(item);
    }
}
