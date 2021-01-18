package easy;

public class FlippingAnImage832 {
    public static void main(String[] args) {
        FlippingAnImage832 thisClass = new FlippingAnImage832();


        System.out.println(     thisClass.flipAndInvertImage(null));
    }
    public int[][] flipAndInvertImage(int[][] a) {

        for (int i = 0; i < a.length; i++){
            int[] current = a[i];
            int l=0;
            int r=current.length-1;
            while(l<r){
                int temp = current[l];
                current[l] = current[r];
                current[r] = temp;
                l++;
                r--;
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {

                a[i][j] = Math.abs(a[i][j] -1);
            }
        }
        return a;
    }
}