package ss.calculator.exercise;

import ss.calculator.Calculator;
import ss.calculator.CalculatorFactory;
import ss.calculator.CalculatorServer;
import ss.calculator.StreamCalculator;

import java.io.Reader;
import java.io.Writer;

public class FactoryImp implements CalculatorFactory {

    CalculatorImp calc;

    public CalculatorImp makeCalculator() {
        CalculatorImp calc = new CalculatorImp();
        return calc;
    }

    public StreamCalculatorImp makeStreamCalculator() {
        StreamCalculatorImp strcalc = new StreamCalculatorImp(makeCalculator());
        return strcalc;
    }

    public Runnable makeRunnableStreamCalculator(Reader reader, Writer writer) {
        return null;
    }

    public CalculatorServer makeCalculatorServer() {
        return null;
    }

}