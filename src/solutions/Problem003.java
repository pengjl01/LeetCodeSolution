package solutions;

/*
 * @author pjl
 * @version 创建时间：2019年3月19日 下午7:41:23
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 我的解法实际上是一个改进的暴力法（主要是indexOf可以换成用hash表实现，这样就和答案类似了），没有用到高级的数据结构，其速度不算太慢，显示战胜89%。
 * 相比于答案的方法，这个解法可以输出子串是什么。
 * 灵感恰好就来源于之前算法课上的一道题，叫做最大连续子序列之和问题，最后优化的结果是在一次遍历数组后，即可输出结果。
 * 那也是一个让作为菜鸡的我惊艳的题目，思路和这题我的实现类似，就不写了。
 * 还有一个地方可以优化：String是个常量，每次赋值都需要创建
 */
public class Problem003 {
	public static void main(String[] args) {
		String a = "abcabcbb";
		int ans = new Solution().lengthOfLongestSubstring(a);
		System.out.print(ans);
	}
	
	static class Solution {
	    public int lengthOfLongestSubstring(String s) {
	        int maxlength=0;
	        int substart=0;
	        int n=s.length();
	        int addr;
	        char temp;
	        String sub="";
	        for(int i=0;i<n;++i){
	            temp=s.charAt(i);
	            addr=sub.indexOf(temp);
	            if(addr == -1){
	                sub+=temp;
	            }else{
	                maxlength=Math.max(sub.length(),maxlength);
	                substart+=addr+1;
	                sub=s.substring(substart,i+1);
	            }
	        }
	        maxlength=Math.max(sub.length(),maxlength);
	        return maxlength;
	    }
	}
}
