public class BinarySearch {
    public static int binarySearch(int[] arr, int left, int right, int value) {
        while (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == value) {
            return mid;
        }
        if (arr[mid] < value) {
            return binarySearch(arr, mid + 1, right, value);
        }
        return binarySearch(arr, left, mid - 1, value);
    }
}
