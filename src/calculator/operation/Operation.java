package calculator.operation;

public abstract class Operation {

    protected static final String numberRegex = "\\-?[0-9]+(\\.[0-9]+)?(e[+-]?[0-9]+)?";

    abstract public double applyTo(double leftOperand, double rightOperand);

    abstract public String toString();

    abstract public String getSignatureRegex();

    abstract public String getOperatorRegex();
}
