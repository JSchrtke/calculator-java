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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getOperatorRegex() {
        // TODO Auto-generated method stub
        return null;
    }

}
