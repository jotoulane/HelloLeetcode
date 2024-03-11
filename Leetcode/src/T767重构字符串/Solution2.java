package T767重构字符串;

public class Solution2 {
    //767 重构字符串
    public String reorganizeString(String s) {
        char[]  arr = s.toCharArray();
        int[] count = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) { //统计每个字符出现的次数
            count[arr[i] - 'a']++;
        }
        int max = 0, mid = (len+1)>>1;
        int alphabet = 0;
        //找出出现最多的字符
        for (int i = 0; i < count.length; i++) {
            if (count[i]>max){
                max =count[i];
                alphabet = i;
                //当出现最多的字符大于一半的话，就直接返回
                if (max > mid){
                    return "";
                }
            }
        }
/**
 * 到达这里就说明可以组成一个两相邻字符不同的字符串
 * 所以下一步就是返回一个两不相邻的字符串res
 * 整体思想就是把出现最多的字符串放到偶数位上
 */
        char[] res = new char[len];
//        在这里维护一个index，用于填入字符
        int index = 0;
        while(count[alphabet]-- > 0){
            res[index] = (char)(alphabet+'a');
            index += 2;
        }
//        把剩余的字符放到空位上
        for (int i = 0; i < count.length; i++) {
            while(count[i]-- > 0){
//                如果到达了res的尽头，就说明偶数已经排完了，就需要从奇数开始进行填充
                if (index >= res.length){
                    index = 1;
                }
                res[index] = (char)(i + 'a');
                index += 2;
            }
        }
        return new String(res);
    }
}
