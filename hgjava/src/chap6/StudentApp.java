package chap6;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		boolean run = true;
		Student[] students = new Student[100];
		Scanner scn = new Scanner(System.in);
		StudentExe exe = new StudentExe();
		while(run) {
			System.out.println("1.��� 2.��� 3.�ܰ���ȸ 4.���� 5.���� 6.����");
			int menu = Integer.parseInt(scn.nextLine()); // "1"
			
			switch(menu) {
			
			case 1: // �߰�.
				System.out.print("�л���ȣ�Է�>> ");
				String no = scn.nextLine();
				System.out.print("�л��̸��Է�>> ");
				String name = scn.nextLine();
				System.out.print("���������Է�>> ");
				int eng = Integer.parseInt(scn.nextLine());
				System.out.print("���������Է�>> ");
				int mat = Integer.parseInt(scn.nextLine());
				Student std = new Student(no, name, eng, mat);
				// students �迭�� �Ѱ� ����.
				if(exe.addStudent(std)) {
					System.out.println("����Ǿ����ϴ�.");
				}
				else {
					System.out.println("���� �� ����.");
				}
				break;
				
			case 2: // ��Ϻ���.
				for(Student stdnt : exe.getStudentList()) {
					if(stdnt != null) {
						stdnt.showInfo();
					}
				} //Student[] Ÿ��
				
				break;
			case 3: // �ܰ���ȸ.
				System.out.println("��ȸ�� �л���ȣ �Է�>>>>");
				no = scn.nextLine();
				Student stnt = exe.getStudent(no);
				if(stnt != null) {
					stnt.showInfo();
				}
				else {
					System.out.println("�������� �ʴ� ����.");
				}
				break;
			case 4: // ����.
				System.out.println("������ �л���ȣ �Է�>>>>");
				no = scn.nextLine();
				System.out.print("������������>> ");
				eng = Integer.parseInt(scn.nextLine());
				System.out.print("������������>> ");
				mat = Integer.parseInt(scn.nextLine());
				if(exe.modifyStudent(no, eng, mat)) {
					System.out.println("���� �Ϸ�");
				}
				else {
					System.out.println("ã�� �� �����ϴ�");
				}
				break;
			case 5:
				System.out.println("������ �л��̸� �Է�>>>>");
				name = scn.nextLine();
				
				break;
			case 6:
				System.out.println("���α׷��� �����մϴ�.");
				run = false;
			}
		}//end of while.
		System.out.println("end of prog.");
	}//end main
}//end class