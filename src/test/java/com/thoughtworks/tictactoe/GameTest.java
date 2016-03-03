package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class GameTest {

    private  Game game;
    private PrintStream printStream;

    @Before
    public void setup(){
        printStream = mock(PrintStream.class);
        game = new Game(PrintStream printStream);
    }

    @Test
    public void shouldPrintBoardWhenGameStarts(){
        game.start();


        verify(printStream).println();
    }

}