package T436寻找右区间;

import java.util.Arrays;
import java.util.Comparator;

public class Solution3 {
    public int[] findRightInterval(int[][] intervals) {
        int length = intervals.length;
        int[] res = new int[length];
        MyNode[] list = new MyNode[length];
        for (int i = 0; i < length; i++) {
            list[i] = new MyNode(intervals[i][0], intervals[i][1], i);
        }
        Arrays.sort(list, new Comparator<MyNode>() {
            public int compare(MyNode a, MyNode b) {
                return a.start - b.start;
            }
        });
        for (int i = 0; i < length; i++) {
            res[list[i].index] = greater(list, 0, length - 1, list[i].end);
        }
        return res;
    }

    class MyNode {
        int start;   // 区间的起点
        int end;     // 区间的终点
        int index;   // 在原数组的下标

        public MyNode(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    // 二分查找第一个区间的起点大于等于target的数组元素的下标，数组是升序排序，范围是[left,right]
    private int greater(MyNode[] list, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (list[mid].start < target) {
                left = mid + 1;
            } else {
                if (mid - 1 >= left && list[mid - 1].start >= target) {
                    right = mid - 1;
                } else {
                    return list[mid].index;
                }
            }
        }
        return -1;        // list[right].start<target
    }
}
