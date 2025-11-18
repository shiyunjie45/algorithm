package com.sky.algorithmleetcode;

/*
完全二叉树是每一层（除最后一层外）都是完全填充（即，结点数达到最大）的，并且所有的结点都尽可能地集中在左侧。 设计一个用完全二叉树初始化的数据结构 CBTIns
erter，它支持以下几种操作：  	CBTInserter(TreeNode root) 使用头结点为 root 的给定树初始化该数据结构； 	CBTInse
rter.insert(int v) 将 TreeNode 插入到存在值为 node.val = v  的树中以使其保持完全二叉树的状态，并返回插入的 Tree
Node 的父结点的值； 	CBTInserter.get_root() 将返回树的头结点。      示例 1： 输入：inputs = ["CBTInser
ter","insert","get_root"], inputs = [[[1]],[2],[]] 输出：[null,1,[1,2]]  示例 2： 输入：i
nputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],
[7],[8],[]] 输出：[null,3,4,[1,2,3,4,5,6,7,8]]    提示：  	最初给定的树是完全二叉树，且包含 1 到 1000 个
结点。 	每个测试用例最多调用 CBTInserter.insert  操作 10000 次。 	给定结点或插入结点的每个值都在 0 到 5000 之间。
*/

 java.util.LinkedList;
import java.util.Queue;

class CBTInserter {
    private TreeNode root;
    private Queue<TreeNode> queue;

    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();
            if (node.left == null) {
                break;
            }
            queue.offer(node.left);
            if (node.right == null) {
                break;
            }
            queue.offer(node.right);
            queue.poll();
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        TreeNode parent = queue.peek();
        if (parent.left == null) {
            parent.left = node;
        } else {
            parent.right = node;
            queue.poll();
        }
        queue.offer(node);
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }
} 