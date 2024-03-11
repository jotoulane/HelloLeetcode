package T767重构字符串;

import java.util.HashMap;
import java.util.Map;

class Date{
    char ch;
    int count;

    @Override
    public String toString() {
        return "Date{" +
                "ch=" + ch +
                ", count=" + count +
                '}';
    }

    public Date() {
    }

    public Date(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

public class Solution {
    public static void main(String[] args) {
        String s ="aabbbbcccd";
        System.out.println(new Solution().reorganizeString(s));
    }
    public String reorganizeString(String s) {
        if (s.length() < 2) {
            return s;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        Date [] dates=new Date[map.size()];
        int index=0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            dates[index++]=new Date(entry.getKey(),entry.getValue());
        }
        quickSort(dates,0,dates.length-1);
        if (dates[0].count>(s.length()+1)/2){
            return "";
        }
        for (Date d:dates) {
            System.out.println(d.toString());
        }
        char [] arr=new char[s.length()];
        for(int i=0;i<dates.length;i++){
            int loc=1;
            while (dates[i].count>0 && loc<s.length()){
                arr[loc]=dates[i].ch;
                loc+=2;
                dates[i].count--;
            }
        }
        for(int i=0;i<dates.length;i++){
            int loc=0;
            while (dates[i].count>0 && loc<s.length()){
                arr[loc]=dates[i].ch;
                loc+=2;
                dates[i].count--;
            }
        }
        String str =new String();
        for (char c :arr) {
            str=str+c;
        }
        return str;
    }


    void quickSort(Date[] dates, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        while (i < j) {
            while (i<j && dates[j].count<=dates[l].count) j--;
            while (i<j && dates[i].count>=dates[l].count) i++;
            swap(dates, i, j);
        }
        swap(dates, i, l);
        quickSort(dates, l, i - 1);
        quickSort(dates, i + 1, r);
    }
    public void swap(Date[] dates, int a, int b) {
        Date temp= dates[a];
        dates[a] = dates[b];
        dates[b] = temp;
    }
}
