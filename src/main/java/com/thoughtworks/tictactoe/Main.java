package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        List<String> boardString = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
        Board board = new Board(printStream,boardString);
        UserScanner scanner = new UserScanner();
        Player player1 = new Player();
        Game game = new Game(printStream,board,player1,scanner);
        game.start();
        game.run();

    }
}
