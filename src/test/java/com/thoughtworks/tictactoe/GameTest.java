package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class GameTest {

    private  Game game;
    private PrintStream printStream;
    private Board board;
    private UserScanner scanner;
    private Player player1;

    @Before
    public void setup(){
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        scanner = mock(UserScanner.class);
        player1 = mock(Player.class);
        game = new Game(printStream,board, player1, scanner);
    }

    @Test
    public void shouldPrintBoardWhenGameStarts(){
        game.start();

        verify(board).print();
    }

    @Test
    public void shouldAskPlayerOneToEnterAMove(){
        when(scanner.nextInt()).thenReturn(1);

        game.promptPlayer1();

        verify(board).interpretInput(1,"X");
    }

    @Test
    public void shouldAskPlayerTwoToEnterAMove(){
        when(scanner.nextInt()).thenReturn(3);

        game.promptPlayer2();

        verify(board).interpretInput(3,"O");
    }

    @Test
    public void shouldEndGameWhenBoardIsComplete(){
        when(board.complete()).thenReturn(true);

        game.run();

        verify(printStream).println("Game Is Over");
    }

    @Test
    public void shouldPromptPlayer1ToMoveWhenRun(){
        when(board.complete()).thenReturn(false,true);

        game.run();

        verify(player1).move();
    }

}