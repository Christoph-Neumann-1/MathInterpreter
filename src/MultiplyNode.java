public class MultiplyNode implements INode {
    INode lhs, rhs;

    @Override
    public double eval() {
        return lhs.eval() * rhs.eval();
    }

    MultiplyNode(INode lhs, INode rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }
}
