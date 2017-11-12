package lab1;

import static org.junit.Assert.*;

import org.junit.Test;

public class MAINTest {

	@Test
	public void test1() {
		MAIN main1=new MAIN();
		String result=main1.calcShortestPath("big", "one");
		String expet="big -> data -> time -> servitization -> becomes -> one -> ";
		assertEquals(expet, result);
	}
	
	@Test
	public void test2() {
		MAIN main1=new MAIN();
		String result=main1.calcShortestPath("internet", "of");
		String expet="No pass from internet to of !";
		assertEquals(expet, result);
	}
	
	@Test
	public void test3() {
		MAIN main1=new MAIN();
		String result=main1.calcShortestPath("one", "two");
		String expet="No one or two in the graph!";
		assertEquals(expet, result);
	}
	
	@Test
	public void test4() {
		MAIN main1=new MAIN();
		String result=main1.calcShortestPath("she", "her");
		String expet="No she or her in the graph!";
		assertEquals(expet, result);
	}
}
