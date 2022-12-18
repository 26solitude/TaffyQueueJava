package Taffy;

public class WorkProcess {
	public static void Work(MakeQueue<Person> Person, MakeQueue<Person> Result, MakeQueue<Person> Vip, Person p1,
			int TotWaitTime, int TotCusNum, int ServiceTime) {
		int vipNum = 0;
		System.out.println("태피 상점이 업무를 시작합니다.");
		for (int i = 1; i < 480; i++) { // 480분간 업무 수행
			System.out.println();
			//IsWorkNow(Person, i); // 현재 시간 출력 및 태피가 업무 중인지 여부 검사
			System.out.printf("--------------------현재 시간 %d분--------------------\n", i);
			TotCusNum = IsCusEnter(Person, Vip, TotCusNum, i); // 손님 입장여부 검사 및 총 인원 계산
			if (ServiceTime > 0) { // 서비스타임이 주어졌을 때 업무를 수행
				System.out.printf("고객 %d의 업무를 처리중입니다.\n", p1.personNum);

				if (Person.size() >= 30) { // 대기 인원에 따른 업무속도 변경
					System.out.println("대기고객 30명 이상! 미친듯이 작업 속도가 상승합니다.");
					if (ServiceTime <= 3)
						ServiceTime = 0;
					else
						ServiceTime -= 3;
				} else if (Person.size() >= 15 && Person.size() < 30) {
					System.out.println("대기고객 15명 이상! 작업 속도가 상승합니다.");
					if (ServiceTime <= 2)
						ServiceTime = 0;
					else
						ServiceTime -= 2;
				} else {
					ServiceTime--;
				}
				if (ServiceTime == 0) { // 업무가 종료되었을 때
					p1.ServiceEnd(i);
					Result.enqueue(p1);
					System.out.printf("태피가 %d번 고객의 업무를 %d분에 마무리합니다.\n\n", p1.personNum, i);
				}
			} else if (p1.doService == true) { // 태피가 업무를 수행할 수 있을 때
				if (!Vip.isEmpty()) {
					p1 = Vip.dequeue();
					ServiceTime = p1.serviceTime;
					p1.ServiceStart(i);
					vipNum++;
					System.out.printf("VIP 고객 %d의 업무가 %d분에 처리됩니다.\n서비스 시간은 %d분, 대기시간은 %d분이었으며 현재 대기중인 인원 : %d\n",
							p1.personNum, i, p1.serviceTime, p1.waitTime, Person.size());
					TotWaitTime += p1.waitTime;
				} else if (!Person.isEmpty()) {
					p1 = Person.dequeue();
					ServiceTime = p1.serviceTime;
					p1.ServiceStart(i);
					System.out.printf("고객 %d의 업무가 %d분에 처리됩니다.\n서비스 시간은 %d분, 대기시간은 %d분이었으며 현재 대기중인 인원 : %d\n",
							p1.personNum, i, p1.serviceTime, p1.waitTime, Person.size());
					TotWaitTime += p1.waitTime;
				}
			}
		}

		int TotWaitPerson = Person.size() + Vip.size() + 2;

		if (p1.vip == true) { // 업무 중 종료가 되면 다시 큐에 입력
			Vip.enqueue(p1);
			vipNum--;
		} else
			Person.enqueue(p1);

		while (Person.size() != 0) // 잔여 인원의 대기 시간 계산 및 Result 큐에 입력
		{
			p1 = Person.dequeue();
			TotWaitTime += (480 - p1.arriveTime);
			p1.waitTime = 480 - p1.arriveTime;
			p1.doService = false;
			Result.enqueue(p1);
		}
		while (Vip.size() != 0) {
			p1 = Vip.dequeue();
			System.out.println(p1.vip);
			TotWaitTime += (480 - p1.arriveTime);
			p1.waitTime = 480 - p1.arriveTime;
			p1.doService = false;
			vipNum++;
			Result.enqueue(p1);
		}

		System.out.println("\n--------------------480분 업무 종료---------------------");
		System.out.printf("총 방문 고객은 %d명이며 그중 VIP 손님은 %d명입니다.\n", Result.size() + 1, vipNum);
		System.out.printf("고객별 평균 대기시간은 %d분이며 처리 못한 인원은 %d명입니다.\n\n", TotWaitTime / (Result.size() + 1), TotWaitPerson);

	}

	public static void IsWorkNow(MakeQueue<Person> Person, int i) {
//		if (p1.doService == true) { // 태피가 업무중인지 여부 검사
		
//			System.out.println("태피는 휴식 중\n");
//		} else {
//			System.out.println("태피는 작업 중\n");
//		}

		if (Person.size() > 0) {
			// System.out.println("태피는 작업 중"); // 휴식 중인 경우에만 출력
		} else {
			//System.out.println("태피는 휴식 중");
		}

	}

	public static int IsCusEnter(MakeQueue<Person> Person, MakeQueue<Person> Vip, int TotCusNum, int i) {
		if (((int) (Math.random() * 4) + 1) == 4) { // 난수가 4일 경우 손님 입장
			Person per = new Person(i, TotCusNum++);
			Person.enqueue(per);
			System.out.printf("고객 %d이 %d분에 들어옵니다. 업무 처리시간 : %d\n", per.personNum, per.arriveTime, per.serviceTime);
		}

		if (((int) (Math.random() * 50) + 1) == 50) {
			Person vip = new Person(i, TotCusNum++);
			vip.vip = true;
			Vip.enqueue(vip);
			System.out.printf("VIP 고객 %d이 %d분에 들어옵니다. 업무 처리시간 : %d\n", vip.personNum, vip.arriveTime, vip.serviceTime);
		}
		return TotCusNum;
	}
}
