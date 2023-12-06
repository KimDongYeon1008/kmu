package Character;

import java.util.Scanner;
import java.util.Random;

public class Warrior extends Hero {
	Scanner in = new Scanner(System.in);
	Random r = new Random();
	
	public Warrior() {
		job = "전사";
		hp = 80;
		mp = 0;
		power = 15;
		defense = 25;
		equipment = "나무 검";
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
			System.out.println("1. 쓰러스트");
			System.out.println("2. 삼단 베기");
			System.out.println("3. 폼멜 타격");
			System.out.println("4. 풀 스윙");
			System.out.print("공격 번호를 입력하세요 : ");
			switch (in.nextInt()) {
				case 2 -> {
					if (level < 3) {
						System.out.println("레벨이 낮아서 사용할 수 없습니다.");
						continue;
					}
					if (monster.name == "들개")
						sum *= 2;
					if (equipment.equals("철 검"))
						sum *= 2;
				}
				case 3 -> {
					if (level < 7) {
						System.out.println("레벨이 낮아서 사용할 수 없습니다.");
						continue;
					}
					if (monster.name == "멧돼지")
						sum *= 2;
					if (equipment.equals("철 검"))
						sum *= 2;
				}
				case 4 -> {
					System.out.println("HP가 " + 3 * level + " 감소했습니다.");
					hp -= 3 * level;
					sum = (r.nextInt(10) >= 5) ? sum * 4 : 0;
				}
			}
			if (hit)
				System.out.println("데미지는 " + sum + "입니다.");
			return sum;
		}
	}
}
