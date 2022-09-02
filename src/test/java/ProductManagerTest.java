import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    Repository repository = new Repository();
    ProductManager manager = new ProductManager(repository);

    Book book1 = new Book(8, "A Street Cat Named Bob", 450,"James Bowen");
    Book book2 = new Book(21,"Flowers for Algernon", 390, "Daniel Keyes");
    Smartphone smartphone1 = new Smartphone(13, "iPhone", 99000,"Apple");
    Smartphone smartphone2 = new Smartphone(11, "iPhone", 54000, "Apple");


    @Test

    public void displayAllProducts() {

        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone1);
        repository.add(smartphone2);

        Product[] expected = {book1, book2, smartphone1,smartphone2};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void removeProductById() {

        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone1);
        repository.add(smartphone2);
        repository.removeById(book2.getId());

        Product[] expected = {book1, smartphone1, smartphone2};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void displayMultipleProducts() {

        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = {smartphone1, smartphone2};
        Product[] actual = manager.searchBy("iPhone");

        Assertions.assertArrayEquals(expected, actual);
    }
}

