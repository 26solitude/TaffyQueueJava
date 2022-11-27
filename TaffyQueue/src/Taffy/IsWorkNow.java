package Taffy;

public class IsWorkNow {
	public static void Check(Person p1, int i) {
		System.out.printf("-----현재 시간 %d분-----\n", i);
		if (p1.doService == true) { // 태피가 업무중인지 여부 검사
			System.out.println("태피는 휴식 중\n");
		} else {
			System.out.println("태피는 작업 중\n");
		}
	}
}
