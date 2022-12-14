package skypro.homework.homeworkalgorithmspart1;

import Homework_Algorithms_Part_2.IntegerListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerListImplTest {
    private IntegerListImpl integerList;

    @BeforeEach
    void setUp() {
        integerList = new IntegerListImpl();
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < 10; i++) {
            integerList.add(random.nextInt(10));
        }
    }

    @Test
    void add() {
        integerList.add(5);
        assertEquals(integerList.get(10), 5);
        assertEquals(integerList.size(), 11);
    }

    @Test
    void testAdd() {
        integerList.add(2, 10);
        assertEquals(integerList.get(2), 10);
    }

    @Test
    void set() {
        integerList.set(5, 10);
        assertEquals(integerList.get(5), 10);
    }

    @Test
    void remove() {
        integerList.remove(9);
        assertEquals(integerList.size(), 9);
    }

    @Test
    void testRemove() {
        integerList.add(5);
        assertEquals(integerList.get(10), 5);
        assertEquals(integerList.size(), 11);
        integerList.remove(5);
        assertEquals(integerList.size(), 10);
    }

    @Test
    void contains() {
        integerList.add(11);
        assertEquals(integerList.contains(11), true);
    }

    @Test
    void indexOf() {
        integerList.add(11);
        assertEquals(integerList.indexOf(11), 10);
    }

    @Test
    void lastIndexOf() {
        integerList.add(2, 50);
        assertEquals(integerList.get(2), 50);
        assertEquals(integerList.lastIndexOf(50), 2);
    }

    @Test
    void get() {
        integerList.add(2, 50);
        assertEquals(integerList.get(2), 50);
    }

    @Test
    void testEquals() {
        assertEquals(integerList.equals(new IntegerListImpl()), false);
        assertEquals(integerList.equals(integerList), true);
    }

    @Test
    void size() {
        assertEquals(integerList.size(), 10);
    }

    @Test
    void isEmpty() {
        assertEquals(integerList.isEmpty(), false);
        integerList.clear();
        assertEquals(integerList.isEmpty(), true);
    }

    @Test
    void clear() {
        integerList.clear();
        assertEquals(integerList.size(), 0);
    }

    @Test
    void toArray() {
        assertEquals(integerList.toArray().length, 10);
    }

    @Test
    void speedTest()  {
        integerList.add(9);

        // Сортировка вставкой
        long start1 = System.currentTimeMillis();
        integerList.contains(9);
        System.out.println(System.currentTimeMillis() - start1);
        // Пузырьковая сортировка
        long start2 = System.currentTimeMillis();
        integerList.contains2(9);
        System.out.println(System.currentTimeMillis() - start2);
        // Сортировка выбором
        long start3 = System.currentTimeMillis();
        integerList.contains3(9);
        System.out.println(System.currentTimeMillis() - start3);

        System.out.println("Наилучший метод сортировки: ");
        long start = Math.min(Math.min(start1, start2), start3);
        if (start == start1) {
            System.out.print("Сортировка вставкой");
        } else if (start == start2) {
            System.out.print("Пузырьковая сортировка");
        } else {
            System.out.print("Сортировка выбором");
        }
    }
}
