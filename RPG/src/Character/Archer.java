package Character;

import java.util.Scanner;

public class Archer extends Hero {
	Scanner in = new Scanner(System.in);
	
	public Archer() {
		job = "궁수";
		hp = 70;
		mp = 20;
		power = 20;
		defense = 20;
		equipment = "새총";
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
			System.out.println("1. 재빠른 사격");
			System.out.println("2. 정확한 사격");
			System.out.println("3. 트릭샷");
			System.out.println("4. 비상식량");
			System.out.print("공격 번호를 입력하세요 : ");
			switch (in.nextInt()) {
				case 2 -> {
					if (level < 3) {
						System.out.println("레벨이 낮아서 사용할 수 없습니다.");
						continue; }
					if (mp < 1) {
						System.out.println("MP가 부족합니다.");
						continue; }
					mp -= 1;
					if (monster.name == "들개")
						sum *= 2;
					if (equipment.equals("장궁"))
						sum *= 2;
					}
				case 3 -> {
					if (level < 7) {
						System.out.println("레벨이 낮아서 사용할 수 없습니다.");
						continue; }
					if (mp < 1) {
						System.out.println("MP가 부족합니다.");
						continue; }
					mp -= 1;
					if (monster.name == "멧돼지")
						sum *= 2;
					if (equipment.equals("사슴 뿔 단궁"))
						sum *= 2;
				}
				case 4 -> {
					hit = false;
					System.out.println("HP가 " + level * 15 + " 회복되었습니다.");
					hp += level * 10;
					sum = 0;
				}
			}
			if (hit)
				System.out.println("데미지는 " + sum + "입니다.");
			return sum;
		}
	}
}
