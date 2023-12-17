package kr.ac.kopo;

import java.util.Scanner;

public class CalcConsole {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Calc calc = new Calc();
		
		while(true) {
			System.out.println("입력: ");
			
			String button = scanner.next();
			
			if("exit".equals(button))
				break;
			
			calc.onButton(button);
			
			System.out.println(calc.getDisplay());
		}
	}
}
