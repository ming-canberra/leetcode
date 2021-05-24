package medium;

public class KokoEatingBananas875 {
    public static void main(String[] args) {
        KokoEatingBananas875 thisClass = new KokoEatingBananas875();
    }
    /**
     *O(NlogM) N is the number of piles and M is the max size in a pile
     */
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int i : piles){
            max = Math.max(max, i);
        }
        // possible result, 1 to max inclusive
        int l = 0;
        int r = max + 1;
        while (l + 1 < r){
            int m = l + (r - l) / 2;
            if (canEatAll(piles, h, m)){
                r = m;
            }
            else{
                l = m;
            }
        }
        return r;
    }
    private boolean canEatAll(int[] piles, int h, int speed) {
        int time = 0;
        for (int i = 0; i < piles.length; i++){
            int tmp = piles[i] / speed;
            if (piles[i] % speed == 0){
                time += tmp;
            }
            else{
                time += tmp + 1;
            }

            if (time > h){
                return false;
            }
        }
        return time <= h;
    }
}