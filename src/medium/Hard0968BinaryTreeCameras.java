package medium;
import java.util.*;

public class Hard0968BinaryTreeCameras {
    class Solution {
        private final int I_AM_CAMERA = -1;
        private final int I_AM_NOT_CAMERA = 0;
        private final int MY_PARENT_MUST_BE_CAMERA = 1;
        private int camera = 0;
        public int minCameraCover(TreeNode root) {
            if (dfs(root) == MY_PARENT_MUST_BE_CAMERA){
                camera++;
            }
            return camera;
        }
        private int dfs(TreeNode root){
            if (root == null){
                return I_AM_NOT_CAMERA;
            }
            if (root.left == null && root.right == null){
                return MY_PARENT_MUST_BE_CAMERA;
            }
            int lResult = dfs(root.left);
            int rResult = dfs(root.right);
            if (lResult == I_AM_NOT_CAMERA && rResult == I_AM_NOT_CAMERA){
                return MY_PARENT_MUST_BE_CAMERA;
            }
            if (lResult == MY_PARENT_MUST_BE_CAMERA || rResult == MY_PARENT_MUST_BE_CAMERA){
                camera++;
                return I_AM_CAMERA;
            }
            return I_AM_NOT_CAMERA;
        }
    }
}