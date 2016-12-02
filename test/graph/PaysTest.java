package graph;

import org.junit.Assert;
import org.junit.Test;

public class PaysTest {

	@Test
	public void updateBonheurUp(){
		Pays pays = new Pays(0, 0, 100);
		int newBonheur = (int)(pays.getBonheur()+(100-pays.getBonheur())*Math.atan((100-0)/3)*2/Math.PI);
		pays.update();
		Assert.assertEquals(newBonheur,pays.getBonheur());
	}
	
	@Test
	public void updateBonheurNull(){
		Pays pays = new Pays(0, 0, 0);
		int newBonheur = (int)(pays.getBonheur()+(0-pays.getBonheur())*Math.atan((0-0)/3)*2/Math.PI);
		pays.update();
		Assert.assertEquals(newBonheur,pays.getBonheur());
	}
	
	@Test
	public void updateBonheurDown(){
		Pays pays = new Pays(0, 0, 100);
		pays.setPopulation(200);
		int newBonheur = (int)(pays.getBonheur()+(100-pays.getBonheur())*Math.atan((100-200)/3)*2/Math.PI);
		pays.update();
		Assert.assertEquals(newBonheur,pays.getBonheur());
	}
}
