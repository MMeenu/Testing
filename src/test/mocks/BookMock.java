package test.mocks;

import library.entities.Book;

public class BookMock extends Book {

	protected boolean saneCalled = false;

	public BookMock(String author, String title, String callNumber, int bookID) {
		super(author, title, callNumber, bookID);
	}
	

}
