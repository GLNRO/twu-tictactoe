package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private Game game;

    @Before
    public void setup(){
        printStream = mock(PrintStream.class);
        game = mock(Game.class);
        board = new Board(printStream);
    }

    public void player1Enters1(){
        board.interpretInput(1,"X");
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

}