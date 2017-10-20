package zAllTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.GraphDijkstraTestCharo;
import test.GraphFloydTestCharo;
import test.GraphTest;
import test.GraphTestCharo;

@RunWith(Suite.class)
@SuiteClasses({ GraphDijkstraTestCharo.class, GraphFloydTestCharo.class, GraphTest.class, GraphTestCharo.class })
public class AllTestsGrafos {

}
