package test.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import library.interfaces.entities.EBookState;
import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;

import org.junit.Before;
import org.junit.Test;

import test.BaseTest;
import test.data.DummyDataGenerator;

public class TestBook extends BaseTest {
	
	@Before
	public void setUpMock() {
//		System.out.println("setup book mock");
	}

	@Test
	public void testBookCreate() {
		final IBook book = createBook();
		
		assertEquals(book.getAuthor(), DummyDataGenerator.AUTHOR);
		assertEquals(book.getTitle(), DummyDataGenerator.TITLE);
		assertEquals(book.getCallNumber(), DummyDataGenerator.CALL_NUMBER);
		assertEquals(book.getID(), 1);
		assertEquals(book.getState(), EBookState.AVAILABLE);
		assertNull(book.getLoan());
	}
	
	@Test
	public void testBorrow() {
		final IBook book = createBook();
		assertNotNull(book);
		
		final IMember member = createMember();
		assertNotNull(member);
		
		final ILoan loan = createLoan(book, member);
		assertNotNull(loan);
		
		book.borrow(loan);
		assertEquals(book.getState(), EBookState.ON_LOAN);
		assertNotNull(book.getLoan());
		assertEquals(book.getLoan(), loan);
		assertEquals(book.getLoan().getBorrower(), member);
	}

	@Test
	public void testReturnBookDamaged() {
		final IBook book = createBook();
		assertNotNull(book);
		
		final IMember member = createMember();
		assertNotNull(member);
		
		final ILoan loan = createLoan(book, member);
		assertNotNull(loan);
		
		book.borrow(loan);
		assertEquals(book.getState(), EBookState.ON_LOAN);

		book.returnBook(true);
		assertEquals(EBookState.DAMAGED, book.getState());
		assertNull(book.getLoan());
	}

	@Test
	public void testReturnBookAvailable() {
		final IBook book = createBook();
		assertNotNull(book);
		
		final IMember member = createMember();
		assertNotNull(member);
		
		final ILoan loan = createLoan(book, member);
		assertNotNull(loan);
		
		book.borrow(loan);
		assertEquals(book.getState(), EBookState.ON_LOAN);

		book.returnBook(false);
		assertEquals(EBookState.AVAILABLE, book.getState());
		assertNull(book.getLoan());
	}
	
	@Test
	public void testRepair() {
		final IBook book = createBook();
		assertNotNull(book);
		
		final IMember member = createMember();
		assertNotNull(member);
		
		final ILoan loan = createLoan(book, member);
		assertNotNull(loan);
		
		book.borrow(loan);
		assertEquals(book.getState(), EBookState.ON_LOAN);

		book.returnBook(true);
		assertEquals(EBookState.DAMAGED, book.getState());

		book.repair();
		assertEquals(EBookState.AVAILABLE, book.getState());
	}

	@Test
	public void testDispose() {

		final IBook book = createBook();
		assertNotNull(book);
		
		book.dispose();
		assertEquals(EBookState.DISPOSED, book.getState());
	}
	
	@Test
	public void testLose() {
		final IBook book = createBook();
		assertNotNull(book);
		
		final IMember member = createMember();
		assertNotNull(member);
		
		final ILoan loan = createLoan(book, member);
		assertNotNull(loan);
		
		book.borrow(loan);
		assertEquals(book.getState(), EBookState.ON_LOAN);

		book.lose();
		assertEquals(EBookState.LOST, book.getState());
	}

	@Test
	public void testSample() {
		int a = 10;
		int b = 10;
		assertEquals(a+b, 20);
	}
}
