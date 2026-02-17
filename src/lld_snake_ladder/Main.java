package lld_snake_ladder;

import lld_snake_ladder.Service.Game;
import lld_snake_ladder.model.Dice;
import lld_snake_ladder.model.Player;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class Main {
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the board size : ");
        int boardSize = scanner.nextInt();

        System.out.println("Enter the number of snakes : ");
        int noOfSnakes = scanner.nextInt();

        System.out.println("Enter the number of ladders : ");
        int noOfLadders = scanner.nextInt();

        System.out.println("Enter the number of players : ");
        int noOfPlayers = scanner.nextInt();

        System.out.println("Enter thr number of Dice : ");
        int noOfDice = scanner.nextInt();

        Game game = new Game(boardSize, noOfLadders, noOfSnakes, noOfDice);

        for(int i = 0; i < noOfPlayers; i++){
            System.out.println("Enter the name of player " + (i + 1) + " : ");
            Player player = new Player(scanner.next());
            game.addPlayer(player);
        }
        game.startGame();
    }
}
