package com.zhenzhen.demo.eureka;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestArray {

	public static void main(String[] args) {
		
		System.out.println(patternMatching("abba","dogdogdogdog"));
		
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor( 2, 5, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(1200));
		
		"test".substring(0);
		
	}
	
	public static boolean patternMatching(String pattern, String value) {
        int count_a = 0, count_b = 0;
        for (char ch: pattern.toCharArray()) {
            if (ch == 'a') {
                ++count_a;
            } else {
                ++count_b;
            }
        }
        if (count_a < count_b) {
            int temp = count_a;
            count_a = count_b;
            count_b = temp;
            char[] array = pattern.toCharArray();
            for (int i = 0; i < array.length; i++) {
                array[i] = array[i] == 'a' ? 'b' : 'a';
            }
            pattern = new String(array);
        }
        if (value.length() == 0) {
            return count_b == 0;
        }
        if (pattern.length() == 0) {
            return false;
        }
        for (int len_a = 0; count_a * len_a <= value.length(); ++len_a) {
            int rest = value.length() - count_a * len_a;
            if ((count_b == 0 && rest == 0) || (count_b != 0 && rest % count_b == 0)) {
                int len_b = (count_b == 0 ? 0 : rest / count_b);
                int pos = 0;
                boolean correct = true;
                String value_a = "", value_b = "";
                for (char ch: pattern.toCharArray()) {
                    if (ch == 'a') {
                        String sub = value.substring(pos, pos + len_a);
                        if (value_a.length() == 0) {
                            value_a = sub;
                        } else if (!value_a.equals(sub)) {
                            correct = false;
                            break;
                        }
                        pos += len_a;
                    } else {
                        String sub = value.substring(pos, pos + len_b);
                        if (value_b.length() == 0) {
                            value_b = sub;
                        } else if (!value_b.equals(sub)) {
                            correct = false;
                            break;
                        }
                        pos += len_b;
                    }
                }
                if (correct && !value_a.equals(value_b)) {
                    return true;
                }
            }
        }
        return false;
    }

	
	
	public static boolean patternMatching1(String pattern, String value) {
        int length = value.length();
        int patterLength = pattern.length();
        if(length%patterLength!=0){
            return false;
        }

        int part = length/patterLength;
        String a = value.substring(0,part);
        String b = null;
        String bTemp = null;
        for(int i=0;i<part;i++){
            bTemp = value.substring(part,2*part);
            if(!a.equals(bTemp)){
                b = bTemp;
                break;
            }
        }

        char[] charArray = pattern.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<charArray.length;i++){
            if('a' == charArray[i]){
                sb.append(a);
            }else{
                sb.append(b);
            }
        }

        if(value.equals(sb.toString())){
            return true;
        }else{
            return false;
        }

    }

}
