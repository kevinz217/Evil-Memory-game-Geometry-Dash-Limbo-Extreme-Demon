import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String antidote = "\uD83D\uDC8A";
        String poison = "\uD83D\uDC80";
        String knight = "\uD83D\uDEE1";
        String robber = "\uD83D\uDDE1";
        String mine = "\uD83E\uDEA4";
        String bomb = "\uD83D\uDCA3";
        String shuffle = "\uD83C\uDCCF";
        String wildcard = "\uD83E\uDD8B";
        String[] a = {"\uD83D\uDD20", "\uD83D\uDD23", "\uD83D\uDD22", "\uD83D\uDD24", "\uD83C\uDD70", "\uD83C\uDD8E", "\uD83C\uDD71", "\uD83C\uDD91", "\uD83C\uDD92", "\uD83C\uDD93", "\uD83C\uDD94", "\uD83C\uDD95", "\uD83C\uDD96", "\uD83C\uDD7E"};
        ArrayList<String> available = new ArrayList<>(Arrays.asList(antidote, poison, knight, robber, mine, bomb, shuffle, wildcard));
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < 2; j++){
                available.add(a[i]);
            }
        }
        String[][] answer = answer(available);

        System.out.println();
        char x = 97;
        System.out.println(x);
        String[] row1 = {"a"," ","b"," ","c"," ","d"," ","e"," ","f"," "," "};
        String[] row2 = {"_"," ","_"," ","_"," ","_"," ","_"," ","_"," ","1"};
        String[] row3 = {"_"," ","_"," ","_"," ","_"," ","_"," ","_"," ","2"};
        String[] row4 = {"_"," ","_"," ","_"," ","_"," ","_"," ","_"," ","3"};
        String[] row5 = {"_"," ","_"," ","_"," ","_"," ","_"," ","_"," ","4"};
        String[] row6 = {"_"," ","_"," ","_"," ","_"," ","_"," ","_"," ","5"};
        String[] row7 = {"_"," ","_"," ","_"," ","_"," ","_"," ","_"," ","6"};
        String[][] grid ={row1, row2, row3, row4, row5, row6, row7};
        makeGrid(grid);
        System.out.print("Enter first position: ");
        String check1 = scanner.nextLine();
        int C1R = check1.charAt(0) - 97;
        int C1C = Integer.parseInt(check1.substring(1)) - 1;
        System.out.print("Enter second position: ");
        String check2 = scanner.nextLine();
        int C2R = check2.charAt(0) - 97;
        int C2C = Integer.parseInt(check2.substring(1)) - 1;
        System.out.println("" + C1R  + " " + C1C + " " + C2R + " " + C2C);
        clear();
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
    public static void clear(){
        Timer t = new Timer();
        try{
            Thread.sleep(300);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.flush();
    }
}