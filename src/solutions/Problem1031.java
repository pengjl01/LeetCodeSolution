package solutions;

import java.util.*;

/*
 * @author pjl
 * @version 创建时间：2019年3月19日 下午8:07:12
1031. 飞地的数量  显示英文描述  我的提交返回竞赛
用户通过次数 136
用户尝试次数 177
通过次数 138
提交次数 317
题目难度 Medium
给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。

移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。

返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。

 

示例 1：

输入：[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
输出：3
解释： 
有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
示例 2：

输入：[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
输出：0
解释：
所有 1 都在边界上或可以到达边界。
 

提示：

1 <= A.length <= 500
1 <= A[i].length <= 500
0 <= A[i][j] <= 1
所有行的大小都相同
 *
 *周赛130
 *没时间做了，刚看完题就结束了。
 *难倒是不难，写起来稍微注意些就好。
 *没什么陷阱，一遍就A了
 */
public class Problem1031 {
	public static void main(String[] args) {
		int[][] nums = { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
		int nums2 = 2;
		int ans = new Solution().numEnclaves(nums);
//		for (int a : ans)
//			System.out.print(a);
		System.out.print(ans);
	}

	static class Solution {
		public int numEnclaves(int[][] A) {
			int size1 = A.length;
			int size2 = A[0].length;
			int all = 0;
			for (int[] a : A) {
				for (int b : a) {
					if (b == 1)
						++all;
				}
			}
			int count = 0;
			Boolean[][] B = new Boolean[size1][size2];
			for (int i = 0; i < size2; ++i) {
				count += mark(A, B, 0, i);
				count += mark(A, B, size1 - 1, i);
			}
			for (int i = 1; i < size1 - 1; ++i) {
				count += mark(A, B, i, 0);
				count += mark(A, B, i, size2 - 1);
			}
			return all - count;
		}

		int mark(int[][] A, Boolean[][] B, int x, int y) {
			int count = 0;
			if (B[x][y] != null) {
				return count;
			} else {
				B[x][y] = true;
				if (A[x][y] == 1) {
					++count;
					if (x > 0)
						count += mark(A, B, x - 1, y);
					if (x < A.length - 1)
						count += mark(A, B, x + 1, y);
					if (y > 0)
						count += mark(A, B, x, y - 1);
					if (y < A[0].length - 1)
						count += mark(A, B, x, y + 1);
				}
			}
			return count;
		}
	}
}
