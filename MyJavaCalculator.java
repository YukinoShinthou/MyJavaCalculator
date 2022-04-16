package com.company;
import java.rmi.server.ExportException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Main {

    public static String calc(String input){
        String[] array = input.split(" ", 5);
        char num1,num2;
        String[] romanarray = {"I" , "II", "III", "IV", "V", "VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX","XXI"};
        String[] romanhundredarray = {"I" , "II", "III", "IV", "V", "VI","VII","VIII","IX","X","L","C"};
        int[] numbarray = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

        num1 = array[0].charAt(0);
        num2 = array[2].charAt(0);

            if (Character.isDigit(num1)) {
                if (Character.isDigit(num2)) {
                    arabiccheker(array);
                    arabicoutput(array);
                }
                else{
                    throw new ArithmeticException();
                }
            }
            else if(true){
                Romancheker(array,romanarray,numbarray,romanhundredarray);
            }
            else{
                throw new ArithmeticException();
            }
        return " ";
    }
    static void arabiccheker(String[] array){
        if(array.length == 3) {
            try{
                int number1, number2;
            number1 = Integer.parseInt(array[0]);
            if(number1 > 10){
                throw new ArithmeticException();
            }
            number2 = Integer.parseInt(array[2]);
            if(number2 > 10){
                throw new ArithmeticException();
            }
        }
            catch (Exception e){
                int number1, number2;
                number1 = Integer.parseInt(array[0]);
                if(number1 > 10){
                    throw new ArithmeticException("Use number or less than 11");
                }
                number2 = Integer.parseInt(array[2]);
                if(number2 > 10){
                    throw new ArithmeticException("Use number or less than 11");
                }
                throw new ArithmeticException("throws Exception //т.к. используются одновременно разные системы счисления");
            }
        }
        else if (array.length < 3){
            throw new ArithmeticException("throws Exception //т.к. строка не является математической операцией");
        }
        else {
            throw new ArithmeticException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
    }
    static void arabicoutput(String[] array){
        int number1, number2;
        number1 = Integer.parseInt(array[0]);
        number2 = Integer.parseInt(array[2]);
        try{
            if (array.length == 3){
                if (array[1].equals("+")) {
                    int answer = number1 + number2;
                    System.out.println(answer);
                } else if (array[1].equals("-")) {
                    int answer = number1 - number2;
                    System.out.println(answer);
                } else if (array[1].equals("*")) {
                    int answer = number1 * number2;
                    System.out.println(answer);
                } else if (array[1].equals("/")) {
                    int answer = number1 / number2;
                    System.out.println(answer);
                } else {
                    throw new ArithmeticException();
                }
            }
        }
        catch (Exception e){
            throw new ArithmeticException("throws Exception. Possibe operators: (+, -, /, *)");
        }
    }
    static void Romancheker(String[] array,String[] romanarray,int[] numbarray,String[] romanhundredarray){
        int number1 = 0;
        int number2 = 0;
        try{
            if(array.length == 3 ){
                for(int i = 0; i <= 11 ; i++){
                    if(romanarray[i].equals(array[0])){
                        number1 = numbarray[i];
                        break;
                    }
                    else if(i == 11){
                        throw new ArithmeticException();
                    }
                }
                for(int i = 0; i <= 11 ; i++){
                    if(romanarray[i].equals(array[2])){
                        number2 = numbarray[i];
                        break;
                    }
                    else if(i == 11){
                        throw new ArithmeticException();
                    }
                }
            }
            else{
                throw new ArithmeticException();
            }
        }
        catch (Exception e){
            if(number1  == 11 || number2 == 11){
                throw new ArithmeticException("Use numbers from 0 to 10");
            }
            if(array.length < 3){
                throw new ArithmeticException("throws Exception //т.к. строка не является математической операцией");
            }
            if(array.length > 3){
                throw new ArithmeticException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            throw new ArithmeticException("throws Exception //т.к. используются одновременно разные системы счисления");
        }
        try{
            if (array.length == 3){
                if (array[1].equals("+")) {
                    int answer = number1 + number2;
                    for(int i = 0 ; i <= 20; i++){
                        if(i == answer){
                            System.out.println(romanarray[i - 1]);
                        }
                    }
                } else if (array[1].equals("-")) {
                    int answer = number1 - number2;
                    if(answer < 1){
                        throw new ArithmeticException();
                    }
                    else {
                        for (int i = 0; i <= 20; i++) {
                            if (i == answer) {
                                System.out.println(romanarray[i - 1]);
                            }
                        }
                    }
                } else if (array[1].equals("*")) {
                    int answer = number1 * number2;
                    System.out.println(answer);
                    int ten = 0,fifty = 0 ,hundred = 0,five = 0,decimals = 0;
                    String one = "";
                    if(answer > 10){
                        ten = answer / 10;
                        decimals = answer % 10;
                        fifty = answer / 50;
                        hundred = answer / 100;
                        if(hundred == 1){
                            System.out.println("C");
                        }
                        else if(hundred == 0){
                            if(fifty == 1){
                                if(ten < 9){
                                    for(int i = 6; i <= ten ; i++){
                                        one += "X";
                                    }
                                    if(decimals == 0){
                                        System.out.println("L" + one);
                                    }
                                    else {
                                        for (int i = 0; i <= 10; i++) {
                                            if (i == decimals) {
                                                System.out.println("L" + one + romanarray[i - 1]);
                                            }
                                        }
                                    }
                                }
                                else if(ten == 9){
                                    System.out.println("XC");

                                }
                            }
                            else if(fifty == 0){
                                if(ten < 5){
                                    for(int i = 1; i <= ten ; i++){
                                        one += "X";
                                    }
                                    if(decimals == 0){
                                        System.out.println(one);
                                    }
                                    else {
                                        for (int i = 0; i <= 10; i++) {
                                            if (i == decimals) {
                                                System.out.println(one + romanarray[i - 1]);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else {
                        for(int i = 0; i <= 10; i++){
                            if(i == answer){
                                System.out.println(romanarray[i - 1]);
                            }
                        }
                    }
                } else if (array[1].equals("/")) {
                    int answer = number1 / number2;
                    for(int i = 0 ; i <= 20; i++){
                        if(i == answer){
                            System.out.println(romanarray[i - 1]);
                        }
                    }
                } else {
                    throw new ArithmeticException();
                }
            }
        }
        catch (Exception e){
            if(number1 - number2 < 1 ){
                throw new ArithmeticException("throws Exception //т.к. в римской системе нет отрицательных чисел");
            }
            throw new ArithmeticException("throws Exception. Possibe operators: (+, -, /, *)");
        }


    }
    public static void main(String[] args) {
        Scanner str = new Scanner(System.in);
        String input;
        input = str.nextLine();
        calc(input);

    }
}

