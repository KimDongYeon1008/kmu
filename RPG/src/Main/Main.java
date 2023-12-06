package Main;

import java.util.*;
import Character.*;
import Map.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Hero hero;
		Monster monster;
		PotionStore potionStore;
		WeaponStore weaponStore;
		Mission mission = new Mission();
		
		int weaponPower = 0;
		
		System.out.println("*******RPG GAME*******");
		System.out.println("1. 전사");
		System.out.println("2. 마법사");
		System.out.println("3. 궁수");
		System.out.print("직업의 번호를 입력하세요. : ");
		switch (in.nextInt()) {
			case 1 -> hero = new Warrior();
			case 2 -> hero = new Mage();
			case 3 -> hero = new Archer();
			default -> hero = new Hero();
		}
		System.out.println("게임에 입장하였습니다.");
		
		while (true) {
			System.out.println("*********************");
			System.out.println("현재 " + hero.name + "의 이름 : " + hero.name);
			System.out.println("현재 " + hero.name + "의 레벨 : " + hero.level);
			System.out.println("현재 " + hero.name + "의 무기 : " + hero.equipment);
			System.out.println("현재 " + hero.name + "의 힘 : " + hero.power);
			System.out.println("현재 " + hero.name + "의 방어력 : " + hero.defense);
			System.out.println("현재 " + hero.name + "의 HP : " + hero.hp);
			System.out.println("현재 " + hero.name + "의 MP : " + hero.mp);
			System.out.println("현재 " + hero.name + "의 경험치 : " + hero.experience);
			System.out.println("현재 " + hero.name + "의 돈 : " + hero.money + "원");
			System.out.println("*********************");
			
			System.out.println("1. 사냥터");
			System.out.println("2. 포션 상점");
			System.out.print("입장할 장소를 입력하세요. : ");
			switch (in.nextInt()) {
				case 1 -> {
					System.out.println("사냥터에 입장하였습니다.");
				
					System.out.println("1. 너구리");
					System.out.println("2. 살쾡이");
					System.out.println("3. 들개");
					System.out.println("4. 멧돼지");
					System.out.print("전투할 상대를 입력하세요. : ");
					switch (in.nextInt()) {
						case 1 -> monster = new Raccoon();
						case 2 -> monster = new Lynx();
						case 3 -> monster = new WildDog();
						case 4 -> monster = new WildBoar();
						default -> monster = new Monster();
					}
					
					System.out.println(monster.name + "과 전투를 시작합니다.");
					while (true) {
						monster.attacked(hero.attack(monster));
						if (monster.hp <= 0) {
							if (!hero.isOnMission)
								hero.experience += monster.experience;
							else
								mission.check(monster);
							hero.money += monster.money;
							System.out.println(monster.name + "가 죽었습니다.");
							break;
						}
					
						hero.attacked(monster.attack());
						if (hero.hp <= 0) {
							hero.hp = 1;
							System.out.println(hero.name + "이 졌습니다.");
							break;
						}
					}
				}
				
				case 2 -> {
					potionStore = new PotionStore();
					hero.money = potionStore.show(hero.money, in.nextInt());
					System.out.println(hero.money + "원 남았습니다.");
					switch (potionStore.item) {
						case 1 -> hero.power += 3;
						case 2 -> hero.defense += 3;
						case 3 -> {
							if (Hero.isOnMission) {
								System.out.println("포션에서 이상한 맛이 느껴집니다..");
								hero.hp += 50;
								hero.mp += 50;
							} else {
								hero.experience +=50;
							}
						}
						case 4 -> hero.hp += 50;
						case 5 -> hero.mp += 50;
					}
				}
				
				case 3 -> {
					weaponStore = new WeaponStore();
					hero.money = weaponStore.show(hero.money, in.nextInt(), hero);
					System.out.println(hero.money + "원 남았습니다.");
					switch (weaponStore.item) {
						case 1 -> {
							hero.equipment = "돌 검";
							hero.power += 12 - weaponPower;
							weaponPower = 12;
						}
						
						case 2 -> {
							hero.equipment = "철 검";
							hero.power += 100 - weaponPower;
							weaponPower = 100;
						}
						
						case 3 -> {
							hero.equipment = "흑단 지팡이";
							hero.power += 12 - weaponPower;
							weaponPower = 12;
						}
						
						case 4 -> {
							hero.equipment = "혹한의 보주";
							hero.power += 100 - weaponPower;
							weaponPower = 100;
						}
						
						case 5 -> {
							hero.equipment = "장궁";
							hero.power += 12 - weaponPower;
							weaponPower = 12;
						}
						
						case 6 -> {
							hero.equipment = "사슴 뿔 단궁";
							hero.power += 100 - weaponPower;
							weaponPower = 100;
						}
					}
				}
			}
				
			if (hero.experience >= hero.level * 80) {
				if (hero.level == 2)
					mission.level2Mission(hero);
				else if (hero.level == 6)
					mission.level6Mission(hero);
				else
					hero.levelUp();
			}
		}
	}
}
