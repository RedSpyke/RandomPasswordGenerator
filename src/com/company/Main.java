package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("How many characters should the password have ? ");
        int numberCh = input.nextInt();
        PasswordGenerator.generatePassword(numberCh);


    }
}
