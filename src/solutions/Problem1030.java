package solutions;

import java.util.*;

/*
 * @author pjl
 * @version 创建时间：2019年3月19日 下午8:07:12
1030. 链表中的下一个更大节点  显示英文描述  我的提交返回竞赛
用户通过次数 194
用户尝试次数 349
通过次数 196
提交次数 810
题目难度 Medium
给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。

每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。

返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。

注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。

 

示例 1：

输入：[2,1,5]
输出：[5,5,0]
示例 2：

输入：[2,7,4,3,5]
输出：[7,0,5,5,0]
示例 3：

输入：[1,7,5,1,9,2,5,1]
输出：[7,9,9,9,0,5,0,0]
 

提示：

对于链表中的每个节点，1 <= node.val <= 10^9
给定列表的长度在 [0, 10000] 范围内
 *
 *周赛130
 *
 *固执的使用链表，导致其他数据结构过于复杂，也浪费了很多精力
 *看别人的java代码有些是直接把链表存成数组，感觉很不服气。
 *java的数组作为不可扩容的东西，是真的麻烦。在这题里不知道申明多大，很费劲。
 *明明c++都用vector。。。
 *总之这一题个人觉得出的不好，就这样吧。。。。
 *
 */
public class Problem1030 {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 1, 2, 3 };
		int nums2 = 2;
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(5);
		a.next = b;
		b.next = c;
		int[] ans = new Solution().nextLargerNodes(a);
		for (int t : ans)
			System.out.print(t + "  ");
//		System.out.print(ans);
	}

	static class Solution {
//		public int[] nextLargerNodes(ListNode head) {
//			List<Integer> ans = new ArrayList<>();
//			ListNode thisNode = head;
//			ListNode target = head.next;
//			int i = 0;
//			while (target != null) {
//				if (target.val > thisNode.val) {
//					while (thisNode != target) {
//						ans.add(target.val);
//						thisNode=thisNode.next;
//					}
//				}
//				target = target.next;
//			}
//			while (thisNode != target) {
//				ans.add(0);
//				thisNode=thisNode.next;
//			}
//			int[] ans1 = new int[ans.size()];
//			for (i = 0; i < ans.size(); ++i) {
//				ans1[i] = ans.get(i);
//			}
//			return ans1;
//		}
		public int[] nextLargerNodes(ListNode head) {
			if (head == null) {
				return null;
			}
			Stack<ListNode> a = new Stack<>();
			Map<ListNode, Integer> ans = new HashMap<>();
			a.push(head);
			ListNode thisNode = head.next;
			while (thisNode != null) {
				while (!a.isEmpty() && thisNode.val > a.peek().val) {
					ans.put(a.pop(), thisNode.val);
				}
				a.push(thisNode);
				thisNode = thisNode.next;
			}
			while (!a.isEmpty()) {
				ans.put(a.pop(), 0);
			}
			int[] ans1 = new int[ans.size()];
			for (int i = 0; i < ans.size(); ++i) {
				ans1[i] = ans.get(head);
				head = head.next;
			}
			return ans1;
		}
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
