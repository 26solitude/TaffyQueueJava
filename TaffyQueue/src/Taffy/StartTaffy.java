package Taffy;

public class StartTaffy {
	static void Start() {
		MakeQueue<Person> Person = new MakeQueue<Person>();
		MakeQueue<Person> Result = new MakeQueue<Person>();
		Person p1 = new Person(0, 0);

		int TotWaitTime = 0; // 고객의 총 대기시간
		int TotCusNum = 1; // 총 고객의 수
		int ServiceTime = 0; // 처리시간을 저장할 변수

		TotWaitTime = WorkProcess.Work(Person, Result, p1, TotWaitTime, TotCusNum, ServiceTime);
		System.out.printf("-----480분 업무 종료------\n\n총 대기시간은 %d분이며 처리 못한 인원은 %d명입니다.\n\n", TotWaitTime,
				Person.size() + 1);

		PrintTot.Print(Result);
	}
}
