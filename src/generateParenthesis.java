import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    public static void main(String[] args) {
        new Solution22().generateParenthesis(3);
    }
}

class Solution22 {
    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        backtrack(sb, n, 0, 0);
        return res;

    }

    public void backtrack(StringBuilder sb, int num, int left, int right) {
        if(sb.length() == 2 * num){
            res.add(sb.toString());
            return;
        }
        if(left < num){
            sb.append("(");
            backtrack(sb, num, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right < left){
            sb.append(")");
            backtrack(sb, num, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }




    }

}