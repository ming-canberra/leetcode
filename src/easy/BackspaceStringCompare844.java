package easy;

public class BackspaceStringCompare844 {
    public static void main(String[] args) {
        BackspaceStringCompare844 thisClass = new BackspaceStringCompare844();
        boolean result = thisClass.backspaceCompare("ab#c","ad#c");
        System.out.println(result);
    }
    public boolean backspaceCompare(String s, String t) {
        return convertedInversed(s).equals(convertedInversed(t));
    }

    private String convertedInversed(String input){
        StringBuilder sb = new StringBuilder();

        int counter = 0;
        for (int i = input.length() -1; i >=0; i--){
            char c = input.charAt(i);
            if (c == '#'){
                counter++;
            }
            else{
                if (counter > 0){
                    //skip
                    counter--;
                }
                else{
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}