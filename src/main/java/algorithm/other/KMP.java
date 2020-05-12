package algorithm.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : KMP
 * @Author : TCW
 * @Date: 2020-05-12 10:50
 */
public class KMP {


    /**
     * 字符串匹配
     * @param text
     * @param pattern
     * @return
     */
    List<Integer> search(String text, String pattern) {
        List<Integer> positions = new ArrayList<Integer>();
        int[] maxMatchLengths = calculateMaxMatchLengths(pattern);
        //count记录已匹配的字符数量
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            while (count > 0 && pattern.charAt(count) != text.charAt(i)) {
                count = maxMatchLengths[count - 1];
            }
            if (pattern.charAt(count) == text.charAt(i)) {
                count++;
            }
            if (count == pattern.length()) {
                positions.add(i - pattern.length() + 1);
                count = maxMatchLengths[count - 1];
            }
        }
        return positions;
    }


    /**
     * 计算next数组
     * 即子串最长的相等的前缀和后缀
     * @param pattern
     * @return
     */
    int[] calculateMaxMatchLengths(String pattern) {
        int[] maxMatchLengths = new int[pattern.length()];
        int maxLength = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (maxLength > 0 && pattern.charAt(maxLength) != pattern.charAt(i)) {
                maxLength = maxMatchLengths[maxLength - 1];
            }
            if (pattern.charAt(maxLength) == pattern.charAt(i)) {
                maxLength++;
            }
            maxMatchLengths[i] = maxLength;
        }
        return maxMatchLengths;
    }




}
