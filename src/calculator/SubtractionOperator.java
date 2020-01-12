package calculator;

public class SubtractionOperator extends Operator {

    @Override
    public double applyTo(double leftOperand, double rightOperand) {
        return leftOperand - rightOperand;
    }

    @Override
    public String toString() {
        return "-";
    }

}
