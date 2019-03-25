package solutions;

import java.util.*;

/*
 * @author pjl
 * @version 创建时间：2019年3月19日 下午8:07:12
990. 等式方程的可满足性  显示英文描述  我的提交返回竞赛
用户通过次数 70
用户尝试次数 111
通过次数 70
提交次数 296
题目难度 Medium
给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。

只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 

 

示例 1：

输入：["a==b","b!=a"]
输出：false
解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
示例 2：

输出：["b==a","a==b"]
输入：true
解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
示例 3：

输入：["a==b","b==c","a==c"]
输出：true
示例 4：

输入：["a==b","b!=c","c==a"]
输出：false
示例 5：

输入：["c==c","b==d","x!=z"]
输出：true
 

提示：

1 <= equations.length <= 500
equations[i].length == 4
equations[i][0] 和 equations[i][3] 是小写字母
equations[i][1] 要么是 '='，要么是 '!'
equations[i][2] 是 '='
 *
 *模拟竞赛
 */
public class Problem990 {
	public static void main(String[] args) {
		String[] strs = { "g==c", "f!=e", "e==b", "j==b", "g!=a", "e==c", "b!=f", "d!=a", "j==g", "f!=i", "a==e" };
		boolean ans = new Solution().equationsPossible(strs);
		System.out.print(ans);
	}

	static class Solution {
		public boolean equationsPossible(String[] equations) {
			int[][] mat = new int[26][26];
			for (int i = 0; i < 26; ++i)
				mat[i][i] = 1;
			for (String s : equations) {
				int x = s.charAt(0) - 'a';
				int y = s.charAt(3) - 'a';
				int eq = s.charAt(1) == '=' ? 1 : 2;
				if (!set(mat, x, y, eq))
					return false;
			}
			return true;
		}

		public boolean set(int[][] mat, int x, int y, int eq) {
			if (mat[x][y] != eq) {
				if (mat[x][y] == 0) {
					mat[x][y] = eq;
					mat[y][x] = eq;
					for (int i = 0; i < 26; ++i) {
						if (mat[x][i] == 1)
							if (!set(mat, i, y, eq))
								return false;
						if (mat[y][i] == 1)
							if (!set(mat, i, x, eq))
								return false;
					}
				} else {
					return false;
				}
			}
			return true;
		}
	}
}
