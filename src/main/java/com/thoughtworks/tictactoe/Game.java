package com.thoughtworks.tictactoe;


import java.io.PrintStream;

public class Game {

    private final Board board;
    private final UserScanner scanner;
    private PrintStream printStream;
    private Player player1;

    public Game(PrintStream printStream, Board board, Player player1,  UserScanner scanner) {
        this.printStream = printStream;
        this.board = board;
        this.scanner = scanner;
        this.player1 = player1;
    }

    public void start() {
        board.print();
    }


    public void promptPlayer1() {
        int playerMove = scanner.nextInt();
        board.interpretInput(playerMove,"X");
    }

    public void promptPlayer2() {
        int playerMove = scanner.nextInt();
        board.interpretInput(playerMove,"O");
    }

    public void run(){
        while(!board.complete()){
            promptPlayer1();
            promptPlayer2();
            player1.move();
        }
        isOver();
    }


    public void isOver() {
        printStream.println("Game Is Over");

    }
}
