public class maxArea {
    public static void main(String[] args) {
        System.out.println(new Solution11().maxArea(new int[]{1,1}));
    }
}
class Solution11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int maxArea = (right-left)*Math.min(height[left],height[right]), current;
        while(left != right){
            if(height[left] > height[right]) right--;
            else left++;
            current = (right-left)*Math.min(height[left],height[right]);
            if(current > maxArea) maxArea = current;
        }
        return maxArea;
    }
}