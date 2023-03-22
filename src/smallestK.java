import java.util.Arrays;
import java.util.Random;

public class smallestK {
    public static void main(String[] args) {

//        System.out.println(
//                Arrays.toString(new Solution_order_statistic().smallestK(
//                        new int[]{3, 2, 1, 5, 6, 4}, 2
//                ))
//        );
        System.out.println(
                new Solution_order_statistic().findKthLargest(
                        new int[]{5,2,4,1,3,6,0},2
                )
        );


    }
}

class Solution2 {
    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        int[] result = new int[k];
        System.arraycopy(arr, 0, result, 0, k);
        return result;


    }
}

class Solution_order_statistic {
    public int[] smallestK(int[] arr, int k) {
        randomizedSelection(arr, 0, arr.length - 1, k);
        int[] result = new int[k];
        System.arraycopy(arr, 0, result, 0, k);
        return result;
    }

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        randomizedSelection(nums, 0, len - 1, len - k);
        return nums[len - k];

    }
    private int randomizedSelection_kth_largest(int[] nums, int l, int r, int k) {
        int pos = randomizedPartition(nums, l, r);
        if (k == pos) return nums[pos];
        else if (k < pos)  return randomizedSelection_kth_largest(nums, l, pos - 1, k);
        else return randomizedSelection_kth_largest(nums, pos + 1, r, k );
    }


    private void randomizedSelection(int[] nums, int l, int r, int k) {
        if (l >= r) return;
        int pos = randomizedPartition(nums, l, r);
        int num = pos - l + 1;
        if (k == num) return;
        else if (k < num) randomizedSelection(nums, l, pos - 1, k);
        else randomizedSelection(nums, pos + 1, r, k - num);
    }

    private int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int p, int r) {
        int x = nums[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (nums[j] <= x) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
