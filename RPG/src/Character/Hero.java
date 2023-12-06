package Character;

public class Hero extends Character {
	public String equipment;
	public String job;
	public static boolean isOnMission = false;
	
	public Hero() {
		level = 1;
		experience = 0;
		money = 0;
	}
	
	public int attack(Monster monster) {
		return 0;
	}
	
	public void attacked(int sum) {
		if (sum > defense)
			hp -= sum - defense;
	}
	
	public void levelUp() {
		level += 1;
		System.out.println(name + "의 레벨이" + level + "이 되었습니다.");
		money += level * 50;
		System.out.println("레벨업 기념으로 돈이 " + level * 50 + "원 증가하여");
		System.out.println(money + "원이 되었습니다.");
		experience = 0;
	}
}
