package solutions;

import java.util.*;

/*
 * @author pjl
 * @version 创建时间：2019年3月19日 下午8:07:12
1028. 负二进制转换  显示英文描述  我的提交返回竞赛
用户通过次数 156
用户尝试次数 227
通过次数 158
提交次数 435
题目难度 Medium
给出数字 N，返回由若干 "0" 和 "1"组成的字符串，该字符串为 N 的负二进制（base -2）表示。

除非字符串就是 "0"，否则返回的字符串中不能含有前导零。

 

示例 1：

输入：2
输出："110"
解释：(-2) ^ 2 + (-2) ^ 1 = 2
示例 2：

输入：3
输出："111"
解释：(-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3
示例 3：

输入：4
输出："100"
解释：(-2) ^ 2 = 4
 

提示：

0 <= N <= 10^9
 *
 *周赛130
 *没做出来，其实也没那么难，最开始想和转二进制一样，后来觉得不妥（其实这就是正确思路），想从高位向低位转，结果非常繁琐，浪费了太多时间。
 *还是菜呀。。。。
 *
 *1  1
 *2  110
 *3  111
 *4  100
 *5  101
 *6  11010
 *7  11011
 *8  11000
 *9  11001
 *10 11110
 *11 11111
 *12 11100
 *13 11101
 *14 10010
 *15 10011
 *
 */
public class Problem1028 {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 1, 2, 3 };
		int nums2 = 6;
		String ans = new Solution().baseNeg2(nums2);
//		for (int a : ans)
//			System.out.print(a);
		System.out.print(ans);
	}

	static class Solution {
		public String baseNeg2(int N) {
			StringBuilder ans=new StringBuilder();
			int step=1;
			while(N!=0) {
				if(N%(2)==1) {
					ans.append(1);
					N=(N-step)/2;
				}else {
					ans.append(0);
					N/=2;
				}
				
				step*=-1;
			}
			ans.reverse();
			if(ans.length()==0)
				ans.append(0);
			return ans.toString();
		}
//		public String baseNeg2(int N) {
//			StringBuilder ans = new StringBuilder();
//			int step = 1, power = 0;
//			while (N > step) {
//				step *= -2;
//				power += 1;
//			}
//			while (power >= 0) {
//				if (N > 0) {
//					if (N <= step && N > (-step / 2)) {
//						ans.append(1);
//						N -= step;
//					} else {
//						ans.append(0);
//					}
//				} else if (N < 0) {
//					if (N >= step && N < (-step / 2)) {
//						ans.append(1);
//						N -= step;
//					} else {
//						ans.append(0);
//					}
//				} else {
//					ans.append(0);
//				}
//				step /= -2;
//				power -= 1;
//			}
//			return ans.toString();
//		}
	}
}
