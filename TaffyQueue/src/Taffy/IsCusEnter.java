package Taffy;

public class IsCusEnter {
	public static int Check(MakeQueue<Person> Person, int TotCusNum, int i) {
		if (((int) (Math.random() * 4) + 1) == 4) { // 난수가 4일 경우 손님 입장
			Person per = new Person(i, TotCusNum++);
			Person.enqueue(per);
			System.out.printf("고객 %d이 %d분에 들어옵니다. 업무 처리시간 : %d\n", per.personNum, per.arriveTime, per.serviceTime);
		}
		return TotCusNum;
	}
}
