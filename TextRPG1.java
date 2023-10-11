package rpg;
import java.util.Scanner;     // 플레이어의 입력을 받기 위한 Scanner import

public class TextRPG1 {
	// 플레어이와 적의 정보를 담기 위한 전역변수 선언
	static int hero_level, hero_power, hero_hp, hero_defense, hero_mp, hero_experience, hero_money;
	static int monster_hp, monster_defense, monster_power, monster_mp, monster_level,
				  monster_experience, monster_money;
	static String hero_name, monster_name;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);     // Scanner 객체 sc 생성
		
		System.out.print(" 영웅의 이름을 입력하세요.\n> ");
		hero_name = sc.next();     // 플레이어의 이름을 hero_name에 저장
		System.out.println(" 이름이 입력되었습니다.");
		System.out.println(" 게임에 입장하였습니다,");
		
		// 플레이어의 초기 능력치 초기화
		hero_level = 1;
		hero_power = 15;
		hero_defense = 25;
		hero_hp = 80;
		hero_mp = 0;
		hero_experience = 0;
		hero_money = 0;
		
		// 초기 설정 끝
		// 여기서부터 게임이 진행되며 무한 반복
		while (true) {
			// 플레이어의 상태 표시창
			System.out.println("-~++@#+~---~*~---~+#@++~-");
			System.out.printf(" %s\t%s\n", "이름", hero_name);
			System.out.printf(" %s\t%d\n", "레벨", hero_level);
			// 경험치	(현재 경험치/다음 레벨까지 요구 경험치)
			System.out.printf(" %s\t(%d/%d)\n", "경험치", hero_experience, hero_level * 80);
			System.out.printf(" %s\t%d\n", "HP", hero_hp);
			System.out.printf(" %s\t%d\n", "MP", hero_mp);
			System.out.printf(" %s\t%d\n", "힘", hero_power);
			System.out.printf(" %s\t%d\n", "방어력", hero_defense);
			System.out.printf(" %s\t%d원\n", "돈", hero_money);
			System.out.println("-~++@#+~---~*~---~+#@++~-");
			
			System.out.println(" 1. 사냥터");
			System.out.println(" 2. 포션 상점");
			System.out.print(" 입장할 장소를 선택하세요.\n> ");
   
			switch (sc.nextInt()) {   
			case 1:     // 1 -> 사냥터
				System.out.println(" 사냥터에 입장하였습니다.");
				System.out.println(" 1. 너구리");
				System.out.println(" 2. 살쾡이");
				System.out.print(" 전투할 상대를 입력하세요.\n> ");
				
				switch (sc.nextInt()) {     // 선택한 적의 정보로 전역변수 초기화
				case 1:     // 1 -> 적을 너구리로 설정
					monster_name = "너구리";
					monster_hp = 100;
					monster_mp = 0;
					monster_level = 1;
					monster_power = 20;
					monster_defense = 5;
					monster_money = 10;
					monster_experience = 10;
					break;
					
				case 2:     // 2. 적을 살쾡이로 설정
					monster_name = "살쾡이";
					monster_hp = 2000;
					monster_mp = 0;
					monster_level = 5;
					monster_power = 10;
					monster_defense = 20;
					monster_money = 30;
					monster_experience = 50;
					break;
				}
				
				System.out.printf(" %s(과)와 전투를 시작합니다.\n", monster_name);
				while (true) {     // 어느 한 쪽이 죽을 때까지 무한 반복
					// 플레이어 턴
					System.out.printf(" %s의 공격입니다.\n", hero_name);
					System.out.println(" 1. 쓰러스트");
					System.out.print(" 공격 번호를 입력하세요.\n> ");
					
					if (sc.nextInt() == 1)     // 1 -> 쓰러스트(임시)
						monster_attacked(hero_attack());     // 플레이어 공격 + 적 피격
					
					if (monster_hp <= 0) {     // 몬스터 사망 여부 확인
						System.out.printf(" %s(이)가 죽었습니다.\n", monster_name);     // 적 사망 메시지 출력
						hero_experience += monster_experience;     // 플레이어 경험치 보상
						hero_money += monster_money;     // 플레이어 돈 보상
						break;     // 전투 종료
					}
					
					// 적 턴
					System.out.printf(" %s의 공격입니다.\n", monster_name);
					hero_attacked(monster_attack());     // 적 공격 + 플레이어 피격
					
					if (hero_hp <= 0) {     // 플레이어 사망 여부 확인
						hero_hp = 1;     // 플레이어의 체력을 1로 설정
						System.out.println(" 당신은 가까스로 도망쳐 살았습니다.");     // 플레이어 부활 메시지 출력
						break;     // 전투 종료
					}
				}
				break;
				
			case 2:     // 2 -> 포션 상점
				System.out.println(" 포션 상점에 입장하였습니다.");
				System.out.println(" 1. 힘 증강 포션 (30원)");
				System.out.println(" 2. 방어력 증강 포션 (30원)");
				System.out.println(" 3. 경험치 증강 포션 (100원)");
				System.out.println(" 4. HP 증강 포션 (10원)");
				System.out.println(" 5. MP 증강 포션 (10원)");
				System.out.print(" 원하시는 물건을 입력하세요.\n> ");
				
				switch (sc.nextInt()) {     // 구매할 포션 선택
				case 1:     // 1 -> 힘 증강 포션
					System.out.printf(" %d원 남았습니다.\n", potionStore_show(30, 1));     // 포션의 가격과 번호를 potionStore_show로 전달
					break;
					
				case 2:     // 2 -> 방어력 증강 포션
					System.out.printf(" %d원 남았습니다.\n", potionStore_show(30, 2));     // 포션의 가격과 번호를 potionStore_show로 전달
					break;
					
				case 3:     // 3 -> 경험치 증강 포션
					System.out.printf(" %d원 남았습니다.\n", potionStore_show(100, 3));     // 포션의 가격과 번호를 potionStore_show로 전달
					break;
					
				case 4:     // 4 -> HP 증강 포션
					System.out.printf(" %d원 남았습니다.\n", potionStore_show(10, 4));     // 포션의 가격과 번호를 potionStore_show로 전달
					break;
					
				case 5:     // 5 -> MP 증강 포션
					System.out.printf(" %d원 남았습니다.\n", potionStore_show(10, 5));     // 포션의 가격과 번호를 potionStore_show로 전달
					break;
				}
				break;
			}
			
			if (hero_experience >= hero_level * 80) {     // 플레이어 레벨업 가능 경험치 도달 여부 확인
				hero_level += 1;     // 플레이어 레벨 1만큼 증가
				System.out.printf(" %s의 레벨이 %d(이)가 되었습니다.\n", hero_name, hero_level);     // 플레이어 레벨업 메시지 출력
				hero_money += hero_level * 50;     // 플레이어 레벨업 보상으로 hero_level * 50만큼의 돈 지급
				System.out.printf(" 레벨업 기념으로 돈이 %d원 증가하여\n %d원이 되었습니다.\n", hero_level * 50, hero_money);     // 플레이어 레벨업 보상 메시지 출력
				hero_experience = 0;     // 플레이어 현재 경험치 0으로 초기화
			}
		}
	}

	static int hero_attack() {     // 플레이어가 가하는 데미지 계산 및 적용, 반환
		int sum = hero_level * 10 + hero_power * 30;     // sum: 플레이어가 가하는 순수 데미지
		if (monster_defense >= sum)     // 만약 sum이 monster_defense보다 작거나 같으면
			return 0;     // 데미지를 적용하지 않고 0을 반환
		else {     // sum이 monster_defense보다 크면
			monster_hp = monster_hp + monster_defense - sum;     // sum에서 monster_defense를 제한 값만큼 데미지 적용
			return sum;     // sum을 반환
		}
	}
	
	static void hero_attacked(int sum) {     // 플레이어 피격 시 데미지 메시지 출력
		System.out.printf(" 데미지는 %d입니다.\n", sum);     // 데미지는 sum(= monster_attack)입니다.
	}

	static int monster_attack() {     // 적이 가하는 데미지 계산 및 적용, 반환
		if (hero_defense >= monster_power)     // 만약 monster_power가 hero_defense보다 작거나 같으면
			return 0;     // 데미지를 적용하지 않고 0을 반환
		else {     // monster_power가 hero_defense보다 크면
			hero_hp = hero_hp + hero_defense - monster_power;     // monster_power에서 hero_defense를 제한 값만큼 데미지 적용
			return monster_power;     // monster_power를 반환
		}
	}
	
	static void monster_attacked(int sum) {     // 적 피격 시 데미지 메시지 출력
		System.out.printf(" 데미지는 %d입니다.\n", sum);     // 데미지는 sum입니다.
	}

	static int potionStore_show(int money, int num) {     // 포션 구매 프로세스
		System.out.println(" 포션 상점에서 물건을 구매 시도하는 중입니다.");
		if (hero_money >= money) {     // 플레이어가 가격을 지불 가능하면
			hero_money -= money;     // 플레이어의 돈을 가격만큼 차감
			System.out.println(" 구입이 완료되었습니다.");
			switch (num) {     // 구매할 포션 번호에 맞는 능력치 증강
			case 1:     // 1 -> 힘 증강 포션
				hero_power += 3;
				break;
			case 2:	// 2 -> 방어력 증강 포션
				hero_defense += 3;
				break;
			case 3:     // 3 -> 경험치 증강 포션
				hero_experience += 50;
				break;
			case 4:     // 4 -> HP 증강 포션
				hero_hp += 50;
				break;
			case 5:     // 5 -> MP 증강 포션
				hero_mp += 50;
				break;
			}
		} else     // 플레이어가 가격을 지불 불가능하면
			System.out.println(" 돈이 부족합니다.");     // 구매 실패 메시지 출력
		return hero_money;	// 지불 후 플레이어 돈 return
	}
}
