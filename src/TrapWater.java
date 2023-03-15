public class TrapWater {
    public static void main(String[] args) {
        System.out.println(new Solution42_new().trap(
                new int[]{0,1,0,2,1,0,1,3,2,1,2,1}
        ));
    }
}
class Solution42_new {
    public int trap(int[] height) {
        int sum = 0;
        int[] max_height_l = new int[height.length];
        int[] max_height_r = new int[height.length];
        for (int j = 1; j < height.length; j++) {
            max_height_l[j] = Math.max(max_height_l[j - 1], height[j - 1]);
        }
        for (int j = height.length - 2; j >= 0; j--) {
            max_height_r[j] = Math.max(max_height_r[j + 1], height[j + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            int lower = Math.min(max_height_l[i], max_height_r[i]);
            if(lower < height[i]){
                continue;
            }
            sum += lower - height[i];
        }
        return sum;
    }
}
class Solution42 {
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int higher_l = 0;
            int higher_r = 0;
            for (int j = i + 1; j < height.length; j++) {
                if(height[j] >= higher_r){
                    higher_r = height[j];
                }
            }
            for (int j = i - 1; j >= 0; j--) {
                if(height[j] >= higher_l){
                    higher_l = height[j];
                }
            }
            int lower = Math.min(higher_l, higher_r);
            if(lower < height[i]){
                continue;
            }
            sum += lower - height[i];
        }
        return sum;
    }
}