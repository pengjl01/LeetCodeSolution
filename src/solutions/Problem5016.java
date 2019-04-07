package solutions;

import java.util.*;

/*
 * @author pjl
 * @version 创建时间：2019年3月19日 下午8:07:12
5016. 删除最外层的括号  显示英文描述  我的提交返回竞赛
用户通过次数 446
用户尝试次数 469
通过次数 456
提交次数 577
题目难度 Easy
有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。

如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。

给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。

对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。

 

示例 1：

输入："(()())(())"
输出："()()()"
解释：
输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
示例 2：

输入："(()())(())(()(()))"
输出："()()()()(())"
解释：
输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
删除每隔部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
示例 3：

输入："()()"
输出：""
解释：
输入字符串为 "()()"，原语化分解得到 "()" + "()"，
删除每个部分中的最外层括号后得到 "" + "" = ""。
 

提示：

S.length <= 10000
S[i] 为 "(" 或 ")"
S 是一个有效括号字符串
 *
 *周赛131
 *这次周赛题目描述都非常长，这题最开始理解有误，以为需要递归的删除括号直到不存在非原语，浪费了极多的时间
 *一边做还一边想：这也是简单题？
 *后来发现了这个问题，就很快弄出来了
 */
public class Problem5016 {
	public static void main(String[] args) {
		int[][] nums = { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
		int nums2 = 2;
		String S = "(()())(())(()(()))";
		String ans = new Solution().removeOuterParentheses(S);
//		for (int a : ans)
//			System.out.print(a);
		System.out.print(ans);
	}

	static class Solution {
		public String removeOuterParentheses(String S) {
			StringBuilder sb = new StringBuilder();
	    	int i=0,left=0,j=0;
	    	while(i<S.length()) {
	    		if(S.charAt(i)=='(') {
	    			++j;
	    		}else {
	    			--j;
	    		}
	    		if(j==0) {
	    			sb.append(S.substring(left+1,i));
	    			left=i+1;
	    		}
	    		++i;
	    	}
			return sb.toString();
		}
	}
}
