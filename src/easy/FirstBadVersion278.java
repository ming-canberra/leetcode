package easy;

public class FirstBadVersion278 {
    public static void main(String[] args) {
        FirstBadVersion278 thisClass = new FirstBadVersion278();

    }

    private class Solution2 {
        public int firstBadVersion(int n) {
            int l = 1;
            int r = n;
            while (l < r){
                int m = l + (r - l) / 2;
                if (!isBadVersion(m)){
                    l = m + 1;
                }
                else{
                    r = m;
                }
            }
            return r;
        }
    }

    public int firstBadVersion(int n) {

        return recursiveFun(1, n);
    }

    private int recursiveFun(int start, int end){
        if (end-start <= 1)
        {
            if (isBadVersion(start)) {
                return start;
            }
            else{
                return end;
            }
        }
        int mid = end +(start-end)/2;

        if (isBadVersion(mid)){
            // search between start and mid
            return recursiveFun(start, mid);
        }
        else{
            // search between mid and end
            return recursiveFun(mid, end);
        }
    }
    private boolean isBadVersion(int i){
        return true;
    }
}