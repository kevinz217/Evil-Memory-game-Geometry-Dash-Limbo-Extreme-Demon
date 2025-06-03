import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome players to a simple matching game!");

        int turn = 0;
        person p1 = new person();
        person p2 = new person();
        String antidote = "\uD83D\uDC8A";
        String poison = "\uD83D\uDC80";
        String knight = "\uD83D\uDEE1";
        String robber = "\uD83D\uDDE1";
        String mine = "\uD83E\uDEA4";
        String bomb = "\uD83D\uDCA3";
        String shuffle = "\uD83C\uDCCF";
        String wildcard = "\uD83E\uDD8B";
        String[] unique = {"\uD83D\uDC8A","\uD83D\uDC80","\uD83D\uDEE1","\uD83D\uDDE1","\uD83E\uDEA4","\uD83D\uDCA3","\uD83C\uDCCF","\uD83E\uDD8B"};
        String[] a = {"\uD83D\uDD20", "\uD83D\uDD23", "\uD83D\uDD22", "\uD83D\uDD24", "\uD83C\uDD70", "\uD83C\uDD8E", "\uD83C\uDD71", "\uD83C\uDD91", "\uD83C\uDD92", "\uD83C\uDD93", "\uD83C\uDD94", "\uD83C\uDD95", "\uD83C\uDD96", "\uD83C\uDD7E"};
        ArrayList<String> available = new ArrayList<>(Arrays.asList(antidote, poison, knight, robber, mine, bomb, shuffle, wildcard));
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < 2; j++){
                available.add(a[i]);
            }
        }
        String[][] answer = answer(available);

        for(int i = 0; i < answer.length; i++){
            for(int j = 0; j < answer[0].length; j++){
                System.out.print(answer[i][j]);
            }
            System.out.println();
        }

        String[] row7 = {"1"," ","2"," ","3"," ","4"," ","5"," ","6"," "," "};
        String[] row1 = {"_"," ","_"," ","_"," ","_"," ","_"," ","_"," ","a"};
        String[] row2 = {"_"," ","_"," ","_"," ","_"," ","_"," ","_"," ","b"};
        String[] row3 = {"_"," ","_"," ","_"," ","_"," ","_"," ","_"," ","c"};
        String[] row4 = {"_"," ","_"," ","_"," ","_"," ","_"," ","_"," ","d"};
        String[] row5 = {"_"," ","_"," ","_"," ","_"," ","_"," ","_"," ","e"};
        String[] row6 = {"_"," ","_"," ","_"," ","_"," ","_"," ","_"," ","f"};
        String[][] grid ={row1, row2, row3, row4, row5, row6, row7};
        while (p1.getMatches() + p2.getMatches() < 14) {
            if (turn % 2 == 0) {
                System.out.println("p1 turn");
                System.out.println("Score: " + p1.getScore());
                p1 = play(grid, answer, unique, p1);
                turn ++;
            } else {
                System.out.println("p2 turn");
                System.out.println("Score: " + p2.getScore());
                p2 = play(grid, answer, unique, p2);
                turn ++;
            }
        }
        if (p1.getScore() > p2.getScore()){
            System.out.println("P1 WINS OMGG");
        }else if (p1.getScore() < p2.getScore()){
            System.out.println("P2 WINS OMGG");
        }else{
            System.out.println("TIE OMGGGGG");
        }
    }
    public static void makeGrid(String[][] grid){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    public static String[][] answer(ArrayList<String> a){
        String[][] answer = new String[6][6];
        for(int i = 0; i < answer.length; i++){
            for(int j = 0; j < answer[0].length; j++){
                Random r = new Random();
                int x = r.nextInt(0, a.size());
                answer[i][j] = a.get(x);
                a.remove(x);
            }
        }
        return answer;
    }

    //fix clear
    public static void clear(){
        Timer t = new Timer();
        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        for (int i = 0; i <= 30; i++) {
            System.out.println();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

        public static person play(String[][] grid, String[][] answer, String[] specItems, person p){
        makeGrid(grid);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first position: ");
        String check1 = scanner.nextLine();
        int C1R = check1.charAt(0) - 97;
        int C1C = Integer.parseInt(check1.substring(1));
        System.out.print("Enter second position: ");
        String check2 = scanner.nextLine();
        int C2R = check2.charAt(0) - 97;
        int C2C = Integer.parseInt(check2.substring(1));
        int A1R = C1R;
        int A1C = C1C;
        int A2R = C2R;
        int A2C = C2C;
        if (C1C * 2 - 1 < 0){
            C1C = 0;
        }else{
            C1C = C1C * 2 - 2;
        }
        if (C2C * 2 - 1 < 0){
            C2C = 1;
        }else{
            C2C = C2C * 2 - 2;
        }
        while (grid[C1R][C1C] != "_" || grid[C2R][C2C] != "_"){
            System.out.println("ERROR, try again");
            System.out.print("Enter first position: ");
            check1 = scanner.nextLine();
            C1R = check1.charAt(0) - 97;
            C1C = Integer.parseInt(check1.substring(1));
            System.out.print("Enter second position: ");
            check2 = scanner.nextLine();
            C2R = check2.charAt(0) - 97;
            C2C = Integer.parseInt(check2.substring(1));
            A1R = C1R;
            A1C = C1C;
            A2R = C2R;
            A2C = C2C;
            if (C1C * 2 - 1 < 0){
                C1C = 0;
            }else{
                C1C = C1C * 2 - 2;
            }
            if (C2C * 2 - 1 < 0){
                C2C = 1;
            }else{
                C2C = C2C * 2 - 2;
            }
        }
        if (A1C - 1 < 0) {
            grid[C1R][C1C] = answer[A1R][A1C];
        }else{
            grid[C1R][C1C] = answer[A1R][A1C - 1];
        }
        if (A2C - 1 < 0) {
            grid[C2R][C2C] = answer[A2R][A2C];
        }else{
            grid[C2R][C2C] = answer[A2R][A2C - 1];
        }
        makeGrid(grid);
        ArrayList<String> SIAL = new ArrayList<>(Arrays.asList(specItems));

        if (SIAL.contains(grid[C1R][C1C])){
            check(grid[C1R][C1C], p);
        }
        if (SIAL.contains(grid[C2R][C2C])){
            check(grid[C2R][C2C], p);
        }
        clear();
        if (grid[C1R][C1C] != grid[C2R][C2C]){
            grid[C1R][C1C] = "_";
            grid[C2R][C2C] = "_";
            return p;
        }
        p.addScore();
        p.addMatches();
        return p;
    }
    public static person check(String spec, person p){
        String antidote = "\uD83D\uDC8A";
        String poison = "\uD83D\uDC80";
        String knight = "\uD83D\uDEE1";
        String robber = "\uD83D\uDDE1";
        String mine = "\uD83E\uDEA4";
        String bomb = "\uD83D\uDCA3";
        String shuffle = "\uD83C\uDCCF";
        String wildcard = "\uD83E\uDD8B";
        if (spec == antidote){
            p.addInv(antidote);
        }else if (spec == knight){
            p.addInv(knight);
        }else if (spec == wildcard){
            p.addInv(antidote);
            p.addInv(knight);
        }
        if (spec == poison && p.getInv().contains(antidote)){
            p.removeInv(antidote);
        }
        if (spec == robber && p.getInv().contains(knight)){
            p.removeInv(knight);
        }
        if (spec == bomb || spec == mine || spec == shuffle){
            p.removeScore();
        }
        return p;
    }
}