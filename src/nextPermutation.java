import ds.ArrayOps;

public class nextPermutation {
    public static void main(String[] args) {
        new Solution31().nextPermutation(new int[]{5,4,3,2,1});
    }
}

class Solution31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]){   //较小数
            i--;
        }
        if(i >= 0){     //较大数
            int j = nums.length - 1;
            while(j >= 0 && nums[i] >= nums[j]){
                j--;
            }
            ArrayOps.swap(nums, i, j); //交换大小
        }
        ArrayOps.reverse(nums, i+1, nums.length-1); //重排较小数后面的序列

    }
}
