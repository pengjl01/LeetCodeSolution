package solutions;

import java.util.*;

/*
 * @author pjl
 * @version 创建时间：2019年3月19日 下午8:07:12
5019. 视频拼接  显示英文描述  我的提交返回竞赛
用户通过次数 127
用户尝试次数 154
通过次数 134
提交次数 329
题目难度 Medium
你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。

视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。

我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。

 

示例 1：

输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
输出：3
解释：
我们选中 [0,2], [8,10], [1,9] 这三个片段。
然后，按下面的方案重制比赛片段：
将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
示例 2：

输入：clips = [[0,1],[1,2]], T = 5
输出：-1
解释：
我们无法只用 [0,1] 和 [0,2] 覆盖 [0,5] 的整个过程。
示例 3：

输入：clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
输出：3
解释： 
我们选取片段 [0,4], [4,7] 和 [6,9] 。
示例 4：

输入：clips = [[0,4],[2,8]], T = 5
输出：2
解释：
注意，你可能录制超过比赛结束时间的视频。
 

提示：

1 <= clips.length <= 100
0 <= clips[i][0], clips[i][1] <= 100
0 <= T <= 100
 *周赛131
 *理解题目花很久
 *比赛时没时间做的一题，看了眼题目，直觉动态规划法，但短时间没来得及想出来。
 *看答案找了很多，排名25的大佬给出的解法是我觉得最好的，比排前几的解法优雅不知道哪去了
 *
 *本次周赛成绩依然不理想。排开题目问题，还是自己速度太慢。还需要多加油
 */
public class Problem5019 {
	public static void main(String[] args) {
		int[][] nums = { { 0, 2 }, { 4, 6 }, { 8, 10 }, { 1, 9 }, { 1, 5 }, { 5, 9 } };
		int nums2 = 2;
		int ans = new Solution().videoStitching(nums, nums2);
		System.out.print(ans);
	}

	static class Solution {
		public int videoStitching(int[][] clips, int T) {
			int[] dp = new int[T + 1];
			for (int i = 1; i < T + 1; ++i)
				dp[i] = T + 1;
			for (int i = 1; i <= T; ++i) {
				for (int j = 0; j < clips.length; ++j) {
					if (clips[j][0] < i && clips[j][1] >= i)
						dp[i] = Math.min(dp[i], dp[clips[j][0]] + 1);
				}
			}
			if (dp[T] > T)
				return -1;
			return dp[T];
		}
	}
}
