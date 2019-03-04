
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        char[] ch = s.toCharArray();
        if(!isValidString(s))  return false;

        Stack<Character> st = new Stack<>();
        for(int i=0;i<ch.length;i++) {
            if(ch[i] == '(' || ch[i] == '{' || ch[i] == '[') {
                st.push(ch[i]);
            } else if(!st.isEmpty()) {
                if(ch[i] == ')' && st.peek()=='(' || ch[i] == '}' && st.peek()=='{'|| ch[i] == ']' && st.peek()=='[') {
                    if(!st.isEmpty()) {
                        st.pop();
                    }
                }
            }
        }
        return st.isEmpty();
    }
    public boolean isValidString(String s) {
        char[] ch = s.toCharArray();
        if(s.length()==0) return false;
        if(s.length()%2!=0) return false;
        if(ch[0]=='}'||ch[0]==']'||ch[0]==')') return false;
        return true;
    }

    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid("(])"));

    }
}
