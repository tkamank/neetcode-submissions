class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private int val;
    private int key;
    public TreeNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class TreeMap {

    //Possible HashMap storage with key being root, and arr of leaves
    TreeNode root = null;
    HashMap<Integer, TreeNode> hash = new HashMap<Integer, TreeNode>();

    public TreeMap() {
        TreeNode root = null;
    }

    public void insert(int key, int val) {
        TreeNode newNode = new TreeNode(key, val);
        if (this.root == null) {
            this.root = newNode;
            return;
        }
        TreeNode curr = this.root;
        while (true) {
            if (newNode.key < curr.key) {
                if (curr.left == null) {
                    curr.left = newNode;
                    return;
                }
                curr = curr.left;
            } else if (newNode.key > curr.key) {
                if (curr.right == null) {
                    curr.right = newNode;
                    return;
                }
                curr = curr.right;
            } else {
                curr.val = val;
                return;
            }
        }
    }

    public int get(int key) {
        TreeNode curr = this.root;
        while (curr != null) {
            if (key < curr.key) {
                curr =  curr.left;
            } else if (key > curr.key) {
                curr = curr.right;
            } else {
                return curr.val;
            }
        }
        return -1;
    }

    public int getMin() {
        TreeNode min = findMin(this.root);
        return (min != null) ? min.val : -1;
    }

    public TreeNode findMin(TreeNode node) {
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    public int getMax() {
        TreeNode curr = this.root;
        while (curr != null && curr.right != null) {
            curr = curr.right;
        }
        return (curr != null) ? curr.val : -1;
    }


    public void remove(int key) {
        this.root = this.removeHelper(this.root, key);
    }

    //Remove node with key, return root of subtree
    public TreeNode removeHelper(TreeNode curr, int key) {
        if (curr == null) {
            return null;
        }

        if (key > curr.key) {
            curr.right = removeHelper(curr.right, key);
        } else if (key < curr.key) {
            curr.left = removeHelper(curr.left, key);
        } else {
            if (curr.left == null) {
                return curr.right;
            } else if (curr.right == null) {
                return curr.left;
            } else {
                TreeNode minNode = findMin(curr.right);
                curr.key = minNode.key;
                curr.val = minNode.val;
                curr.right = removeHelper(curr.right, minNode.key);
            }
        }
        return curr;
    }

    public List<Integer> getInorderKeys() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        inOrderTraversal(root,result);
        return result;
    }

    public List<Integer> inOrderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            inOrderTraversal(root.left, result);
            result.add(root.key);
            inOrderTraversal(root.right, result);
        }
        return result;
    }
}
