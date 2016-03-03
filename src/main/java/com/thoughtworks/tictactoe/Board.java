package com.thoughtworks.tictactoe;


import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private PrintStream printStream;
    private List<String> board = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9"));

    public Board(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void print() {
        printStream.println(board.get(0) +"|"+ board.get(1) +"|" + board.get(2) +"\n-----\n"+ board.get(3) +"|"+ board.get(4) +"|" + board.get(5) +"\n-----\n"+ board.get(6) +"|" + board.get(7) + "|" + board.get(8));

    }

    public void interpretInput(int userInput) {
        board.set(userInput,"X");
        print();
    }
}
