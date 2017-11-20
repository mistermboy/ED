package zAllTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import trees.test.AVLTest;
import trees.test.ArbolesBinariosBoolTestCharo;
import trees.test.BSTest;

@RunWith(Suite.class)
@SuiteClasses({  ArbolesBinariosBoolTestCharo.class, BSTest.class, AVLTest.class })
public class AllTestsTrees {

}
