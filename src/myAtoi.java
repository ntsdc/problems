import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class myAtoi {
    public static void main(String[] args) {
        System.out.println(new Solution8().myAtoi("91283472332"));
    }

}
class Solution8 {
    public int myAtoi(String s) {
        //清空字符串开头和末尾空格（这是trim方法功能，事实上我们只需清空开头空格）
        s = s.trim();
        //java正则表达式
        Pattern p = Pattern.compile("^[\\+\\-]?\\d+");
        Matcher m = p.matcher(s);
        int value = 0;
        //判断是否能匹配
        if (m.find()) {
            //字符串转整数，溢出
            try {
                value = Integer.parseInt(s.substring(m.start(), m.end()));
            } catch (Exception e) {
                //由于有的字符串"42"没有正号，所以我们判断'-'
                value = s.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return value;
    }
}

        /* if(Pattern.matches(" *(/+|-)?[0-9].*",s)) return 0;
        char[] arr = s.toCharArray();
        boolean positive = true;
        long sum = 0;
        ArrayList<Integer> nums= new ArrayList<>();
        int i = 0,count = 0;
        while (arr[i] == ' '){
         i++;
        }
        if(arr[i] == '-') {
            positive = false;
            i++;
        }
        if(arr[i] == '+') {
            i++;
            if(!positive) return 0;
        }
        for (; i < s.length(); i++) {
            if(arr[i] <= '9' && arr[i] >= '0'){
                nums.add(arr[i] - '0');
                count++;
            }else break;
        }
        for (int j = 0; j < count; j++) {
            sum += nums.get(j)*Math.pow(10, count-j-1);
        }
        if((int)sum != sum) return positive?Integer.MAX_VALUE:Integer.MIN_VALUE;
        if(!positive) sum = -sum;
        return (int)sum;
        */