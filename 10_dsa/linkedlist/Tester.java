public class Tester {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.add(1, 6);
        System.out.println("Danh sách sau khi thêm các phần tử:");
        list.printList();
        System.out.println("Kích thước của danh sách: " + list.size());
        System.out.println("Danh sách có chứa 20 không? " + list.contains(20));
        System.out.println("Danh sách có chứa 3 không? " + list.contains(3));
        System.out.println("Vị trí của 2 trong danh sách: " + list.indexOf(2));
        System.out.println("Vị trí của 5 trong danh sách: " + list.indexOf(5));
        System.out.println("Xóa phần tử tại vị trí 2: " + list.remove(2));
        list.printList();
        System.out.println("Kích thước của danh sách sau khi xóa: " + list.size());
        System.out.println("Phần tử tại vị trí 0: " + list.get(0));
    }
}
