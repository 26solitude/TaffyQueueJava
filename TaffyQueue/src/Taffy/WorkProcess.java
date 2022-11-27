package Taffy;

public class WorkProcess {
	public static int Work(MakeQueue<Person> Person, MakeQueue<Person> Result, Person p1, int TotWaitTime,
			int TotCusNum, int ServiceTime) {
		for (int i = 1; i < 480; i++) {
			IsWorkNow.Check(p1, ServiceTime);
			TotCusNum = IsCusEnter.Check(Person, TotCusNum, i);

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
}
