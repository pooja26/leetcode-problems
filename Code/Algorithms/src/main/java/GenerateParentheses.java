import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list,"",0,0,n);
        return list;
    }
    public void backtrack(List<String> list,String s,int open,int closed,int max) {
        if(s.length()==max*2) {
            list.add(s);
            return;
        }
        if(open<max) {
            backtrack(list,s+"(",open+1,closed,max);
        }
        if(closed<open) {
            backtrack(list,s+")",open,closed+1,max);
        }

    }

    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        List<String> list = g.generateParenthesis(2);
        for(String s:list) {
            System.out.println(s);
        }
    }
}
