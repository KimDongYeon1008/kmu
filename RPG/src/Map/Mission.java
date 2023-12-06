package Map;

import Character.Hero;
import Character.Monster;

public class Mission {
	String targetMonster;
	String targetEquipment;
	int currentAmount = 0;
	
	public void check(Monster monster) {
		if (monster.name.equals(targetMonster))
			currentAmount++;
	}
	
	public void level2Mission(Hero hero) {
		targetMonster = "너구리";
		Hero.isOnMission = true;
		System.out.println("레벨 3 레벨업 미션");
		System.out.println("너구리를 3마리 처치하세요. (" + currentAmount + "/3)");
		if (currentAmount >= 3) {
			Hero.isOnMission = false;
			hero.levelUp();
			switch (hero.job) {
			case "전사" -> System.out.println("이제 삼단 베기를 사용할 수 있습니다.");
			case "마법사" -> System.out.println("이제 파이어 볼트를 사용할 수 있습니다.");
			case "궁수" -> System.out.println("이제 정확한 사격을 사용할 수 있습니다.");
			}
			currentAmount = 0;
		}
	}
	
	public void level6Mission(Hero hero) {
		Hero.isOnMission = true;
		targetEquipment = "철 검";
		System.out.println("레벨 7 레벨업 미션");
		System.out.println("철 검을 장착하세요.");
		if (hero.equipment.equals(targetEquipment)) {
			Hero.isOnMission = false;
			hero.levelUp();
			switch (hero.job) {
			case "전사" -> System.out.println("이제 폼멜 타격을 사용할 수 있습니다.");
			case "마법사" -> System.out.println("이제 얼음 화살을 사용할 수 있습니다.");
			case "궁수" -> System.out.println("이제 트릭샷을 사용할 수 있습니다.");
			}
		}
	}
}
