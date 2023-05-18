import java.util.*;
import java.math.*;

//TODO
//FIX SYNTAX - CHECK EVERY NUMBER FOR IF AN EXPONENT FOLLOWS IT
// 12xe^2 = 12x * e^2
//!!!!!!!!

//make -x work as intended
//make the 1st term check work if it starts with sin
//incorporate ln functions in normal runnnings

//to evalutae, convert string to number vaules of characters, use a large switch statement to step through each thing
//make the function recursive, so that if it encounters addition or parenthesis it evaluates thos before combining
// 2x + (x + 1) -> 2 -> x => multiply 2 and x -> + => call function again at (index 2 and how many characters left)
// -> ( => call function again at (index 1) -> x -> + => call function again(index 2) etc etc
//merges them all on the way back down.

public class SimpleGraph{

    private String originalEquation;

    public SimpleGraph(){}

    public SimpleGraph(String eq){
        originalEquation = eq;
    }

    public void setEquation(String eq){
        originalEquation = eq;
    }


//26 = 2 -> 6 => 2 * 10 + 6 -> next value
//two digit number AB = A -> B -> A * 10 + B = AB

//make a switch statement for 1st term and set currentValue to it

//breakStatment is used for multiplication, and limits the recursion to one term if it is 1, and if it is two, it only stops for a space(used for exponents)

//returns two numbers -> [y, moves] which is the value, and how many characters it has gone through
    public double[] Calculate(double x, String equation, int breakStatement){
        double y = 0, currentValue = 0;
        int move = 0;
        double[] calcResults = new double[2];
        

        for (int i = 0; i < equation.length(); i ++){
            
            if (i == 0){
                move ++;
                switch(equation.charAt(i)){
                    //space
                    case 32: 
                    //does nothing
                    break;
    
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
                    System.out.print("First (0th) symbol was a plus?");
                    break;
    
                    // -
                    case 45:
                    
                    switch(equation.charAt(i + 1)){
                        //space
                        case 32: 
                        //does nothing
                        break;
        
                        //0
                        case 48:
                        currentValue = 0;
                        i ++;
                        break;
        
                        //1
                        case 49:
                        currentValue = -1;
                        i ++;
                        break;
        
                        //2
                        case 50:
                        currentValue = -2;
                        i ++;
                        break;
        
                        //3
                        case 51:
                        currentValue = -3;
                        i ++;
                        break;
        
                        //4
                        case 52:
                        currentValue = -4;
                        i ++;
                        break;
        
                        //5
                        case 53:
                        currentValue = -5;
                        i ++;
                        break;
        
                        //6
                        case 54:
                        currentValue = -6;
                        i ++;
                        break;
        
                        //7
                        case 55:
                        currentValue = -7;
                        i ++;
                        break;
        
                        //8
                        case 56:
                        currentValue = -8;
                        i ++;
                        break;
        
                        //9
                        case 57:
                        currentValue = -9;
                        i ++;
                        break;

                        // x 
                        case 120:
                        currentValue = -x;
                        i ++;
                        break;

                    }

                    break;
    
                    // *
                    case 46:
                    System.out.print("First (0th) symbol was a multiply?");
                    break;
    
                    // /
                    case 47:
                    System.out.print("First (0th) symbol was a divide?");
                    break;
    
                    // (
                    case 40:
                    calcResults = Calculate(x, equation.substring(i + 1, equation.length()), 0);
                    //System.out.println("CalcResults: " + calcResults[1]);
                    if (currentValue == 0) currentValue = 1;
                    currentValue = currentValue * calcResults[1];
                    //System.out.println("CurrentValue: " + currentValue);
                    i = (int) (i + calcResults[0]);
                    break;
    
                    // )
                    case 41:
                    break;
    
                    // ^
                    case 94:
                    System.out.print("First (0th) symbol was a exponent sign?");
                    break;
    
                    // x 
                    case 120:
                    currentValue = x;
                    //System.out.print("Current X Value: " + currentValue);
                    break;
    
                    // s
                    case 115:
                    if (equation.charAt(i + 1) == 105 && equation.charAt(i + 2) == 110){
                        calcResults = Calculate(x, equation.substring(i + 2, equation.length()), 1);
                        currentValue = currentValue * Math.sin(calcResults[1]); 
                        //System.out.println("(" + currentValue * Math.sin(calcResults[1]) + ")");
                        //System.out.println(" " + calcResults[1]);
                        i = (int) (i + calcResults[0]);
                    }
                    break;
    
                    // i
                    case 105:
                    break;
    
                    // n
                    case 110:
                    break;
    
                    // c
                    case 99:
                    if (equation.charAt(i + 1) == 111 && equation.charAt(i + 2) == 115){
                        calcResults = Calculate(x, equation.substring(i + 1, equation.length()), 1);
                        currentValue = currentValue * Math.cos(calcResults[1]);
                        i = (int) (i + calcResults[0]);
                    }
                    break;
    
                    // o
                    case 111:
                    break;
    
                    // t
                    case 116:
                    if (equation.charAt(i + 1) == 97 && equation.charAt(i + 2) == 110){
                        calcResults = Calculate(x, equation.substring(i + 1, equation.length()), 1);
                        currentValue = currentValue * Math.tan(calcResults[1]);
                        i = (int) (i + calcResults[0]);
                    }
                    break;
    
                    // a
                    case 97:
                    break;
    
                    //e
                    case 101:
                    currentValue = currentValue + Math.E;
                    break;
    
                    //l
                    case 108:
                    if (equation.charAt(i + 1) == 110){
                        currentValue = currentValue * Math.log(Calculate(x, equation.substring(i + 1,equation.length()), 1)[1]);
                    }
                    break;
    
            }
            
        }
        else {
            switch(equation.charAt(i)){
                //space
                case 32: 
                if (breakStatement == 2){
                    i = equation.length();
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
                calcResults = Calculate(x, equation.substring(i + 1, equation.length()), 0);
                currentValue = currentValue + calcResults[1];
                i = (int) (i + calcResults[0]);
                break;

                // -
                case 45:
                if (breakStatement == 1){
                    i = equation.length();
                }
                calcResults = Calculate(x, equation.substring(i + 1, equation.length()), 0);
                currentValue = currentValue - calcResults[1];
                i = (int) (i + calcResults[0]);
                break;
                
                // *
                case 46:
                if (breakStatement == 1){
                    i = equation.length();
                }
                calcResults = Calculate(x, equation.substring(i + 1, equation.length()), 1);
                currentValue = currentValue * calcResults[1];
                i = (int) (i + calcResults[0]);
                break;

                // /
                case 47:
                if (breakStatement == 1){
                    i = equation.length();
                }
                else {
                calcResults = Calculate(x, equation.substring(i + 1, equation.length()), 1);
                currentValue = currentValue / calcResults[1];
                i = (int) (i + calcResults[0]);
                }
                break;

                // (
                case 40:
                if (breakStatement == 1){
                    i = equation.length();
                }
                else {
                calcResults = Calculate(x, equation.substring(i + 1, equation.length()), 0);
                if (currentValue == 0) currentValue = 1;
                currentValue = currentValue * calcResults[1];
                i = (int) (i + calcResults[0]);
                }
                break;

                // )
                case 41:
                i = equation.length();
                break;

                // ^
                case 94:
                if (breakStatement == 1){
                    i = equation.length();
                }
                else {
                    calcResults = Calculate(x, equation.substring(i + 1, equation.length()), 2);
                    //System.out.print("Exponent: " + calcResults[1] + " -- CurrentValue: " + currentValue);
                    currentValue = Math.pow(currentValue, calcResults[1]);
                    //System.out.println(" -- Output: " + currentValue);
                    i = (int) (i + calcResults[0]);
                }
                break;

                // x 
                case 120:
                currentValue = currentValue * x;
                break;

                // s
                case 115:
                if (breakStatement == 1){
                    i = equation.length();
                }
                else if (equation.charAt(i + 1) == 105 && equation.charAt(i + 2) == 110){
                    calcResults = Calculate(x, equation.substring(i + 1, equation.length()), 1);
                    currentValue = currentValue * Math.sin(calcResults[1]);
                    i = (int) (i + calcResults[0]);
                }
                break;

                // i
                case 105:
                //does nothing
                break;

                // n
                case 110:
                //does nothing
                break;

                // c
                case 99:
                if (breakStatement == 1){
                    i = equation.length();
                }
                else if (equation.charAt(i + 1) == 111 && equation.charAt(i + 2) == 115){
                    calcResults = Calculate(x, equation.substring(i + 1, equation.length()), 1);
                    currentValue = currentValue * Math.cos(calcResults[1]);
                    i = (int) (i + calcResults[0]);
                }
                break;

                // o
                case 111:
                //does nothing
                break;

                // t
                case 116:
                if (breakStatement == 1){
                    i = equation.length();
                }
                else if (equation.charAt(i + 1) == 97 && equation.charAt(i + 2) == 110){
                    calcResults = Calculate(x, equation.substring(i + 1, equation.length()), 1);
                    currentValue = currentValue * Math.tan(calcResults[1]);
                    i = (int) (i + calcResults[0]);
                }
                break;

                // a
                case 97:
                //does nothing
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
                    currentValue = currentValue * Math.log(Calculate(x, equation.substring(i + 1,equation.length()), 1)[1]);
                }
                break;


            }
            move ++;
        }
    }

        calcResults[1] = currentValue;
        calcResults[0] = move + 1;
        return calcResults;
    }

}
