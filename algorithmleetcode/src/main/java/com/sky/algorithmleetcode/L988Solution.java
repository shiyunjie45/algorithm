package com.sky.algorithmleetcode;

/*
给定一颗根结点为 root 的二叉树，树中的每一个结点都有一个从 0 到 25 的值，分别代表字母 'a' 到 'z'：值 0 代表 'a'，值 1 代表 'b
'，依此类推。 找出按字典序最小的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。 （小贴士：字符串中任何较短的前缀在字典序上都是较小的：例如，在字典序
上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。）     示例 1：  输入：[0,1,2,3,4,3,4] 输出："dba"  示例 2： 
 输入：[25,1,3,1,3,0,2] 输出："adz"  示例 3：  输入：[2,2,1,null,1,0,null,0] 输出："abc"    提示：
  	给定树的结点数介于 1 和 8500 之间。 	树中的每个结点都有一个介于 0 和 25 之间的值。
*/

 L988Solution {
    String res = null;

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return res;
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return;

        sb.append((char) (root.val + 'a')); //将当前节点的值加到字符串sb中

        if (root.left == null && root.right == null) { //当前节点是叶子节点
            String curStr = sb.reverse().toString(); //将sb翻转得到从叶子节点到根节点的字符串
            sb.reverse(); //将sb翻转回来
            if (res == null || curStr.compareTo(res) < 0) { //更新最小字典序的字符串
                res = curStr;
            }
        } else {
            dfs(root.left, sb);
            dfs(root.right, sb);
        }
        sb.deleteCharAt(sb.length() - 1);//回溯
    }
} 