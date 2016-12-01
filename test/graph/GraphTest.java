package graph;

import org.junit.Assert;
import org.junit.Test;

public class GraphTest {

	@Test
	public void addNodeTest(){
		Graph g = new Graph();
		Node n = new Node(0, 0);
		
		g.addNode(n);
		Assert.assertEquals(g.getNodeNumber(), 1);
		
		g.addNode(n);
		Assert.assertEquals(g.getNodeNumber(), 1);
		
		g.addNode(new Node(0, 0), new Node(0, 0));
		Assert.assertEquals(g.getNodeNumber(), 3);
		
		Node n2 = new Node(0, 0);
		g.addNode(n2,n2);
		Assert.assertEquals(g.getNodeNumber(), 4);
		
	}
	
	@Test
	public void addLinkTest(){
		Graph g = new Graph();
		Node n1 = new Node(0, 0);
		Node n2 = new Node(1, 0);
		g.addNode(n1,n2);
		
		g.addLink(n1, n1);
		Assert.assertEquals(g.getLinkNumber(), 0);
		
		g.addLink(n1, n2);
		Assert.assertEquals(g.getLinkNumber(), 1);
	}
	
	@Test
	public void existingLinkTest(){
		Graph g = new Graph();
		Node n1 = new Node(0, 0);
		Node n2 = new Node(0, 0);
		g.addNode(n1,n2);
		
		Assert.assertFalse(g.existingLink(n1,n2));

		g.addLink(n1, n2);
		Assert.assertTrue(g.existingLink(n1,n2));
	}
	
	
}
