package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 331. 验证二叉树的前序序列化
 */
public class Solution_331 {

    public static void main(String[] args) {
        String data = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(isValidSerialization(data));
    }

    public static boolean isValidSerialization(String preorder) {
        LinkedList<String> linkedList = hepler(preorder);
        TreeNode root = isPreOrder(linkedList);
        StringBuilder sb = new StringBuilder();
        String data = preOrder(sb, root);
        return data.substring(0, data.length() - 1).equals(preorder);
    }

    public static LinkedList<String> hepler(String preorder) {
        LinkedList<String> linkedList = new LinkedList<>();
        String[] splits = preorder.split(",");
        for (String s : splits) {
            linkedList.add(s);
        }
        return linkedList;
    }

    public static TreeNode isPreOrder(LinkedList<String> list) {
        if (list == null) {
            return null;
        }
        String first = list.removeFirst();
        if (first.equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = isPreOrder(list);
        root.right = isPreOrder(list);
        return root;
    }

    public static String preOrder(StringBuilder sb, TreeNode root) {
        if (root == null) {
            sb.append("#").append(",");
            return null;
        }
        sb.append(root.val).append(",");
        preOrder(sb, root.left);
        preOrder(sb, root.right);
        return sb.toString();
    }
}
