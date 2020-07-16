package com.company;

public class PasswordGenerator {

    public static String generatePassword (int numberCharacters){
        StringBuilder password = new StringBuilder();
        int minimumNumberCharacters = 12;
        if(numberCharacters > minimumNumberCharacters){
            minimumNumberCharacters = numberCharacters;
        }

        System.out.println("password length: "+ minimumNumberCharacters);

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






        return "hack";





    }


}
