import java.util.Stack;

public class Evalpostfix {

    public static int PostFix(String expression) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                int b = stack.pop();
                int a = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(PostFix("231*+9-"));
    }
}