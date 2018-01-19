package zAllTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import hash.test.ClosedHashTableTest;
import hash.test.ClosedHashTableTestCharo;

@RunWith(Suite.class)
@SuiteClasses({ AllTestsGrafos.class,AllTestsTrees.class,AllTestsHash.class })
public class AllTests{

}


