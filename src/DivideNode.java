public class DivideNode implements INode {
    INode lhs, rhs;

    @Override
    public double eval() {
        return lhs.eval() / rhs.eval();
    }

    DivideNode(INode lhs, INode rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }
}
