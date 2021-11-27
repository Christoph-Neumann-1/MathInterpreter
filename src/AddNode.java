public class AddNode implements INode {
    INode lhs, rhs;

    @Override
    public double eval() {
        return lhs.eval() + rhs.eval();
    }

    AddNode(INode lhs, INode rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }
}
