package easy;

import java.util.ArrayList;
import java.util.List;

public class AddStrings415 {
    public static void main(String[] args) {
        AddStrings415 thisClass = new AddStrings415();
        System.out.println(thisClass.addStrings2("408", "5"));

        StringBuilder sb = new StringBuilder();
        //System.out.println(sb.append(1).append(2).append(3).reverse());
    }

    public String addStrings(String num1, String num2) {

        String longerString;
        String shorterString;
        if (num1.length() > num2.length()) {
            longerString = num1;
            shorterString = num2;
        } else {
            longerString = num2;
            shorterString = num1;
        }
        int leadingPartLongerStringLength = longerString.length() - shorterString.length();

        String partLongerStringDoAdding = longerString.substring(leadingPartLongerStringLength, longerString.length());

        String addedStringCommonLength = "";
        boolean plusOneFromLastRound = false;
        for (int i = partLongerStringDoAdding.length() - 1; i >= 0; i--) {
            int firstDigit = new Integer(partLongerStringDoAdding.substring(i, i + 1));
            int secondDigit = new Integer(shorterString.substring(i, i + 1));
            int digitsAdded = 0;
            if (plusOneFromLastRound) {
                digitsAdded = firstDigit + secondDigit + 1;
            } else {
                digitsAdded = firstDigit + secondDigit;
            }
            if (digitsAdded > 9) {
                plusOneFromLastRound = true;
                digitsAdded = digitsAdded % 10;
            } else {
                plusOneFromLastRound = false;
            }
            addedStringCommonLength = new Integer(digitsAdded) + addedStringCommonLength;
        }

        String toReturn = "";
        if (plusOneFromLastRound) {
            if (leadingPartLongerStringLength > 0) {
                //handle leading part
                if (leadingPartLongerStringLength == 1) {
                    toReturn = new Integer(new Integer(longerString.substring(0, 1)) + 1).toString()
                            + addedStringCommonLength;
                } else {
                    String leadingPartAddedOne = "";
                    String leadingPartLongerString = longerString.substring(0, leadingPartLongerStringLength);
                    boolean carry = true;
                    for (int i = leadingPartLongerString.length() - 1; i >= 0; i--) {
                        int currentDigit = new Integer(leadingPartLongerString.substring(i, i + 1));
                        if (currentDigit == 9 && carry) {
                            carry = true;
                            leadingPartAddedOne = "0" + leadingPartAddedOne;
                        } else {
                            if (carry) {
                                leadingPartAddedOne = (currentDigit + 1) + leadingPartAddedOne;

                            } else {
                                leadingPartAddedOne = currentDigit + leadingPartAddedOne;
                            }
                            carry = false;
                        }
                    }
                    if (carry) {
                        leadingPartAddedOne = "1" + leadingPartAddedOne;
                    }
                    toReturn = leadingPartAddedOne + addedStringCommonLength;
                }
            } else {
                toReturn = "1" + addedStringCommonLength;
            }
        } else {
            if (leadingPartLongerStringLength > 0) {
                //handle leading part
                toReturn = longerString.substring(0, leadingPartLongerStringLength) + addedStringCommonLength;
            } else {
                toReturn = addedStringCommonLength;
            }
        }


        return toReturn;
    }

    public String addStrings2(String num1, String num2) {
        int length = Math.max(num1.length(), num2.length());
        int index = 0;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (index < length) {
            int digit1 = 0;
            if (num1.length() - index > 0) {
                digit1 = num1.charAt(num1.length() - index - 1) - '0';
            }
            int digit2 = 0;
            if (num2.length() - index > 0) {
                digit2 = num2.charAt(num2.length() - index - 1) - '0';
            }
            int newDigit = (digit1 + digit2 + carry) % 10;
            carry = (digit1 + digit2 + carry) / 10;
            sb.append(Integer.valueOf(newDigit).toString());
            index++;
        }
        if (carry > 0) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}