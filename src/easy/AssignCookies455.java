package easy;

import java.util.Arrays;

public class AssignCookies455 {
    public static void main(String[] args) {
        AssignCookies455 thisClass = new AssignCookies455();
        System.out.println(thisClass.findContentChildren(new int[]{1,2}, new int[]{1,2,3}));

        StringBuilder sb = new StringBuilder();
    }
    public int findContentChildren(int[] children, int[] cookies) {

        Arrays.sort(children);
        Arrays.sort(cookies);
        int i = 0;
        int j = 0;
        int ans = 0;
        while (i <= children.length -1 && j <= cookies.length -1){
            if (cookies[j]>=children[i]){
                ans++;
                i++;
                j++;
            }
            else{
                j++;
            }
        }

        return ans;
    }
}