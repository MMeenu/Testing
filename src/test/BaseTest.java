package test;

import java.util.Date;

import library.daos.BookHelper;
import library.daos.LoanHelper;
import library.daos.MemberHelper;
import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;
import test.data.DummyDataGenerator;

public abstract class BaseTest {

	public final BookHelper bookHelper = new BookHelper();
	public final LoanHelper loanHelper = new LoanHelper();
	public final MemberHelper memberHelper = new MemberHelper();
	
	
	public BaseTest() {
	}

	public IBook createBook() {
	   return bookHelper.makeBook(DummyDataGenerator.AUTHOR, DummyDataGenerator.TITLE, DummyDataGenerator.CALL_NUMBER, 1);
	}

	public IMember createMember() {
	   return memberHelper.makeMember(DummyDataGenerator.FIRST_NAME, DummyDataGenerator.LAST_NAME, DummyDataGenerator.CONTACT_PHONE, DummyDataGenerator.EMAIL, 1);
	}
	
	public ILoan createLoan(IBook book, IMember member) {
		return loanHelper.makeLoan(book, member, new Date(), new Date());
	}


}
