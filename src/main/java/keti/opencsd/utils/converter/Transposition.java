package keti.opencsd.utils.converter;

import keti.opencsd.config.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transposition {
    private String leftValue;
    private List<String> forTrans;
    private String operator;
    private List<String> rightValue;
    private List<String> resultList;

    public Transposition(String LV,String OP,String RV){
        String[] lvSplit = LV.split(" ");
        this.leftValue = lvSplit[0];
        this.forTrans = new ArrayList<>(Arrays.asList(lvSplit).subList(1, lvSplit.length));
        this.operator = OP;
        this.rightValue = new ArrayList<>(Arrays.asList(RV.split(" ")));
        this.resultList = new ArrayList<>();
    }

    private String operatorTrans(String op){
        switch (op){
            case "+":
                return "-";
            case "-":
                return "+";
            case "*":
                return "/";
            case "/":
                return "*";
        }
        return "";
    }
    private List<Object> integerConvert(){
        List<Object> result = new ArrayList<>();
        for (String s : this.resultList) {
            try {
                result.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                result.add(s);
            }
        }
        return result;
    }

    public List<Object> TranspositionStart(){
        String tranOp = operatorTrans(this.forTrans.get(0));
        this.rightValue.add(tranOp);
        this.rightValue.add("(");

        this.forTrans.remove(0);
        this.rightValue.addAll(this.forTrans);

        this.rightValue.add(")");
        String rightFormula = String.join(" ", this.rightValue);
        List<Object> newRV = new Infix2Postfix().Build()
                .setExpression(rightFormula)
                .Convert2List();


        this.resultList.add(this.leftValue);
        this.resultList.add(this.operator);
        List<Object> result = new ArrayList<>(integerConvert());
        result.addAll(newRV);


        return result;

    }
}
