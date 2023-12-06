package Map;

import java.util.Scanner;
import Character.Hero;

public class WeaponStore {
	Scanner in = new Scanner(System.in);
	public int item = -1;
	
	public WeaponStore() {
		System.out.println("무기 상점에 입장하였습니다.");
		System.out.println("1. 돌 검 (100원)");
		System.out.println("2. 철 검 (700원)");
		System.out.println("3. 흑단 지팡이 (100원)");
		System.out.println("4. 혹한의 보주 (700원)");
		System.out.println("5. 장궁 (100원)");
		System.out.println("6. 사슴 뿔 단궁 (700원)");
		System.out.print("원하시는 물건을 입력하세요. : ");
	}
	
	public int show(int money, int num, Hero hero) {
		switch (num) {
			case 1 -> {
				if (hero.job.equals("전사") && money >= 100) {
					System.out.println("구입이 완료되었습니다.");
					item = num;
					return money - 100;
				}
			}
			
			case 2 -> {
				if (hero.job.equals("전사") && money >= 700) {
					System.out.println("구입이 완료되었습니다.");
					item = num;
					return money - 700;
				}
			}
			
			case 3 -> {
				if (hero.job.equals("마법사") && money >= 100) {
					System.out.println("구입이 완료되었습니다.");
					item = num;
					return money - 100;
				}
			}
			
			case 4 -> {
				if (hero.job.equals("마법사") && money >= 700) {
					System.out.println("구입이 완료되었습니다.");
					item = num;
					return money - 700;
				}
			}
			
			case 5 -> {
				if (hero.job.equals("궁수") && money >= 100) {
					System.out.println("구입이 완료되었습니다.");
					item = num;
					return money - 100;
				}
			}
			
			case 6 -> {
				if (hero.job.equals("궁수") && money >= 700) {
					System.out.println("구입이 완료되었습니다.");
					item = num;
					return money - 700;
				}
			}
		}
		
		System.out.println("구매 실패");
		return money;
	}
}
