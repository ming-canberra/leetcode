package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InorderSuccessorInBST285 {
    public static void main(String[] args) {
        InorderSuccessorInBST285 thisClass = new InorderSuccessorInBST285();
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        inorder(root, p);

        if (index <list.size()){
            return list.get(index);
        }
        else{
            return null;
        }

    }

    private List<TreeNode> list = new ArrayList<>();
    private int index = -1;
    private void inorder(TreeNode root, TreeNode p){

        if (root == null){
            return;
        }

        inorder(root.left, p);

        list.add(root);

        if (index >= list.size()){
            return;
        }

        if (root == p){
            index = list.size();
        }


        inorder(root.right, p);


    }
}