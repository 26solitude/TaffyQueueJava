package Taffy;

public class Main {
	public static void main(String args[]) {
		MakeQueue<Person> Person = new MakeQueue<Person>();
		
		int totalWaitTime=0;
		int serviceTime = 0;
		int serviceCustomer = 0;
		int CusNum = 1;
		boolean Counter = true;
	
		for (int i = 0; i < 60; i++) {
			System.out.println("-----현재 시간-----");
			if (Counter == true)
				System.out.println("태피는 작업 중\n");
			else
				System.out.println("태피는 휴식 중\n");
			
			if (((int) (Math.random() * 4) + 1) == 4) {
				Person per = new Person(i, CusNum++);
				Person.enqueue(per);
				System.out.printf("고객 %d이 %d분에 들어옵니다. 업무 처리시간 : %d\n", per.personNum, per.arriveTime, per.serviceTime);
			}

			if (serviceTime > 0) {
				System.out.printf("고객 %d이 업무 처리중입니다.\n", Person.peek().personNum);
				serviceTime--;
				if (serviceTime == 0) {
					System.out.printf("태피가 %d분에 현재 업무를 마무리합니다.\n", i);
					Counter = true;
				}
			}
			else if (Counter) {
				if (!Person.isEmpty()) {
					Person cus = Person.dequeue();
					System.out.printf("고객 %d의 업무가 %d분에 처리됩니다.\n대기시간은 %d분이었으며 현재 대기중인 인원 : %d\n", cus.personNum, i,
							i - cus.arriveTime, CusNum - cus.personNum - 1);
					totalWaitTime += (i - cus.arriveTime);
					Counter=false;
				}
			}
		}
		System.out.printf("-----60분 업무 종료------\n총 대기시간은 %d분이며 처리 못한 인원은 %d명입니다.",totalWaitTime, CusNum - serviceCustomer - 1);
	}
}
