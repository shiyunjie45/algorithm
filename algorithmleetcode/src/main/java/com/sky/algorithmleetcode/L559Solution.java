package com.sky.algorithmleetcode;

/*
给定一个 N 叉树，找到其最大深度。  最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。  例如，给定一个 3叉树 :          我们应返回其
最大深度，3。  说明:   	树的深度不会超过 1000。 	树的节点总不会超过 5000。
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class L559Solution {
    public int maxDepth(L429Solution.Node root) {
        if (root == null) {
            return 0;
        } else if (root.children.isEmpty()) {
            return 1;
        } else {
            List<Integer> heights = new ArrayList<>();
            for (L429Solution.Node child : root.children) {
                heights.add(maxDepth(child));
            }
            return Collections.max(heights) + 1;
        }
    }
} 