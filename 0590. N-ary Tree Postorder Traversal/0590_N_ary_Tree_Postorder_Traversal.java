class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            for (Node child : node.children) {
                stack.push(child);
            }
        }

        Collections.reverse(result);
        return result;   
    }
}
