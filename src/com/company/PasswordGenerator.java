package com.company;

/*

  This is a password generator
  It takes an integer value for the length of the password, the minimum length of the password that will be generated is 12 characters.
  In order for the password to be valid it must contain at least a lower case character, an upper case character, a digit and a symbol.

 */

public class PasswordGenerator {

    public static String generatePassword (int numberCharacters){



        StringBuilder password = new StringBuilder();
        int minimumNumberCharacters = 12;
        if(numberCharacters > minimumNumberCharacters){
            minimumNumberCharacters = numberCharacters;
        }

       // System.out.println("password length: "+ minimumNumberCharacters);
        int max = 126;
        int min = 33;

        int [] previousNumbersGenerated= new int[minimumNumberCharacters];
        int numGeneratedPrev = 0;
        boolean numberGeneratedValid = false;

        while (minimumNumberCharacters > 0){
            int randomNumber = (int)(Math.random() * (max - min + 1) + min);
            // check to see if the number generated has already been generated
            // the number generated must never be the same as the previous numbers

            if(numGeneratedPrev == 0){
                previousNumbersGenerated [numGeneratedPrev] = randomNumber;
                numGeneratedPrev++;
            }
            else {
                for (int i = 0; i < numGeneratedPrev; i++) {

                    if(previousNumbersGenerated [i] != randomNumber){
                        numberGeneratedValid = true;
                    }
                    else{
                        numberGeneratedValid = false;
                    }
                }
                if(numberGeneratedValid){
                    previousNumbersGenerated [numGeneratedPrev] = randomNumber;
                    numGeneratedPrev++;
                }
            }

            char ch = (char) randomNumber;
            password.append(ch);
            minimumNumberCharacters--;

        }

        System.out.println(password);
       // System.out.println("Password valid: " + passwordValidation(String.valueOf(password)));
        if(!passwordValidation(String.valueOf(password))){
            generatePassword(numberCharacters);
        }
        return String.valueOf(password);
    }

    private static boolean passwordValidation (String password){

        // the password must contain at least a lower case, an upper case , a digit and a symbol
        if(password != null){

            boolean upperCase = false;
            boolean lowerCase = false;
            boolean digit = false;
            boolean symbol = false;

            for (int i = 0; i < password.length(); i++) {
                int value = (int) password.charAt(i);

                if( value >= 33 && value <= 46 || value >= 58 && value <= 64
                        || value >= 91 && value <= 96 || value >= 123 && value <= 126){
                    symbol = true;
                }
                if(value >= 48 && value <= 57){
                    digit = true;
                }
                if(value >= 65 && value <= 90){
                    upperCase = true;
                }
                if(value >= 97 && value <= 122){
                    lowerCase = true;
                }
            }
            if(upperCase && lowerCase && digit && symbol){
                return true;
            }
        }
        return false;



    }



}
