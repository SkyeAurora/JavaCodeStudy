package src.com.huahua.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/7/29
 */
public class LCR48 {
    public static void main(String[] args) {
        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(ser.serialize(root));
        TreeNode ans = deser.deserialize(ser.serialize(root));

        System.out.println(ans);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    // Encodes a tree to a single string.
    // 广度优先搜索
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t == null) {
                res.add(null);
            } else {
                res.add(t.val);
                queue.offer(t.left);
                queue.offer(t.right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<TreeNode> res = new ArrayList<>();
        String[] content = data.substring(1, data.length() - 1).trim().split(",\\s*");
        if (content.length == 0) {
            return null;
        }
        for (String s : content) {
            TreeNode t = "null".equals(s) ? null : new TreeNode(Integer.parseInt(s));
            res.add(t);
            TreeNode node = res.get((res.size() - 1) / 2);
            if (node != null && res.size() % 2 == 0) {
                node.left = t;
            } else if (node != null) {
                node.right = t;
            }
        }
        return res.get(0);
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
