import java.io.*;

class Solution {

    static double calculateMin(double a[], int low, int high) {
        int i;
        double mini = a[low];
        for (i = low; i <= high; i++) {
            if (a[i] < mini) {
                mini = a[i];
            }
        }
        return mini;
    }

    static double calculateMax(double a[], int low, int high) {
        int i;
        double maxi = a[low];
        for (i = low; i <= high; i++) {
            if (a[i] > maxi) {
                maxi = a[i];
            }
        }
        return maxi;
    }

    static double calculateMaxDiff(double a[], int low, int high) {
        if (low >= high)
            return 0;

        int mid = (low + high) / 2;
        double leftPartition = calculateMaxDiff(a, low, mid);
        double rightPartition = calculateMaxDiff(a, mid + 1, high);
        double left = calculateMin(a, low, mid); 
        double right = calculateMax(a, mid + 1, high); 
        return Math.max(Math.max(leftPartition, rightPartition), (right - left));

    }

    static Boolean checkBaseCae(double arr[]) {
        boolean baseCase = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 1)
                baseCase = true;
            else
                baseCase = false;
        }
        return baseCase;
    }

    static void read(String filename) throws IOException {
        File file = new File(filename);
        byte[] bytes = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(bytes);
        fis.close();
        String[] valueStr = new String(bytes).trim().split("\\s+");
        double[] price = new double[valueStr.length];
        for (int i = 0; i < valueStr.length; i++)
            price[i] = Double.parseDouble(valueStr[i]);
        if (checkBaseCae(price) == true)
            System.out.println("The file " + filename + " contains the number 1 or a number less than one");
        else {
            System.out.println(filename + ": The optimal solution for " + filename + " is "
                    + calculateMaxDiff(price, 0, price.length - 1));
        }

    }

    public static void main(String[] args) throws IOException {

        read(args[0]);
        
    }
}