package zAllTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import treeTest.AVLTest;
import treeTest.ArbolesBinariosBoolTestCharo;
import treeTest.BSTest;

@RunWith(Suite.class)
@SuiteClasses({  ArbolesBinariosBoolTestCharo.class, BSTest.class, AVLTest.class })
public class AllTestsTrees {

}
