package Taffy;

public class Person {
	public int arriveTime; // 도착시간
	public int startService; // 서비스 시작 시간
	public int endService; // 서비스 종료 시간
	public int serviceTime; // 서비스 시간
	public int waitTime; // 대기 시간
	public int personNum; // 고객의 번호
	boolean doService; // 서비스가 수행되었는가
	boolean vip;

	public Person(int currentTime, int number) {
		this.arriveTime = currentTime;
		this.personNum = number;
		this.waitTime = 0;
		this.startService = 0;
		this.endService = 0;
		this.doService = true;
		this.serviceTime = (int) (Math.random() * 10 + 1);
		this.vip=false;

	}

	@Override
	public String toString() {
		System.out.printf("%-3d번 고객   도착시간 : %-3d   서비스 시작시간 : %-3d   서비스 종료시간 : %-3d   서비스 소요시간 : %-3d   대기시간 : %-3d"
				, personNum, arriveTime, startService,endService,serviceTime,waitTime);
		return personNum +"번 고객   도착시간=" + arriveTime + "분   서비스 시작시간=" + startService
				+ "분   서비스 종료시간=" + endService + "분   서비스 소요시간=" + serviceTime + "분   대기시간=" + waitTime+"분";
	}
	
	public String FailtoString() {
		System.out.printf("%-3d번 고객   도착시간 : %-3d   서비스 소요시간 : %-3d   대기시간 : %-3d   업무수행 : 실패"
				, personNum, arriveTime, serviceTime,waitTime);
		
		return personNum +"번 고객   도착시간=" + arriveTime + "분   서비스 소요시간=" + serviceTime + "분   대기시간=" + waitTime+"분   업무수행 : 실패";
	}

	public void ServiceStart(int currentTime) {
		this.waitTime = currentTime - this.arriveTime;
		this.startService = currentTime;
		doService = false;
	}

	public void ServiceEnd(int currentTime) {
		this.endService = currentTime;
		doService = true;
	}
	
}