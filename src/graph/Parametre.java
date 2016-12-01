package graph;

public enum Parametre {
	GUERRE("guerre", -50),
	FAMINE("famine", -30);

	private String name;
	private int bonus;
	
	public String getName() {
		return name;
	}
	public int getBonus() {
		return bonus;
	}
	
	Parametre(String n, int b) {
		name = n;
		bonus = b;
	}
}
