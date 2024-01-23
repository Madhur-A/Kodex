
/*
 *
 * Copyright (c) 2024
 * A. Madhur
 *
 * Permission to use, copy, modify, distribute and sell this software
 * and its documentation for any purpose is hereby granted without fee,
 * provided that the above copyright notice appear in all copies and
 * that both that copyright notice and this permission notice appear
 * in supporting documentation. A. Madhur makes no representations
 * about the suitability of this software for any purpose. It is provided
 * "as is" without express or implied warranty.
 */

// date: 23rd of January, 2024
// url: https://leetcode.com/problems/trim-a-binary-search-tree

// note: 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root != null) {
            if(root.val < low) {
                return trimBST(root.right, low, high);
            }
            if(root.val > high) {
                return trimBST(root.left, low, high);
            }
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
        return root;
    }
}
