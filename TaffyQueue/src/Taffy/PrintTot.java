package Taffy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintTot {
	public static void Print(MakeQueue<Person> Result) throws IOException {
		Person p1;
		int ResSize;
		ResSize = Result.size();

		// 1. 파일 객체 생성
		File file = new File("c:/test/CustomerList.txt");

		// 2. 파일 존재여부 체크 및 생성
		if (!file.exists()) {
			file.createNewFile();
		}
		// 3. Writer 생성
		FileWriter fw = new FileWriter(file);
		PrintWriter writer = new PrintWriter(fw);

		System.out.println("태피 상점을 방문한 고객들의 명단"); // Result 스택의 모든 요소 출력
		writer.print("태피 상점의 금일 고객명단\n\n");

		for (int i = 0; i < ResSize; i++) {
			p1 = Result.dequeue();

			if (p1.doService == true) {
				if (p1.vip == true) {
					writer.println(p1.toString() + "   (vip)");
					System.out.println("	(vip)");
				} else {
					writer.println(p1.toString());
					System.out.println("");
				}
			} else {
					writer.println(p1.FailtoString());
					System.out.println();
			}
		}
		// 5. PrintWriter close

		writer.close();

	}

}
