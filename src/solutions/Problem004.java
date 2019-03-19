package solutions;

/*
 * @author pjl
 * @version 创建时间：2019年3月19日 下午8:07:12
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5
 *
 *来了来了！leetcode之旅的第一个难题！这题我初见之时没做出来，被各种边界条件、数组越界弄崩溃了（真菜）
 *这题一直放着没写，直到刷leetcode一个多月后才补上，方法是二分法（答案是直接遍历，按理说我比答案的快）
 */
public class Problem004 {
	public static void main(String[] args) {
		int[] nums = { 1, 2 };
		int[] nums2 = { 3, 4 };
		double ans = new Solution().findMedianSortedArrays(nums, nums2);
		System.out.print(ans);
	}

	static class Solution {
		public double findMedianSortedArrays(int[] nums1, int[] nums2) {
			int sumlength = nums1.length + nums2.length;
			int slice1 = nums1.length / 2, slice2 = sumlength / 2 - slice1;
			int step = Math.min(slice1, slice2);
			int l1 = getLeft(nums1, slice1), l2 = getLeft(nums2, slice2), r1 = getRight(nums1, slice1),
					r2 = getRight(nums2, slice2);
			while (Math.max(l1, l2) > Math.min(r1, r2)) {
				step = step / 2;
				if (step == 0)
					step = 1;
				if (l1 > r2) {
					slice1 -= step;
					slice2 += step;
				} else {
					slice1 += step;
					slice2 -= step;
				}
				l1 = getLeft(nums1, slice1);
				l2 = getLeft(nums2, slice2);
				r1 = getRight(nums1, slice1);
				r2 = getRight(nums2, slice2);
			}
			if (sumlength % 2 == 0)
				return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
			else
				return Math.min(r1, r2);
		}

		private int getLeft(int[] nums, int slice) {
			if (slice == 0)
				return Integer.MIN_VALUE;
			else
				return nums[slice - 1];
		}

		private int getRight(int[] nums, int slice) {
			if (slice == nums.length)
				return Integer.MAX_VALUE;
			else
				return nums[slice];
		}
	}
}
