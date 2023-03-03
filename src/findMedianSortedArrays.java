public class findMedianSortedArrays {
    public static void main(String[] args) {
        System.out.println(new Solution4().findMedianSortedArrays(
                new int[]{1, 2, 7, 8}, new int[]{3, 4, 5, 6}
        ));
    }
}
/*
*       ****************************    困难  Hard    ***************************
* */
class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        if ((len1 + len2) % 2 == 0) return (getKthNumber((len1 + len2) / 2 , nums1, nums2) +
                getKthNumber((len1 + len2) / 2 + 1, nums1, nums2)) / 2.; //中位数对应的奇偶数目位置（第k大的数）
        else return getKthNumber((len1 + len2) / 2 + 1, nums1, nums2);
    }

    public int getKthNumber(int k, int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int index1 = 0, index2 = 0;
        while (true) {
            // 边界情况
            if (index1 == len1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == len2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int newIndex1 = Math.min(index1 + k / 2, len1) - 1;//比较A[k/2−1] 和B[k/2−1]
            int newIndex2 = Math.min(index2 + k / 2, len2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {     //数组1，pivot前半部分排除，一定比第k个小
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }

        }


    }
}


