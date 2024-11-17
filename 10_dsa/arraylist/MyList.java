import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] element;

    public MyList() {
        element = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        element = new Object[capacity];
    }

    private void ensureCapa() {
        if (size == element.length) {
            int newSize = element.length * 2;
            element = Arrays.copyOf(element, newSize);
        }
    }

    public void add(E e) {
        ensureCapa();
        element[size++] = e;
    }

    public boolean add(E e, int index) {
        if (index >= 0 && index <= size) {
            ensureCapa();
            for (int i = size; i > index; i--) {
                element[i] = element[i - 1];
            }
            element[index] = e;
            size++;
            return true;
        }
        return false;
    }

    public E get(int index) {
        if (index >= 0 && index < size) {
            return (E) element[index];
        }
        return null;
    }

    @Override
    public MyList clone() {
        MyList<E> clone = new MyList<>(element.length);
        for (int i = 0; i < size; i++) {
            clone.add((E) element[i]);
        }
        return clone;
    }

    public int size() {
        return size;
    }

    public boolean remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                element[i] = element[i + 1];
            }
            element[size - 1] = null;
            size--;
            return true;
        }
        return false;
    }

    public void clear() {
        Arrays.fill(element, 0, size, null);
        size = 0;
    }

    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (element[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }
}
