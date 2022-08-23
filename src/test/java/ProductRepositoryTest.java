import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    Book book1 = new Book(11, "bookName1", 1, "bookAuthor1");
    Book book2 = new Book(22, "bookName2", 12, "bookAuthor2");


    Smartphone smartphone1 = new Smartphone(1, "smartphoneName1", 1, "smartphoneManufacturer1");
    Smartphone smartphone2 = new Smartphone(2, "smartphoneName2", 2, "smartphoneManufacturer2");


    @Test
    public void shouldSaveOnlyBooks() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        Product[] expected = {book1, book2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveOnlySmartphones() {
        ProductRepository repo = new ProductRepository();
        repo.save(smartphone1);
        repo.save(smartphone2);
        Product[] expected = {smartphone1, smartphone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveBooksAndSmartphones() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);
        repo.save(smartphone2);
        Product[] expected = {book1, smartphone1, book2, smartphone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveNothing() {
        ProductRepository repo = new ProductRepository();
        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveOneProductIfIdCorrect() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);
        repo.save(smartphone2);
        repo.removeById(book2.getId());

        Product[] expected = {book1, smartphone1, smartphone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveSeveralProductsIfIdCorrect() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);
        repo.save(smartphone2);
        repo.removeById(book2.getId());
        repo.removeById(smartphone2.getId());

        Product[] expected = {book1, smartphone1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldRemoveNothingIfIdNotCorrect() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);
        repo.save(smartphone2);

        Assertions.assertThrows(RuntimeException.class, () -> repo.removeById(28));

        Product[] expected = {book1, smartphone1, book2, smartphone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}