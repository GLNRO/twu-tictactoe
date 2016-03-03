package com.thoughtworks.tictactoe;

import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        Board board = new Board(printStream);
        UserScanner scanner = new UserScanner();

        Game game = new Game(printStream,board,scanner);
        game.start();
        game.promptPlayer();
    }
}
