public class Tester {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println("Kích thước danh sách sau khi thêm phần tử: " + list.size());
        System.out.println("Phần tử tại chỉ số 2: " + list.get(2));
        list.add("E", 2);
        System.out.println("Phần tử tại chỉ số 2 sau khi chèn: " + list.get(2));
        System.out.println("Chỉ số của 'B': " + list.indexOf("B"));
        System.out.println("Chỉ số của 'H': " + list.indexOf("H"));
        System.out.println("Danh sách có chứa 'A' không: " + list.contains("A"));
        System.out.println("Danh sách có chứa 'G' không: " + list.contains("G"));
        list.remove(1);
        System.out.println("Kích thước danh sách sau khi xóa: " + list.size());
        System.out.println("Phần tử tại chỉ số 1 sau khi xóa: " + list.get(1));
        MyList<String> clonedList = list.clone();
        System.out.println("Kích thước của danh sách sao chép: " + clonedList.size());
        System.out.println("Phần tử tại chỉ số 0 của danh sách sao chép: " + clonedList.get(0));
        list.clear();
        System.out.println("Kích thước danh sách sau khi xóa tất cả: " + list.size());
        System.out.println("Danh sách có chứa 'A' sau khi clear không: " + list.contains("A"));

    }
}
