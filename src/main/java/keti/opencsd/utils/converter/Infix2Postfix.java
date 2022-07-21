package keti.opencsd.utils.converter;

import keti.opencsd.KetiParser;
import keti.opencsd.config.Config;
import org.apache.commons.collections.ArrayStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Infix2Postfix {
    private static final char ADD = '+', SUBTRACT = '-';
    private static final char MULTIPLY = '*', DIVIDE = '/';
    private static final char POWER ='^';
    private String infix;
    //private StringBuilder postfix;
    private List<Object> postfixList;
    public Infix2Postfix(){
        this.postfixList = new ArrayList<>();
    }
    public Infix2Postfix(Config.AggregationFunc aggregateFunc){
        this.postfixList = new ArrayList<>();
        this.postfixList.add(aggregateFunc.getValue());
    }
    public Infix2Postfix Build(){
        return this;
    }
    private boolean isOperator(char c) { // Tell whether c is an operator.
        return c == '+'  ||  c == '-'  ||  c == '*'  ||  c == '/'  ||  c == '^'
                || c=='(' || c==')';
    }

    private boolean isSpace(char c) {
        return (c == ' ');
    }

    private boolean lowerPrecedence(char op1, char op2) {
        switch (op1) {
            case '+':
            case '-':
                return !(op2=='+' || op2=='-') ;
            case '*':
            case '/':
                return op2=='^' || op2=='(';
            case '^':
                return op2=='(';
            case '(': return true;
            default:
                return false;
        }
    }
//    public String Convert2String() {
//        Stack operatorStack = new Stack();
//        char c;
//        StringTokenizer parser = new StringTokenizer(infix,"+-*/^() ",true);
//        postfix = new StringBuilder(infix.length());
//        while (parser.hasMoreTokens()) {
//            String token = parser.nextToken();
//            c = token.charAt(0);
//            if ( (token.length() == 1) && isOperator(c) ) {
//                while (!operatorStack.empty() &&
//                        !lowerPrecedence(((String)operatorStack.peek()).charAt(0), c)) {
//                    postfix.append(" ").append((String) operatorStack.pop());
//                }
//                if (c==')') {
//                    String operator = (String)operatorStack.pop();
//                    while (operator.charAt(0)!='(') {
//                        postfix.append(" ").append(operator);
//                        operator = (String)operatorStack.pop();
//                    }
//                }
//                else
//                    operatorStack.push(token);
//            }
//            else if ( (token.length() == 1) && isSpace(c) ) {
//            }
//            else {
//                postfix.append(" ").append(token);
//            }
//        }
//        while (!operatorStack.empty()) {
//            postfix.append(" ").append((String) operatorStack.pop());
//        }
//        return postfix.toString();
//    }
    public List<Object> Convert2List() {
        Stack operatorStack = new Stack();
        char c;
        StringTokenizer parser = new StringTokenizer(infix,"+-*/^() ",true);
        while (parser.hasMoreTokens()) {
            String token = parser.nextToken();
            c = token.charAt(0);
            if ( (token.length() == 1) && isOperator(c) ) {
                while (!operatorStack.empty() &&
                        !lowerPrecedence(((String)operatorStack.peek()).charAt(0), c)) {
                    postfixList.add((String) operatorStack.pop());
                }
                if (c==')') {
                    String operator = (String)operatorStack.pop();
                    while (operator.charAt(0)!='(') {
                        postfixList.add(operator);
                        operator = (String)operatorStack.pop();
                    }
                }
                else
                    operatorStack.push(token);
            }
            else if ( (token.length() == 1) && isSpace(c) ) {
            }
            else {
                try {
                    postfixList.add(Integer.parseInt(token));
                }catch (NumberFormatException e){
                    postfixList.add(token);
                }
            }
        }
        while (!operatorStack.empty()) {
            postfixList.add((String) operatorStack.pop());
        }
        return postfixList;
    }
    public Infix2Postfix setExpression(String formula){
        formula = formula.toLowerCase();
        this.infix = formula;
        return this;
    }

}
