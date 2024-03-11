package T49字母异位分组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Solution().groupAnagrams(s));

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {   //遍历数组
            char[] chars = s.toCharArray(); //将字符串转化为字符数组，然后对字符数组进行排序
            Arrays.sort(chars);
            String key = new String(chars);  //将有序的字符数组转化为字符串
            List<String> list = map.getOrDefault(key, new ArrayList());
            list.add(s);
            System.out.println(list);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
