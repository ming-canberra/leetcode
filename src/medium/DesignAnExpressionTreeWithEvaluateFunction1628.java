package medium;

public class DesignAnExpressionTreeWithEvaluateFunction1628 {
    public static void main(String[] args) {
        DesignAnExpressionTreeWithEvaluateFunction1628 thisClass = new DesignAnExpressionTreeWithEvaluateFunction1628();

    }

    /**
     * This is the interface for the expression tree Node.
     * You should not remove it, and you can define some classes to implement it.
     */

    abstract class Node {
        public abstract int evaluate();
        // define your fields here
    };


    /**
     * This is the TreeBuilder class.
     * You can treat it as the driver code that takes the postinfix input
     * and returns the expression tree represnting it as a Node.
     */

    class TreeBuilder {
        Node buildTree(String[] postfix) {
            return null;
        }
    };


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
}