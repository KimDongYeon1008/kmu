package Character;

public class Monster extends Character {
	public int attack() {
		System.out.println(name + "의 공격입니다.");
		System.out.println("데미지는 " + power + "입니다.");
		return power;
	}
	
	public void attacked(int sum) {
		if (sum > defense)
			hp -= sum - defense;
	}
}
