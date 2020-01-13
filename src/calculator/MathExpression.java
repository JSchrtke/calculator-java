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

    // 2 + 3 * 5
    public static MathExpression fromString(String mathExpressionString) {
        mathExpressionString.split('')
        return new MathExpression(2, MathExpression.fromString("3 * 5").evaluate(), new AdditionOperator());
    }

    public double evaluate() throws ArithmeticException {
        return operator.applyTo(leftOperand, rightOperand);
    }
}
