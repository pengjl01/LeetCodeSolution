package solutions;

import java.util.*;

/*
 * @author pjl
 * @version 创建时间：2019年3月19日 下午8:07:12
992. K 个不同整数的子数组  显示英文描述  我的提交返回竞赛
用户通过次数 11
用户尝试次数 36
通过次数 12
提交次数 73
题目难度 Hard
给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。

（例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）

返回 A 中好子数组的数目。

 

示例 1：

输出：A = [1,2,1,2,3], K = 2
输入：7
解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
示例 2：

输入：A = [1,2,1,3,4], K = 3
输出：3
解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 

提示：

1 <= A.length <= 20000
1 <= A[i] <= A.length
1 <= K <= A.length
 *
 *模拟竞赛
 *subarraysWithKDistinct为个人初版，timeout了
 *subarraysWithKDistinct2为个人次版，为成功做出，但思路已接近
 *subarraysWithKDistinct3为第一名的答案，不得不服
 *
 *从right至left的计算每步ans增量；
 *维护left为下次超过K时，调整后的最左位置，很巧妙
 */
public class Problem992 {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 1, 2, 3 };
		int nums2 = 2;
		int ans = new Solution().subarraysWithKDistinct(nums, nums2);

		System.out.print(ans);
	}

	static class Solution {
		public int subarraysWithKDistinct(int[] A, int K) {
			int ans = 0;
			for (int i = 0; i < A.length; ++i) {
				Set<Integer> diff = new HashSet<>();
				int tail = 0;
				while (diff.size() <= K&&(i+tail)<A.length) {
					if (!diff.contains(A[i + tail]))
						diff.add(A[i + tail]);
					if (diff.size() == K)
						++ans;
					++tail;
				}
			}
			return ans;
		}

//		public int subarraysWithKDistinct2(int[] A, int K) {
//			int ans = 0;
//			Map<Integer, Integer> nums = new HashMap<>();
//			int left = 0, right = 0, step = 0;
//			while (right < A.length) {
//				if (nums.size() < K) {
//					add(nums, A[right]);
//					++right;
//				}
//				if (nums.size() > K) {
//					ans += step;
//					delete(nums, A[left]);
//					++left;
//				}
//				if (nums.size() == K) {
//					add(nums, A[right]);
//					++right;
//					++step;
//				}
//			}
//			return ans;
//		}
//
//		public void add(Map<Integer, Integer> nums, int a) {
//			if (nums.containsKey(a)) {
//				nums.put(a, nums.get(a) + 1);
//			} else {
//				nums.put(a, 1);
//			}
//		}
//
//		public void delete(Map<Integer, Integer> nums, int a) {
//			if (nums.containsKey(a)) {
//				if (nums.get(a) == 1)
//					nums.remove(a);
//				nums.put(a, nums.get(a) - 1);
//			}
//		}

		int subarraysWithKDistinct3(int[] A, int K)
	    {
	        int size = A.length;
	        int[] hash=new int[size+1];
	        int cnt = 0;
	        int ans = 0;
	        int l = 0, r = -1;
	        int step = 1;
	        while(++r < size)
	        {
	            if(++hash[A[r]] == 1)
	                cnt++;
	            if(cnt < K)
	                continue;
	            if(cnt > K)
	            {
	                while(cnt > K)
	                {
	                    if(--hash[A[l++]] == 0)
	                        cnt--;
	                }
	                step = 1;
	            }
	            if(cnt == K)
	            {
	                while(hash[A[l]] > 1) {
						--hash[A[l++]];
						step++;
					}
	                ans += step;
	            }
	        }
	        return ans;
	    }
	}
}
