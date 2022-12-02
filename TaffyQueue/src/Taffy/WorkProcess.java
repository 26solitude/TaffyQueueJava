package Taffy;

public class WorkProcess {
	public static int Work(MakeQueue<Person> Person, MakeQueue<Person> Result, Person p1, int TotWaitTime,
			int TotCusNum, int ServiceTime) {
		for (int i = 1; i < 480; i++) {
			IsWorkNow(p1, ServiceTime);
			TotCusNum = IsCusEnter(Person, TotCusNum, i);

			if (ServiceTime > 0) { // 서비스타임이 주어졌을 때 업무를 수행
				System.out.printf("고객 %d이 업무 처리중입니다.\n", p1.personNum);
				ServiceTime--;
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
					TotWaitTime = p1.waitTime;
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
