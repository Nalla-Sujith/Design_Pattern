package Tic_Tac_Toe;

public class Main {
    public static void main(String args[]) {
        Game g = new Game();
        String status = g.startGame();
        if (status.equals("Tie")) {
            System.out.println("****===Game Tied===****");
        } else {
            System.out.println("***====Winner is " + status + "===***");
        }
    }

}
