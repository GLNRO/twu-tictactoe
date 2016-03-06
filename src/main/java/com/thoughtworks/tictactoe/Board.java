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
        checkForDraw();
        checkColumns();
        return gameOver;
    }

    public void checkForDraw(){
        boolean completeCells =  true;
        for(String cell : boardString){
            if(!(cell.equals("X") || cell.equals("O"))){
                completeCells = false;
            }
        }

       if(completeCells){
           gameOver = true;
           printStream.println("Game Is A Draw");
       }

    }

    public void checkColumns(){
        for(int i=6;i<9;i++){
            if(boardString.get(i).equals(boardString.get(i-3)) && boardString.get(i).equals(boardString.get(i-6))){
                gameOver = true;
            }
        }
    }

    public void checkRows(){
        for(int i=0;i<9;i+=3){
            if(boardString.get(i).equals(boardString.get(i+1)) && boardString.get(i).equals(boardString.get(i+2))){
                gameOver = true;
            }
        }
    }

    public void checkDiagonals(){
        for(int i=0;i<3;i+=2){
            if(boardString.get(i).equals(boardString.get(i+2)) && boardString.get(i).equals(boardString.get(i+4))){
                gameOver = true;
            }
            else if(boardString.get(i).equals(boardString.get(i+4)) && boardString.get(i).equals(boardString.get(i+8))){
                gameOver = true;
            }
        }
    }

    public void checkGameStatus() {
        if (gameOver) {
            printStream.println("Game Over");
        }
    }
}
