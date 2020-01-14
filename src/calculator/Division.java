package calculator;

public class Division extends Operation {

    @Override
    public double applyTo(double leftOperand, double rightOperand) {
        return leftOperand / rightOperand;
    }

    @Override
    public String toString() {
        return "/";
    }

}
