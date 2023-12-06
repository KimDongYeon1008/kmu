package Character;

import java.util.Scanner;

public class Mage extends Hero {
	Scanner in = new Scanner(System.in);
	
	public Mage() {
		job = "마법사";
		hp = 60;
		mp = 40;
		power = 30;
		defense = 10;
		equipment = "잡목 나뭇가지";
		System.out.println(job + "가 선택되었습니다.");
		System.out.print("영웅의 이름을 입력하세요. : ");
		name = in.next();
		System.out.println("이름이 입력되었습니다.");
	}
	
	public int attack(Monster monster) {
		int sum = level * 10 + power * 30;
		boolean hit = true;
		System.out.println(name + "의 공격입니다.");
		while (true) {
			System.out.println("1. 매직 미사일");
			System.out.println("2. 파이어 볼트");
			System.out.println("3. 얼음 화살");
			System.out.println("4. 마력의 바람");
			System.out.print("공격 번호를 입력하세요 : ");
			switch (in.nextInt()) {
				case 1 -> {
					if (mp < 2) {
						System.out.println("MP가 부족합니다.");
						continue; }
					mp -= 2;
				}
				case 2 -> {
					if (level < 3) {
						System.out.println("레벨이 낮아서 사용할 수 없습니다.");
						continue; }
					if (mp < 3) {
						System.out.println("MP가 부족합니다.");
						continue; }
					mp -= 3;
					if (monster.name == "들개")
						sum *= 2;
					if (equipment.equals("흑단 지팡이"))
						sum *= 2;
				}
				case 3 -> {
					if (level < 7) {
						System.out.println("레벨이 낮아서 사용할 수 없습니다.");
						continue; }
					if (mp < 4) {
						System.out.println("MP가 부족합니다.");
						continue; }
					mp -= 4;
					if (monster.name == "멧돼지")
						sum *= 2;
					if (equipment.equals("혹한의 보주"))
						sum *= 2;
				}
				case 4 -> {
					hit = false;
					System.out.println("MP가 " + level + " 회복되었습니다.");
					mp += level;
					sum = 0;
				}
			}
			if (hit)
				System.out.println("데미지는 " + sum + "입니다.");
			return sum;
		}
	}
}
