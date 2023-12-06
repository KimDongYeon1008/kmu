package Map;

import java.util.*;

public class PotionStore {
	Scanner in = new Scanner(System.in);
	public int item = -1;
	
	public PotionStore() {
		System.out.println("포션 상점에 입장하였습니다.");
		System.out.println("1. 힘 증강 포션 (30원)");
		System.out.println("2. 방어력 증강 포션 (30원)");
		System.out.println("3. 경험치 증강 포션 (100원)");
		System.out.println("4. HP 증강 포션 (10원)");
		System.out.println("5. MP 증강 포션 (10원)");
		System.out.print("원하시는 물건을 입력하세요. : ");
	}
	
	public int show(int money, int num) {
		switch (num) {
			case 1, 2 -> {
				if (money >= 30) {
					System.out.println("구입이 완료되었습니다.");
					item = num;
					return money - 30;
				} else
					break;
			}
			case 3 -> {
				if (money >= 100) {
					System.out.println("구입이 완료되었습니다.");
					item = num;
					return money - 100;
				} else
					break;
			}
			case 4, 5 -> {
				if (money >= 10) {
					System.out.println("구입이 완료되었습니다.");
					item = num;
					return money - 10;
				} else
					break;
			}
		}
		System.out.println("돈이 부족합니다.");
		return money;
	}
}
