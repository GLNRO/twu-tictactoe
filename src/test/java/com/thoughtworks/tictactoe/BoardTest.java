package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private Game game;
    private Board fullBoard;
    private Board fullColumnBoard;
    private Board fullRowBoard;
    private Board fullDiagonalBoard;

    @Before
    public void setup(){
        printStream = mock(PrintStream.class);
        game = mock(Game.class);
        emptyBoard();
    }

    public void emptyBoard(){
        List<String> boardString = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
        board = new Board(printStream, boardString);
    }

    public void fullBoard(){
        List<String> fullBoardString = new ArrayList<>(Arrays.asList("X","O","X","X","O","O","X","O","X"));
        fullBoard = new Board(printStream, fullBoardString);
    }

    public void player1Enters1(){
        board.interpretInput(1,"X");
    }

    public void fullColumnBoard(){
        List<String> fullColumnString = new ArrayList<>(Arrays.asList("1","X","O","4","X","O","7","X","9"));
        fullColumnBoard = new Board(printStream, fullColumnString);
    }

    public void fullRowBoard() {
        List<String> fullRowString = new ArrayList<>(Arrays.asList("X","X","X","4","O","O","7","8","9"));
        fullRowBoard = new Board(printStream, fullRowString);
    }

    private void fullDiagonalBoard() {
        List<String> fullDiagonalString = new ArrayList<>(Arrays.asList("O","X","3","X","5","X","7","O","9"));
        fullDiagonalBoard = new Board(printStream, fullDiagonalString);
    }

    @Test
    public void shouldPrintEmptyBoardWhenGameStarts(){
        board.print();

        verify(printStream).println(contains("1|2|3\n-----\n4|5|6\n-----\n7|8|9"));
    }

    @Test
    public void shouldPrintXinSpace1WhenPlayer1Enters1(){
        player1Enters1();

        verify(printStream).println(contains("X|2|3\n-----\n4|5|6\n-----\n7|8|9"));
    }



    @Test
    public void shouldPrintOinSpace3WhenPlayer2Enters3(){
        player1Enters1();
        board.interpretInput(3,"O");

        verify(printStream).println(contains("X|2|O\n-----\n4|5|6\n-----\n7|8|9"));
    }

    @Test
    public void shouldPrintLocationIsInvalidWhenPlayerChoosesATakenCell(){
        player1Enters1();
        board.interpretInput(1,"O");

        verify(printStream).println(contains("Location already taken, please try again"));
    }

//    @Test
//    public void shouldEvaluateToTrueWhenBoardIsFull(){
//        fullBoard();
//        boolean comp = fullBoard.complete();
//        assertEquals(true,comp);
//    }

    @Test
    public void shouldPrintDrawWhenBoardIsFull(){
        fullBoard();
        fullBoard.checkForDraw();

        verify(printStream).println(contains("Game Is A Draw"));
    }


    @Test
    public void shouldEndGameWhenPlayerFillsAColumn(){
        fullColumnBoard();
        fullColumnBoard.checkColumns();
        fullColumnBoard.checkGameStatus();

        verify(printStream).println(contains("Game Over"));
    }

    @Test
    public void shouldEndGameWhenPlayerFillsARow(){
        fullRowBoard();
        fullRowBoard.checkRows();
        fullRowBoard.checkGameStatus();

        verify(printStream).println(contains("Game Over"));
    }
    
    @Test
    public void shouldEndGameWhenPlayerFillsDiagonal(){
        fullDiagonalBoard();
        fullDiagonalBoard.checkDiagonals();
        fullDiagonalBoard.checkGameStatus();
        
        verify(printStream).println(contains("Game Over"));
    }
    

}