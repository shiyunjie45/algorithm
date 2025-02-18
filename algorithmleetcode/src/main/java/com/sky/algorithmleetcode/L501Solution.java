package com.sky.algorithmleetcode;

/*
给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 假定 BST 有如下定义：  	结点左子树中所含结点的值小于等于当前
结点的值 	结点右子树中所含结点的值大于等于当前结点的值 	左子树和右子树都是二叉搜索树  例如： 给定 BST [1,null,2,2],   1   \  
 2   /  2  返回[2]. 提示：如果众数超过1个，不需考虑输出顺序 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
*/

 java.util.ArrayList;
import java.util.List;

public class L501Solution {
    TreeNode pre;
    int maxCount = 0;
    int curCount = 0;

    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();
        inorder(root, modes);
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inorder(TreeNode node, List<Integer> modes) {
        if (node == null) return;

        inorder(node.left, modes);

        // 更新当前出现次数
        if (pre != null && node.val == pre.val) {
            curCount++;
        } else {
            curCount = 1;
        }

        // 更新最大出现次数及众数
        if (curCount > maxCount) {
            maxCount = curCount;
            modes.clear();
            modes.add(node.val);
        } else if (curCount == maxCount) {
            modes.add(node.val);
        }

        pre = node;
        inorder(node.right, modes);
    }
} 