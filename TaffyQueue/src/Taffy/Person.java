package Taffy;

public class Person {
	public int arriveTime; //도착시간
//	public int startService; //서비스 시작 시간
//	public int endService; //서비스 종료 시간
	public int serviceTime; //서비스 시간
//	public int waitTime; //대기 시간
	public int personNum; //고객의 번호
//	boolean doService; //서비스가 수행되었는가
	
	public Person(int currentTime, int number) {
		this.arriveTime=currentTime;
		this.personNum=number;
//		this.waitTime=0;
//		this.startService=0;
//		this.endService=0;
//		this.doService=false;
		this.serviceTime=(int)(Math.random()*10+1);
	
	}
	
//	@Override
//	public String toString() {
//		return "Person [arriveTime=" + arriveTime + ", startService=" + startService + ", endService=" + endService
//				+ ", serviceTime=" + serviceTime + ", waitTime=" + waitTime + ", personNum=" + personNum
//				+ ", doService=" + doService + "]";
//	}
//
//	public void ServiceStart(int currentTime) {
//		this.waitTime=currentTime-this.arriveTime;
//		this.startService=currentTime;
//	}
//	public void ServiceEnd(int currentTime) {
//		this.endService=currentTime;
//		doService=true;
//	}
//	
//	public void ServiceFail(int currentTime) {
//		this.waitTime=currentTime-this.arriveTime;
//	}
}