package com.sky.algorithmleetcode;

/*
满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。 答案中
每个树的每个结点都必须有 node.val=0。 你可以按任何顺序返回树的最终列表。   示例： 输入：7 输出：[[0,0,0,null,null,0,0,n
ull,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,nul
l,null,0,0],[0,0,0,0,0,null,null,0,0]] 解释：    提示：  	1
*/

 L894Solution {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if(N % 2 == 0) {  // N为偶数时，不存在满二叉树
            return res;
        }
        if(N == 1) {  // N为1时，只有一个节点构成一棵树
            TreeNode root = new TreeNode(0);
            res.add(root);
            return res;
        }
        for(int i = 1; i < N; i+=2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i - 1);
            for(TreeNode l : left) {
                for(TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
} 