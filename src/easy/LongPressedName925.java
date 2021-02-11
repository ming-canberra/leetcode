package easy;

public class LongPressedName925 {
    public static void main(String[] args) {
        LongPressedName925 thisClass = new LongPressedName925();
        boolean a = thisClass.isLongPressedName("leelee", "lleeelee");
            System.out.println(a);
    }
    public boolean isLongPressedName(String name, String typed) {
        int nIndex = 0;
        for (int i = 0; i < typed.length(); i++){
            char c = typed.charAt(i);
            if (nIndex == name.length()){
                if (c == name.charAt(nIndex - 1)) {
                    // do nothing
                }
                else{
                    return false;
                }
            }
            else if (name.charAt(nIndex) == c){
                    nIndex++;
            }
            else{
                if (nIndex == 0){
                    return false;
                }
                else{
                    if (name.charAt(nIndex -1) == c){
                        //do nothing
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        if (nIndex == name.length()){
            return true;
        }
        return false;
    }
}