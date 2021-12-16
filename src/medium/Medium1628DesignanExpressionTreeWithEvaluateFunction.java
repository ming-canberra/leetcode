package medium;

import java.util.*;

public class Medium1628DesignanExpressionTreeWithEvaluateFunction {
    class Node {
        Node left = null;
        Node right = null;
        String value;
        public Node(String input, Node left, Node right){
            value = input;
            this.left = left;
            this.right = right;
        }
        public int evaluate(){
            if (value.equals("+")){
                return left.evaluate() + right.evaluate();
            }
            else if (value.equals("-")){
                return left.evaluate() - right.evaluate();
            }
            else if (value.equals("*")){
                return left.evaluate() * right.evaluate();
            }
            else if (value.equals("/")){
                return left.evaluate() / right.evaluate();
            }
            else{
                return Integer.valueOf(value);
            }
        }
        // define your fields here
    };


    /**
     * This is the TreeBuilder class.
     * You can treat it as the driver code that takes the postinfix input
     * and returns the expression tree represnting it as a Node.
     */

    class TreeBuilder {
        Node buildTree(String[] postfix) {
            Set<String> operands = new HashSet<>();
            operands.add("+");
            operands.add("-");
            operands.add("*");
            operands.add("/");
            Stack<Node> stack = new Stack<>();
            for (int i = 0; i < postfix.length; i++){
                if (operands.contains(postfix[i])){
                    Node right = stack.pop();
                    Node left = stack.pop();
                    stack.push( new Node((postfix[i]), left, right) );
                }
                else{
                    stack.push( new Node((postfix[i]), null, null) );
                }
            }
            return stack.pop();
        }
    };

}