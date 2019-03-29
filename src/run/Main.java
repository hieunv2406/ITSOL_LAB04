package run;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Account;
import entities.Student;
import model.AccountModel;
import model.StudentModel;

public class Main {
	List<Account> listAc = new ArrayList<>();
	List<Account> listAc1 = new ArrayList<>();
	List<Student> listStudents = new ArrayList<>();
	List<Student> listAllStudents = new ArrayList<>();

	public static void main(String[] args) {
		Main main1 = new Main();
		int chon;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Menu: ");
			System.out.println("1: Dang Nhap");
			System.out.println("2:Thoat!");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				main1.login();

				break;
			case 2:
				System.exit(0);
			}
		} while (chon != 8);
	}


	public boolean login() {
		boolean check = false;
		Scanner sc = new Scanner(System.in);
		AccountModel acM = new AccountModel();
		listAc = acM.getAccountDB();
		System.out.println("nhap ten tai khoan: ");
		String inName = sc.nextLine();
		for (Account acc : listAc) {
			if (inName.equals(acc.getAccount_Id())) {
				System.out.println("Dang nhap thanh cong !");
				System.out.println(acc.toString());
				check = true;
				listAc1.add(acc);
				break;
			}


		}
		if (check == true) {

			Main main1 = new Main();
			Student student = new Student();
			int chon;
			do {
				System.out.println("Menu: ");
				System.out.println("1: Xem danh sach hoc vien");
				System.out.println("2: Them Moi hoc vien");
				System.out.println("3: Sua thong tin cua hoc vien theo id");
				System.out.println("4: Xoa hoc vien theo id");
				System.out.println("5: Tim kiem thong tin hoc vien theo ten");
				System.out.println("6: Xap xep sinh vien theo ten");
				System.out.println("7: Thoat!");
				chon = Integer.parseInt(sc.nextLine());
				switch (chon) {
				case 1:
					for (Account account : listAc1) {
						String accountID = account.getAccount_Id();
						main1.listStudentView(accountID);
					}
					// main1.listAllStudentView();
					break;
				case 2:

					main1.addNewStudent(student);
					break;
				case 3:

					main1.updateStudent(student);
					break;
				case 4:

					break;
				case 5:

					break;
				case 6:

					break;
				case 7:
					System.exit(0);
				}
			} while (chon != 8);

		} else {
			System.out.println("tai khoan khong ton tai");
		}
		return check;

	}

	public void listStudentView(String accountID) {


		StudentModel stM = new StudentModel();
		listStudents = stM.getStudentByAccountId(accountID);

		for (Student st : listStudents) {
			System.out.println(st.toString());
		}

	}

	public void listAllStudentView() {
		StudentModel stM = new StudentModel();
		listAllStudents = stM.getAllStudent();
		for (Student st : listAllStudents) {
			System.out.println(st.toString());
		}

	}

	public void addNewStudent(Student student) {

		StudentModel stM = new StudentModel();
		listAllStudents = stM.getAllStudent();
		Scanner sc = new Scanner(System.in);
		System.out.println("---Nhap thong tin---");
		boolean check1 = true;
		do {

			System.out.println("Nhap id: ");
			student.setId(sc.nextLine());
			for (Student student1 : listAllStudents) {
				if (student.getId().equals(student1.getId())) {
					System.out.println("Id da ton tai! vui long nhap lai");
					check1 = false;
					break;
				} else {
					check1 = true;
				}

			}

		} while (check1 == false);

			System.out.println("Nhap StudentName: ");
			student.setStudentName(sc.nextLine());
			System.out.println("Nhap StudentEmail: ");
			student.setStudentEmail(sc.nextLine());

		do {
			System.out.println("Nhap PhoneNumber: ");
			try {
				student.setPhoneNumber(Integer.parseInt(sc.nextLine()));
				check1 = true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("vui long nhap kieu so nguyen!");
				check1 = false;
			}
		} while (check1 == false);

			System.out.println("Nhap StudentClass: ");
			student.setStudentClass(sc.nextLine());
			System.out.println("Nhap Note: ");
			student.setNote(sc.nextLine());
			System.out.println("Nhap Account_id");
			student.setAccount_Id(sc.nextLine());


			boolean check = stM.insertNewStudent(student);
			if (check) {
				System.out.println("them thanh cong");
			} else {
				System.out.println("them that bai");
			}
	}

	public void updateStudent(Student student) {
		StudentModel stM = new StudentModel();
		Scanner sc = new Scanner(System.in);
		listAllStudents = stM.getAllStudent();
		boolean check1 = true;
		do {

			System.out.println("Nhap StudentID can sua: ");
			String id = sc.nextLine();
			for (Student st : listAllStudents) {
				if (id.equals(st.getId())) {
					System.out.println("Thong tin hoc vien truoc khi sua:");
					System.out.println(st.toString());
					student.setId(st.getId());
					check1 = true;
					break;
				} else {
					check1 = false;

				}

			}

		} while (check1 == false);

		System.out.println("Nhap StudentName: ");
		student.setStudentName(sc.nextLine());
		System.out.println("Nhap StudentEmail: ");
		student.setStudentEmail(sc.nextLine());

		do {
			System.out.println("Nhap PhoneNumber: ");
			try {
				student.setPhoneNumber(Integer.parseInt(sc.nextLine()));
				check1 = true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("vui long nhap kieu so nguyen!");
				check1 = false;
			}
		} while (check1 == false);

		System.out.println("Nhap StudentClass: ");
		student.setStudentClass(sc.nextLine());
		System.out.println("Nhap Note: ");
		student.setNote(sc.nextLine());
		System.out.println("Nhap Account_id");
		student.setAccount_Id(sc.nextLine());

		boolean check = stM.updateStudent(student);
		if (check) {
			System.out.println("Sua thanh cong");
		} else {
			System.out.println("Sua that bai");
		}

	}
	}


