package calculator;

public class Subtraction extends Operation {

    @Override
    public double applyTo(double leftOperand, double rightOperand) {
        return leftOperand - rightOperand;
    }

    @Override
    public String toString() {
        return "-";
    }

}
