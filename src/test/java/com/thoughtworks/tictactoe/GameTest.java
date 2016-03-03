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
    public void shouldPrintGameOverWhenBoardIsFull(){
        when(board.complete()).thenReturn(true);

        game.isOver();

        verify(printStream).println(contains("Game Is A Draw"));
    }

//    @Test
//    public void shouldPromptBothPlayersDuringRunUntilBoardIsFull(){
//        when(board.complete()).thenReturn(true).thenReturn(false);
//        game.run();
//
//        verify()
//    }

}