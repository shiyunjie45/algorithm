package com.sky.algorithmleetcode;

/*
在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：  	行数 m 应当等于给定二叉树的高度。 	列数 n 应当总是奇数。 	根节点的值（以字符串格式
给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和
右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它
们留出任何空间。 	每个未使用的空间应包含一个空的字符串""。 	使用相同的规则输出子树。  示例 1:  输入:   1   /  2 输出: [["", "
1", ""], ["2", "", ""]]  示例 2:  输入:   1   / \  2  3   \   4 输出: [["", "", "", "1
", "", "", ""], ["", "2", "", "", "", "3", ""], ["", "", "4", "", "", "", ""]]  
示例 3:  输入:    1   / \   2  5  /  3  / 4 输出: [["", "", "", "", "", "", "", "1", "
", "", "", "", "", "", ""] ["", "", "", "2", "", "", "", "", "", "", "", "5", ""
, "", ""] ["", "3", "", "", "", "", "", "", "", "", "", "", "", "", ""] ["4", ""
, "", "", "", "", "", "", "", "", "", "", "", "", ""]]  注意: 二叉树的高度在范围 [1, 10] 中。
*/

 class L655Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int width = (1 << height) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                row.add("");
            }
            res.add(row);
        }
        fill(root, res, 0, 0, width - 1);
        return res;
    }

    private void fill(TreeNode root, List<List<String>> res, int level, int left, int right) {
        if (root == null) {
            return;
        }
        int mid = (left + right) / 2;
        res.get(level).set(mid, Integer.toString(root.val));
        fill(root.left, res, level + 1, left, mid - 1);
        fill(root.right, res, level + 1, mid + 1, right);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
} 