package AV.AV4.Calculator;

import java.util.Scanner;

public class Calculator {
    public static final char[] OPERATIONS={'+','-','*','/'};
    public static final char[] TERMINATE={'R','r'};
    private double result;

    public Calculator() {
        this.result = 0;
    }

    @Override
    public String toString() {
        return String.format("Result: %.02f",result);
    }

    public void init(){
        System.out.println("Result: 0.0");
    }
    public static boolean contains(char[] list,char elem){
        for(char x:list){
            if(x == elem){
                return true;
            }
        }
        return false;
    }
    public void operation(char o,double value) throws  DivisionByZeroException {
        if(o == OPERATIONS[0]){ // +
            this.result+=value;

        } else if (o == OPERATIONS[1]) { // -
            this.result-=value;
        }
        else if (o == OPERATIONS[2]) { // *
            this.result*=value;
        }
        else if (o == OPERATIONS[3]) { // /
            if (value == 0){
                throw new DivisionByZeroException("/ by 0");
            }else {
                this.result/=value;
            }

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator=new Calculator();
        calculator.init();
        while (true) {
            String line=scanner.nextLine();
            char operation=line.charAt(0);
            if(contains(OPERATIONS,operation)){
                double value=Double.parseDouble(line.split("\\s+")[1]);
                try{
                    calculator.operation(operation,value);
                }catch (Exception e){
                    System.err.println(e.getMessage());
                }
            }
            System.out.println(calculator);
            if(contains(TERMINATE,operation)){
                System.out.println("Are you sure (y/n)");
                String s= scanner.nextLine();
                if (Character.toLowerCase(s.charAt(0)) =='y'){
                    break;
                }
            }
        }
    }

    private class UnknownOperationException extends Exception {
        UnknownOperationException(String message){
            super(message);
        }
    }

    private class DivisionByZeroException extends Exception {
        public DivisionByZeroException(String message) {
            super(message);
        }
    }
}
