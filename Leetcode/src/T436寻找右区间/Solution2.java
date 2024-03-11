package T436寻找右区间;

public class Solution2 {
    public int[] findRightInterval(int[][] intervals) {
        int length = intervals.length;
        int[][] startIntervals = new int[length][2];
        int[][] endIntervals = new int[length][2];
        for (int i = 0; i < length; i++) {
            startIntervals[i][0] = intervals[i][0];
            startIntervals[i][1] = i;
            endIntervals[i][0] = intervals[i][1];
            endIntervals[i][1] = i;
        }
        quickSort(startIntervals, 0, length - 1);
        quickSort(endIntervals, 0, length - 1);
//        Arrays.sort(startIntervals, (o1, o2) -> o1[0] - o2[0]);
//        Arrays.sort(endIntervals, (o1, o2) -> o1[0] - o2[0]);

        int[] ans = new int[length];
        for (int i = 0, j = 0; i < length; i++) {
            while (j < length && endIntervals[i][0] > startIntervals[j][0]) {
                j++;
            }
            if (j < length) {
                ans[endIntervals[i][1]] = startIntervals[j][1];
            } else {
                ans[endIntervals[i][1]] = -1;
            }
        }
        return ans;
    }


    public void quickSort(int[][] arr, int l, int r) {
        if (l >= r) return;
        int i = l;
        int j = r;
        while (i < j) {
            while (i < j && arr[j][0] >= arr[l][0]) j--;
            while (i < j && arr[i][0] <= arr[l][0]) i++;
            swap(arr, i, j);
        }
        swap(arr, l, i);
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }

    public void swap(int[][] arr, int a, int b) {
        int temp1 = arr[a][0];
        int temp2 = arr[a][1];
        arr[a][0] = arr[b][0];
        arr[a][1] = arr[b][1];
        arr[b][0] = temp1;
        arr[b][1] = temp2;
    }
}
