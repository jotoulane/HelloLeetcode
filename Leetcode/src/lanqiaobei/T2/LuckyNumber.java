package lanqiaobei.T2;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumber {
    public static void main(String[] args) {
        List<Integer> luckyNumbers = new ArrayList<>();
        int count = 0;
        int number = 1;
        while (count < 2023) {
            if (isHarshadInAllBases(number)) {
                luckyNumbers.add(number);
                count++;
            }
            number++;
        }
        System.out.println("The 2023rd lucky number is " + luckyNumbers.get(2022));
    }

    private static boolean isHarshadInAllBases(int number) {
        return isHarshad(number, 10) && isHarshad(number, 2) && isHarshad(number, 8) && isHarshad(number, 16);
    }

    private static boolean isHarshad(int number, int base) {
        int a=number;
        int sum = 0;
        while (number > 0) {
            int digit = number % base;
            sum += digit;
            number /= base;
        }
        return a%sum==0;
    }
}
