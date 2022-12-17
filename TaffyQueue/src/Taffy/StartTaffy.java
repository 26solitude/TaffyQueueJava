package Taffy;

import java.io.IOException;

public class StartTaffy {
	static void Start() throws IOException {
		MakeQueue<Person> Person = new MakeQueue<Person>();
		MakeQueue<Person> Vip = new MakeQueue<Person>();
		MakeQueue<Person> Result = new MakeQueue<Person>();
		Person p1 = new Person(0, 0);

		int TotWaitTime = 0; // 고객의 총 대기시간
		int TotCusNum = 1; // 총 고객의 수
		int ServiceTime = 0; // 처리시간을 저장할 변수

		WorkProcess.Work(Person, Result, Vip, p1, TotWaitTime, TotCusNum, ServiceTime);
		
		PrintTot.Print(Result);
	}
}
