package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



        boolean toDecode;
        boolean keepGoing = true;
        while(keepGoing == true){
        toDecode = intro();

        if(toDecode == true){
           ifDecode();
        }
        else if (toDecode == false){
            ifEncode();
        }
        keepGoing = keepGoing();



    }
        System.out.println("Thanks for using Enigma encoder");
    }

    public static boolean intro(){
        System.out.println("Welcome do you want to encode or decode (d/e)");
        boolean keepGoing = true;
        boolean toDecode = false;
        Scanner scanner = new Scanner(System.in);
        while (keepGoing == true){
        String choice = scanner.nextLine();
        if (choice.equals("e")) {
            toDecode = false;
            keepGoing = false;
        }
        else if (choice.equals("d")){
            toDecode = true;
            keepGoing = false;
        }
        else{
            System.out.println("invalid input");}
        }
        return toDecode;
    }


    public static boolean keepGoing(){
        Scanner scanner = new Scanner(System.in);
        boolean keepGoing = false;
        boolean vaildInput = false;

        while(vaildInput == false){
            System.out.println("Do you want to decode or encode anything else (y/n)");
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

    public static void ifDecode(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give list of number in format 2, 5, 6, 8");
        String input = scanner.nextLine();
        input = numToLetter(numStringToArray(input));
        System.out.println(input);
    }

    public static void ifEncode(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text to endcode");
        String input = scanner.nextLine();
        int numArray[] = new int[input.length()];
        numArray = stringtoNumArray(input);
        System.out.println(Arrays.toString(numArray));


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

