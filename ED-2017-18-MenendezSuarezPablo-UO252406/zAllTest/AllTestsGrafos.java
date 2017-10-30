package zAllTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import graphTest.GraphDijkstraTestCharo;
import graphTest.GraphFloydTestCharo;
import graphTest.GraphTest;
import graphTest.GraphTestCharo;

@RunWith(Suite.class)
@SuiteClasses({ GraphDijkstraTestCharo.class, GraphFloydTestCharo.class, GraphTest.class, GraphTestCharo.class })
public class AllTestsGrafos {

}
