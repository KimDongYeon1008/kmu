package Map;

import Character.Hero;
import Character.Monster;

public class Mission {
	String targetMonster;
	String targetEquipment;
	int targetAmount;
	int currentAmount;
	
	public void check(Monster monster) {
		if (monster.name.equals(targetMonster))
			targetAmount++;
	}
	
	public void level2Mission(Hero hero) {
		Hero.isOnMission = true;
		System.out.println("레벨 3 레벨업 미션");
		System.out.println("너구리를 3마리 처치하세요. (" + currentAmount + "/" + targetAmount + ")");
		if (currentAmount >= targetAmount) {
			Hero.isOnMission = false;
			hero.levelUp();
			switch (hero.job) {
			case "전사" -> System.out.println("이제 삼단 베기를 사용할 수 있습니다.");
			case "마법사" -> System.out.println("이제 파이어 볼트를 사용할 수 있습니다.");
			case "궁수" -> System.out.println("이제 정확한 사격을 사용할 수 있습니다.");
			}
		}
	}
	
	public void level6Mission(Hero hero) {
		Hero.isOnMission = true;
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
