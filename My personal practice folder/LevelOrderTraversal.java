import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

class Solution {
    // BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelList.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            list.add(levelList);
        }

        return list;
    }

    // Level order successor of a node
    public int levelOrderSuccessor(TreeNode root, int target) {

        if (root == null) {
            return -1;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
                
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }

            if (currentNode.val == target) {
                return queue.peek();
            }
        }
        return -1;
    }   
    
    // Binary Tree zig zag level order traversal #103//
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean reverse = false;
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Deque<TreeNode> deque = new LinkedList<>();

        deque.offer(root);
        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            List<Integer> levelList = new ArrayList<>();

            if (!reverse) {
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = deque.poll();
                    levelList.add(currentNode.val);
                    if (currentNode.left != null) {
                        deque.offer(currentNode.left);
                    }
                
                    if (currentNode.right != null) {
                        deque.offer(currentNode.right);
                    }
                }
            }

            if (reverse) {
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = deque.poll();
                    levelList.add(currentNode.val);

                    if (currentNode.right != null) {
                        deque.offer(currentNode.right);
                    }

                    if (currentNode.left != null) {
                        deque.offer(currentNode.left);
                    }
                }
            }
            reverse = !reverse;
            list.add(levelList);
        }
        return list;
    }

    public List<List<Integer>> levelOrderReverse(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelList.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            // list.add(levelList);
            list.add(0, levelList);
        }

        return list;
    }

    // 116
    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentNode.next = queue.peek();

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            currentNode.next = null;
        }
        return root;
    }

    public Node connect2(Node node) {
        if (node == null) {
            return node;
        }

        Node leftMost = node;
        while (leftMost.next != null) {
            Node currentNode = leftMost;
            while (currentNode != null) {
                currentNode.left.next = currentNode.right;
                if (currentNode.next != null) {
                    currentNode.right.next = currentNode.next.left;
                }
                currentNode = currentNode.next;
            }
            leftMost = left.next;
        }
        return node;
    }

    // #199
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            list.add(currentNode);
        }
        return list;
    }

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Node rightMost = root;
        while (rightMost != null) {
            list.add(rightMost.val);
            rightMost = rightMost.right;
            
        }
        return list;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);
        
        return level(root, xx, 0) == level(root, yy, 0) && (!isSiblings(root, xx, yy));
    }

    public TreeNode findNode(Node root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        TreeNode findLeft = findNode(root.left, val);

        if (findleft != null) {
            return findLeft;
        }

        return findNode(root.right, val);
    }

    public int level(Node root, Node node, int level) {
        if (root == null) {
            return 0;
        }

        if (root == node) {
            return level;
        }

        int levelLeft = level(root.left, node, ++level);
        if (levelLeft != 0) {
            return levelLeft;
        }

        return levelRight = level(root.right, node, ++level);
    }

    public boolean isSiblings(Node root, Node xx, Node yy) {
        if (root == null) {
            return false;
        }

        if (root.left == xx && root.right == yy || root.right == xx && root.left == yy) {
            return true;
        }

        boolean left = isSiblings(root.left, xx, yy);
        if (!left) {
            return isSiblings(root.right, xx, yy);
        }
        return true;
    }

    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);    
        return diameter - 1;
    }

    int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter, dia);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}