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

    @Test
    public void shouldPrintEmptyBoardWhenGameStarts(){
        board.print();

        verify(printStream).println(contains("1|2|3\n-----\n4|5|6\n-----\n7|8|9"));
    }



}