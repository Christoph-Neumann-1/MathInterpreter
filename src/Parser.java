import java.awt.image.SinglePixelPackedSampleModel;

public class Parser {
    int position = 0;
    String input;

    Parser(String input) {
        input = input.replaceAll("\\s", "");
        this.input = input;
    }

    public INode generateTree() {
        return parseExpr();
    }

    private INode parseExpr() {
        var node = parseTerm();
        while (true) {
            char c = position < input.length() ? input.charAt(position) : '\0';
            if (c == '+') {
                ++position;
                var rhs = parseTerm();
                node = new AddNode(node, rhs);
            } else if (c == '-') {
                ++position;
                var rhs = parseTerm();
                node = new SubtractNode(node, rhs);
            } else {
                return node;
            }
        }
    }

    private INode parseTerm() {
        var node = parseFactor();
        while (true) {
            char c = position < input.length() ? input.charAt(position) : '\0';
            if (c == '/') {
                ++position;
                var rhs = parseFactor();
                node = new DivideNode(node, rhs);
            } else if (c == '*') {
                ++position;
                var rhs = parseFactor();
                node = new MultiplyNode(node, rhs);
            } else {
                return node;
            }
        }
    }

    private INode parseFactor() {
        var c = input.charAt(position);
        if (c == '(') {
            ++position;
            var node = parseExpr();
            return input.charAt(position++) == ')' ? node : null;
        }
        if (c >= '0' && c <= '9') {
            boolean dotFound = false;
            var start = position;
            while (true) {
                c = ++position < input.length() ? input.charAt(position) : '\0';
                if (c == '.') {
                    if (dotFound)
                        return null;
                    dotFound = true;
                    continue;
                }
                if (c >= '0' && c <= '9')
                    continue;
                return new NumberNode(dotFound ? Double.parseDouble(input.substring(start, position)) : Long.parseLong(input.substring(start, position)));
            }
        }
        return null;
    }

}
