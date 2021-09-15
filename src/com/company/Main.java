package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Enigma program");

        mainMenu();

        System.out.println("Thanks for using Marks Enigma program");
    }

    public static void mainMenu(){
        while(true){
            int choice = intro();
            if (choice==1){
                numberCipher();
            }
            else if (choice==2){
                caesarCipher();;
            }
            else if (choice==3){
                vigCipher();
            }
            else if (choice == 0){
                break;
            }
            else {
                System.out.println("invalid input. Try again");
            }
        }

    }
    public static int intro(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which Cipher do you want to use");
        System.out.println("Press 1 for number cipher");
        System.out.println("Press 2 for Caesar cipher");
        System.out.println("Press 3 for Vigenère Cipher");
        System.out.println("Press 0 to exit");
        int choice = scanner.nextInt();
        return choice;

    }
    public static void numberCipher(){
        int menuChoice;
        boolean keepGoing = true;
        System.out.println("Welcome to number cipher");
        while(keepGoing == true){
            menuChoice = subMenu();

            if(menuChoice == 1){
                numEncrypt();
                keepGoing = keepGoing();
            }
            else if (menuChoice == 2){
                numDecrypt();
                keepGoing = keepGoing();
            }
            else if (menuChoice == 0){
                keepGoing = false;
            }
        }
    }
    public static void caesarCipher(){
        int menuChoice;
        boolean keepGoing = true;
        System.out.println("Welcome to Caesar cipher");
        while(keepGoing == true){
            menuChoice = subMenu();

            if(menuChoice == 1){
                caeEncrypt();
                keepGoing = keepGoing();
            }
            else if (menuChoice == 2){
                caeDecrypt();
                keepGoing = keepGoing();
            }
            else if (menuChoice == 0){
                keepGoing = false;
            }
        }
    }
    public static void vigCipher(){
        int menuChoice;
        boolean keepGoing = true;
        System.out.println("Welcome to Vigenère cipher");
        while(keepGoing == true){
            menuChoice = subMenu();

            if(menuChoice == 1){
                vigEncrypt();
                keepGoing = keepGoing();
            }
            else if (menuChoice == 2){
                vigDecrypt();
                keepGoing = keepGoing();
            }
            else if (menuChoice == 0){
                keepGoing = false;
            }
        }
    }


    public static int subMenu(){
        System.out.println("Do you want to encrypt or decrypt (d/e) or return to main menu (m)");
        boolean keepGoing = true;
        int menuChoice = 0;
        Scanner scanner = new Scanner(System.in);
        while (keepGoing == true){
            String choice = scanner.nextLine();
            if (choice.equals("e")) {
                menuChoice = 1;
                keepGoing = false;
            }
            else if (choice.equals("d")){
                menuChoice = 2;
                keepGoing = false;
            }
            else if(choice.equals("m")){
                keepGoing = false;
            }
            else{
                System.out.println("invalid input");}
        }
        return menuChoice;
    }

    public static boolean keepGoing(){
        Scanner scanner = new Scanner(System.in);
        boolean keepGoing = false;
        boolean vaildInput = false;

        while(vaildInput == false){
            System.out.println("Do you want to encrypt or decrypt anything else (y/n)");
            String input = scanner.nextLine();
            if(input.equals("y")){
                vaildInput = true;
                keepGoing = true;
            }
            else if (input.equals("n")){
                vaildInput = true;
                keepGoing = false;
            }
            else{
                System.out.println("invalid input");
            }
        }
        return keepGoing;
    }


    public static void vigEncrypt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text to encrypt");
        String text = scanner.nextLine();
        System.out.println("Enter code pharse");
        String code = scanner.nextLine();
        int numCode[];
        numCode = stringtoNumArray(code);
        int textArray[];
        textArray = stringtoNumArray(text);
        text = "";
        for(int i = 0; i < textArray.length;){
            for(int j = 0; j <numCode.length && i < textArray.length;j++){
                text = text + vigNumToLetter(textArray[i],numCode[j],false);
                i++;
        }
        }
        System.out.println(text);
    }
    public static void vigDecrypt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text to encrypt");
        String text = scanner.nextLine();
        System.out.println("Enter code pharse used to encrypt message");
        String code = scanner.nextLine();
        int numCode[];
        numCode = stringtoNumArray(code);
        int textArray[];
        textArray = stringtoNumArray(text);
        text = "";
        for(int i = 0; i < textArray.length;){
            for(int j = 0; j <numCode.length && i < textArray.length;j++){
                text = text + vigNumToLetter(textArray[i],numCode[j],true);
                i++;
            }
        }
        System.out.println(text);
    }

    public static void caeDecrypt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter encrypted message");
        String input = scanner.nextLine();
        System.out.println("Enter the shift that the message was encrypted with (1-29)");
        int shift = scanner.nextInt();
        input = caeNumToLetter(stringtoNumArray(input),shift,false);
        System.out.println(input);
    }

    public static void caeEncrypt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text to encrypt");
        String input = scanner.nextLine();
        System.out.println("Enter a shift (1-29)");
        int shift = scanner.nextInt();
        int numArray[] = new int[input.length()];
        numArray = stringtoNumArray(input);
        input = caeNumToLetter(stringtoNumArray(input),shift,true);
        System.out.println(input);
    }

    public static void numDecrypt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give list of number in format {2, 5, 6, 8}");
        String input = scanner.nextLine();
        input = numToLetter(numStringToArray(input));
        System.out.println(input);
    }

    public static void numEncrypt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text to encrypt");
        String input = scanner.nextLine();
        int numArray[] = new int[input.length()];
        numArray = stringtoNumArray(input);
        System.out.println(arrayToString(numArray));
    }


    public static String caeNumToLetter(int[] array, int shift , boolean toEncode){
        if(toEncode == false){
            shift = -shift;
        }
        String alfabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        String text = "";
        int index = 0;

        for (int i = 0 ; i < array.length; i++){
            if (array[i]+shift < 30 && array[i]+shift >= 0){
            text = text + alfabet.substring(array[i]+shift,array[i]+1+shift);
        }
            else if (array[i]+shift >= 30){
                index = array[i]+shift-30;
                text = text + alfabet.substring(index,index+1);
            }
            else{
                index = array[i]+shift+30;
                text = text + alfabet.substring(index,index+1);
            }
        }
        return text;
    }

    public static String vigNumToLetter(int num, int shift , boolean toEncode){
        if(toEncode == false){
            shift = -shift;
        }
        String alfabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        String text = "";
        int index = 0;
            if (num+shift < 30 && num+shift >= 0){
                text = text + alfabet.substring(num+shift,num+1+shift);
            }
            else if (num+shift >= 30){
                index = num+shift-30;
                text = text + alfabet.substring(index,index+1);
            }
            else{
                index = num+shift+30;
                text = text + alfabet.substring(index,index+1);
            }
        return text;
    }



    public static String arrayToString(int[] input){
        String text ="{";
        for(int i = 0; i < input.length; i++){
            text = text + Integer.toString(input[i]) + ", ";
        }
        text = text.substring(0,text.length()-2) + "}";
    return text;
    }


    // Takes strings of number and converts to array with number
    public static int[] stringtoNumArray(String inputText){
        int nums[] = new int[inputText.length()];
        for(int i =0 ; i < inputText.length();i++){
            nums[i] = letterToNum(inputText.substring(i,i+1));
        }

        return nums;  }

    // take a letter and converts to number
    public static int letterToNum (String inputchar){
        String alfabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        inputchar = inputchar.toUpperCase();
        int num = alfabet.indexOf(inputchar);
        return num;
    }

    //takes an array of numbers and converts to a string of letters
    public static String numToLetter(int[] array){
        String alfabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        String text = "";
        for (int i = 0 ; i < array.length; i++){
            text = text + alfabet.substring(array[i],array[i]+1);
        }
        return text;
    }



    /// takes String in form "1, 5, 6, 4, 3" and returns it as array
    public static int[] numStringToArray (String inputString){
        //finder antal af tal og laver array
        inputString = inputString.substring(1,inputString.length());
        inputString = inputString.substring(0,inputString.length()-1);
        int numAmount = findNumAmount(inputString);
        int nums[] = new int[numAmount];

        //finder første tal
        if (inputString.substring(1,2).equals(" ")||inputString.substring(1,2).equals(",")) {
            nums[0] = Integer.parseInt(inputString.substring(0,1));
        }
        else{
            nums[0] = Integer.parseInt(inputString.substring(0,2));
        }
        int index = 2;

        //finder resten af tal
        for(int i = 1; i < numAmount; i++){
            //index for næste comma
            index = findComma(inputString,index);

            //sætter sidste tal
            if (index == -1){
                if (inputString.substring(inputString.length()-2, inputString.length()-1).equals(" ")||inputString.substring(inputString.length()-2, inputString.length()-1).equals(",")){
                nums[i] = Integer.parseInt(inputString.substring(inputString.length()-1));
                break;}
                else {
                    nums[i] = Integer.parseInt(inputString.substring(inputString.length()-2));
                    break;}
            }
            //checker om det er 1 eller 2 cifret tal
            if (inputString.substring(index-2, index-1).equals(" ")||inputString.substring(index-2, index-1).equals(",")) {
                nums[i] = Integer.parseInt(inputString.substring(index-1,index));
            }
            else{
                nums[i] = Integer.parseInt(inputString.substring(index-2,index));
            }
            index = index +1;
        }
       return nums;
    }



    public static int findComma(String input, int lastComma){
        int index;
        if(lastComma == 0){
           index = input.indexOf(",");
        }
        else{
            index = input.indexOf(",", lastComma+1);
        }
        return index;
    }


    public static int findNumAmount(String input){
        int sum = 0;
        int index = 0;
        while(index != -1){
            index = input.indexOf(",",index+1);
            sum ++;
        }
        return sum;
    }
}

