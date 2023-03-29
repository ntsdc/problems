import java.util.LinkedList;
import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        System.out.println(new Solution394().decodeString("3[a2[c]]"));
    }
}

class Solution394 {

    public String decodeString(String s) {
        Stack<StringBuilder> words = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '['){
                words.add(sb);
                nums.push(num);
                num = 0;
                sb = new StringBuilder();
            } else if (Character.isAlphabetic(c)) {
                sb.append(c);
            }else {
                StringBuilder temp = words.pop();
                int count = nums.pop();
                for (int i = 0; i < count; i++) {
                    temp.append(sb);
                }
                sb = temp;
            }
        }
        return sb.toString();
    }
}