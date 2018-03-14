package hackerrank.java.Advanced;

/*
 * https://www.hackerrank.com/challenges/java-vistor-pattern/problem
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

enum Color {
	RED, GREEN
}

abstract class Tree {

	private int value;
	private Color color;
	private int depth;

	public Tree(int value, Color color, int depth) {
		this.value = value;
		this.color = color;
		this.depth = depth;
	}

	public int getValue() {
		return value;
	}

	public Color getColor() {
		return color;
	}

	public int getDepth() {
		return depth;
	}

	public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

	private ArrayList<Tree> children = new ArrayList<>();

	public TreeNode(int value, Color color, int depth) {
		super(value, color, depth);
	}

	public void accept(TreeVis visitor) {
		visitor.visitNode(this);

		for (Tree child : children) {
			child.accept(visitor);
		}
	}

	public void addChild(Tree child) {
		children.add(child);
	}
}

class TreeLeaf extends Tree {

	public TreeLeaf(int value, Color color, int depth) {
		super(value, color, depth);
	}

	public void accept(TreeVis visitor) {
		visitor.visitLeaf(this);
	}
}

abstract class TreeVis {
	public abstract int getResult();

	public abstract void visitNode(TreeNode node);

	public abstract void visitLeaf(TreeLeaf leaf);

}

//must return the sum of the values in the tree's leaves only.
class SumInLeavesVisitor extends TreeVis {
	int sum = 0;

	public int getResult() {
		// implement this
		return sum;
	}

	public void visitNode(TreeNode node) {
		// implement this
	}

	public void visitLeaf(TreeLeaf leaf) {
		// implement this
		sum += leaf.getValue();
	}
}

/*
 * must return the product of values stored in all red nodes, including leaves, 
 * Note that the product of zero values is equal to .
 */
class ProductOfRedNodesVisitor extends TreeVis {
	private long product = 1;
	private final int M = 1000000007;

	public int getResult() {
		// implement this
		return (int) product;
	}

	public void visitNode(TreeNode node) {
		// implement this
		int value = node.getValue();
		if (value == 0) {
			value = 1;
		}
		if (Color.RED == node.getColor()) {
			product = (product * value) % M;
		}
	}

	public void visitLeaf(TreeLeaf leaf) {
		// implement this
		int value = leaf.getValue();
		if (value == 0) {
			value = 1;
		}
		if (Color.RED == leaf.getColor()) {
			product = (product * value) % M;
		}
	}
}

/*
 * 
 * must return the absolute difference between 
 * the sum of values stored in the tree's non-leaf nodes at even depth 
 * and the sum of values stored in the tree's green leaf nodes. 
 * Recall that zero is an even number.
 */
class FancyVisitor extends TreeVis {
	int nonLeafEvenNodeValue = 0;
	int greenLeafValue = 0;

	public int getResult() {
		// implement this
		return Math.abs(nonLeafEvenNodeValue - greenLeafValue);
	}

	public void visitNode(TreeNode node) {
		// implement this
		if (node.getDepth() % 2 == 0) {
			nonLeafEvenNodeValue += node.getValue();
		}
	}

	public void visitLeaf(TreeLeaf leaf) {
		// implement this
		if (Color.GREEN == leaf.getColor()) {
			greenLeafValue += leaf.getValue();
		}
	}
}

/*
 * Input Format

The first line contains a single integer, n, denoting the number of nodes in the tree. 
The second line contains n space-separated integers describing the respective values of x1,x2,..xn. 
The third line contains  space-separated binary integers describing the respective values of c1,c2,..cn. 
Each ci denotes the color of the i node, where 0 denotes red and 1 denotes green. 
Each of the n-1 subsequent lines contains two space-separated integers, ui and vi, describing an edge between nodes ui and vi.
 * 
 * Sample Input
5
4 7 2 5 12
0 1 0 0 1
1 2
1 3
3 4
3 5
 * 
 * 
 * Sample Output

24
40
15

 */
public class VisitorPatternDemo {
	private static int nodeValues[];
	private static Color nodeColors[];
	private static Map<Integer, Set<Integer>> nodesMap = new HashMap<>();

	public static Tree solve() {
		// read the tree from STDIN and return its root as a return value of
		// this function
		Scanner in = new Scanner(System.in);

		int numberOfNodes = in.nextInt();

		nodeValues = new int[numberOfNodes];
		for (int index = 0; index < numberOfNodes; index++) {
			nodeValues[index] = in.nextInt();
		}

		nodeColors = new Color[numberOfNodes];
		for (int index = 0; index < numberOfNodes; index++) {
			nodeColors[index] = Color.values()[in.nextInt()];
		}

		Tree rootNode;
		if (numberOfNodes == 1) {
			rootNode = new TreeLeaf(nodeValues[0], nodeColors[0], 0);
		} else {
			for (int index = 0; index < (numberOfNodes - 1); index++) {
				int u = in.nextInt();
				int v = in.nextInt();
				Set<Integer> uEdges = nodesMap.get(u);
				if (uEdges == null) {
					uEdges = new HashSet<>();
				}
				uEdges.add(v);
				nodesMap.put(u, uEdges);
				Set<Integer> vEdges = nodesMap.get(v);
				if (vEdges == null) {
					vEdges = new HashSet<>();
				}
				vEdges.add(u);
				nodesMap.put(v, vEdges);
			}

			rootNode = new TreeNode(nodeValues[0], nodeColors[0], 0);
			Set<Integer> rootEdges = nodesMap.get(1);
			Iterator<Integer> rootIterator = rootEdges.iterator();
			while (rootIterator.hasNext()) {
				Integer nodeIdentifier = rootIterator.next();
				nodesMap.get(nodeIdentifier).remove(1);
				createEdge(rootNode, nodeIdentifier);
			}
		}

		return rootNode;
	}

	private static void createEdge(Tree parentNode, Integer nodeIdentifier) {

		Set<Integer> nodeEdges = nodesMap.get(nodeIdentifier);
		boolean hasChild = false;
		if (nodeEdges != null && !nodeEdges.isEmpty())
			hasChild = true;

		if (hasChild) {
			TreeNode node = new TreeNode(nodeValues[nodeIdentifier - 1],
					nodeColors[nodeIdentifier - 1], parentNode.getDepth() + 1);
			((TreeNode) parentNode).addChild(node);
			Iterator<Integer> nodeIterator = nodeEdges.iterator();
			while (nodeIterator.hasNext()) {
				Integer neighborNodeIdentifier = nodeIterator.next();
				nodesMap.get(neighborNodeIdentifier).remove(nodeIdentifier);
				createEdge(node, neighborNodeIdentifier);
			}
		} else {
			TreeLeaf leaf = new TreeLeaf(nodeValues[nodeIdentifier - 1],
					nodeColors[nodeIdentifier - 1], parentNode.getDepth() + 1);
			((TreeNode) parentNode).addChild(leaf);
		}
	}

	public static void main(String[] args) {
		Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
		ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
		FancyVisitor vis3 = new FancyVisitor();

		root.accept(vis1);
		root.accept(vis2);
		root.accept(vis3);

		int res1 = vis1.getResult();
		int res2 = vis2.getResult();
		int res3 = vis3.getResult();

		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
	}
}
