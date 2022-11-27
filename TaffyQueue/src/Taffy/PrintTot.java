package Taffy;

public class PrintTot {
	public static void Print(MakeQueue<Person> Result) {
		Person p1;
		int ResSize;
		ResSize = Result.size();
		System.out.println("업무 수행에 성공한 고객의 명단"); // Result 스택의 모든 요소 출력
		for (int i = 0; i < ResSize; i++) {
			p1 = Result.dequeue();
			System.out.println(p1.toString());
		}
	}
}
