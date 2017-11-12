package lab1;

import static org.junit.Assert.*;

import org.junit.Test;

public class MAINTest2 {


		@Test
		public void test1() {
			MAIN main1=new MAIN();
			String result=main1.queryBridgeWords("the", "big");
			String expet="No bridge words from the to big!";
			assertEquals(expet, result);
			}
		
		
		@Test
		public void test2() {
			MAIN main1=new MAIN();
			String result=main1.queryBridgeWords("data", "of");
			String expet="No bridge words from data to of!";
			assertEquals(expet, result);
		}
		
		
		@Test
		public void test3() {
			MAIN main1=new MAIN();
			String result=main1.queryBridgeWords("the", "data");
			String expet="The bridge words from the to data are: big, ";
			assertEquals(expet, result);
		}
		
		@Test
		public void test4() {
			MAIN main1=new MAIN();
			String result=main1.queryBridgeWords("in", "thank");
			String expet="No in or thank in the graph!";
			assertEquals(expet, result);
		}
		
		@Test
		public void test5() {
			MAIN main1=new MAIN();
			String result=main1.queryBridgeWords("one", "in");
			String expet="No bridge words from one to in!";
			assertEquals(expet, result);
		}
	

}
