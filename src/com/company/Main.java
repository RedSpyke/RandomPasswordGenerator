package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numberCh = input.nextInt();
        System.out.println(PasswordGenerator.generatePassword(numberCh));



    }
}
