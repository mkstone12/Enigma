package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        String test = "asdfsdfgdfg";
        int testnum[] = new int[test.length()];

        testnum = stringtoNumArray(test);

        String nexttest = arrayToString(testnum);
        System.out.println(nexttest);


        int[] newtestnum = {7, 15, 4, 20, 0, 7, 29, 5, 20, 0, 4, 21, 0, 5, 18, 0, 6, 15, 18, 0, 19, 5, 10};
        System.out.println(Arrays.toString(newtestnum));


        nexttest = arrayToString(newtestnum);

        System.out.println(nexttest);

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

    //takes an array of strings and converts to a string
    public static String arrayToString(int[] array){
        String alfabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        String text = "";
        for (int i = 0 ; i < array.length; i++){
            text = text + alfabet.substring(array[i],array[i]+1);
        }
        return text;
    }



    /// takes String in form "1, 5 ,6 ,4, 3" and returns it as array
    public static int[] numStringToArray (String inputString){
        int nums[] = new int[inputString.length()/3];
        nums[0] = Integer.parseInt(inputString.substring(0,1));
        for(int i = 1; i< inputString.length()/3;i++){
            nums[i] = Integer.parseInt(inputString.substring(i*3,i*3+1));
        }
        return nums;
    }




}

