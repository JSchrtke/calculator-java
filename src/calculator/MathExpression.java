package calculator;

public class MathExpression {
    private double leftOperand;
    private double rightOperand;
    private Operation operation;

    public MathExpression(double leftOperand, double rightOperand, Operation operation) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operation = operation;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s %.2f = %.2f", leftOperand, operation.toString(), rightOperand, this.evaluate());
    }

    private double evaluate() throws ArithmeticException {
        return operation.applyTo(leftOperand, rightOperand);
    }

    public double getResult() {
        return this.evaluate();
    }
}
