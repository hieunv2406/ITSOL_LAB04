package entities;

import java.util.Scanner;

public class Student {
	private String id;
	private String studentName;
	private String studentEmail;
	private int phoneNumber;
	private String studentClass;
	private String note;
	private String account_Id;

	public Student() {
		super();
	}

	public Student(String id, String studentName, String studentEmail, int phoneNumber, String studentClass,
			String note, String account_Id) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.phoneNumber = phoneNumber;
		this.studentClass = studentClass;
		this.note = note;
		this.account_Id = account_Id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAccount_Id() {
		return account_Id;
	}

	public void setAccount_Id(String account_Id) {
		this.account_Id = account_Id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", studentEmail=" + studentEmail
				+ ", phoneNumber=" + phoneNumber + ", studentClass=" + studentClass + ", note=" + note + ", account_Id="
				+ account_Id + "]";
	}

	public void insertDataStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap id: ");
		this.id = sc.nextLine();
		System.out.println("Nhap id: ");
		this.id = sc.nextLine();
		System.out.println("Nhap id: ");
		this.id = sc.nextLine();
		System.out.println("Nhap id: ");
		this.id = sc.nextLine();
		System.out.println("Nhap id: ");
		this.id = sc.nextLine();
		System.out.println("Nhap id: ");
		this.id = sc.nextLine();
		System.out.println("Nhap id: ");
		this.id = sc.nextLine();
		System.out.println("Nhap id: ");
		this.id = sc.nextLine();
	}

}
