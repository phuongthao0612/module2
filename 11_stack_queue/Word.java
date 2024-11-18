import java.util.TreeMap;

public class Word {
    public static void main(String[] args) {
        String str = "ha Ho Hi ha he";
        TreeMap<String, Integer> map = new TreeMap<>();
        String[] words = str.toLowerCase().split(" ");
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        System.out.println(map);
    }
}
