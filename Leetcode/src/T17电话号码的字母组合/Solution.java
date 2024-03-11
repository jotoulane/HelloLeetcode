package T17电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Character, String> m = new HashMap() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    List<String> ans = new ArrayList();
    StringBuilder t = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            dfs(0,digits);
        }
        return ans;
    }

    private void dfs(int k, String digits) {
        if (k == digits.length()) {
            ans.add(t.toString());
            return;
        }
        for (char ch: m.get(digits.charAt(k)).toCharArray()) {
            t.append(ch);
            dfs(k + 1, digits);
            t.deleteCharAt(t.length() - 1);
        }
    }
}
