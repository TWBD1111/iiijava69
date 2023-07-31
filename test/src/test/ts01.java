package test;

import java.util.Arrays;

public class ts01 {

	public static void main(String[] args) {
		int x=121;

        boolean result = false;
        int temp = x;
        int after = 0;
        if(x<0){System.out.println(result);}
        while(temp != 0){
            after = after * 10 + temp % 10;
            System.out.println(after);
            temp = temp / 10;
        }
        if(x == after){result = true;}
        System.out.println(result);
        
    }
}
