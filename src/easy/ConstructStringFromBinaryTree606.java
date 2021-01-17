package easy;

public class ConstructStringFromBinaryTree606 {
    public static void main(String[] args) {
        ConstructStringFromBinaryTree606 thisClass = new ConstructStringFromBinaryTree606();
        System.out.println(thisClass.tree2str(null));
    }



    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();

        if (t == null){
            return "";
        }
        else{
            sb.append(t.val);
        }

        if (t.left == null && t.right == null){
            return sb.toString();
        }
        else if (t.left == null){
            return sb.append("()(").append(tree2str(t.right)).append(")").toString();
        }
        else if (t.right == null){
            return sb.append("(").append(tree2str(t.left)).append(")").toString();
        }

        sb.append("(").append(tree2str(t.left)).append(")(").append(tree2str(t.right)).append(")");

        return sb.toString();
    }



}