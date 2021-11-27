import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var s=new Scanner(System.in);
        while (true)
        {
            var input=s.nextLine();
            if(input.equals(""))
                return;
            System.out.println(new Parser(input).generateTree().eval());
        }
    }
}
