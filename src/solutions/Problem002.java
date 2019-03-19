package solutions;
/*
 * @author pjl
 * @version 创建时间：2019年3月19日 下午7:29:15
 * 
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 *
 * leetcode第二题，感觉思维上没什么难度，感觉不如第一题。不知道为啥是个中等题。
 * 测试用main不太好写，懒得写了，反正是一遍就ac的题目。
 */
public class Problem002 {
	public static void main(String[] args) {

	}

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int a, b;
		int c = 0;
		ListNode ans = new ListNode(0);
		ListNode p = ans;
		while (l1 != null || l2 != null || c != 0) {
			if (l1 != null) {
				a = l1.val;
				l1 = l1.next;
			} else
				a = 0;
			if (l2 != null) {
				b = l2.val;
				l2 = l2.next;
			} else
				b = 0;
			ListNode q = new ListNode((a + b + c) % 10);
			c = (a + b + c) / 10;
			p.next = q;
			p = q;
		}
		return ans.next;
	}
}
}
