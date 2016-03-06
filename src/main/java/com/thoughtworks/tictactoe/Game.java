package com.thoughtworks.tictactoe;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Game {

    private Board board;
    private UserScanner scanner;
    private BufferedReader reader;
    private PrintStream printStream;
    private Player player1;

    public Game(PrintStream printStream, Board board, UserScanner scanner, BufferedReader reader) {
        this.printStream = printStream;
        this.board = board;
        this.scanner = scanner;
        this.reader = reader;
    }

    public void start() {
        board.print();
    }


    public void promptPlayer(String playerMark) throws IOException {
        String playerMove = reader.readLine();
        board.interpretInput(Integer.valueOf(playerMove),playerMark);

    }

    public void run() throws IOException {
        while (!board.complete()) {
            promptPlayer("X");
            promptPlayer("O");
        }
        isOver();
    }

    public void isOver() {
        printStream.println("Game Is Over");

    }
}
