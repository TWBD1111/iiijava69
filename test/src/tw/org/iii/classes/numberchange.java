package tw.org.iii.classes;

import java.util.Scanner;

public class numberchange {
	private static final String[] CN_NUMERIC = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
	public static void main(String[] args) {
		

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个字符串：");
        int input = scanner.nextInt();
        
        String chineseNumber = convertToChineseNumber(input);
        System.out.println(chineseNumber);
	}
	private static String convertToChineseNumber(int number) {
        String numStr = String.valueOf(number);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numStr.length(); i++) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            sb.append(CN_NUMERIC[digit]);
        }

        return sb.toString();
    }

}
