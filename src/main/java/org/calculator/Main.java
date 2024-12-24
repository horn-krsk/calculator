package org.calculator;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        System.out.println("Введите арифметическое выражение с двумя целыми числами," +
                " каждое из которых не менее 1 и не более 10");
        String string = scanner.nextLine();
        System.out.println(calc(string));
    }
    public static String calc(String input) throws Exception {

        StringBuilder firstOperand =new StringBuilder();
        StringBuilder secondOperand =new StringBuilder();
        char operator=0;
        int result=0;
        char[] inputCharArray = input.toCharArray();

        for (char inputChar :inputCharArray){

            if(inputChar==' ') continue;
            if(Character.isDigit(inputChar)){

                if(operator==0) firstOperand.append(inputChar);
                else secondOperand.append(inputChar);
            }else{

                if(!firstOperand.isEmpty()){
                    if(operator==0) operator=inputChar;
                    else throw new Exception("В выражении должены быть только целые числа и один оператор");
                }
                else throw new Exception("Выражение должно начинаться с числа.");
            }
        }

        int firstOperandInt=Integer.parseInt(firstOperand.toString());
        int secondOperandInt=Integer.parseInt(secondOperand.toString());

        if(firstOperandInt<1 || firstOperandInt>10 || secondOperandInt<1 || secondOperandInt>10)
            throw new Exception("Числа не должны быть меньше 1 и больше 10");

	    result = switch (operator) {
		    case '+' -> firstOperandInt + secondOperandInt;
		    case '-' -> firstOperandInt - secondOperandInt;
		    case '*' -> firstOperandInt * secondOperandInt;
		    case '/' -> firstOperandInt / secondOperandInt;
		    default -> throw new Exception("в выражении могут использоваться только операторы: +, -, /, * ");
	    };
        return String.valueOf(result);
    }
}