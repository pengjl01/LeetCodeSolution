package solutions;

import java.util.*;

/*
 * @author pjl
 * @version 创建时间：2019年3月19日 下午8:07:12
5018. 驼峰式匹配  显示英文描述  我的提交返回竞赛
用户通过次数 220
用户尝试次数 268
通过次数 227
提交次数 469
题目难度 Medium
如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）

给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。

 

示例 1：

输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
输出：[true,false,true,true,false]
示例：
"FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
"FootBall" 可以这样生成："F" + "oot" + "B" + "all".
"FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".
示例 2：

输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
输出：[true,false,true,false,false]
解释：
"FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
"FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
示例 3：

输出：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
输入：[false,true,false,false,false]
解释： 
"FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".
 *
 *周赛131
 *理解题目花很久，做起来倒是不怎么难。本次周赛通病了
 *代码其实可以再简化一下，把break整的更漂亮，懒得弄了
 */
public class Problem5018 {
	public static void main(String[] args) {
		int[][] nums = { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
		int nums2 = 2;
		String S = "(()())(())(()(()))";
		String[] queries = { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" };
		String pattern = "FoBa";
		List<Boolean> ans = new Solution().camelMatch(queries, pattern);
		for (Boolean a : ans)
			System.out.print(a + " ");
//		System.out.print(ans);
	}

	static class Solution {
		public List<Boolean> camelMatch(String[] queries, String pattern) {
			List<Boolean> ans = new ArrayList<>();
			for (String s : queries) {
				ans.add(match(s, pattern));
			}

			return ans;
		}

		private Boolean match(String s, String pattern) {
			int i = 0, j = 0;
			while (i < s.length()) {
				if (j < pattern.length()) {
					if (s.charAt(i) == pattern.charAt(j)) {
						++j;
						++i;
					} else {
						if (s.charAt(i) < 'a')
							break;
						++i;
					}
				} else {
					if (s.charAt(i) < 'a')
						break;
					++i;
				}

			}
			if (i >= s.length() && j >= pattern.length())
				return true;
			return false;
		}
	}
}
