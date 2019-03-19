package solutions;

import java.util.*;

/*
 * @author pjl
 * @version 创建时间：2019年3月19日 下午4:45:11
 * 
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 *
 * leetcode第一题，初次用c++，双层嵌套循环做的，看了答案之后感到不可思议。
 * twoSum是根据印象用hash表做。
 * twoSum2是初次想到的方案，也重写了一次，并且没有一次通过（就很气）。虽然速度上并不差，但是实在是不够优雅。
 */
public class Problem001 {
	public static void main(String[] args) {
		int[] nums = { 2, 5, 5, 11 };
		int target = 10;
		int[] ans = new Solution().twoSum2(nums, target);
		for (int t : ans)
			System.out.print(t + " ");
	}

	static class Solution {
		public int[] twoSum(int[] nums, int target) {
			HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
			for (int index = 0; index < nums.length; ++index) {
				Integer temp = m.get(target - nums[index]);
				if (temp != null)
					return new int[] { temp, index };
				m.put(nums[index], index);
			}
			throw new IllegalArgumentException("no answer found");
		}

		public int[] twoSum2(int[] nums, int target) {
			int[] sorted = new int[nums.length];
			System.arraycopy(nums, 0, sorted, 0, nums.length);
			Arrays.sort(sorted);
			int left = 0;
			int right = nums.length - 1;
			while (left < right) {
				int temp = sorted[left] + sorted[right];
				if (temp == target) {
					int[] ans = { 0, 0 };
					int flag = 0;
					for (int i = 0; i < nums.length; ++i) {
						if (flag != 1 && sorted[left] == nums[i]) {
							ans[0] = i;
							++flag;
						} else if (flag != 2 && sorted[right] == nums[i]) {
							ans[1] = i;
							flag += 2;
						}
						if (flag == 3)
							break;
					}
					return ans;
				} else if (temp > target) {
					--right;
				} else {
					++left;
				}
			}
			throw new IllegalArgumentException("no answer found");
		}

	}
}
