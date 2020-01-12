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

    @Override
    public String toString() {
        return String.format("%.2f %s %.2f = %.2f", leftOperand, operator.toString(), rightOperand, this.evaluate());
    }

    private double evaluate() throws ArithmeticException {
        return operator.applyTo(leftOperand, rightOperand);
    }

    public double getResult() {
        return this.evaluate();
    }
}
