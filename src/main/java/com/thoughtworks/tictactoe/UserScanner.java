package com.thoughtworks.tictactoe;

import java.util.Scanner;

public class UserScanner {

    private Scanner scanner;

    public UserScanner(){
        scanner = new Scanner(System.in);
    }

    public int nextInt (){
        return scanner.nextInt();
    }

}
