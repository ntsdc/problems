public class longestPalindrome {
    public static void main(String[] args) {
        String s = "bb";
        solution5 solution = new solution5();
        System.out.println(solution.longestPalindrome(s));
    }

}
class solution5{
    public String longestPalindrome(String s) {

        int len = s.length();
        if(len < 2) return s;

        char[] arr = s.toCharArray();
        int max_l = 0,max_r = 0,max = 1;
        boolean [][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < len-1; i++) {
            if(arr[i]==arr[i+1]){
                dp[i][i+1] = true;
                max_l = i;
                max_r = i+1;
            }
        }
        for (int i = 2; i < len; i++) { //step
            for (int j = 0; j < len - i; j++) {
                if((arr[j] == arr[j+i]) && dp[j+1][j+i-1]){
                    dp[j][j+i] = true;
                    if (i > max){
                        max = i;
                        max_l = j;
                        max_r = j+i;
                    }
                }
            }
        }
        return s.substring(max_l,max_r+1);
    }
}
