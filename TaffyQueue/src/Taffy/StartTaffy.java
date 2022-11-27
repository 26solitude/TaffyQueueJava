package Taffy;

public class StartTaffy {
	static void Start() {
		MakeQueue<Person> Person = new MakeQueue<Person>();
		MakeQueue<Person> Result = new MakeQueue<Person>();
		Person p1 = new Person(0, 0);

		int TotWaitTime = 0;	// 고객의 총 대기시간
		int TotCusNum = 1;		// 총 고객의 수
		int ServiceTime = 0;	// 처리시간을 저장할 변수
		int ResSize = 0;		// Result 스택에 들어있는 요소의 개수

		for (int i = 1; i < 480; i++) {
			System.out.printf("-----현재 시간 %d분-----\n", i);
			if (p1.doService == true) {						// 태피가 업무중인지 여부 검사
				System.out.println("태피는 휴식 중\n");
			} else {
				System.out.println("태피는 작업 중\n");
			}

			if (((int) (Math.random() * 4) + 1) == 4) {		// 난수가 4일 경우 손님 입장
				Person per = new Person(i, TotCusNum++);
				Person.enqueue(per);
				System.out.printf("고객 %d이 %d분에 들어옵니다. 업무 처리시간 : %d\n", per.personNum, per.arriveTime, per.serviceTime);
			}

			if (ServiceTime > 0) {							// 서비스타임이 주어졌을 때 업무를 수행
				System.out.printf("고객 %d이 업무 처리중입니다.\n", p1.personNum);
				ServiceTime--;
				if (ServiceTime == 0) {						// 업무가 종료되었을 때
					p1.ServiceEnd(i);
					Result.enqueue(p1);
					System.out.printf("태피가 %d분에 현재 업무를 마무리합니다.\n", i);
				}
			} else if (p1.doService == true) {				// 태피가 업무를 수행할 수 있을 때
				if (!Person.isEmpty()) {
					p1 = Person.dequeue();
					ServiceTime = p1.serviceTime;
					p1.ServiceStart(i);
					System.out.printf("고객 %d의 업무가 %d분에 처리됩니다.\n대기시간은 %d분이었으며 현재 대기중인 인원 : %d\n", p1.personNum, i, p1.waitTime, Person.size());
					TotWaitTime = p1.waitTime;
				}
			}
		}
		System.out.printf("-----480분 업무 종료------\n\n총 대기시간은 %d분이며 처리 못한 인원은 %d명입니다.\n\n", TotWaitTime,Person.size() + 1);

		ResSize = Result.size();
		System.out.println("업무 수행에 성공한 고객의 명단");		// Result 스택의 모든 요소 출력
		for (int i = 0; i < ResSize; i++) {
			p1 = Result.dequeue();
			System.out.println(p1.toString());
		}
	}
}
