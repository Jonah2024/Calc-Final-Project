import java.util.*;
import java.math.*;

public class SimpleGraph{

    private String originalEquation;

    public SimpleGraph(){}

    public SimpleGraph(String eq){
        originalEquation = eq;
    }

    public void setEquation(String eq){
        originalEquation = eq;
    }

//  breakStatement = 0 -> go through whole equation => used in initial call
//  breakStatement = 1 -> stops for addition / sutraction => used for multiplication
//  breakStatement = 2 -> stops for spaces only => used for most functions == sin cos tan division ln ^
//  breakStatement = 3 -> stops only for ( or ) => used for parenthesis and enables nested parenthesis

//returns two numbers -> [y, moves] => y is the value, moves is how many characters it has parsed through during the call
    public double[] Calculate(double x, String equation, int breakStatement){
        double currentValue = 0;
        int move = 0;
        double[] calcResults = new double[2];
        
        //parses through the equation, doing specific actions depending on the character
        for (int i = 0; i < equation.length(); i ++){
            
            //first term checks
            if (i == 0){
                move ++;
                switch(equation.charAt(i)){
    
                    //0
                    case 48:
                    currentValue = 0;
                    break;
    
                    //1
                    case 49:
                    currentValue = 1;
                    break;
    
                    //2
                    case 50:
                    currentValue = 2;
                    break;
    
                    //3
                    case 51:
                    currentValue = 3;
                    break;
    
                    //4
                    case 52:
                    currentValue = 4;
                    break;
    
                    //5
                    case 53:
                    currentValue = 5;
                    break;
    
                    //6
                    case 54:
                    currentValue = 6;
                    break;
    
                    //7
                    case 55:
                    currentValue = 7;
                    break;
    
                    //8
                    case 56:
                    currentValue = 8;
                    break;
    
                    //9
                    case 57:
                    currentValue = 9;
                    break;

                    // +
                    case 43:
                    if (breakStatement == 1){
                        i = equation.length();
                    }
                    calcResults = Calculate(x, equation.substring(i + 1, equation.length()), 1);
                    currentValue = currentValue + calcResults[1];
                    i = (int) (i + calcResults[0] + 1);
                    move += calcResults[0] + 1;
                    break;
    
                    // -
                    case 45:
                    calcResults = Calculate(x, equation.substring(i + 1, equation.length()), 2);
                    currentValue = -1 * calcResults[1];
                    i = (int) (i + calcResults[0] + 1);
                    move += calcResults[0] + 1;
                    break;
    
                    // (
                    case 40:
                    calcResults = Calculate(x, equation.substring(i + 1, equation.length()), 3);
                    currentValue = 1;
                    currentValue = currentValue * calcResults[1];
                    i = (int) (i + calcResults[0] + 1);
                    move += calcResults[0] + 1;
                    break;
    
                    // x 
                    case 120:
                    currentValue = x;
                    break;
    
                    // s
                    case 115:
                    if (equation.charAt(i + 1) == 105 && equation.charAt(i + 2) == 110){
                        currentValue = 1;
                        calcResults = Calculate(x, equation.substring(i + 3, equation.length()), 2);
                        currentValue = currentValue * Math.sin(calcResults[1]); 
                        i = (int) (i + calcResults[0] + 3);
                        move += calcResults[0] + 3;
                    }
                    break;

                    // c
                    case 99:
                    if (equation.charAt(i + 1) == 111 && equation.charAt(i + 2) == 115){
                        currentValue = 1;
                        calcResults = Calculate(x, equation.substring(i + 3, equation.length()), 2);
                        currentValue = currentValue * Math.cos(calcResults[1]);
                        i = (int) (i + calcResults[0] + 3);
                        move += calcResults[0] + 3;
                    }
                    break;
    
                    // t
                    case 116:
                    if (equation.charAt(i + 1) == 97 && equation.charAt(i + 2) == 110){
                        currentValue = 1;
                        calcResults = Calculate(x, equation.substring(i + 3, equation.length()), 2);
                        currentValue = currentValue * Math.tan(calcResults[1]);
                        i = (int) (i + calcResults[0] + 3);
                        move += calcResults[0] + 3;
                    }
                    break;
    
                    //e
                    case 101:
                    currentValue = currentValue + Math.E;
                    break;
    
                    //l
                    case 108:
                    if (equation.charAt(i + 1) == 110){
                        currentValue = 1;
                        currentValue = currentValue * Math.log(Calculate(x, equation.substring(i + 2,equation.length()), 2)[1]);
                        i = (int) (i + calcResults[0] + 2);
                        move += calcResults[0] + 2;
                    }
                    break;
            }
        }
        //functions for if a new recursion was not just called - continuing off of the last character
        else {
            move++;
            switch(equation.charAt(i)){
                //space
                case 32: 
                if (breakStatement == 2){
                    i = equation.length();
                    move --;
                }
                break;

                //0
                case 48:
                currentValue = currentValue * 10 + 0;
                break;

                //1
                case 49:
                currentValue = currentValue * 10 + 1;
                break;

                //2
                case 50:
                currentValue = currentValue * 10 + 2;
                break;

                //3
                case 51:
                currentValue = currentValue * 10 + 3;
                break;

                //4
                case 52:
                currentValue = currentValue * 10 + 4;
                break;

                //5
                case 53:
                currentValue = currentValue * 10 + 5;
                break;

                //6
                case 54:
                currentValue = currentValue * 10 + 6;
                break;

                //7
                case 55:
                currentValue = currentValue * 10 + 7;
                break;

                //8
                case 56:
                currentValue = currentValue * 10 + 8;
                break;

                //9
                case 57:
                currentValue = currentValue * 10 + 9;
                break;

                // +
                case 43:
                if (breakStatement == 1){
                    i = equation.length();
                }
                calcResults = Calculate(x, equation.substring(i + 1, equation.length()), 1);
                currentValue = currentValue + calcResults[1];
                i = (int) (i + calcResults[0] + 1);
                move += calcResults[0] + 1;
                break;

                // -
                case 45:
                if (breakStatement == 1){
                    i = equation.length();
                }
                calcResults = Calculate(x, equation.substring(i + 1, equation.length()), 1);
                currentValue = currentValue - calcResults[1];
                i = (int) (i + calcResults[0] + 1);
                move += calcResults[0] + 1;
                break;
                
                // *
                case 46:
                if (breakStatement == 1){
                    i = equation.length();
                }
                calcResults = Calculate(x, equation.substring(i + 1, equation.length()), 2);
                currentValue = currentValue * calcResults[1];
                i = (int) (i + calcResults[0] + 1);
                move += calcResults[0] + 1;
                break;

                // /
                case 47:
                if (breakStatement == 1){
                    i = equation.length();
                }
                else {
                calcResults = Calculate(x, equation.substring(i + 1, equation.length()), 2);
                currentValue = currentValue / calcResults[1];
                i = (int) (i + calcResults[0] + 1);
                move += calcResults[0] + 1;
                }
                break;

                // (
                case 40:
                if (breakStatement == 1){
                    i = equation.length();
                }
                else {
                calcResults = Calculate(x, equation.substring(i + 1, equation.length()), 3);
                if (currentValue == 0) currentValue = 1;
                currentValue = currentValue * calcResults[1];
                i = (int) (i + calcResults[0] + 1);
                move += calcResults[0] + 1;
                }
                break;

                // )
                case 41:
                i = equation.length();
                move --;
                break;

                // ^
                case 94:
                if (breakStatement == 1){
                    i = equation.length();
                }
                else {
                    calcResults = Calculate(x, equation.substring(i + 1, equation.length()), 2);
                    currentValue = Math.pow(currentValue, calcResults[1]);
                    i = (int) (i + calcResults[0] + 1);
                    move += calcResults[0] + 1;
                }
                break;

                // x 
                case 120:
                if (equation.charAt(i + 1) == 94){
                    calcResults = Calculate(x, equation.substring(i + 1, equation.length()), 2);
                    currentValue = currentValue * Math.pow(x, calcResults[1]);
                    i = (int) (i + calcResults[0] + 2);
                    move += calcResults[0] + 2;
                }
                else {
                    currentValue = currentValue * x;
                }
                break;

                // s
                case 115:
                if (breakStatement == 1){
                    i = equation.length();
                }
                else if (equation.charAt(i + 1) == 105 && equation.charAt(i + 2) == 110){
                    calcResults = Calculate(x, equation.substring(i + 3, equation.length()), 2);
                    currentValue = currentValue * Math.sin(calcResults[1]); 
                    i = (int) (i + calcResults[0] + 3);
                    move += calcResults[0] + 3;
                }
                break;

                // c
                case 99:
                if (breakStatement == 1){
                    i = equation.length();
                }
                else if (equation.charAt(i + 1) == 111 && equation.charAt(i + 2) == 115){
                    calcResults = Calculate(x, equation.substring(i + 3, equation.length()), 2);
                    currentValue = currentValue * Math.cos(calcResults[1]);
                    i = (int) (i + calcResults[0] + 3);
                    move += calcResults[0] + 3;
                }
                break;

                // t
                case 116:
                if (breakStatement == 1){
                    i = equation.length();
                }
                else if (equation.charAt(i + 1) == 97 && equation.charAt(i + 2) == 110){
                    calcResults = Calculate(x, equation.substring(i + 3, equation.length()), 2);
                    currentValue = currentValue * Math.tan(calcResults[1]);
                    i = (int) (i + calcResults[0] + 3);
                    move += calcResults[0] + 3;
                }
                break;

                //e
                case 101:
                currentValue = currentValue * Math.E;
                break;

                //l
                case 108:
                if (breakStatement == 1){
                    i = equation.length();
                }
                else if (equation.charAt(i + 1) == 110){
                    currentValue = currentValue * Math.log(Calculate(x, equation.substring(i + 2,equation.length()), 2)[1]);
                    i = (int) (i + calcResults[0] + 2);
                    move += calcResults[0] + 2;
                }
                break;
            }
            
        }
    }
        calcResults[1] = currentValue;
        calcResults[0] = move;
        return calcResults;
    }
}
