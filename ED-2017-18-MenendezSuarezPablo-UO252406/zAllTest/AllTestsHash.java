package zAllTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import hash.ClosedHashTable;
import hash.test.ClosedHashTableTestCharo;

@RunWith(Suite.class)
@SuiteClasses({ ClosedHashTableTestCharo.class })
public class AllTestsHash {

}
