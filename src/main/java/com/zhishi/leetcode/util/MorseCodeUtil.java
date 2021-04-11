package com.zhishi.leetcode.util;

/**
 * Created by songpb on 2020/9/15.
 * 摩尔斯转换
 */
public class MorseCodeUtil {
    private static String morseCodeToBinary(String morseCode) {
        char[] morseCodeArray = morseCode.toCharArray();
        char[] returnArray = new char[morseCodeArray.length];
        for (int i = 0; i < morseCodeArray.length; i++) {
            char code = morseCodeArray[i];
            switch (code) {
                case '.':
                    returnArray[i] = '0';
                    break;
                case '-':
                    returnArray[i] = '1';
                    break;
                default:
                    returnArray[i] = code;
                    break;
            }
        }
        return new String(returnArray);
    }

    private static String binaryToMorseCode(String binary) {
        char[] binaryArray = binary.toCharArray();
        char[] returnArray = new char[binaryArray.length];
        for (int i = 0; i < binaryArray.length; i++) {
            char code = binaryArray[i];
            switch (code) {
                case '0':
                    returnArray[i] = '.';
                    break;
                case '1':
                    returnArray[i] = '-';
                    break;
                default:
                    returnArray[i] = code;
                    break;
            }
        }
        return new String(returnArray);
    }

    public static void main(String[] args) {
//        String tranforString = MorseCodeUtil.morseCodeToBinary(".-/.-././-.--/---/..-/-/..../../-./-.-/../.-../../-.-/./-/..../../.../-..././.-/..-/-/../..-./..-/.-../.-/-./-../.-../---/...-/./.-../-.--/.-../../-/-/.-.././--./../.-./.-../..--../-.--/./.../-.-.--");
        String tranforString = MorseCodeUtil.morseCodeToBinary(".-/.-././-.--/---/..-/-/..../../-./-.-/../.-../../-.-/./-/..../../.../--./../.-./.-../..--../-.--/./.../-.-.--");
        System.out.println(tranforString);
        String retranforString = MorseCodeUtil.binaryToMorseCode(tranforString);
        System.out.println(retranforString);
    }
}
