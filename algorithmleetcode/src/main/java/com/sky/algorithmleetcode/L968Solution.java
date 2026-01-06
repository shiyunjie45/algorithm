package com.sky.algorithmleetcode;

/*
给定一个二叉树，我们在树的节点上安装摄像头。 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。 计算监控树的所有节点所需的最小摄像头数量。   示例 
1：  输入：[0,0,null,0,0] 输出：1 解释：如图所示，一台摄像头足以监控所有节点。  示例 2：  输入：[0,0,null,0,null,0,
null,null,0] 输出：2 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。  提示：  	给定树的节点数的范围是 [
1, 1000]。 	每个节点的值都是 0。
*/

 L968Solution {
    
    int count = 0;

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0) {
            count++;
        }
        return count;
    }

    // 后序遍历：0-该节点无覆盖，1-该节点有摄像头，2-该节点有覆盖
    private int dfs(TreeNode node) {
        if (node == null) {
            return 2; // 空节点默认被覆盖
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        // 如果左右子节点中有未被覆盖的，就在该节点上放置摄像头
        if (left == 0 || right == 0) {
            count++;
            return 1;
        }
        // 如果左右子节点中有摄像头，该节点被覆盖
        if (left == 1 || right == 1) {
            return 2;
        } else {
            return 0; // 如果左右子节点都被覆盖了，但都没有摄像头，该节点无覆盖
        }
    }
} 