package calculator;

public class MathExpression {
    private double leftOperand;
    private double rightOperand;
    private Operator operator;

    public MathExpression(double leftOperand, double rightOperand, Operator operator) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
    }

    public double evaluate() {
        return operator.applyTo(leftOperand, rightOperand);
    }
}
