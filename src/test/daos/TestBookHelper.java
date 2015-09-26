package test.daos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import library.interfaces.entities.IBook;

import org.junit.Test;

import test.BaseTest;
import test.data.DummyDataGenerator;


public class TestBookHelper extends BaseTest {
	
	@Test
	public void testMakeBook() {
		final IBook iBook = bookHelper.makeBook(DummyDataGenerator.AUTHOR, DummyDataGenerator.TITLE, DummyDataGenerator.CALL_NUMBER, 1);
		
		assertTrue(iBook instanceof IBook);
		assertNotNull(iBook);
		assertEquals(iBook.getAuthor(), DummyDataGenerator.AUTHOR);
		assertEquals(iBook.getTitle(), DummyDataGenerator.TITLE);
		assertEquals(iBook.getCallNumber(), DummyDataGenerator.CALL_NUMBER);
		assertEquals(iBook.getID(), 1);
	}
	
//	public MyUnitMock extends MyUnit {
//
//		  protected boolean callOneCalled = false;
//		  protected boolean callTwoCalled = false;
//
//		  @Override
//		  protected void callOne() {
//		    this.callOneCalled = true;
//		    super.callOne();
//		  }
//
//		  @Override
//		  protected void callTwo() {
//		    this.callTwoCalled = true;
//		    super.callTwo();
//		  }
//
//		}	
	
	
//	@Test
//	public void test() {
//	   MyUnitMock myUnitMock = new MyUnitMock();
//
//	   myUnitMock.doTheThing("one");
//
//	   assertTrue (myUnitMock.callOneCalled);
//	   assertFalse(myUnitMock.callTwoCalled);
//
//	   //reset mock before next call
//	   myUnitMock.callOneCalled = false;
//
//	   myUnitMock.doTheThing("two");
//
//	   assertFalse(myUnitMock.callOneCalled);
//	   assertTrue (myUnitMock.callTwoCalled);
//	}
	
//	@Test
//	public void testSample() {
//		int a = 10;
//		int b = 10;
//		assertEquals(a+b, 20);
//	}
	
//	@Test
//	public void testSaveComplaint() {
//		final User user = userService.saveUser(ddg.createUser());
//		assertTrue(user.getUserId() > 0);
//		
//		Complaint complaint = ddg.createComplaint();
//		complaint.setUser(user);
//		complaint = complaintService.saveComplaint(complaint);		
//		assertTrue(complaint.getComplaintId() > 0);		
//	}
//	
//	@Test
//	public void testDeleteComplaint() {
//		final User user = userService.saveUser(ddg.createUser());
//		assertTrue(user.getUserId() > 0);
//		
//		Complaint complaint = ddg.createComplaint();
//		complaint.setUser(user);
//		complaint = complaintService.saveComplaint(complaint);
//		assertTrue(complaint.getComplaintId() > 0);
//		
//		complaintService.deleteComplaint(complaint.getComplaintId());
//		complaint = complaintService.getComplaintById(complaint.getComplaintId());
//		assertNull(complaint);				
//	}
//	
//	@Test
//	public void testFindComplaintById() {
//		final User user = userService.saveUser(ddg.createUser());
//		assertTrue(user.getUserId() > 0);
//		
//		Complaint complaint = ddg.createComplaint();
//		complaint.setUser(user);
//		complaint = complaintService.saveComplaint(complaint);
//		assertTrue(complaint.getComplaintId() > 0);
//		
//		final Complaint fetchedComplaint = complaintService.getComplaintById(complaint.getComplaintId());
//		
//		assertEquals(complaint.getComplaintId(), fetchedComplaint.getComplaintId());
//		assertEquals(complaint.getAddress(), fetchedComplaint.getAddress());
//		//assertEquals(complaint.getCity(), fetchedComplaint.getCity());
//		assertEquals(complaint.getCountry(), fetchedComplaint.getCountry());
//		assertEquals(complaint.getDescription(), fetchedComplaint.getDescription());
//		assertEquals(complaint.getLocation(), fetchedComplaint.getLocation());
//		assertEquals(complaint.getMap(), fetchedComplaint.getMap());
//		//assertEquals(complaint.getProvience(), fetchedComplaint.getProvience());
//		assertEquals(complaint.getTitle(), fetchedComplaint.getTitle());
//	}
//	
//	@Test
//	public void testGetAllComplaints() {
//		final User user = userService.saveUser(ddg.createUser());
//		assertTrue(user.getUserId() > 0);
//		
//		Complaint complaint = ddg.createComplaint();
//		complaint.setUser(user);
//		complaint = complaintService.saveComplaint(complaint);
//		assertTrue(complaint.getComplaintId() > 0);
//		
//		final List<Complaint> complaints = null;//complaintService.getAllComplaints();
//		assertTrue(complaints.size() > 0);		
//	}
}
