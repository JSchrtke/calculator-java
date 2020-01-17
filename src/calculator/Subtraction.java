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

    @Override
    public String getSignatureRegex() {
        return "([0-9]+(\\.[0-9])*\\s*\\-\\s*[0-9]+\\.*[0-9]*)";
    }

    @Override
    public String getOperatorRegex() {
        return "\\-";
    }

}
