import java.util.Stack;

public class Balance {
  public static boolean balanceParanthesesis(String str){

    Stack<Character> stack= new Stack<>();
    for(char ch : str.toCharArray()){
        if(ch == '(' || ch =='{' || ch=='['){
            stack.push(ch);
        }else{
            if(stack.isEmpty()) return false;
            if(ch=='}'){
                if(stack.peek()=='{'){
                    stack.pop();
                }else return false;
            }
             else if(ch==')'){
                if(stack.peek()=='('){
                    stack.pop();
                }
                else return false;
            }
                else if (ch==']'){
                if(stack.peek()=='['){
                    stack.pop();
                }else return false;
            }
            
        }
    }

    return stack.isEmpty();


  }
    public static void main (String[] args) {

        System.out.println(balanceParanthesesis("{[]}()"));
        System.out.println(balanceParanthesesis("{[]}{)"));
        System.out.println(balanceParanthesesis("}}}}}}"));

    }
    
}
