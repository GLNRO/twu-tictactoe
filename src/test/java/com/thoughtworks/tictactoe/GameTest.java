package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class GameTest {

    private  Game game;
    private PrintStream printStream;
    private Board board;
    private UserScanner scanner;
    private BufferedReader reader;

    @Before
    public void setup(){
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        scanner = mock(UserScanner.class);
        reader = mock(BufferedReader.class);
        game = new Game(printStream,board, scanner, reader);
    }

    @Test
    public void shouldPrintBoardWhenGameStarts(){
        game.start();

        verify(board).print();
    }


    @Test
    public void shouldAskPlayerOneToEnterAMove() throws IOException{
        when(reader.readLine()).thenReturn("1");

        game.promptPlayer("X");

        verify(board).interpretInput(1,"X");
    }

    @Test
    public void shouldAskPlayerTwoToEnterAMove() throws IOException {
        when(reader.readLine()).thenReturn("3");

        game.promptPlayer("O");

        verify(board).interpretInput(3,"O");
    }

    @Test
    public void shouldEndGameWhenBoardIsComplete() throws IOException {
        when(board.complete()).thenReturn(true);

        game.run();

        verify(printStream).println("Game Is Over");
    }


}