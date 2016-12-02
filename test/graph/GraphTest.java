package graph;

import org.junit.Assert;
import org.junit.Test;

public class GraphTest {

	@Test
	public void addNodeTest(){
		Graph g = new Graph();
		Pays n = new Pays(0, 0, 10);
		
		g.addNode(n);
		Assert.assertEquals(g.getNodeNumber(), 1);
		
		g.addNode(n);
		Assert.assertEquals(g.getNodeNumber(), 1);
		
		g.addNode(new Pays(0, 0, 0), new Pays(0, 0, 0));
		Assert.assertEquals(g.getNodeNumber(), 3);
		
		Pays n2 = new Pays(0, 0, 0);
		g.addNode(n2,n2);
		Assert.assertEquals(g.getNodeNumber(), 4);
		
	}
	
	@Test
	public void addLinkTest(){
		Graph g = new Graph();
		Pays n1 = new Pays(0, 0, 0);
		Pays n2 = new Pays(1, 0, 0);
		g.addNode(n1,n2);
		
		g.addLink(n1, n1);
		Assert.assertEquals(g.getLinkNumber(), 0);
		
		g.addLink(n1, n2);
		Assert.assertEquals(g.getLinkNumber(), 1);
	}
	
	@Test
	public void existingLinkTest(){
		Graph g = new Graph();
		Pays n1 = new Pays(0, 0, 0);
		Pays n2 = new Pays(0, 0, 0);
		g.addNode(n1,n2);
		
		Assert.assertFalse(g.existingLink(n1,n2));

		g.addLink(n1, n2);
		Assert.assertTrue(g.existingLink(n1,n2));
	}
	
	@Test
	public void getLinkedNodeTest(){
		Graph g = new Graph();
		Pays n1 = new Pays(0, 0, 0);
		Pays n2 = new Pays(0, 0, 0);
		Pays n3 = new Pays(0, 0, 0);
		g.addNode(n1,n2,n3);
		
		
		Assert.assertEquals(g.getLinkedNodes(n1).size(), 0);

		g.addLink(n1, n2);
		Assert.assertEquals(g.getLinkedNodes(n1).size(), 1);
	
		g.addLink(n2, n3);
		Assert.assertEquals(g.getLinkedNodes(n2).size(), 2);
	}
	
	
}
