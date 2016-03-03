package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class GameTest {

    private  Game game;
    private PrintStream printStream;
    private Board board;
    private Player player1;
    private Player player2;
    private UserScanner scanner;

    @Before
    public void setup(){
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        scanner = mock(UserScanner.class);
        game = new Game(printStream,board,scanner);
    }

    @Test
    public void shouldPrintBoardWhenGameStarts(){
        game.start();

        verify(board).print();
    }

    @Test
    public void shouldAskPlayerOneToEnterAMove(){
        when(scanner.nextInt()).thenReturn(0);

        game.promptPlayer();

        verify(board).interpretInput(0,"X");
    }


}