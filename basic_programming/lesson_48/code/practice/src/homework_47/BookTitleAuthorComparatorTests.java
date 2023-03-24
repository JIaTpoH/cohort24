package homework_47;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;
import org.junit.jupiter.api.Test;

// Напишите автотесты с использованием JUnit для BookTitleAuthorComparator.
//
// Проверьте краевые случаи, предусмотрите разные варианты.
public class BookTitleAuthorComparatorTests {

  private Comparator<Book> comparator = new BookTitleAuthorComparator();

  @Test
  public void differentTitleComparison() {
    // сравниваем две книги с разными названиями

    // arrange
    Book book1 = new Book("Author", "A", 25);
    Book book2 = new Book("Author", "B", 25);

    // act
    int result = comparator.compare(book1, book2);
    int result2 = comparator.compare(book2, book1);

    // assert
    assertTrue(result < 0);
    assertTrue(result2 > 0);
  }

  // Вместо этого теста мы в каждом тесте сравниваем дважды и проверяем, что знаки разные.
  // Это поможет, если сломается какое-то конкретное сравнение.
//  @Test
//  public void consistency() {
//    Book book1 = new Book("Author 1", "Title 1", 1);
//    Book book2 = new Book("Author 2", "Title 2", 2);
//
//    int result1 = comparator.compare(book1, book2);
//    int result2 = comparator.compare(book2, book1);
//
//    assertTrue(result1 * result2 < 0); // результаты должны получиться с разными знаками
//  }

  @Test
  public void sameTitleDifferentAuthorComparison() {
    // сравниваем две книги с одинаковыми названиями и разными авторами

    // arrange
    Book book1 = new Book("A", "Title", 25);
    Book book2 = new Book("B", "Title", 25);

    // act
    int result = comparator.compare(book1, book2);
    int result2 = comparator.compare(book2, book1);

    // assert
    assertTrue(result < 0);
    assertTrue(result2 > 0);
  }

  @Test
  public void sameTitleAuthorDifferentPagesComparison() {
    // сравниваем две книги с одинаковыми названиями и авторами, но разным количеством страниц

    // arrange
    Book book1 = new Book("Author", "Title", 25);
    Book book2 = new Book("Author", "Title", 26);

    // act
    int result = comparator.compare(book1, book2);
    int result2 = comparator.compare(book2, book1);

    // assert
    assertEquals(0, result);
    assertEquals(0, result2);
  }
}
