package calculator;

public abstract class Operation {

    abstract public double applyTo(double leftOperand, double rightOperand);

    abstract public String toString();

    abstract public String getSignatureRegex();

    abstract public String getOperatorRegex();
}
