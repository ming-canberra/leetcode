package easy;

public class ReverseWordsinaStringIII557 {
    public static void main(String[] args) {
        ReverseWordsinaStringIII557 thisClass = new ReverseWordsinaStringIII557();

        System.out.println (thisClass.reverseWords("408"));

    }
    public String reverseWords(String s) {
        if (s != null){

            StringBuilder toReturn = new StringBuilder();
            String wordsArray[] = s.split(" ");
            for (int i =0; i < wordsArray.length; i ++){

                String current  = wordsArray[i];

                StringBuilder sb = new StringBuilder(current);

                wordsArray[i] = sb.reverse().toString();
                if (i == wordsArray.length -1){
                    toReturn.append(wordsArray[i]);
                }
                else{
                    toReturn.append(wordsArray[i]).append(" ");
                }
            }
            return toReturn.toString();
        }
        else{
            return null;
        }
    }
}