package solutions;

import java.util.*;

/*
 * @author pjl
 * @version 创建时间：2019年3月19日 下午8:07:12
1029. 可被 5 整除的二进制前缀  显示英文描述  我的提交返回竞赛
用户通过次数 467
用户尝试次数 662
通过次数 477
提交次数 1964
题目难度 Easy
给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。

返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。

 

示例 1：

输入：[0,1,1]
输出：[true,false,false]
解释：
输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
示例 2：

输入：[1,1,1]
输出：[false,false,false]
示例 3：

输入：[0,1,1,1,1,1]
输出：[true,false,false,false,true,false]
示例 4：

输入：[1,1,1,0,1]
输出：[false,false,false,false,false]
 

提示：

1 <= A.length <= 30000
A[i] 为 0 或 1
 *
 *周赛130
 *热身题没什么可说的，6分钟A了。
 *不过结束看大佬们都是2分钟A的。。。卧槽。。。
 *
 */
public class Problem1029 {
	public static void main(String[] args) {
		int[] nums = {0,1,1,1,1,1 };
		int nums2 = 2;
		List<Boolean> ans = new Solution().prefixesDivBy5(nums);
		for (Boolean a : ans)
			System.out.print(a+" ");
//		System.out.print(ans);
	}

	static class Solution {
	    public List<Boolean> prefixesDivBy5(int[] A) {
	        List<Boolean> ans=new ArrayList<>();
	        int num=0;
	        for(int i=0;i<A.length;++i) {
	        	num=(num*2+A[i])%5;
	        	ans.add(num==0);
	        }
	        return ans;
	    }

	}
}
