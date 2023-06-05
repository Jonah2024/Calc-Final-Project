import java.util.*;
import java.math.*;

import org.apache.commons.math4.legacy.analysis.differentiation.*;

public class Derivitive{

    private String equation;

    public Derivitive(){}

    public Derivitive(String eq){
        equation = eq;
    }

    //takes in a string and creates the derivative structure for it
    //ideally this would be done via program instead of manually inputted derivatives
    public double derive(String eq, int order){

        equation = eq;

        //parameters = input values, order = how many times it can be derived, index = which variable to derive, value = x value for derivative
        DerivativeStructure x = new DerivativeStructure(1, order, 0, 0);
        DerivativeStructure y = x;

        if (equation.equals("sinx")){
            y = x.sin();
        }
        else if (equation.equals("cosx")){
            y = x.cos();
        }
        else if (equation.equals("tanx")){
            y = x.tan();
        }
        else if (equation.equals("(sinx)^2")){
            y = x.sin().pow(2);
        }
        else if (equation.equals("1/(1-x)")){
            y = x.createConstant(1).divide(x.createConstant(1).subtract(x));
        }
        else if (equation.equals("1/(1+x)")){
            y = x.createConstant(1).divide(x.createConstant(1).add(x));
        }
        else if (equation.equals("e^x")){
            y = x.createConstant(Math.E).pow(x);
        }
        else if (equation.equals("xsinx")){
            y = x.multiply(x.sin());
        }
        else {
            y = x;
        }
        
        return y.getPartialDerivative(order);
    }

}
