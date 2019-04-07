package solutions;

import java.util.*;

/*
 * @author pjl
 * @version 创建时间：2019年3月19日 下午8:07:12
5017. 从根到叶的二进制数之和  显示英文描述  我的提交返回竞赛
用户通过次数 267
用户尝试次数 386
通过次数 269
提交次数 1279
题目难度 Easy
给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。

对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。

以 10^9 + 7 为模，返回这些数字之和。

 

示例：



输入：[1,0,1,0,1,0,1]
输出：22
解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 

提示：

树中的结点数介于 1 和 1000 之间。
node.val 为 0 或 1 。
 *
 *周赛131
 *这次周赛的题目整体都感觉不好，特别这题，文字游戏呢？真没什么意思，浪费不少时间，最后结束了才发现还要求模
 */
public class Problem5017 {
	public static void main(String[] args) {

	}

	static class Solution {
		public int sumRootToLeaf(TreeNode root) {
			return find(root, 0);
		}

		int find(TreeNode node, int count) {
			if (node == null)
				return 0;
			count = count * 2%(1000000007) + node.val;
			if (node.left == null && node.right == null)
				return count%(1000000007);
			return (find(node.left, count) + find(node.right, count))%(1000000007);
		}
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
