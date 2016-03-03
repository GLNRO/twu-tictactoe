package com.thoughtworks.tictactoe;


import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private PrintStream printStream;
    private List<String> boardString;
    private boolean gameOver;

    public Board(PrintStream printStream,List<String> boardString) {

        this.printStream = printStream;
        this.gameOver = false;
        this.boardString = boardString;
    }

    public void print() {
        printStream.println(boardString.get(0) +"|"+ boardString.get(1) +"|" + boardString.get(2) +"\n-----\n"+ boardString.get(3) +"|"+ boardString.get(4) +"|" + boardString.get(5) +"\n-----\n"+ boardString.get(6) +"|" + boardString.get(7) + "|" + boardString.get(8));

    }

    public void interpretInput(int userInput,String player) {
        String cellContent = boardString.get(userInput-1);

        if(cellContent.equals("X") || cellContent.equals("O")) {
            printStream.println("Location already taken, please try again");
        }
        else {
            boardString.set(userInput - 1, player);
            print();
        }
    }



    public boolean complete() {
        boolean completeCells =  true;
        for(String cell : boardString){
            if(!(cell.equals("X") || cell.equals("O"))){
                completeCells = false;
            }
            else if(!checkColumns()){
                completeCells = false;
            }
        }

        return completeCells;
    }

    public boolean checkColumns(){
        boolean completeColumn = false;
        for(int i=6;i<9;i++){
            if(boardString.get(i).equals(boardString.get(i-3)) && boardString.get(i).equals(boardString.get(i-6))){
                completeColumn = true;
            }
        }
        return completeColumn;
    }
}
