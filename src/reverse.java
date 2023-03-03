public class reverse {
    public static void main(String[] args) {
        System.out.println(new Solution7().reverse(-123456));
    }
}
class Solution7 {
    public int reverse(int x) {
        String s = String.valueOf(x);
        boolean num = true;
        if(x < 0) {
            s = s.substring(1);
            num = false;
        }
        char[] arr = s.toCharArray();
        long sum = 0;
        for (int i = 0; i < arr.length ; i++) {
         sum += (arr[i]-'0')*Math.pow(10,i);
         if(sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE){
             sum = 0;
             break;
         }
        }
        if(!num) sum = -sum;
        return (int)sum;
    }
}