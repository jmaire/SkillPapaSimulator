package graph;

import org.junit.Assert;
import org.junit.Test;

public class GraphTest {

	@Test
	public void addNodeTest(){
		Graph g = new Graph();
		Node n = new Node();
		
		g.addNode(n);
		Assert.assertEquals(g.getNodeNumber(), 1);
		
		g.addNode(n);
		Assert.assertEquals(g.getNodeNumber(), 1);
		
		g.addNode(new Node(), new Node());
		Assert.assertEquals(g.getNodeNumber(), 3);
		
		Node n2 = new Node();
		g.addNode(n2,n2);
		Assert.assertEquals(g.getNodeNumber(), 4);
		
	}
	
	@Test
	public void addLinkTest(){
		Graph g = new Graph();
		Node n1 = new Node();
		Node n2 = new Node();
		g.addNode(n1,n2);
		
		g.addLink(n1, n1);
		Assert.assertEquals(g.getLinkNumber(), 0);
		
		g.addLink(n1, n2);
		Assert.assertEquals(g.getLinkNumber(), 1);
	}
	@Test
	public void existingLinkTest(){
		Graph g = new Graph();
		Node n1 = new Node();
		Node n2 = new Node();
		g.addNode(n1,n2);
		
		Assert.assertFalse(g.existingLink(n1,n2));

		g.addLink(n1, n2);
		Assert.assertTrue(g.existingLink(n1,n2));
	}
	
	@Test 
	public void getLinkedNodesTest() {
		Graph g = new Graph();
		Node n1 = new Node();
		Node n2 = new Node();	
		Node n3 = new Node();	
		g.addNode(n1,n2,n3);
		g.addLink(n1, n2);
		g.addLink(n1, n3);
		
		Assert.assertEquals(g.getLinkedNodes(n1).size(), 2);
		Assert.assertTrue(g.getLinkedNodes(n1).contains(n2));
		Assert.assertTrue(g.getLinkedNodes(n1).contains(n3));
	}
	
	@Test
	public void getNodeNumberTest() {
		Graph g = new Graph();
		Node n1 = new Node();
		Node n2 = new Node();
	
		Assert.assertEquals(g.getNodeNumber(), 0);
	
		g.addNode(n1,n2);
		Assert.assertEquals(g.getNodeNumber(), 2);
	}
	
	@Test
	public void getLinkNumberTest() {
		Graph g = new Graph();
		Node n1 = new Node();
		Node n2 = new Node();
	
		Assert.assertEquals(g.getLinkNumber(), 0);
		
		g.addNode(n1,n2);
		g.addLink(n1, n2);
		Assert.assertEquals(g.getLinkNumber(), 1);
		
		g.addLink(n1,n2);
		Assert.assertEquals(g.getLinkNumber(), 1);
	}
	
}
