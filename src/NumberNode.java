public class NumberNode implements INode {
    private double value;

    @Override
    public double eval() {
        return value;
    }

    NumberNode(double value) {
        this.value = value;
    }
}
