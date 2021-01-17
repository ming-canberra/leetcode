package easy;

public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        ContainerWithMostWater11 thisClass = new ContainerWithMostWater11();

        System.out.println(thisClass.maxArea2(new int[]{2,3,4,5,18,17,6}));
    }
    public int maxArea(int[] height) {
        int re = 0;
        for (int i = 0; i < height.length -1 ; i++){
            for (int j = i +1; j < height.length;j++){
                re = Math.max(re, (j-i) * Math.min(height[j], height[i]));
            }
        }

        return re;
    }

    /*this does not work*/
    public int maxArea2(int[] height) {

        return 111;
    }
}