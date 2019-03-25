package solutions;

import java.util.*;

/*
 * @author pjl
 * @version 创建时间：2019年3月19日 下午8:07:12
989. 数组形式的整数加法  显示英文描述  我的提交返回竞赛
用户通过次数 150
用户尝试次数 170
通过次数 152
提交次数 437
题目难度 Easy
对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。

给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。

 

示例 1：

输入：A = [1,2,0,0], K = 34
输出：[1,2,3,4]
解释：1200 + 34 = 1234
解释 2：

输入：A = [2,7,4], K = 181
输出：[4,5,5]
解释：274 + 181 = 455
示例 3：

输入：A = [2,1,5], K = 806
输出：[1,0,2,1]
解释：215 + 806 = 1021
示例 4：

输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
输出：[1,0,0,0,0,0,0,0,0,0,0]
解释：9999999999 + 1 = 10000000000
 

提示：

1 <= A.length <= 10000
0 <= A[i] <= 9
0 <= K <= 10000
如果 A.length > 1，那么 A[0] != 0
 *
 *模拟竞赛 考试的时候复制下来题目感觉和后来看的不一样？
 */
public class Problem989 {
	public static void main(String[] args) {
		int[] nums = { 9,9,9,9,9,9,9,9,9,9 };
		int nums2 = 1;
		List<Integer> ans = new Solution().addToArrayForm(nums, nums2);
		for (int a : ans)
			System.out.print(a);
	}

	static class Solution {
//		public int[] addToArrayForm(int[] A, int K) {
//			
//		}
	    public List<Integer> addToArrayForm(int[] A, int K) {
	        List<Integer> ans=new ArrayList<>();
	        int num=A[A.length-1]+K;
	        for(int i=1;i<A.length;++i) {
	        	ans.add(num%10);
	        	num=num/10+A[A.length-1-i];
	        }
	        while(num>0) {
	        	ans.add(num%10);
	        	num=num/10;
	        }
	        Collections.reverse(ans);
	        if(ans.size()==0)
	        	ans.add(0);
	        return ans;
	    }
	}
}
