package com.fqh.java.leetcode;

import lombok.var;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 比奇堡海滩
 * @version 1.0
 *  1302. 层数最深叶子节点的和
 *  输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 */
public class Solution_1302 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(8);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        node3.left = node6;
        node5.right = node7;

        int deepestLeavesSum = deepestLeavesSum(root);
        System.out.println(deepestLeavesSum);
    }

    public static int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1; //root不为null 初始化为1层
        Map<Integer, Integer> map = new HashMap<>();


        while (!queue.isEmpty()) {
            int n = queue.size();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    break;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                sum += node.val;
            }
            map.put(depth, sum); //sum可能相同, 不能当作key
            depth++;
        }
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(entrySet);

        Collections.sort(list, ((o2, o1) -> (o1.getKey() - o2.getKey())));

        return list.get(0).getValue();
    }
}
