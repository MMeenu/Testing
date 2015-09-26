
package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.daos.TestBookHelper;
import test.daos.TestBookMapDAO;
import test.entities.TestBook;

@RunWith(Suite.class)
@SuiteClasses({TestBookHelper.class, TestBookMapDAO.class, TestBook.class})
public class AllTests {

}
