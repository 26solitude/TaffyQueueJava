package Taffy;

public class WorkProcess {
	public static int Work(MakeQueue<Person> Person, MakeQueue<Person> Result, Person p1, int TotWaitTime,
			int TotCusNum, int ServiceTime) {
		for (int i = 1; i < 480; i++) { // 480분간 업무 수행
			IsWorkNow(p1, i); // 현재 시간 출력 및 태피가 업무 중인지 여부 검사
			TotCusNum = IsCusEnter(Person, TotCusNum, i); // 손님 입장여부 검사 및 총 인원 계산

			if (ServiceTime > 0) { // 서비스타임이 주어졌을 때 업무를 수행
				System.out.printf("고객 %d이 업무 처리중입니다.\n", p1.personNum);
				if (Person.size() >= 20 && ServiceTime > 4) { // 대기 인원에 따른 업무속도 변경
					System.out.println("대기고객 20명 이상! 미친듯이 작업 속도가 상승합니다.");
					ServiceTime -= 4;
				} else if (Person.size() >= 10 && Person.size() < 20 && ServiceTime > 2) {
					System.out.println("대기고객 10명 이상! 작업 속도가 상승합니다.");
					ServiceTime -= 2;
				} else {
					ServiceTime--;
				}
				if (ServiceTime == 0) { // 업무가 종료되었을 때
					p1.ServiceEnd(i);
					Result.enqueue(p1);
					System.out.printf("태피가 %d분에 현재 업무를 마무리합니다.\n", i);
				}
			} else if (p1.doService == true) { // 태피가 업무를 수행할 수 있을 때
				if (!Person.isEmpty()) {
					p1 = Person.dequeue();
					ServiceTime = p1.serviceTime;
					p1.ServiceStart(i);
					System.out.printf("고객 %d의 업무가 %d분에 처리됩니다.\n대기시간은 %d분이었으며 현재 대기중인 인원 : %d\n", p1.personNum, i,
							p1.waitTime, Person.size());
					TotWaitTime += p1.waitTime;
				}
			}
		}
		return TotWaitTime;
	}

	public static void IsWorkNow(Person p1, int i) {
		System.out.printf("-----현재 시간 %d분-----\n", i);
		if (p1.doService == true) { // 태피가 업무중인지 여부 검사
			System.out.println("태피는 휴식 중\n");
		} else {
			System.out.println("태피는 작업 중\n");
		}
	}

	public static int IsCusEnter(MakeQueue<Person> Person, int TotCusNum, int i) {
		if (((int) (Math.random() * 4) + 1) == 4) { // 난수가 4일 경우 손님 입장
			Person per = new Person(i, TotCusNum++);
			Person.enqueue(per);
			System.out.printf("고객 %d이 %d분에 들어옵니다. 업무 처리시간 : %d\n", per.personNum, per.arriveTime, per.serviceTime);
		}
		return TotCusNum;
	}
}
