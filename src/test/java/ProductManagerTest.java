
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "Сказки", 100, "Русские народные");
    Product book2 = new Book(2, "День", 150, "Василий Морев");
    Product smartphone1 = new Smartphone(3, "Apple 13", 100000, "apple");
    Product smartphone2 = new Smartphone(4, "Samsung А35", 50000, "samsung");
    Product smartphone3 = new Smartphone(4, "Xiaomi 11", 25000, "xiaomi");

    @Test
    void shouldAddIntoEmpty() {
        manager.add(book1);

        Product[] expected = {book1};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddIntoNonEmpty() {
        manager.add(book1);
        manager.add(book2);

        Product[] expected = {book1, book2};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddDifferentBook() {
        manager.add(book1);
        manager.add(book2);


        Product[] expected = {book1, book2};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldAddDifferentSmarthone() {
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);


        Product[] expected = {smartphone1, smartphone2, smartphone3};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotSearchInEmpty() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("smartphone2");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchInyWithOneItem() {
        manager.add(book1);

        Product[] expected = {};
        Product[] actual = manager.searchBy(" book1");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyResultWithWrongKeyword() {
        manager.add(book1);

        Product[] expected = {};
        Product[] actual = manager.searchBy("smartphone2");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchProductInyWithDifferentObjects() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("smartphone2");

        assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldAddNothing() {

        Product[] expected = {};
        Product[] actual =  repository.findAll();

        assertArrayEquals(expected, actual);
    }
}