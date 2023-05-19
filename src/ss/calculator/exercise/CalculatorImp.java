package ss.calculator.exercise;

import ss.calculator.Calculator;
import ss.calculator.DivideByZeroException;
import ss.calculator.StackEmptyException;

import java.util.Stack;

public class CalculatorImp implements Calculator {

    Stack<Double> stack;

    public CalculatorImp() {
        stack = new Stack();
    }

    public void push(double value) {
        stack.push(value);
    }

    public double pop() throws StackEmptyException {
        if (stack.isEmpty()) {
            throw new StackEmptyException("the stack is empty");
        }
        return stack.pop();
    }

    public void add() throws StackEmptyException {
        if (stack.isEmpty()) {
            throw new StackEmptyException("the stack is empty");
        }
        double val1 = stack.pop();
        double val2 = stack.pop();
        double result = val1 + val2;
        stack.push(result);
    }

    public void sub() throws StackEmptyException {
        if (stack.isEmpty() || stack.size() < 2) {
            throw new StackEmptyException("the stack is empty");
        }
        double val1 = stack.pop();
        double val2 = stack.pop();
        double result = val2 - val1;
        stack.push(result);
    }

    public void mult() throws StackEmptyException {
        if (stack.isEmpty() || stack.size() < 2) {
            throw new StackEmptyException("the stack is empty");
        }
        double val1 = stack.pop();
        double val2 = stack.pop();
        double result = val2 * val1;
        stack.push(result);
    }

    public void div() throws DivideByZeroException, StackEmptyException {
        if (stack.isEmpty() || stack.size() < 2) {
            throw new StackEmptyException("the stack is empty");
        }

        double val1 = stack.pop();
        double val2 = stack.pop();

        if (val1 == 0) {
            stack.push(Double.NaN);
            throw new DivideByZeroException("we cant divide by zero");
        }

        double result = val2 / val1;
        stack.push(result);
    }

    public void mod() throws DivideByZeroException, StackEmptyException {
        if (stack.isEmpty() || stack.size() < 2) {
            throw new StackEmptyException("the stack is empty");
        }

        double val1 = stack.pop();
        double val2 = stack.pop();

        if (val1 == 0) {
            stack.push(Double.NaN);
            throw new DivideByZeroException("we cant divide by zero");
        }

        double result = val2 % val1;
        stack.push(result);
    }

    public void dup() throws StackEmptyException {
        if (stack.isEmpty()) {
            throw new StackEmptyException("the stack is empty");
        }
        double val = stack.lastElement();
        stack.push(val);
    }

}