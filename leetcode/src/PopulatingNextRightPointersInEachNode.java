import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointersInEachNode extends BaseNode {
    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode instance = new PopulatingNextRightPointersInEachNode();
    }
    public Node connect(Node root) {
        if (root != null) {
            List<Node> nodeList = new ArrayList<Node>();
            nodeList.add(root);
            while (!nodeList.isEmpty()) {
                nodeList = visit(nodeList);
            }
        }
        return root;
    }
    private List<Node> visit(List<Node> nodeList) {

        List<Node> result = new ArrayList<Node>();
        for (Node node : nodeList) {
            if (node.left != null) {
                result.add(node.left);
            }
            if (node.right != null) {
                result.add(node.right);
            }
        }
        if (!result.isEmpty()) {
            Node previous = null;
            for (Node node : result) {
                if (previous == null) {
                    previous = node;
                } else {
                    previous.next = node;
                    previous = node;
                }
            }
        }
        return result;
    }
}
