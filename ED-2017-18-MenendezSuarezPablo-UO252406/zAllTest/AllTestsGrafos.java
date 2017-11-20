package zAllTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import graphs.test.GraphDijkstraTestCharo;
import graphs.test.GraphFloydTestCharo;
import graphs.test.GraphTest;
import graphs.test.GraphTestCharo;
import trees.test.ArbolesBinariosBoolTestCharo;
import trees.test.BSTest;

@RunWith(Suite.class)
@SuiteClasses({ GraphDijkstraTestCharo.class, GraphFloydTestCharo.class, GraphTest.class, GraphTestCharo.class})
public class AllTestsGrafos {

}
