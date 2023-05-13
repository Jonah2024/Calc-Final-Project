import java.util.*;

//to evalutae, convert string to number vaules of characters, use a large switch statement to step through each thing
//make the function recursive, so that if it encounters addition or parenthesis it evaluates thos before combining
// 2x + (x + 1) -> 2 -> x => multiply 2 and x -> + => call function again at (index 2 and how many characters left)
// -> ( => call function again at (index 1) -> x -> + => call function again(index 2) etc etc
//merges them all on the way back down.

public class SimpleGraph{

    private String equation;

    public SimpleGraph(){}

    public SimpleGraph(String eq){
        equation = eq;
    }


//26 = 2 -> 6 => 2 * 10 + 6 -> next value
//two digit number AB = A -> B -> A * 10 + B = AB
    public int Calculate(int x){
        int y = 0;

        for (int i = 0; i < equation.length(); i ++){
            switch(equation.charAt(i)){
                //space
                case 32: 
                break;

                //0
                case 48:
                break;

                //1
                case 49:
                break;

                //2
                case 50:
                break;

                //3
                case 51:
                break;

                //4
                case 52:
                break;

                //5
                case 53:
                break;

                //6
                case 54:
                break;

                //7
                case 55:
                break;

                //8
                case 56:
                break;

                //9
                case 57:
                break;

                // +
                case 43:
                break;

                // -
                case 45:
                break;

                // *
                case 46:
                break;

                // /
                case 47:
                break;

                // (
                case 40:
                break;

                // )
                case 41:
                break;

                // ^
                case 94:
                break;

                // x 
                case 120:
                break;

                // s
                case 115:
                break;

                // i
                case 105:
                break;

                // n
                case 110:
                break;

                // c
                case 99:
                break;

                // o
                case 111:
                break;

                // t
                case 116:
                break;

                // a
                case 97:
                break;

                //e
                case 101:
                break;

                //l
                case 108:
                break;


            }
        }


        return y;
    }

}