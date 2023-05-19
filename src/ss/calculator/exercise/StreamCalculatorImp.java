package ss.calculator.exercise;

import ss.calculator.DivideByZeroException;
import ss.calculator.StackEmptyException;
import ss.calculator.StreamCalculator;

import java.io.Reader;
import java.io.Writer;
import java.io.*;

public class StreamCalculatorImp implements StreamCalculator {

    CalculatorImp calc;

    public StreamCalculatorImp(CalculatorImp calculatorImp) {
        this.calc = calculatorImp;
    }

    public void processLine(String text) {

    }

    @Override
    public void process(Reader input, Writer output) {

        try (BufferedReader br = new BufferedReader(input); PrintWriter pw = new PrintWriter(output)) {

            while (br.readLine() != null) {

                String[] split = br.readLine().split("\\s+");
                String command = split[0];
                String val = null;

                if (split.length > 1) {
                    val = split[1];
                }

                while (calc.stack.size() >= 2) {
                    try {
                        switch (command) {
                            case "push":
                                if (val != null) {
                                    double value = Double.parseDouble(val);
                                    calc.push(value);
                                }
                            case "pop":
                                calc.pop();
                            case "add":
                                calc.add();
                            case "sub":
                                calc.sub();
                            case "mult":
                                calc.mult();
                            case "div":
                                calc.div();
                            case "mod":
                                calc.mod();
                            case "dup":
                                calc.dup();
                            default:
                                pw.println("error: invalid command or input");
                        }
                    } catch (DivideByZeroException | StackEmptyException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            if (br.readLine() == null) {
                pw.println("error: there is no more input from the reader.");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
