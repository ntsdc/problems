import java.util.ArrayList;
import java.util.List;

public class letterCombinations {
    public static void main(String[] args) {
        new Solution17().letterCombinations("345");
    }
}
class Solution17 {
    // 数字到号码的映射
    private final String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    // 路径
    private StringBuilder sb = new StringBuilder();

    // 结果集
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return res;
        backtrack(digits,0);
        return res;
    }

    // 回溯函数
    private void backtrack(String digits,int index) {
        if(sb.length() == digits.length()) {
            res.add(sb.toString());//递归出口，产生了满足条件的解
            return;
        }
        String val = map[digits.charAt(index)-'2'];
        for(char ch:val.toCharArray()) {
            sb.append(ch);
            backtrack(digits,index+1);//选择下一位
            sb.deleteCharAt(sb.length()-1);//撤销上一步的选择（回溯算法）
        }
    }
}