package test.daos;

import static org.junit.Assert.*;
import library.daos.BookMapDAO;
import library.interfaces.entities.IBook;

import org.junit.Before;
import org.junit.Test;

import test.BaseTest;
import test.data.DummyDataGenerator;

public class TestBookMapDAO extends BaseTest {

	private BookMapDAO bookMapDao;
	
	@Before
	public void setupTest() {
		bookMapDao = new BookMapDAO(bookHelper);
	}
	
	@Test
	public void testBookMapDAO() {
		assertNotNull(bookMapDao);
	}
	
	@Test
	public void testAddBook() {
		int count = bookMapDao.listBooks().size();
		final IBook book = bookMapDao.addBook(DummyDataGenerator.AUTHOR, DummyDataGenerator.TITLE, DummyDataGenerator.CALL_NUMBER);
		
		assertEquals(count + 1, bookMapDao.listBooks().size());
		assertEquals(DummyDataGenerator.AUTHOR, book.getAuthor());
		assertEquals(DummyDataGenerator.TITLE, book.getTitle());
		assertEquals(DummyDataGenerator.CALL_NUMBER, book.getCallNumber());
	}

	@Test
	public void testGetBookByID() {
		final IBook book = bookMapDao.addBook(DummyDataGenerator.AUTHOR, DummyDataGenerator.TITLE, DummyDataGenerator.CALL_NUMBER);
		final IBook fetchedBook = bookMapDao.getBookByID(book.getID());
		
		assertEquals(book, fetchedBook);
	}

	@Test
	public void testListBooks() {
		int count = bookMapDao.listBooks().size();
		final IBook book = bookMapDao.addBook(DummyDataGenerator.AUTHOR, DummyDataGenerator.TITLE, DummyDataGenerator.CALL_NUMBER);
		
		assertEquals(count + 1, bookMapDao.listBooks().size());
		assertEquals(book.getAuthor(), bookMapDao.listBooks().get(count).getAuthor());
		assertEquals(book.getTitle(), bookMapDao.listBooks().get(count).getTitle());
		assertEquals(book.getCallNumber(), bookMapDao.listBooks().get(count).getCallNumber());
		assertEquals(book.getID(), bookMapDao.listBooks().get(count).getID());
	}

	@Test
	public void testFindBooksByAuthor() {
		final String author = "new author";
		int count = bookMapDao.findBooksByAuthor(author).size();

		final IBook book = bookMapDao.addBook(author, DummyDataGenerator.TITLE, DummyDataGenerator.CALL_NUMBER);
		int newCount = bookMapDao.findBooksByAuthor(author).size();
		assertEquals(count + 1, newCount);
		assertEquals(book, bookMapDao.findBooksByAuthor(author).get(0));
	}

	@Test
	public void testFindBooksByTitle() {
		final String title = "new title";
		int count = bookMapDao.findBooksByTitle(title).size();

		final IBook book = bookMapDao.addBook(DummyDataGenerator.AUTHOR, title, DummyDataGenerator.CALL_NUMBER);
		int newCount = bookMapDao.findBooksByTitle(title).size();
		assertEquals(count + 1, newCount);
		assertEquals(book, bookMapDao.findBooksByTitle(title).get(0));
	}

	@Test
	public void testFindBooksByAuthorTitle() {
		final String author = "new author";
		final String title = "new title";
		int count = bookMapDao.findBooksByAuthorTitle(author, title).size();

		final IBook book = bookMapDao.addBook(author, title, DummyDataGenerator.CALL_NUMBER);
		int newCount = bookMapDao.findBooksByAuthorTitle(author, title).size();
		assertEquals(count + 1, newCount);
		assertEquals(book, bookMapDao.findBooksByAuthorTitle(author, title).get(0));
	}

}
