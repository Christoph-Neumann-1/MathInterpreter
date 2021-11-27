public class SubtractNode implements INode {
    INode lhs, rhs;

    @Override
    public double eval() {
        return lhs.eval() - rhs.eval();
    }

    SubtractNode(INode lhs, INode rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }
}
