import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

	public static void main (String[]args) throws IndexOutOfBoundsException {
		ArrayList<Integer> ISBN = new ArrayList<>();
		file ("ISBN");
		readFileInt("ISBN", ISBN);
		/*ISBN.add(6573421);
		ISBN.add(6573422);
		ISBN.add(6573423);*/
		writeFileInt("ISBN", ISBN);

		ArrayList<String> BookName = new ArrayList<>();
		file("bookName");
		readFileStr("bookName", BookName);
		/*BookName.add("Effective Java by Joshua Bloch, 2001");
		BookName.add("Python for Data Analysis by Wes McKinney, 2011");
		BookName.add("Java Concurrency in Practice by Brian Goetz, 2008");*/
		writeFileStr("bookName", BookName);

		ArrayList<Integer> Quantity = new ArrayList<>();
		file("Quantity");
		readFileInt("Quantity", Quantity);
		/*Quantity.add(2);
		Quantity.add(1);
		Quantity.add(3);*/
		writeFileInt("Quantity", Quantity);

		ArrayList<String> studentID = new ArrayList<>();
		file("studentID");
		readFileStr("studentID", studentID);
		/*studentID.add("SP22-BSE-027");*/
		writeFileStr("studentID", studentID);

		ArrayList<String> studentName = new ArrayList<>();
		file("studentName");
		readFileStr("studentName", studentName);
		/*studentName.add("Moeez-ur-Rehman");*/
		writeFileStr("studentName", studentName);

		ArrayList<String> studentNumber = new ArrayList<>();
		file("studentNumber");
		readFileStr("studentNumber", studentNumber);
		/*studentNumber.add("moeez@123");*/
		writeFileStr("studentNumber", studentNumber);

		ArrayList<String> issuedBook1 = new ArrayList<>();
		file("issuedBook1");
		readFileStr("issuedBook1", issuedBook1);

		ArrayList<Integer> issueBook1ISBN = new ArrayList<>();
		file("issueBook1ISBN");
		readFileInt("issueBook1ISBN", issueBook1ISBN);

		ArrayList<LocalTime> issueTime1 = new ArrayList<>();
		file("issueTime1");
		readFileTime("issueTime1", issueTime1);

		ArrayList<String> issuedBook2 = new ArrayList<>();
		file("issuedBook2");
		readFileStr("issuedBook2", issuedBook2);

		ArrayList<Integer> issueBook2ISBN = new ArrayList<>();
		file("issueBook2ISBN");
		readFileInt("issueBook2ISBN", issueBook2ISBN);

		ArrayList<LocalTime> issueTime2 = new ArrayList<>();
		file("issueTime2");
		readFileTime("issueTime2", issueTime2);

		ArrayList<String> issuedBook3 = new ArrayList<>();
		file("issuedBook3");
		readFileStr("issuedBook3", issuedBook3);

		ArrayList<Integer> issueBook3ISBN = new ArrayList<>();
		file("issueBook3ISBN");
		readFileInt("issueBook3ISBN", issueBook3ISBN);

		ArrayList<LocalTime> issueTime3 = new ArrayList<>();
		file("issueTime3");
		readFileTime("issueTime3", issueTime3);

		ArrayList<Integer> passwordTry = new ArrayList<>();
		file ("passwordTry");
		readFileInt("passwordTry",passwordTry);
		//passwordTry.add(3);
		writeFileInt("passwordTry", passwordTry);

		//issuedBook1.add("NULL");
		writeFileStr("issuedBook1", issuedBook1);
		//issueBook1ISBN.add(0);
		writeFileInt("issueBook1ISBN", issueBook1ISBN);
		//issueTime1.add(LocalTime.ofSecondOfDay(0));
		writeFileTime("issueTime1", issueTime1);
		//issuedBook2.add("NULL");
		writeFileStr("issuedBook2", issuedBook2);
		//issueBook2ISBN.add(0);
		writeFileInt("issueBook2ISBN", issueBook2ISBN);
		//issueTime2.add(LocalTime.ofSecondOfDay(0));
		writeFileTime("issueTime2", issueTime2);
		//issuedBook3.add("NULL");
		writeFileStr("issuedBook3", issuedBook3);
		//issueBook3ISBN.add(0);
		writeFileInt("issueBook3ISBN", issueBook3ISBN);
		//issueTime3.add(LocalTime.ofSecondOfDay(0));
		writeFileTime("issueTime3", issueTime3);

		ArrayList<String> searchBook = new ArrayList<>();
		ArrayList<Integer> searchISBN = new ArrayList<>();

		ArrayList<String> adminLogin = new ArrayList<>();
		file("adminLogin");
		readFileStr("adminLogin", adminLogin);
		//adminLogin.add("admin");
		writeFileStr("adminLogin", adminLogin);

		ArrayList<String> adminPassword = new ArrayList<>();
		file("adminPassword");
		readFileStr("adminPassword", adminPassword);
		//adminPassword.add("123");
		writeFileStr("adminPassword", adminPassword);

		ArrayList<LocalTime> loginTime = new ArrayList<>();
		file("loginTime");
		readFileTime("loginTime", loginTime);
		//loginTime.add(LocalTime.ofSecondOfDay(0));
		writeFileTime("loginTime", loginTime);

		while (true) {
			try {
				try {
					Scanner input = new Scanner(System.in);
					System.out.println("\n============================================");
					System.out.println("<<<<<<<<<<<<<<<  LOGIN MENU  >>>>>>>>>>>>>>>");
					System.out.println("============================================");
					System.out.print("\t\t1 -- Admin Login.\n\t\t2 -- Student Login.\n\t\t3 -- To Search Book.\n\t\t4 -- Exit.\n\t\tEnter Your Choice: ");
					int x = input.nextInt();
					if (x == 1) {
						System.out.print("\n\t\tEnter Login: ");
						input.nextLine();
						String login = input.nextLine();
						int index = adminLogin.indexOf(login);
						if (index == -1) {
							System.out.println("\n\t\tInvalid..");
						} else {
							System.out.print("\t\tEnter Password: ");
							String pass = input.nextLine();
							if (Objects.equals(pass, adminPassword.get(index))) {
								admin(ISBN, Quantity, BookName, studentID, studentName, studentNumber, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN, issueTime1, issueTime2, issueTime3, loginTime, searchBook, searchISBN, passwordTry, adminLogin, adminPassword, index);
							} else {
								System.out.println("\n\t\tWrong Password");
							}
						}
						System.out.println("\n\t\tPress Enter to Continue");
						input.nextLine();
					} else if (x == 2) {
						boolean a = true;
						while (a) {
							System.out.print("\t\tEnter Registration Number: ");
							String p = input.next();
							String login = p.toUpperCase();
							int index = studentID.indexOf(login);
							if (index == -1) {
								System.out.println("\t\tNot Registered.");
								a = false;
							} else {
								LocalTime Time = LocalTime.now();
								long diffInSeconds = java.time.Duration.between(loginTime.get(index), Time).getSeconds();
								if ((diffInSeconds > 0) && (diffInSeconds <= 60)) {
									long t = 60 - diffInSeconds;
									System.out.println("\t\tTry Again After " + t + " seconds.");
									a = false;
								} else if (diffInSeconds > 60) {
									loginTime.set(index, LocalTime.ofSecondOfDay(0));
									writeFileTime("loginTime", loginTime);
									boolean b = true;
									while (b) {
										int t = passwordTry.get(index);
										System.out.print("\t\tEnter Password: ");
										String password = input.next();
										if (Objects.equals(password, studentNumber.get(index))) {
											passwordTry.set(index, 3);
											writeFileInt("passwordTry", passwordTry);
											student(index, studentID, studentName, studentNumber, BookName, searchBook, ISBN, searchISBN, Quantity, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN, issueTime1, issueTime2, issueTime3);
											a = b = false;
										} else {
											System.out.println("\t\tWrong Password");
											if (t != 1) {
												System.out.println("\t\t" + (t - 1) + " Attempts Left.");
												passwordTry.set(index, t - 1);
												writeFileInt("passwordTry", passwordTry);
												boolean c = true;
												while (c) {
													try {
														System.out.print("\n\t\t1. Try Again.\n\t\t2. Exit.\n\t\tEnter Your Choice: ");
														int choice = input.nextInt();
														if (choice == 1) {
															c = false;
														} else if (choice == 2) {
															b = a = c = false;
															break;
														} else {
															System.out.println("\n\t\tYou have entered an invalid choice");
															System.out.println("\t\tTry Again...");
														}
													} catch (InputMismatchException ex) {
														System.out.println("\n\t\tYou have entered an invalid input");
														System.out.println("\t\tTry Again...");
														input.nextLine();
													}
												}
											} else {
												System.out.println("\t\tTry Again After 60 Seconds.");
												LocalTime time = LocalTime.now();
												loginTime.set(index, time);
												passwordTry.set(index, 3);
												writeFileInt("passwordTry", passwordTry);
												writeFileTime("loginTime", loginTime);
												a = b = false;
											}
										}
									}
								}
							}
						}
						System.out.print("\n\t\tPress Enter to Continue");
						input.nextLine();
					} else if (x == 3) {
						publicSearch(BookName, searchBook, ISBN, searchISBN);
						System.out.print("\n\t\tPress Enter to Continue");
						input.nextLine();
						input.nextLine();
					} else if (x == 4) {
						break;
					} else {
						System.out.println("\n\t\tYou have entered an invalid choice");
						System.out.println("\t\tTry Again...");
					}
				} catch (InputMismatchException ex) {
					System.out.println("\n\t\tYou have entered an invalid input");
					System.out.println("\t\tTry Again...");
				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println("\n\t\tIndex Exception.");
			}
		}

		writeFileInt ("ISBN", ISBN);
		writeFileStr ("bookName", BookName);
		writeFileInt ("Quantity", Quantity);
		writeFileStr ("studentID", studentID);
		writeFileStr ("studentName", studentName);
		writeFileStr ("studentNumber", studentNumber);
		writeFileStr ("issuedBook1", issuedBook1);
		writeFileInt ("issueBook1ISBN", issueBook1ISBN);
		writeFileTime("issueTime1", issueTime1);
		writeFileStr ("issuedBook2", issuedBook2);
		writeFileInt ("issueBook2ISBN", issueBook2ISBN);
		writeFileTime("issueTime2", issueTime2);
		writeFileStr ("issuedBook3", issuedBook3);
		writeFileInt ("issueBook3ISBN", issueBook3ISBN);
		writeFileTime("issueTime3", issueTime3);
		writeFileInt ("passwordTry", passwordTry);
		writeFileTime("loginTime", loginTime);
		writeFileStr ("adminLogin", adminLogin);
		writeFileStr ("adminPassword", adminPassword);

	}

	//==========================================================================================================================================================
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//==========================================================================================================================================================


			public static void admin (ArrayList<Integer>ISBN,ArrayList<Integer>Quantity,ArrayList<String>BookName,ArrayList<String>studentID,ArrayList<String>studentName,ArrayList<String>studentNumber,ArrayList<String>issuedBook1,ArrayList<String>issuedBook2,ArrayList<String>issuedBook3,ArrayList<Integer>issueBook1ISBN,ArrayList<Integer>issueBook2ISBN,ArrayList<Integer>issueBook3ISBN,ArrayList<LocalTime> issueTime1,ArrayList<LocalTime> issueTime2,ArrayList<LocalTime> issueTime3,ArrayList<LocalTime> loginTime, ArrayList<String>searchBook,ArrayList<Integer>searchISBN, ArrayList<Integer>passwordTry, ArrayList<String>adminLogin, ArrayList<String>adminPassword, int index) {
			while (true) {
				Scanner input = new Scanner(System.in);
				try {
					System.out.println("\n===========================================");
					System.out.println("<<<<<<<<<<<<<<<  MAIN MENU  >>>>>>>>>>>>>>>");
					System.out.println("===========================================");
					System.out.println("\t\t 1 -- To Add Book.");
					System.out.println("\t\t 2 -- To Add Student.");
					System.out.println("\t\t 3 -- To Issue Book.");
					System.out.println("\t\t 4 -- To Search Student Profile.");
					System.out.println("\t\t 5 -- To Return Book.");
					System.out.println("\t\t 6 -- To Search Book.");
					System.out.println("\t\t 7 -- To Show List of Books.");
					System.out.println("\t\t 8 -- To Show List of Students.");
					System.out.println("\t\t 9 -- To Edit Book.");
					System.out.println("\t\t10 -- To Delete Book.");
					System.out.println("\t\t11 -- To Delete Student.");
					System.out.println("\t\t12 -- To Login settings.");
					System.out.println("\t\t13 -- To Exit.");
					System.out.print("\t\tEnter your choice: ");
					int choice = input.nextInt();
					if (choice == 1) {
						System.out.println("=====================================================");
						addBook(ISBN, BookName, Quantity);
						System.out.println("\n\t\tPress Enter to Continue");
						input.nextLine();
						input.nextLine();
					} else if (choice == 2) {
						System.out.println("=====================================================");
						addStudent(studentID, studentName, studentNumber, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN, issueTime1, issueTime2, issueTime3, loginTime, passwordTry);
						System.out.println("\n\t\tPress Enter to Continue");
						input.nextLine();
						input.nextLine();
					} else if (choice == 3) {
						System.out.println("=====================================================");
						issueBook(studentID, ISBN, Quantity, BookName, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN, issueTime1, issueTime2, issueTime3, studentName);
						System.out.println("\n\t\tPress Enter to Continue");
						input.nextLine();
						input.nextLine();
					} else if (choice == 4) {
						System.out.println("=====================================================");
						searchProfile(studentID, studentName, studentNumber, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN);
						System.out.println("\n\t\tPress Enter to Continue");
						input.nextLine();
						input.nextLine();
					} else if (choice == 5) {
						System.out.println("=====================================================");
						returnBook(studentID, ISBN, Quantity, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN, issueTime1, issueTime2, issueTime3,studentName);
						System.out.println("\n\t\tPress Enter to Continue");
						input.nextLine();
						input.nextLine();
					} else if (choice == 6) {
						System.out.println("=====================================================");
						searchBook(BookName, searchBook, ISBN, searchISBN, studentID, Quantity, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN, issueTime1, issueTime2, issueTime3, studentName);
						System.out.println("\n\t\tPress Enter to Continue");
						input.nextLine();
						input.nextLine();
					} else if (choice == 7) {
						System.out.println("=====================================================");
						booksList(ISBN, BookName, Quantity);
						System.out.println("\n\t\tPress Enter to Continue");
						input.nextLine();
						input.nextLine();
					} else if (choice == 8) {
						System.out.println("=====================================================");
						studentsList(studentID, studentName, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN);
						System.out.println("\n\t\tPress Enter to Continue");
						input.nextLine();
					} else if (choice == 9) {
						System.out.println("=====================================================");
						editBook(ISBN, BookName, Quantity);
						System.out.println("\n\t\tPress Enter to Continue");
						input.nextLine();
						input.nextLine();
					} else if (choice == 10) {
						System.out.println("=====================================================");
						dletBook(ISBN, BookName, Quantity);
						System.out.println("\n\t\tPress Enter to Continue");
						input.nextLine();
						input.nextLine();
					} else if (choice == 11) {
						System.out.println("=====================================================");
						deleteStudent(studentID, studentName, studentNumber, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN, issueTime1, issueTime2, issueTime3, loginTime, passwordTry);
						System.out.println("\n\t\tPress Enter to Continue");
						input.nextLine();
						input.nextLine();
					} else if (choice == 12) {
						System.out.println("=====================================================");
						loginSettings(index, adminLogin, adminPassword, studentID, studentNumber);
						System.out.println("\n\t\tPress Enter to Continue");
						input.nextLine();
						input.nextLine();
					} else if (choice == 13) {
						break;
					} else {
						System.out.println("\n\t\tYou have entered an invalid choice");
						System.out.println("\t\tTry Again...\n");
					}
				} catch (InputMismatchException a) {
					System.out.println("\n\t\tYou have entered an invalid input");
					System.out.println("\t\tTry Again...\n");
					input.nextLine();
				}
			}
		}

	//==========================================================================================================================================================

			public static void student (int studentIndex,ArrayList<String>studentID,ArrayList<String>studentName,ArrayList<String>studentNumber,ArrayList<String>BookName,ArrayList<String>searchBook,ArrayList<Integer>ISBN,ArrayList<Integer>searchISBN,ArrayList<Integer>Quantity,ArrayList<String>issuedBook1,ArrayList<String>issuedBook2,ArrayList<String>issuedBook3,ArrayList<Integer>issueBook1ISBN,ArrayList<Integer>issueBook2ISBN,ArrayList<Integer>issueBook3ISBN,ArrayList<LocalTime> issueTime1,ArrayList<LocalTime> issueTime2,ArrayList<LocalTime> issueTime3) {
		while (true) {
			try {
				Scanner input = new Scanner(System.in);
				System.out.println("\n===========================================");
				System.out.println("<<<<<<<<<<<<<<<  MAIN MENU  >>>>>>>>>>>>>>>");
				System.out.println("===========================================");
				System.out.println("\t\t1 -- Search book.");
				System.out.println("\t\t2 -- Issue book.");
				System.out.println("\t\t3 -- Change Password.");
				System.out.println("\t\t4 -- View Profile.");
				System.out.println("\t\t5 -- Exit.");
				System.out.print("\t\tEnter your choice: ");
				int choice = input.nextInt();
				if (choice == 1) {
					System.out.println("=====================================================");
					studentSearchBook(studentIndex, BookName, searchBook, ISBN, searchISBN, studentID, Quantity, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN, issueTime1, issueTime2, issueTime3, studentName);
					System.out.println("\n\t\tPress Enter to Continue");
					input.nextLine();
					input.nextLine();
				} else if (choice == 2) {
					System.out.println("=====================================================");
					studentIssueBook(studentIndex, studentID, studentName, ISBN, Quantity, BookName, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN, issueTime1, issueTime2, issueTime3);
					System.out.println("\n\t\tPress Enter to Continue");
					input.nextLine();
					input.nextLine();
				} else if (choice == 3) {
					System.out.println("=====================================================");
					studentChangePassword(studentIndex, studentNumber);
					System.out.println("\n\t\tPress Enter to Continue");
					input.nextLine();
					input.nextLine();
				} else if (choice == 4) {
					System.out.println("=====================================================");
					showProfile(studentIndex, studentID, studentName, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN);
					System.out.println("\n\t\tPress Enter to Continue");
					input.nextLine();
					input.nextLine();
				} else if (choice == 5) {
					break;
				}else {
					System.out.println("\n\t\tYou have entered an invalid choice");
					System.out.println("\n\t\tTry Again...");
				}
			}catch (InputMismatchException ex) {
				System.out.println("\n\t\tYou have entered an invalid input");
				System.out.println("\n\t\tTry Again...");
			}
		}
	}

	//-----------------------------------------------------------------------------------------------------------------------------------------
	//                   Method for admin to add book in library.
			public static void addBook (ArrayList<Integer>ISBN,ArrayList<String>BookName,ArrayList<Integer>Quantity) {
				Scanner input = new Scanner(System.in);
				boolean y = true;
				while (y) {
					if (ISBN.size() == 0) {
						ISBN.add(6573421);
					} else {
						int z = ISBN.get(ISBN.size() - 1);
						ISBN.add(z + 1);
					}
					System.out.print("\n\t\tEnter Book Name: ");
					String bookName = input.nextLine();
					BookName.add(bookName);
					//boolean x = true;
					while (true) {
						try {
							System.out.print("\t\tEnter Quantity of books: ");
							int quantity = input.nextInt();
							if (quantity <= 0) {
								System.out.println("\n\t\tEnter Right Quantity.\n");
							} else {
								Quantity.add(quantity);
								break;
							}
						} catch (InputMismatchException ex) {
							System.out.println("\n\t\tYou have entered an invalid input");
							System.out.println("\t\tTry Again...");
							input.nextLine();
						}
					}
					//System.out.println("Book Added Successfully.\n");
					System.out.println("==========================================================\n");
					System.out.println("\tISBN: " + ISBN.get(ISBN.size() - 1));
					System.out.println("\tName: " + BookName.get(BookName.size() - 1));
					System.out.println("\tQuantity: " + Quantity.get(Quantity.size() - 1) + "\n");
					System.out.println("\n==========================================================");
					boolean p = true;
					while (p) {
						try {
							System.out.println("\t\tAre you sure you want to save this book:");
							System.out.println("\t\t1. Yes\n\t\t2. No");
							System.out.print("\t\tEnter Your Choice: ");
							int save = input.nextInt();
							if (save == 1) {
								System.out.println("\n\t\tBook Added Successfully.");
								p = false;
							} else if (save == 2) {
								ISBN.remove(ISBN.size() - 1);
								BookName.remove(BookName.size() - 1);
								Quantity.remove(Quantity.size() - 1);
								System.out.println("\n\t\tBook Doesn't Added.");
								p = false;
							} else {
								System.out.println("\n\t\tYou have entered an invalid choice");
								System.out.println("\t\tTry Again...");
							}
						} catch (InputMismatchException ex) {
							System.out.println("\n\t\tYou have entered an invalid input");
							System.out.println("\t\tTry Again...");
							input.nextLine();
						}
						writeFileInt ("ISBN", ISBN);
						writeFileStr ("bookName", BookName);
						writeFileInt ("Quantity", Quantity);
					}
					boolean c = true;
					while (c) {
						try {
							System.out.print("\n\t\t1. To Add Another Book.\n\t\t2. Back.\n\t\tEnter Your Choice: ");
							int choice = input.nextInt();
							if (choice == 1) {
								input.nextLine();
								c = false;
							} else if (choice == 2) {
								c = y = false;
							} else {
								System.out.println("\n\t\tYou have entered an invalid choice");
								System.out.println("\t\tTry Again...");
							}
						} catch (InputMismatchException ex) {
							System.out.println("\n\t\tYou have entered an invalid input");
							System.out.println("\t\tTry Again...");
							input.nextLine();
						}
					}
				}
			}

	//-----------------------------------------------------------------------------------------------------------------------------------------
	//                   Method for admin to register student.
			public static void addStudent (ArrayList<String>studentID,ArrayList<String>studentName,ArrayList<String>studentNum,ArrayList<String>issueBook1,ArrayList<String>issueBook2,ArrayList<String>issueBook3,ArrayList<Integer>issueBook1IBAN,ArrayList<Integer>issueBook2IBAN,ArrayList<Integer>issueBook3IBAN,ArrayList<LocalTime> issueTime1,ArrayList<LocalTime> issueTime2,ArrayList<LocalTime> issueTime3, ArrayList<LocalTime> loginTime, ArrayList<Integer>passwordTry) {
				boolean m = true;
				while (m) {
					Scanner input = new Scanner(System.in);
					System.out.print("\n\t\tEnter Student Registration Number: ");
					String id = input.nextLine();
					String reg = id.toUpperCase();
					if (reg.length()!=12 ) {
						System.out.println("\n\t\tYou have entered an invalid Reg. Number");
						System.out.println("\t\tTry Again...");
						continue;
					} else if (reg.charAt(4) != '-' && reg.charAt(8) != '-' ) {
						System.out.println("\n\t\tYou have entered an invalid Reg. Number");
						System.out.println("\t\tTry Again...");
						continue;
					}
					int x = studentID.indexOf(reg);
					if (x != -1){
						System.out.println("\n\t\tThis Registration Number Already Registered.");
						m = false;
						continue;
					}
					studentID.add(reg);
					boolean mm = true;
					while (mm) {
						System.out.print("\t\tEnter Student Name: ");
						String name = input.nextLine();
						if (nameValid(name)) {
							studentName.add(name);
							mm = false;
						} else {
							System.out.println("\t\tType Correct Name...");
						}
					}
					boolean n = true;
					while (n) {
						System.out.print("\t\tEnter Login Password: ");
						String num = input.nextLine();
						if (isValid(num)) {
							studentNum.add(num);
							n = false;
						}else {
							System.out.println("\tPassword length must be between 8 to 15 characters.");
							System.out.println("\tContain upper case or lower case letters.");
							System.out.println("\tmust contain digit.\n\tmust contain special character.");
							System.out.println("\n\t\tTry Again...");
						}
					}
					issueBook1.add("NULL");
					issueBook1IBAN.add(0);
					issueTime1.add(LocalTime.ofSecondOfDay(0));
					issueBook2.add("NULL");
					issueBook2IBAN.add(0);
					issueTime2.add(LocalTime.ofSecondOfDay(0));
					issueBook3.add("NULL");
					issueBook3IBAN.add(0);
					issueTime3.add(LocalTime.ofSecondOfDay(0));
					loginTime.add(LocalTime.ofSecondOfDay(0));
					passwordTry.add(3);
					int w = studentID.size();
					int q = w-1;
					System.out.println("==========================================================\n");
					System.out.println("\tReg. no:  " + studentID.get(q));
					System.out.println("\tName:     " + studentName.get(q));
					System.out.println("\tPassword: " + studentNum.get(q));
					System.out.println("\n==========================================================");
					boolean p = true;
					while (p) {
						try {
							System.out.println("\t\tAre you sure you want to save this profile:");
							System.out.println("\t\t1. Yes\n\t\t2. No");
							System.out.print("\t\tEnter Your Choice: ");
							int save = input.nextInt();
							if (save == 1) {
								System.out.println("\n\t\tProfile Added Successfully.");
								p = false;
							} else if (save == 2) {
								int i = studentID.size() - 1;
								studentID.remove(i);
								studentName.remove(i);
								studentNum.remove(i);
								issueBook1.remove(i);
								issueBook1IBAN.remove(i);
								issueTime1.remove(i);
								issueBook2.remove(i);
								issueBook2IBAN.remove(i);
								issueTime2.remove(i);
								issueBook3.remove(i);
								issueBook3IBAN.remove(i);
								issueTime3.remove(i);
								loginTime.remove(i);
								passwordTry.remove(i);
								System.out.println("\n\t\tProfile Doesn't Added.");
								p = false;
							} else {
								System.out.println("\n\t\tYou have entered an invalid choice");
								System.out.println("\t\tTry Again...");
							}
						} catch (InputMismatchException ex) {
							System.out.println("\n\t\tYou have entered an invalid input");
							System.out.println("\t\tTry Again...");
							input.nextLine();
						}
						writeFileStr ("studentID", studentID);
						writeFileStr ("studentName", studentName);
						writeFileStr ("studentNumber", studentNum);
						writeFileStr ("issuedBook1", issueBook1);
						writeFileInt ("issueBook1ISBN", issueBook1IBAN);
						writeFileTime("issueTime1", issueTime1);
						writeFileStr ("issuedBook2", issueBook2);
						writeFileInt ("issueBook2ISBN", issueBook2IBAN);
						writeFileTime("issueTime2", issueTime2);
						writeFileStr ("issuedBook3", issueBook3);
						writeFileInt ("issueBook3ISBN", issueBook3IBAN);
						writeFileTime("issueTime3", issueTime3);
						writeFileInt ("passwordTry", passwordTry);
						writeFileTime("loginTime", loginTime);
					}
					boolean c = true;
					while (c) {
						try {
							System.out.print("\n\t\t1. To Add Another Student.\n\t\t2. Back.\n\t\tEnter Your Choice: ");
							int choice = input.nextInt();
							if (choice == 1) {
								input.nextLine();
								c = false;
							} else if (choice == 2) {
								c = m = false;
							} else {
								System.out.println("\n\t\tYou have entered an invalid choice");
								System.out.println("\t\tTry Again...");
							}
						} catch (InputMismatchException ex) {
							System.out.println("\n\t\tYou have entered an invalid input");
							System.out.println("\t\tTry Again...");
							input.nextLine();
						}
					}
				}
			}

	//-----------------------------------------------------------------------------------------------------------------------------------------
	//                   Method for admin to Issue Book.
			public static void issueBook (ArrayList<String>studentID,ArrayList<Integer>ISBN,ArrayList<Integer>Quantity,ArrayList<String>BookName,ArrayList<String>issuedBook1,ArrayList<String>issuedBook2,ArrayList<String>issuedBook3,ArrayList<Integer>issueBook1ISBN,ArrayList<Integer>issueBook2ISBN,ArrayList<Integer>issueBook3ISBN,ArrayList<LocalTime> issueTime1,ArrayList<LocalTime> issueTime2,ArrayList<LocalTime> issueTime3,ArrayList<String>studentName) {
				boolean m = true;
				while (m) {
					Scanner input = new Scanner(System.in);
					System.out.print("\n\t\tEnter Registration Number of Student: ");
					String iD = input.nextLine();
					String reg = iD.toUpperCase();
					int studentIndex = studentID.indexOf(reg);
					if (studentIndex == -1) {
						System.out.println("\n\t\tStudent Not Registered.");
						boolean mm = true;
						while (mm) {
							try {
								System.out.print("\n\t\t1.Enter Another Registration number.\n\t\t2.Exit\n\t\tEnter Your Choice:");
								int choice = input.nextInt();
								if (choice == 1) {
									mm = false;
								} else if (choice == 2) {
									mm = false;
									m = false;
								} else {
									System.out.println("\n\t\tYou have entered an invalid choice");
									System.out.println("\t\tTry Again...");
								}
							} catch (InputMismatchException ex) {
								System.out.println("\n\t\tYou have entered an invalid input");
								System.out.println("\t\tTry Again...");
								input.nextLine();
							}
						}
					} else {
						studentIssueBook(studentIndex, studentID, studentName, ISBN, Quantity, BookName, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN, issueTime1, issueTime2, issueTime3);
						m = false;

					}

				}
			}

	//----------------------------------------------------------------------------------------------------------------------------------------
	//                   Method for student to issue book.
			public static void studentIssueBook (int studentIndex,ArrayList<String>studentID,ArrayList<String>studentName,ArrayList<Integer>ISBN,ArrayList<Integer>Quantity,ArrayList<String>BookName,ArrayList<String>issuedBook1,ArrayList<String>issuedBook2,ArrayList<String>issuedBook3,ArrayList<Integer>issueBook1ISBN,ArrayList<Integer>issueBook2ISBN,ArrayList<Integer>issueBook3ISBN,ArrayList<LocalTime> issueTime1,ArrayList<LocalTime> issueTime2,ArrayList<LocalTime> issueTime3) {
				Scanner input = new Scanner(System.in);
				if (!(issueBook1ISBN.get(studentIndex) == 0 || issueBook2ISBN.get(studentIndex) == 0 || issueBook3ISBN.get(studentIndex) == 0)) {
					System.out.println("\n\t\tYou have already issued 3 books\n\t\tFirst return previous book\n\t\tthen try again...");
				} else {
					boolean n = true;
					while (n) {
						try {
							System.out.print("\t\tEnter ISBN of book you want to issue: ");
							int iSBN = input.nextInt();
							int bookIndex = ISBN.indexOf(iSBN);
							if (bookIndex == -1) {
								System.out.println("\n\t\tBook is not Available.");
								boolean nn = true;
								while (nn) {
									try {
										System.out.print("\n\t\t1.Enter Another ISBN.\n\t\t2.Exit\n\t\tEnter Your Choice:");
										int choice = input.nextInt();
										if (choice == 1) {
											nn = false;
										} else if (choice == 2) {
											nn = false;
											n = false;
										} else {
											System.out.println("\n\t\tYou have entered an invalid choice");
											System.out.println("\t\tTry Again...");
										}
									} catch (InputMismatchException ex) {
										System.out.println("\n\t\tYou have entered an invalid input");
										System.out.println("\t\tTry Again...");
										input.nextLine();
									}
								}
								continue;
							} else if (Quantity.get(bookIndex) == 0) {
								System.out.println("\n\t\tOut of Stock.");
								n = false;
								continue;
							} else {
								String x = BookName.get(bookIndex);
								String a = issuedBook1.get(studentIndex);
								String b = issuedBook2.get(studentIndex);
								String c = issuedBook3.get(studentIndex);
								String d = "NULL";
								LocalTime Time = LocalTime.now();
								if (Objects.equals(a, d)) {
									issuedBook1.set(studentIndex, x);
									issueBook1ISBN.set(studentIndex, iSBN);
									int w = Quantity.get(bookIndex);
									Quantity.set(bookIndex, w - 1);
									issueTime1.set(studentIndex, Time);
									System.out.println("\n\t\tBook Issued Successfully.");
									showProfile(studentIndex, studentID, studentName, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN);
								} else if (Objects.equals(b, d)) {
									issuedBook2.set(studentIndex, x);
									issueBook2ISBN.set(studentIndex, iSBN);
									int w = Quantity.get(bookIndex);
									Quantity.set(bookIndex, w - 1);
									issueTime2.set(studentIndex, Time);
									System.out.println("\n\t\tBook Issued Successfully.");
									showProfile(studentIndex, studentID, studentName, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN);
								} else if (Objects.equals(c, d)) {
									issuedBook3.set(studentIndex, x);
									issueBook3ISBN.set(studentIndex, iSBN);
									int w = Quantity.get(bookIndex);
									Quantity.set(bookIndex, w - 1);
									issueTime3.set(studentIndex, Time);
									System.out.println("\n\t\tBook Issued Successfully.");
									showProfile(studentIndex, studentID, studentName, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN);
								} else {
									System.out.println("\n\t\tYou have already issued 3 books\n\t\tFirst return previous book\n\t\tthen try again...");
									n = false;
								}
								writeFileStr("issuedBook1", issuedBook1);
								writeFileInt("issueBook1ISBN", issueBook1ISBN);
								writeFileTime("issueTime1", issueTime1);
								writeFileStr("issuedBook2", issuedBook2);
								writeFileInt("issueBook2ISBN", issueBook2ISBN);
								writeFileTime("issueTime2", issueTime2);
								writeFileStr("issuedBook3", issuedBook3);
								writeFileInt("issueBook3ISBN", issueBook3ISBN);
								writeFileTime("issueTime3", issueTime3);
								writeFileInt ("Quantity", Quantity);
							}
						} catch (InputMismatchException a) {
							System.out.println("\n\t\tYou have entered an invalid input");
							System.out.println("\t\tTry Again...");
							input.nextLine();
							continue;
						}
						boolean nn = true;
						while (nn) {
							try {
								System.out.print("\n\t\t1.Issue Another Book.\n\t\t2.Exit\n\t\tEnter Your Choice:");
								int choice = input.nextInt();
								if (choice == 1) {
									if (!(issueBook1ISBN.get(studentIndex) == 0 || issueBook2ISBN.get(studentIndex) == 0 || issueBook3ISBN.get(studentIndex) == 0)) {
										System.out.println("\n\t\tYou have already issued 3 books\n\t\tFirst return previous book\n\t\tthen try again...");
										n = nn = false;
									} else {
										nn = false;
									}
								} else if (choice == 2) {
									nn = false;
									n = false;
								} else {
									System.out.println("\n\t\tYou have entered an invalid choice");
									System.out.println("\t\tTry Again...");
								}
							} catch (InputMismatchException ex) {
								System.out.println("\n\t\tYou have entered an invalid input");
								System.out.println("\t\tTry Again...");
								input.nextLine();
							}
						}
					}
				}
			}

	//----------------------------------------------------------------------------------------------------------------------------------------
	//                    Method for admin to search any student profile.
			public static void searchProfile (ArrayList<String>studentID,ArrayList<String>studentName,ArrayList<String>studentNumber,ArrayList<String>issuedBook1,ArrayList<String>issuedBook2,ArrayList<String>issuedBook3,ArrayList<Integer>issueBook1ISBN,ArrayList<Integer>issueBook2ISBN,ArrayList<Integer>issueBook3ISBN) {
			Scanner input = new Scanner(System.in);
			System.out.print("\n\t\tEnter Registration Number of student: ");
			String iD = input.nextLine();
			String reg = iD.toUpperCase();
			int q = studentID.indexOf(reg);
			if (q == -1) {
				System.out.println("\t\tNot Registered.");
			}
			else {
				showProfile(q, studentID, studentName, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN);
				/*System.out.println(" ");
				System.out.println("ID: " + studentID.get(q));
				System.out.println("Name: " + studentName.get(q));
				System.out.println("Password: " + studentNumber.get(q));
				if (issueBook1ISBN.get(q) == 0 && issueBook2ISBN.get(q) == 0 && issueBook3ISBN.get(q) == 0){
					System.out.println("\nNo Book is issued.");
				}if (issueBook1ISBN.get(q) != 0) {
					System.out.println("\nIssued book ISBN: " + issueBook1ISBN.get(q) +
									   "\n            Name: " + issuedBook1.get(q));
				} if (issueBook2ISBN.get(q) != 0) {
					System.out.println("\nIssued book ISBN: " + issueBook2ISBN.get(q) +
							"\n            Name: " + issuedBook2.get(q));
				}if (issueBook3ISBN.get(q) != 0) {
					System.out.println("\nIssued book ISBN: " + issueBook3ISBN.get(q) +
							"\n            Name: " + issuedBook3.get(q));
				}*/
			}
	}

	//----------------------------------------------------------------------------------------------------------------------------------------
	//                    Method for admin to return book.
			public static void returnBook (ArrayList<String>studentID,ArrayList<Integer>ISBN,ArrayList<Integer>Quantity,ArrayList<String>issuedBook1,ArrayList<String>issuedBook2,ArrayList<String>issuedBook3,ArrayList<Integer>issuedBook1ISBN,ArrayList<Integer>issuedBook2ISBN,ArrayList<Integer>issuedBook3ISBN,ArrayList<LocalTime> issueTime1,ArrayList<LocalTime> issueTime2,ArrayList<LocalTime> issueTime3, ArrayList<String>studentName) {
				Scanner input = new Scanner(System.in);
				boolean m = true;
				while (m) {
					System.out.print("\n\t\tEnter Registration Number of Student:");
					String e = input.nextLine();
					String reg = e.toUpperCase();
					int studentIndex = studentID.indexOf(reg);
					if (studentIndex == -1) {
						System.out.println("\t\tNot Registered.");
						boolean mm = true;
						while (mm) {
							try {
								System.out.print("\n\t\t1.Enter Another Registration number.\n\t\t2.Exit\n\t\tEnter Your Choice:");
								int choice = input.nextInt();
								if (choice == 1) {
									mm = false;
								} else if (choice == 2) {
									mm = false;
									m = false;
								} else {
									System.out.println("\n\t\tYou have entered an invalid choice");
									System.out.println("\t\tTry Again...");
								}
							} catch (InputMismatchException ex) {
								System.out.println("\n\t\tYou have entered an invalid input");
								System.out.println("\t\tTry Again...");
								input.nextLine();
							}
						}
					} else if (issuedBook1ISBN.get(studentIndex) == 0 && issuedBook2ISBN.get(studentIndex) == 0 && issuedBook3ISBN.get(studentIndex) == 0) {
						showProfile(studentIndex, studentID, studentName, issuedBook1, issuedBook2, issuedBook3, issuedBook1ISBN, issuedBook2ISBN, issuedBook3ISBN);
						System.out.println("\n\t\tNo Book is Issued on this Registration Number.");
						m = false;
					} else {
						showProfile(studentIndex, studentID, studentName, issuedBook1, issuedBook2, issuedBook3, issuedBook1ISBN, issuedBook2ISBN, issuedBook3ISBN);
						boolean n = true;
						while (n) {
							try {
								System.out.print("\t\tEnter ISBN of book you want to return: ");
								int r = input.nextInt();
								int bookIndex = ISBN.indexOf(r);
								if (bookIndex == -1) {
									System.out.println("\n\t\tInvalid ISBN.");
									boolean nn = true;
									while (nn) {
										try {
											System.out.print("\n\t\t1.Enter Another ISBN.\n\t\t2.Exit\n\t\tEnter Your Choice:");
											int choice = input.nextInt();
											if (choice == 1) {
												nn = false;
											} else if (choice == 2) {
												nn = false;
												n = false;
												m = false;
											} else {
												System.out.println("\n\t\tYou have entered an invalid choice");
												System.out.println("\t\tTry Again...");
											}
										} catch (InputMismatchException ex) {
											System.out.println("\n\t\tYou have entered an invalid input");
											System.out.println("\t\tTry Again...");
											input.nextLine();
										}
									}
								} else {
									int t = issuedBook1ISBN.get(studentIndex);
									int y = issuedBook2ISBN.get(studentIndex);
									int u = issuedBook3ISBN.get(studentIndex);
									LocalTime Time = LocalTime.now();
									if (Objects.equals(r, t)) {
										issuedBook1ISBN.set(studentIndex, 0);
										issuedBook1.set(studentIndex, "NULL");
										int w = Quantity.get(bookIndex);
										Quantity.set(bookIndex, w + 1);
										long diffInSeconds = java.time.Duration.between(issueTime1.get(studentIndex), Time).getSeconds();
										issueTime1.set(studentIndex, LocalTime.ofSecondOfDay(0));
										System.out.println("\n\t\tYou return book after " + diffInSeconds + " seconds.");
										int f = (int) (diffInSeconds - 15);
										if (f <= 0) {
											System.out.println("\t\tYou return book in Time\n\t\t<<<< No Fine >>>>");
										} else {
											int g = f * 2;
											System.out.println("\t\tYou return book " + f + " seconds late.");
											System.out.println("\t\tYour fine is Rs." + g);
										}
										showProfile(studentIndex, studentID, studentName, issuedBook1, issuedBook2, issuedBook3, issuedBook1ISBN, issuedBook2ISBN, issuedBook3ISBN);
									} else if (Objects.equals(r, y)) {
										issuedBook2ISBN.set(studentIndex, 0);
										issuedBook2.set(studentIndex, "NULL");
										int w = Quantity.get(bookIndex);
										Quantity.set(bookIndex, w + 1);
										long diffInSeconds = java.time.Duration.between(issueTime2.get(studentIndex), Time).getSeconds();
										issueTime1.set(studentIndex, LocalTime.ofSecondOfDay(0));
										System.out.println("\n\t\tYou return book after " + diffInSeconds + " seconds.");
										int f = (int) (diffInSeconds - 15);
										if (f <= 0) {
											System.out.println("\t\tYou return book in Time\n\t\t<<<< No Fine >>>>");
										} else {
											int g = f * 2;
											System.out.println("\t\tYou return book " + f + " seconds late.");
											System.out.println("\t\tYour fine is Rs." + g);
										}
										showProfile(studentIndex, studentID, studentName, issuedBook1, issuedBook2, issuedBook3, issuedBook1ISBN, issuedBook2ISBN, issuedBook3ISBN);
									} else if (Objects.equals(r, u)) {
										issuedBook3ISBN.set(studentIndex, 0);
										issuedBook3.set(studentIndex, "NULL");
										int w = Quantity.get(bookIndex);
										Quantity.set(bookIndex, w + 1);
										long diffInSeconds = java.time.Duration.between(issueTime3.get(studentIndex), Time).getSeconds();
										issueTime1.set(studentIndex, LocalTime.ofSecondOfDay(0));
										System.out.println("\n\t\tYou return book after " + diffInSeconds + " seconds.");
										int f = (int) (diffInSeconds - 15);
										if (f <= 0) {
											System.out.println("\t\tYou return book in Time\n\t\t<<<< No Fine >>>>");
										} else {
											int g = f * 2;
											System.out.println("\t\tYou return book " + f + " seconds late.");
											System.out.println("\t\tYour fine is Rs." + g);
										}
										showProfile(studentIndex, studentID, studentName, issuedBook1, issuedBook2, issuedBook3, issuedBook1ISBN, issuedBook2ISBN, issuedBook3ISBN);
									} else {
										System.out.println("\n\t\tThis Book is Not Issued on this Registration Number.");
									}
									n = false;
									m = false;
									writeFileStr ("issuedBook1", issuedBook1);
									writeFileInt ("issueBook1ISBN", issuedBook1ISBN);
									writeFileTime("issueTime1", issueTime1);
									writeFileStr ("issuedBook2", issuedBook2);
									writeFileInt ("issueBook2ISBN", issuedBook2ISBN);
									writeFileTime("issueTime2", issueTime2);
									writeFileStr ("issuedBook3", issuedBook3);
									writeFileInt ("issueBook3ISBN", issuedBook3ISBN);
									writeFileTime("issueTime3", issueTime3);
									writeFileInt ("Quantity", Quantity);
								}
							}catch (InputMismatchException ex) {
								System.out.println("\n\t\tYou have entered an invalid input");
								System.out.println("\t\tTry Again...");
								input.nextLine();
							}
						}
					}
				}
			}

	//--------------------------------------------------------------------------------------------------------------------------------------
	//                     Method for search book publicly
			public static void publicSearch (ArrayList<String>BookName,ArrayList<String>searchBook,ArrayList<Integer>ISBN,ArrayList<Integer>searchISBN) {
				ArrayList<String> upperCaseBooks = new ArrayList<>();
				for (int i = 0; i <  ISBN.size();i++) {
					String x = BookName.get(i);
					String y = x.toUpperCase();
					upperCaseBooks.add(y);
				}
				Scanner input = new Scanner(System.in);
				boolean p = true;
				while (p) {
					System.out.print("\n\t\tEnter name of book: ");
					String xx = input.nextLine();
					String x = xx.toUpperCase();
					for (String element : upperCaseBooks) {
						if (element.contains(x)) {
							String y = BookName.get(upperCaseBooks.indexOf(element));
							searchBook.add(y);
						}
					}
					for (int i = 0; i < searchBook.size(); i++) {
						int l = BookName.indexOf(searchBook.get(i));
						int k = ISBN.get(l);
						searchISBN.add(k);
					}
					if (searchBook.size() == 0) {
						System.out.println("\t\tNot Found.");
					} else {
						for (int i = 0; i < searchBook.size(); i++) {
							System.out.println("==========================================================================");
							System.out.println("\n\t" + (i + 1) + ". " + searchBook.get(i) + "\n\t\tISBN: " + searchISBN.get(i) + "\n");
						}
						System.out.println("==========================================================================");
					}
					boolean m = true;
					while (m) {
						try {
							System.out.println("\n\t\t1. For again search.");
							System.out.println("\t\t2. For exit");
							System.out.print("\t\tEnter Your Choice: ");
							int o = input.nextInt();
							if (o == 1) {
								searchBook.clear();
								searchISBN.clear();
								input.nextLine();
								m = false;
							} else if (o == 2) {
								searchBook.clear();
								searchISBN.clear();
								m = false;
								p = false;
							} else {
								System.out.println("\n\t\tYou have entered an invalid choice");
								System.out.println("\t\tTry Again...");
							}
						} catch (InputMismatchException ex) {
							System.out.println("\n\t\tYou have entered an invalid input");
							System.out.println("\t\tTry Again...");
							input.nextLine();
						}
					}
				}
			}

	//--------------------------------------------------------------------------------------------------------------------------------------

			public static void searchBook (ArrayList<String>BookName,ArrayList<String>searchBook,ArrayList<Integer>ISBN,ArrayList<Integer>searchISBN,ArrayList<String>studentID,ArrayList<Integer>Quantity,ArrayList<String>issuedBook1,ArrayList<String>issuedBook2,ArrayList<String>issuedBook3,ArrayList<Integer>issueBook1ISBN,ArrayList<Integer>issueBook2ISBN,ArrayList<Integer>issueBook3ISBN, ArrayList<LocalTime> issueTime1,ArrayList<LocalTime> issueTime2,ArrayList<LocalTime> issueTime3,ArrayList<String>studentName) {
				ArrayList<String> upperCaseBooks = new ArrayList<>();
				for (int i = 0; i <  ISBN.size();i++) {
					String x = BookName.get(i);
					String y = x.toUpperCase();
					upperCaseBooks.add(y);
				}
				Scanner input = new Scanner(System.in);
				boolean p = true;
				while (p) {
					System.out.println("Enter name of book: ");
					String xx = input.next();
					String x = xx.toUpperCase();
					for (String element : upperCaseBooks) {
						if (element.contains(x)) {
							String y = BookName.get(upperCaseBooks.indexOf(element));
							searchBook.add(y);
						}
					}
					for (int i = 0; i < searchBook.size(); i++){
						int l = BookName.indexOf(searchBook.get(i));
						int k = ISBN.get(l);
						searchISBN.add(k);
					}
					if (searchBook.size() == 0) {
						System.out.println("Not Found");
						boolean o = true;
						while (o) {
							try {
								System.out.println("press 1. to search again\npress 2. to exit.");
								int g = input.nextInt();
								if (g == 1) {
									o = false;
								} else if (g == 2) {
									o = p = false;
								} else {
									System.out.println("You have entered an invalid choice");
									System.out.println("Try Again...");
								}
							} catch (InputMismatchException ex) {
								System.out.println("You have entered an invalid input");
								System.out.println("Try Again...");
								input.nextLine();
							}
						}
					}else {
						for (int i = 0; i < searchBook.size(); i++) {
							System.out.println("==========================================================================");
							System.out.println((i + 1) + ". " + searchBook.get(i) + "\n\tISBN: " + searchISBN.get(i));
						}System.out.println("==========================================================================");
						System.out.println("\n1. for issue book.");
						System.out.println("2. for again search.");
						System.out.println("3. for exit");
						int o = input.nextInt();
						if (o == 1) {
							boolean l = true;
							while (l) {
								System.out.println("Enter Registration number of student: ");
								input.nextLine();
								String id = input.nextLine();
								String iD = id.toUpperCase();
 								int StudentIndex = studentID.indexOf(iD);
								if (StudentIndex == -1) {
									System.out.println("Not Registered.");
									boolean k = true;
									while (k) {
										try {
											System.out.println("1. Enter Another Registration Number.");
											System.out.println("2. Search Another Book.");
											System.out.println("3. Exit.");
											int choice = input.nextInt();
											if (choice == 1) {
												k = false;
											} else if (choice == 2) {
												k = l = false;
											} else if (choice == 3) {
												k = l = p = false;
											} else {
												System.out.println("You have entered an invalid choice");
												System.out.println("Try Again...");
											}
										} catch (InputMismatchException ex) {
											System.out.println("You have entered an invalid input");
											System.out.println("Try Again...");
											input.nextLine();
										}
									}
								} else if (!(issueBook1ISBN.get(StudentIndex) == 0 || issueBook2ISBN.get(StudentIndex) == 0 || issueBook3ISBN.get(StudentIndex) == 0)) {
									System.out.println("\n\t\tYou have already issued 3 books\n\t\tFirst return previous book\n\t\tthen try again...");
									boolean k = true;
									while (k) {
										try {
											System.out.println("1. Enter Another Registration Number.");
											System.out.println("2. Search Another Book.");
											System.out.println("3. Exit.");
											int choice = input.nextInt();
											if (choice == 1) {
												k = false;
											} else if (choice == 2) {
												k = l = false;
											} else if (choice == 3) {
												k = l = p = false;
											} else {
												System.out.println("You have entered an invalid choice");
												System.out.println("Try Again...");
											}
										} catch (InputMismatchException ex) {
											System.out.println("You have entered an invalid input");
											System.out.println("Try Again...");
											input.nextLine();
										}
									}
								} else {
									boolean q = true;
									while (q) {
										try {
											System.out.println("Enter book number");
											int num = input.nextInt();
											if (num >= 1 && num <= searchBook.size() - 1) {
												int f = searchISBN.get(num - 1);
												int BookIndex = ISBN.indexOf(f);
												if (Quantity.get(BookIndex) == 0) {
													System.out.println("Out of Stock.");
												} else {
													issue(BookIndex, StudentIndex, f, studentID, Quantity, BookName, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN, issueTime1, issueTime2, issueTime3, studentName);
												}
												q = l = false;
											} else {
												System.out.println("You have entered an invalid choice");
												System.out.println("Try Again...");
											}
										} catch (InputMismatchException ex) {
											System.out.println("You have entered an invalid input");
											System.out.println("Try Again...");
											input.nextLine();
										}
									}
									boolean k = true;
									while (k) {
										try {
											System.out.println("1. Search Another Book.");
											System.out.println("2. Exit.");
											int choice = input.nextInt();
											if (choice == 1) {
												k = l = false;
											} else if (choice == 2) {
												k = l = p = false;
											} else {
												System.out.println("You have entered an invalid choice");
												System.out.println("Try Again...");
											}
										} catch (InputMismatchException ex) {
											System.out.println("You have entered an invalid input");
											System.out.println("Try Again...");
											input.nextLine();
										}
									}
								}
							}
							searchBook.clear();
							searchISBN.clear();
						}
						else if (o == 2) {
							searchBook.clear();
							searchISBN.clear();
						} else if (o == 3) {
							searchBook.clear();
							searchISBN.clear();
							break;
						}
					}
				}

			}

	//======================================================================================================================================

			public static void studentSearchBook (int studentIndex,ArrayList<String>BookName,ArrayList<String>searchBook,ArrayList<Integer>ISBN,ArrayList<Integer>searchISBN,ArrayList<String>studentID,ArrayList<Integer>Quantity,ArrayList<String>issuedBook1,ArrayList<String>issuedBook2,ArrayList<String>issuedBook3,ArrayList<Integer>issueBook1ISBN,ArrayList<Integer>issueBook2ISBN,ArrayList<Integer>issueBook3ISBN, ArrayList<LocalTime> issueTime1,ArrayList<LocalTime> issueTime2,ArrayList<LocalTime> issueTime3,ArrayList<String>studentName) {
				ArrayList<String> upperCaseBooks = new ArrayList<>();
				for (int i = 0; i <  ISBN.size();i++) {
					String x = BookName.get(i);
					String y = x.toUpperCase();
					upperCaseBooks.add(y);
				}
				Scanner input = new Scanner(System.in);
				boolean p = true;
				while (p) {
					System.out.println("Enter name of book: ");
					String xx = input.next();
					String x = xx.toUpperCase();
					for (String element : upperCaseBooks) {
						if (element.contains(x)) {
							String y = BookName.get(upperCaseBooks.indexOf(element));
							searchBook.add(y);
						}
					}
					for (int i = 0; i < searchBook.size(); i++){
						int l = BookName.indexOf(searchBook.get(i));
						int k = ISBN.get(l);
						searchISBN.add(k);
					}
					if (searchBook.size() == 0) {
						System.out.println("Not Found");
						boolean o = true;
						while (o) {
							try {
								System.out.println("press 1. to search again\npress 2. to exit.");
								int g = input.nextInt();
								if (g == 1) {
									o = false;
								} else if (g == 2) {
									o = p = false;
								} else {
									System.out.println("You have entered an invalid choice");
									System.out.println("Try Again...");
								}
							} catch (InputMismatchException ex) {
								System.out.println("You have entered an invalid input");
								System.out.println("Try Again...");
								input.nextLine();
							}
						}
					}else {
						for (int i = 0; i < searchBook.size(); i++) {
							System.out.println("==========================================================================");
							System.out.println((i + 1) + ". " + searchBook.get(i) + "\n\tISBN: " + searchISBN.get(i));
						}System.out.println("==========================================================================");
						System.out.println("\n1. for issue book.");
						System.out.println("2. for again search.");
						System.out.println("3. for exit");
						int o = input.nextInt();
						if (o == 1) {
							showProfile(studentIndex, studentID, studentName, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN);
								if (!(issueBook1ISBN.get(studentIndex) == 0 || issueBook2ISBN.get(studentIndex) == 0 || issueBook3ISBN.get(studentIndex) == 0)) {
									System.out.println("\n\t\tYou have already issued 3 books\n\t\tFirst return previous book\n\t\tthen try again...");
									boolean k = true;
									while (k) {
										try {
											System.out.println("1. Search Another Book.");
											System.out.println("2. Exit.");
											int choice = input.nextInt();
											if (choice == 1) {
												k = false;
											} else if (choice == 2) {
												k = p = false;
											} else {
												System.out.println("You have entered an invalid choice");
												System.out.println("Try Again...");
											}
										} catch (InputMismatchException ex) {
											System.out.println("You have entered an invalid input");
											System.out.println("Try Again...");
											input.nextLine();
										}
									}
								} else {
									boolean q = true;
									while (q) {
										try {
											System.out.println("Enter book number");
											int num = input.nextInt();
											if (num >= 1 && num <= searchBook.size() - 1) {
												int f = searchISBN.get(num - 1);
												int BookIndex = ISBN.indexOf(f);
												if (Quantity.get(BookIndex) == 0) {
													System.out.println("Out of Stock.");
													boolean k = true;
													while (k) {
														try {
															System.out.println("1. Issue Another Book.");
															System.out.println("2. Search Another Book.");
															System.out.println("3. Exit.");
															int choice = input.nextInt();
															if (choice == 1) {
																k = false;
															} else if (choice == 2) {
																k = q = false;
															} else if (choice == 3) {
																k = q = p = false;
															} else {
																System.out.println("You have entered an invalid choice");
																System.out.println("Try Again...");
															}
														} catch (InputMismatchException ex) {
															System.out.println("You have entered an invalid input");
															System.out.println("Try Again...");
															input.nextLine();
														}
													}
												} else {
													issue(BookIndex, studentIndex, f, studentID, Quantity, BookName, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN, issueTime1, issueTime2, issueTime3, studentName);
												}
												q = false;
											} else {
												System.out.println("You have entered an invalid choice");
												System.out.println("Try Again...");
											}
										} catch (InputMismatchException ex) {
											System.out.println("You have entered an invalid input");
											System.out.println("Try Again...");
											input.nextLine();
										}
									}
									boolean k = true;
									while (k) {
										try {
											System.out.println("1. Search Another Book.");
											System.out.println("2. Exit.");
											int choice = input.nextInt();
											if (choice == 1) {
												k = false;
											} else if (choice == 2) {
												k = p = false;
											} else {
												System.out.println("You have entered an invalid choice");
												System.out.println("Try Again...");
											}
										} catch (InputMismatchException ex) {
											System.out.println("You have entered an invalid input");
											System.out.println("Try Again...");
											input.nextLine();
										}
									}
								}
							searchBook.clear();
							searchISBN.clear();
						}
						else if (o == 2) {
							searchBook.clear();
							searchISBN.clear();
						} else if (o == 3) {
							searchBook.clear();
							searchISBN.clear();
							break;
						}
					}
				}


				/*ArrayList<String> upperCaseBooks = new ArrayList<>();
				System.out.println(upperCaseBooks);
				for (int i = 0; i <  ISBN.size();i++) {
					String x = BookName.get(i);
					String y = x.toUpperCase();
					upperCaseBooks.add(y);
				}
				Scanner input = new Scanner(System.in);
				boolean p = true;
				while (p) {
					System.out.println("Enter name of book: ");
					String xx = input.next();
					String x = xx.toUpperCase();
					for (String element : BookName) {
						if (element.contains(x)) {
							String y = BookName.get(upperCaseBooks.indexOf(element));
							searchBook.add(y);
						}
					}
					for (int i = 0; i < searchBook.size(); i++){
						int l = BookName.indexOf(searchBook.get(i));
						int k = ISBN.get(l);
						searchISBN.add(k);
					}
					if (searchBook.size() == 0) {
						System.out.println("Not Found");
						boolean o = true;
						while (o) {
							try {
								System.out.println("press 1. to search again\npress 2. to exit.");
								int g = input.nextInt();
								if (g == 1) {
									o = false;
								} else if (g == 2) {
									o = p = false;
								} else {
									System.out.println("You have entered an invalid choice");
									System.out.println("Try Again...");
								}
							} catch (InputMismatchException ex) {
								System.out.println("You have entered an invalid input");
								System.out.println("Try Again...");
							}
						}
					}else {
						for (int i = 0; i < searchBook.size(); i++) {
							System.out.println("==========================================================================");
							System.out.println((i + 1) + ". " + searchBook.get(i) + "\n\tISBN: " + searchISBN.get(i));
						} System.out.println("==========================================================================");
						System.out.println("\n1. for issue book.");
						System.out.println("2. for again search.");
						System.out.println("3. for exit");
						int o = input.nextInt();
						if (o == 1) {
							boolean l = true;
							while (l) {
								System.out.println("Enter Registration number of student: ");
								String iD = input.nextLine();
								int StudentIndex = studentID.indexOf(iD);
								if (StudentIndex == -1) {
									System.out.println("Not Registered.");
									boolean k = true;
									while (k) {
										try {
											System.out.println("1. Enter Another Registration Number.");
											System.out.println("2. Search Another Book.");
											System.out.println("2. Exit.");
											int choice = input.nextInt();
											if (choice == 1) {
												k = false;
											} else if (choice == 2) {
												k = l = false;
											} else if (choice == 3) {
												k = l = p = false;
											} else {
												System.out.println("You have entered an invalid choice");
												System.out.println("Try Again...");
											}
										} catch (InputMismatchException ex) {
											System.out.println("You have entered an invalid input");
											System.out.println("Try Again...");
										}
									}
								}
								else {
									boolean q = true;
									while (q) {
										try {
											System.out.println("Enter book number");
											int num = input.nextInt();
											if (num <= searchBook.size() - 1) {
												int f = searchISBN.get(num - 1);
												int BookIndex = ISBN.indexOf(f);
												if (Quantity.get(BookIndex) == 0) {
													System.out.println("Out of Stock.");
												} else {
													issue(BookIndex, StudentIndex, f, studentID, Quantity, BookName, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN, issueTime1, issueTime2, issueTime3, studentName);
												}
												q = l = false;
											} else {
												System.out.println("You have entered an invalid choice");
												System.out.println("Try Again...");
											}
										} catch (InputMismatchException ex) {
											System.out.println("You have entered an invalid input");
											System.out.println("Try Again...");
										}
									}
								}
							}
							searchBook.clear();
							searchISBN.clear();
							break;
						}
						else if (o == 2) {
							searchBook.clear();
							searchISBN.clear();
						} else if (o == 3) {
							searchBook.clear();
							searchISBN.clear();
							break;
						}
					}
				}*/


			}

	//--------------------------------------------------------------------------------------------------------------------------------------
	//                            Method for Admin to show all books.
			public static void booksList (ArrayList<Integer>ISBN,ArrayList<String>BookName,ArrayList<Integer>Quantity) {
		for (int i = 0; i < ISBN.size(); i++){
			System.out.println((i + 1) + ".\tISBN: " + ISBN.get(i) + "\n\tName: " + BookName.get(i) + "\n\tQuantity: " + Quantity.get(i));
			System.out.println("------------------------------------------------------");
				}
			}

	//--------------------------------------------------------------------------------------------------------------------------------------
	//                            Method for Admin to show students list.
			public static void studentsList (ArrayList<String>studentID,ArrayList<String>studentName,ArrayList<String>issuedBook1,ArrayList<String>issuedBook2,ArrayList<String>issuedBook3,ArrayList<Integer>issueBook1ISBN,ArrayList<Integer>issueBook2ISBN,ArrayList<Integer>issueBook3ISBN) {
		for (int i = 0; i < studentID.size(); i++){
			System.out.println((i+1) + ".\tID: " + studentID.get(i));
			System.out.println("\tName: " + studentName.get(i));
			if (issueBook1ISBN.get(i) == 0 && issueBook2ISBN.get(i) == 0 && issueBook3ISBN.get(i) == 0){
				System.out.println("\n\t\tNo Book is issued.\n");
			} else {
				System.out.println("\nIssued Books:");
			}
			int num = 1;
			if (issueBook1ISBN.get(i) != 0) {
				System.out.println("\n\t\t" + num + ". ISBN: " + issueBook1ISBN.get(i) +
						"\n\t\t   Name: " + issuedBook1.get(i));
				num++;
			}
			if (issueBook2ISBN.get(i) != 0) {
				System.out.println("\n\t\t" + num + ". ISBN: " + issueBook2ISBN.get(i) +
						"\n\t\t   Name: " + issuedBook2.get(i));
				num ++;
			}
			if (issueBook3ISBN.get(i) != 0) {
				System.out.println("\n\t\t" + num + ". ISBN: " + issueBook3ISBN.get(i) +
						"\n\t\t   Name: " + issuedBook3.get(i));
			}
			System.out.println("========================================================");
		}
			}

	//--------------------------------------------------------------------------------------------------------------------------------------
	//                            Method for Admin to Edit Book.
			public static void editBook (ArrayList<Integer>ISBN,ArrayList<String>BookName,ArrayList<Integer>Quantity) {
				Scanner input = new Scanner(System.in);
				boolean m = true;
				while (m) {
					try {
						System.out.println("Enter ISBN of book you want to edit");
						int isbn = input.nextInt();
						int index2 = ISBN.indexOf(isbn);
						if (index2 == -1) {
							System.out.println("Book is not available.");
							boolean mm = true;
							while (mm) {
								try {
									System.out.println("1. Try again. \n2. Exit \nEnter your choice");
									int x = input.nextInt();
									if (x == 1) {
										mm = false;
									} else if (x == 2) {
										m = mm = false;
									} else {
										System.out.println("You have entered an invalid choice");
										System.out.println("Try Again...");
									}
								} catch (InputMismatchException ex) {
									System.out.println("You have entered an invalid input");
									System.out.println("Try Again...");
									input.nextLine();
								}

							}
						} else {
							boolean n = true;
							while (n) {
								try {
									System.out.println("Press 1. to Edit name.\nPress 2. to Edit Quantity.\nPress 3. to Edit Both. \n Press 4. to Exit \nEnter Your Choice: ");
									int x = input.nextInt();
									if (x == 1) {
										input.nextLine();
										System.out.println("Present name: " + BookName.get(index2) + "\nEnter new Name:");
										String y = input.nextLine();
										System.out.println("\n\tISBN: " + ISBN.get(index2) + "\n\tName: " + y + "\n\tQuantity: " + Quantity.get(index2));
										boolean o = true;
										while (o) {
											try {
												System.out.println("Do you want to save Changes.\n1. Yes\n2. No");
												int w = input.nextInt();
												if (w == 1) {
													BookName.set(index2, y);
													writeFileStr ("bookName", BookName);
													System.out.println("Changes Saved.");
													n = o = m = false;
												} else if (w == 2) {
													System.out.println("Changes Not Saved.");
													o = false;
												} else {
													System.out.println("You have entered an invalid input");
													System.out.println("Try Again...");
												}
											} catch (InputMismatchException ex) {
												System.out.println("You have entered an invalid input");
												System.out.println("Try Again...");
												input.nextLine();
											}
										}
									} else if (x == 2) {
										boolean o = true;
										while (o) {
											try {
												System.out.println("Present Quantity: " + Quantity.get(index2) + "\nEnter new Quantity:");
												int y = input.nextInt();
												System.out.println("\n\tISBN: " + ISBN.get(index2) + "\n\tName: " + y + "\n\tQuantity: " + Quantity.get(index2));
												boolean oo = true;
												while (oo) {
													try {
														System.out.println("Do you want to save Changes.\n1. Yes\n2. No");
														int w = input.nextInt();
														if (w == 1) {
															Quantity.set(index2, y);
															System.out.println("Changes Saved.");
															writeFileInt ("Quantity", Quantity);
															m = n = o = oo = false;
														} else if (w == 2) {
															System.out.println("Changes Not Saved.");
															oo = o = false;
														} else {
															System.out.println("You have entered an invalid input");
															System.out.println("Try Again...");
														}
													} catch (InputMismatchException ex) {
														System.out.println("You have entered an invalid input");
														System.out.println("Try Again...");
														input.nextLine();
													}
												}
											} catch (InputMismatchException ex) {
												System.out.println("You have entered an invalid input");
												System.out.println("Try Again...");
												input.nextLine();
											}
										}
									} else if (x == 3) {
										input.nextLine();
										System.out.println("Present name: " + BookName.get(index2) + "\nEnter new Name:");
										String y = input.nextLine();
										boolean o = true;
										while (o) {
											try {
												System.out.println("Present Quantity: " + Quantity.get(index2) + "\nEnter new Quantity:");
												int z = input.nextInt();
												System.out.println("\n\tISBN: " + ISBN.get(index2) + "\n\tName: " + y + "\n\tQuantity: " + z);
												boolean oo = true;
												while (oo) {
													try {
														System.out.println("Do you want to save Changes.\n1. Yes\n2. No");
														int w = input.nextInt();
														if (w == 1) {
															BookName.set(index2, y);
															Quantity.set(index2, z);
															writeFileStr ("bookName", BookName);
															writeFileInt ("Quantity", Quantity);
															System.out.println("Changes Saved.");
															m = n = o = oo = false;
														} else if (w == 2) {
															System.out.println("Changes Not Saved.");
															o = oo = false;
														} else {
															System.out.println("You have entered an invalid input");
															System.out.println("Try Again...");
														}
													} catch (InputMismatchException ex) {
														System.out.println("You have entered an invalid input");
														System.out.println("Try Again...");
														input.nextLine();
													}
												}
											} catch (InputMismatchException ex) {
												System.out.println("You have entered an invalid input");
												System.out.println("Try Again...");
												input.nextLine();
											}
										}
									} else if (x == 4) {
										m = n = false;
									} else {
										System.out.println("You have entered an invalid choice");
										System.out.println("Try again...");
									}
								} catch (InputMismatchException ex) {
									System.out.println("You have entered an invalid input");
									System.out.println("Try again...");
									input.nextLine();
								}
							}
						}
					} catch (InputMismatchException ex) {
						System.out.println("You have entered an invalid input");
						System.out.println("Try again...");
						input.nextLine();
					}
				}
			}

	//--------------------------------------------------------------------------------------------------------------------------------------
	//                            Method use to show specific student profile.
			public static void showProfile (int i,ArrayList<String>studentID,ArrayList<String>studentName,ArrayList<String>issuedBook1,ArrayList<String>issuedBook2,ArrayList<String>issuedBook3,ArrayList<Integer>issueBook1ISBN,ArrayList<Integer>issueBook2ISBN,ArrayList<Integer>issueBook3ISBN) {
				System.out.println("===================================================================");
		System.out.println("\tReg. no: " + studentID.get(i));
		System.out.println("\tName: " + studentName.get(i));
		if (issueBook1ISBN.get(i) == 0 && issueBook2ISBN.get(i) == 0 && issueBook3ISBN.get(i) == 0) {
			System.out.println("\n\t\tNo Book is issued.\n");
		} else {
			System.out.println("\nIssued Books:");
		}
		int num = 1;
		if (issueBook1ISBN.get(i) != 0) {
			System.out.println("\n\t\t" + num + ". ISBN: " + issueBook1ISBN.get(i) +
					"\n\t\t   Name: " + issuedBook1.get(i));
			num++;
		}
		if (issueBook2ISBN.get(i) != 0) {
			System.out.println("\n\t\t" + num + ". ISBN: " + issueBook2ISBN.get(i) +
					"\n\t\t   Name: " + issuedBook2.get(i));
			num ++;
		}
		if (issueBook3ISBN.get(i) != 0) {
			System.out.println("\n\t\t" + num + ". ISBN: " + issueBook3ISBN.get(i) +
					"\n\t\t   Name: " + issuedBook3.get(i));
		}
				System.out.println("===================================================================");
	}

	//---------------------------------------------------------------------------------------------------------------------------------------
	//                            Method for student to change its password.
			public static void studentChangePassword (int index,ArrayList<String>studentNumber) {
		boolean x = true;
		while (x) {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter Password:");
			String pass = input.nextLine();
			if (isValid(pass)){
			System.out.println("Confirm Password:");
			String pass2 = input.nextLine();
			if (Objects.equals(pass, pass2)) {
				studentNumber.set(index, pass);
				writeFileStr ("studentNumber", studentNumber);
				System.out.println("Password Changed Successfully.");
				x = false;
			} else {
				System.out.println("Doesn't Match...\n");
				boolean y = true;
				while (y) {
				try {
					System.out.println("Press 1. To Try Again...");
					System.out.println("Press 2. Back.");
					int choice = input.nextInt();
					if (choice == 1) {
						y = false;
					} else if (choice == 2) {
						x = false;
						y = false;
					} else {
						System.out.println("You have entered an invalid choice");
						System.out.println("Try Again...");
					}
				} catch (InputMismatchException ex1) {
					System.out.println("You have entered an invalid input");
					System.out.println("Try Again...");
					input.nextLine();
				}
				}
			}
			}else {
				System.out.println("Password length must be between 8 to 15 characters.");
				System.out.println("Contain upper case or lower case letters.");
				System.out.println("must contain digit.\nmust contain special character.");
				System.out.println("Try Again...");
			}
		}
	}

	//--------------------------------------------------------------------------------------------------------------------------------------
	//                           Method for admin to dlet book from library.
			public static void dletBook (ArrayList<Integer>ISBN,ArrayList<String>BookName,ArrayList<Integer>Quantity) {
				Scanner input = new Scanner(System.in);
				boolean x = true;
		while (x) {
			try {
				System.out.println("Enter ISBN of book you want to Dlet:");
				int num = input.nextInt();
				int index = ISBN.indexOf(num);
				if (index == -1) {
					System.out.println("Book not Found.");
					boolean v = true;
					while (v) {
						try {
							System.out.println("1. Enter Again.\n2. Back.");
							int c = input.nextInt();
							if (c == 1) {
								v = false;
							} else if (c == 2) {
								v = false;
								x = false;
							} else {
								System.out.println("You have entered an invalid choice.");
								System.out.println("Try Again...");
							}
						} catch (InputMismatchException ex) {
							System.out.println("You have entered an invalid Input.");
							System.out.println("Try Again...");
							input.nextLine();
						}
					}
				} else {
					System.out.println("================================================================");
					System.out.println("\n\tISBN: " + ISBN.get(index) + "\n\tName: " + BookName.get(index) + "\n\tQuantity: " + Quantity.get(index));
					System.out.println("\n================================================================");
					boolean z = true;
					while (z) {
						try {
							System.out.println("\nAre you sure you want to dlet\n1. Yes..\n2. No..");
							int choice = input.nextInt();
							if (choice == 1) {
								ISBN.remove(index);
								BookName.remove(index);
								Quantity.remove(index);
								writeFileInt ("ISBN", ISBN);
								writeFileStr ("bookName", BookName);
								writeFileInt ("Quantity", Quantity);
								System.out.println("Book Deleted Successfully.");
								x = false;
								z = false;
							} else if (choice == 2) {
								boolean y = true;
								while (y) {
									try {
										System.out.println("1. You Want to dlet Another book.\n2. Back..");
										int ch = input.nextInt();
										if (ch == 1) {
											y = z = false;
										} else if (ch == 2) {
											x = y = z = false;
										} else {
											System.out.println("You have entered an invalid choice.");
											System.out.println("Try Again...");
										}
									} catch (InputMismatchException ex) {
										System.out.println("You have entered an invalid input.");
										System.out.println("Try Again...");
										input.nextLine();
									}
								}
							} else {
								System.out.println("You have entered an invalid choice.");
								System.out.println("Try Again...");
							}
						} catch (Exception ex) {
							System.out.println("You have entered a wrong Input.");
							System.out.println("Try Again...");
							input.nextLine();
						}
					}
				}
			} catch (InputMismatchException ex) {
				System.out.println("You have entered a wrong Input.");
				System.out.println("Try Again...");
				input.nextLine();
			}
		}
	}

	//--------------------------------------------------------------------------------------------------------------------------------------

			public static void issue (int bookIndex, int studentIndex, int iSBN, ArrayList<String>studentID, ArrayList<Integer>Quantity,ArrayList<String>BookName,ArrayList<String>issuedBook1,ArrayList<String>issuedBook2,ArrayList<String>issuedBook3,ArrayList<Integer>issueBook1ISBN,ArrayList<Integer>issueBook2ISBN,ArrayList<Integer>issueBook3ISBN,ArrayList<LocalTime> issueTime1,ArrayList<LocalTime> issueTime2,ArrayList<LocalTime> issueTime3,ArrayList<String>studentName) {
				Scanner input = new Scanner(System.in);
				String x = BookName.get(bookIndex);
				String a = issuedBook1.get(studentIndex);
				String b = issuedBook2.get(studentIndex);
				String c = issuedBook3.get(studentIndex);
				String d = "NULL";
				LocalTime Time = LocalTime.now();
				if (Objects.equals(a, d)) {
					issuedBook1.set(studentIndex, x);
					issueBook1ISBN.set(studentIndex, iSBN);
					int w = Quantity.get(bookIndex);
					Quantity.set(bookIndex, w - 1);
					issueTime1.set(studentIndex, Time);
					System.out.println("Book Issued Successfully.");
					showProfile(studentIndex, studentID, studentName, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN);
					System.out.println("\nPress Enter to continue.");
					input.nextLine();
				} else if (Objects.equals(b, d)) {
					issuedBook2.set(studentIndex, x);
					issueBook2ISBN.set(studentIndex, iSBN);
					int w = Quantity.get(bookIndex);
					Quantity.set(bookIndex, w - 1);
					issueTime2.set(studentIndex, Time);
					System.out.println("Book Issued Successfully.");
					showProfile(studentIndex, studentID, studentName, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN);
					System.out.println("\nPress Enter to continue.");
					input.nextLine();
				} else if (Objects.equals(c, d)) {
					issuedBook3.set(studentIndex, x);
					issueBook3ISBN.set(studentIndex, iSBN);
					int w = Quantity.get(bookIndex);
					Quantity.set(bookIndex, w - 1);
					issueTime3.set(studentIndex, Time);
					System.out.println("Book Issued Successfully.");
					showProfile(studentIndex, studentID, studentName, issuedBook1, issuedBook2, issuedBook3, issueBook1ISBN, issueBook2ISBN, issueBook3ISBN);
					System.out.println("\nPress Enter to continue.");
					input.nextLine();
				} else {
					System.out.println("Your limit to issue books is full.");
					System.out.println("\nPress Enter to continue.");
					input.nextLine();
					input.nextLine();
				}
				writeFileStr ("issuedBook1", issuedBook1);
				writeFileInt ("issueBook1ISBN", issueBook1ISBN);
				writeFileTime("issueTime1", issueTime1);
				writeFileStr ("issuedBook2", issuedBook2);
				writeFileInt ("issueBook2ISBN", issueBook2ISBN);
				writeFileTime("issueTime2", issueTime2);
				writeFileStr ("issuedBook3", issuedBook3);
				writeFileInt ("issueBook3ISBN", issueBook3ISBN);
				writeFileTime("issueTime3", issueTime3);
				writeFileInt ("Quantity", Quantity);
			}

	//--------------------------------------------------------------------------------------------------------------------------------------
	//               to check password validity.
	public static boolean isValid(String password) {

		// for checking password length
		if (!((password.length() >= 8)
				&& (password.length() <= 15))) {
			return false;
		}
		// to check space
		if (password.contains(" ")) {
			return false;
		}
		if (true) {
			int count = 0;
			// check digits from 0 to 9
			for (int i = 0; i <= 9; i++) {
				// to convert int to string
				String str1 = Integer.toString(i);
				if (password.contains(str1)) {
					count = 1;
				}
			}
			if (count == 0) {
				return false;
			}
		}
		// for special characters
		if (!(password.contains("@") || password.contains("#")
				|| password.contains("!") || password.contains("~")
				|| password.contains("$") || password.contains("%")
				|| password.contains("^") || password.contains("&")
				|| password.contains("*") || password.contains("(")
				|| password.contains(")") || password.contains("-")
				|| password.contains("+") || password.contains("/")
				|| password.contains(":") || password.contains(".")
				|| password.contains(", ") || password.contains("<")
				|| password.contains(">") || password.contains("?")
				|| password.contains("|"))) {
			return false;
		}
		if (true) {
			int count = 0;
			// checking capital letters
			for (int i = 65; i <= 90; i++) {
				// type casting
				char c = (char)i;
				String str1 = Character.toString(c);
				if (password.contains(str1)) {
					count = 1;
				}
			}
			if (count == 0) {
				return false;
			}
		}
		if (true) {
			int count = 0;
			// checking small letters
			for (int i = 97; i <= 122; i++) {
				// type casting
				char c = (char)i;
				String str1 = Character.toString(c);
				if (password.contains(str1)) {
					count = 1;
				}
			}
			if (count == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean nameValid (String name) {
		if (true) {
			int count = 0;
			// check digits from 0 to 9
			for (int i = 0; i <= 9; i++) {
				// to convert int to string
				String str1 = Integer.toString(i);
				if (name.contains(str1)) {
					count = 1;
				}
			}
			if (count != 0) {
				return false;
			}
		}
		if (name.contains("@") || name.contains("#")
				|| name.contains("!") || name.contains("~")
				|| name.contains("$") || name.contains("%")
				|| name.contains("^") || name.contains("&")
				|| name.contains("*") || name.contains("(")
				|| name.contains(")") || name.contains("-")
				|| name.contains("+") || name.contains("/")
				|| name.contains(":") || name.contains(".")
				|| name.contains(", ") || name.contains("<")
				|| name.contains(">") || name.contains("?")
				|| name.contains("|")) {
			return false;
		}
		return true;
	}

	public static void file (String name) {
		try {
			File myObj = new File(name + ".txt");
			if (myObj.createNewFile()) {
				//System.out.println("File created: " + myObj.getName());
			} else {
				//System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void writeFileInt (String name, ArrayList<Integer>array) {
		try {
			FileWriter myWriter = new FileWriter(name + ".txt");
			for (int i = 0; i < array.size(); i++) {
				myWriter.write(array.get(i) + "\n");
			}
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void writeFileStr (String name, ArrayList<String>array) {
		try {
			FileWriter myWriter = new FileWriter(name + ".txt");
			for (int i = 0; i < array.size(); i++) {
				myWriter.write(array.get(i) + "\n");
			}
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void readFileInt (String name, ArrayList<Integer>array) {
		try {
			File myObj = new File(name + ".txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				array.add(Integer.valueOf(data));
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void readFileStr (String name, ArrayList<String>array) {
		try {
			File myObj = new File(name + ".txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				array.add(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void writeFileTime (String name, ArrayList<LocalTime>array) {
		try {
			FileWriter myWriter = new FileWriter(name + ".txt");
			for (int i = 0; i < array.size(); i++) {
				myWriter.write(array.get(i) + "\n");
			}
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void readFileTime (String name, ArrayList<LocalTime>array) {
		try {
			File myObj = new File(name + ".txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				LocalTime data = LocalTime.parse(myReader.nextLine());
				array.add(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void addAdmin (ArrayList<String>adminLogin, ArrayList<String> adminPassword) {
		Scanner input = new Scanner(System.in);
		boolean x = true;
		while (x) {
			System.out.println("Enter username: ");
			String login = input.nextLine();
			int i = adminLogin.indexOf(login);
			if (i != -1) {
				System.out.println("This username already registered.");
				boolean x1 = true;
				while (x1) {
					try {
						System.out.println("1. Try Another Username.\n2. Back.");
						int a = input.nextInt();
						if (a == 1) {
							x1 = false;
							input.nextLine();
						} else if (a == 2) {
							x = x1 = false;
						} else {
							System.out.println("You have entered an invalid choice.");
							System.out.println("Try Again...");
						}
					} catch (InputMismatchException ex) {
						System.out.println("You have entered an invalid input.");
						System.out.println("Try Again...");
						input.nextLine();
					}
				}
			} else {
				boolean x2 = true;
				while (x2) {
					System.out.println("Enter Password: ");
					String password = input.nextLine();
					System.out.println("ReEnter Password: ");
					String password2 = input.nextLine();
					if (Objects.equals(password, password2)) {
						boolean x21 = true;
						while (x21) {
							try {
								System.out.println("Are you sure you want to save:\n1. Yes\n2. No");
								int a = input.nextInt();
								if (a == 1) {
									adminLogin.add(login);
									adminPassword.add(password);
									writeFileStr("adminLogin", adminLogin);
									writeFileStr("adminPassword", adminPassword);
									System.out.println("Added Successfully.");
									x = x21 = x2 = false;
								} else if (a == 2) {
									boolean x211 = true;
									while (x211) {
										try {
											System.out.println("1. Add Another\n2. Back");
											int b = input.nextInt();
											if (b == 1) {
												x2 = x21 = x211 = false;
												input.nextLine();
											} else if (b == 2) {
												x = x2 = x21 = x211 = false;
											} else {
												System.out.println("You have entered an invalid choice.");
												System.out.println("Try Again...");
											}
										} catch (InputMismatchException ex) {
											System.out.println("You have entered an invalid input.");
											System.out.println("Try Again...");
											input.nextLine();
										}
									}
								} else {
									System.out.println("You have entered an invalid choice.");
									System.out.println("Try Again...");
								}
							} catch (InputMismatchException ex) {
								System.out.println("You have entered an invalid input.");
								System.out.println("Try Again...");
								input.nextLine();
							}
						}
					} else {
						boolean x22 = true;
						while (x22) {
							try {
								System.out.println("Password Doesn't Match.");
								System.out.println("1. Try Again.\n2. Back");
								int a = input.nextInt();
								if (a == 1) {
									x22 = false;
									input.nextLine();
								} else if (a == 2) {
									x = x2 = x22 = false;
								} else {
									System.out.println("You have entered an invalid choice.");
									System.out.println("Try Again...");
								}
							} catch (InputMismatchException ex) {
								System.out.println("You have entered an invalid input.");
								System.out.println("Try Again...");
								input.nextLine();
							}
						}
					}
				}
			}
		}
	}

	public static void adminChangePassword (int index, ArrayList<String> adminPassword) {
		Scanner input = new Scanner(System.in);
		boolean x = true;
		while (x) {
			System.out.println("Enter Password:");
			String pass = input.nextLine();
			System.out.println("Confirm Password:");
			String pass2 = input.nextLine();
			if (Objects.equals(pass, pass2)) {
				adminPassword.set(index, pass);
				writeFileStr("adminPassword", adminPassword);
				System.out.println("Password Changed Successfully.");
				break;
			} else {
				System.out.println("Doesn't Match...\n");
				boolean y = true;
				while (y) {
					try {
						System.out.println("Press 1. To Try Again...");
						System.out.println("Press 2. Back.");
						int choice = input.nextInt();
						if (choice == 1) {
							y = false;
							input.nextLine();
						} else if (choice == 2) {
							x = false;
							y = false;
						} else {
							System.out.println("You have entered an invalid choice");
							System.out.println("Try Again...");
						}
					} catch (InputMismatchException ex1) {
						System.out.println("You have entered an invalid input");
						System.out.println("Try Again...");
						input.nextLine();
					}
				}
			}
		}
	}

	public static void deleteStudent (ArrayList<String>studentID,ArrayList<String>studentName,ArrayList<String>studentNum,ArrayList<String>issueBook1,ArrayList<String>issueBook2,ArrayList<String>issueBook3,ArrayList<Integer>issueBook1IBAN,ArrayList<Integer>issueBook2IBAN,ArrayList<Integer>issueBook3IBAN,ArrayList<LocalTime> issueTime1,ArrayList<LocalTime> issueTime2,ArrayList<LocalTime> issueTime3, ArrayList<LocalTime> loginTime, ArrayList<Integer>passwordTry) {
		Scanner input = new Scanner(System.in);
		boolean x = true;
		while (x) {
			System.out.println("Enter Registration Number: ");
			String num1 = input.nextLine();
			String num = num1.toUpperCase();
			int index = studentID.indexOf(num);
			if (index == -1) {
				System.out.println("Not Found.");
				boolean x1 = true;
				while (x1) {
					try {
						System.out.println("1. Try Another\n2. Back");
						int a = input.nextInt();
						if (a == 1) {
							x1 = false;
							input.nextLine();
						} else if (a == 2) {
							x = x1 = false;
						} else {
							System.out.println("You have entered an invalid choice");
							System.out.println("Try Again...");
						}
					} catch (InputMismatchException ex) {
						System.out.println("You have entered an invalid input");
						System.out.println("Try Again...");
						input.nextLine();
					}
				}
			} else if (!(issueBook1IBAN.get(index) == 0 && issueBook2IBAN.get(index) == 0 && issueBook3IBAN.get(index) == 0)) {
				showProfile(index, studentID, studentName, issueBook1, issueBook2, issueBook3, issueBook1IBAN, issueBook2IBAN, issueBook3IBAN);
				System.out.println("\n\t\tUnable to Remove Because Student doesn't return the Issued Books\n\t\tFirst return All books\n\t\tThen try again...");
				boolean x2 = true;
				while (x2) {
					try {
						System.out.println("1. Remove another Student\n2. Exit");
						int b = input.nextInt();
						if (b == 1) {
							x2 = false;
						} else if (b == 2) {
							x = x2 = false;
						} else {
							System.out.println("You have entered an invalid choice");
							System.out.println("Try Again...");
						}
					} catch (InputMismatchException ex) {
						System.out.println("You have entered an invalid input");
						System.out.println("Try Again...");
						input.nextLine();
					}
				}
			} else {
				showProfile(index, studentID, studentName, issueBook1, issueBook2, issueBook3, issueBook1IBAN, issueBook2IBAN, issueBook3IBAN);
				boolean x3 = true;
				while (x3) {
					try {
						System.out.println("Are you sure you want to Delete\n1.Yes\n2.No");
						int a = input.nextInt();
						if (a == 1) {
							studentID.remove(index);
							studentName.remove(index);
							studentNum.remove(index);
							issueBook1.remove(index);
							issueBook1IBAN.remove(index);
							issueTime1.remove(index);
							issueBook2.remove(index);
							issueBook2IBAN.remove(index);
							issueTime2.remove(index);
							issueBook3.remove(index);
							issueBook3IBAN.remove(index);
							issueTime3.remove(index);
							loginTime.remove(index);
							passwordTry.remove(index);
							writeFileStr("studentID", studentID);
							writeFileStr("studentName", studentName);
							writeFileStr("studentNumber", studentNum);
							writeFileStr("issuedBook1", issueBook1);
							writeFileInt("issueBook1ISBN", issueBook1IBAN);
							writeFileTime("issueTime1", issueTime1);
							writeFileStr("issuedBook2", issueBook2);
							writeFileInt("issueBook2ISBN", issueBook2IBAN);
							writeFileTime("issueTime2", issueTime2);
							writeFileStr("issuedBook3", issueBook3);
							writeFileInt("issueBook3ISBN", issueBook3IBAN);
							writeFileTime("issueTime3", issueTime3);
							writeFileInt("passwordTry", passwordTry);
							writeFileTime("loginTime", loginTime);
							System.out.println("Deleted Successfully");
							boolean x31 = true;
							while (x31) {
								try {
									System.out.println("1. Remove another Student\n2. Exit");
									int b = input.nextInt();
									if (b == 1) {
										x3 = x31 = false;
									} else if (b == 2) {
										x = x3 = x31 = false;
									} else {
										System.out.println("You have entered an invalid choice");
										System.out.println("Try Again...");
									}
								} catch (InputMismatchException ex) {
									System.out.println("You have entered an invalid input");
									System.out.println("Try Again...");
									input.nextLine();
								}
							}
						} else if (a == 2) {
							boolean x32 = true;
							while (x32) {
								try {
									System.out.println("1. Remove another Student\n2. Exit");
									int b = input.nextInt();
									if (b == 1) {
										x3 = x32 = false;
									} else if (b == 2) {
										x = x3 = x32 = false;
									} else {
										System.out.println("You have entered an invalid choice");
										System.out.println("Try Again...");
									}
								} catch (InputMismatchException ex) {
									System.out.println("You have entered an invalid input");
									System.out.println("Try Again...");
									input.nextLine();
								}
							}
						} else {
							System.out.println("You have entered an invalid choice");
							System.out.println("Try Again...");
						}
					} catch (InputMismatchException ex) {
						System.out.println("You have entered an invalid input");
						System.out.println("Try Again...");
						input.nextLine();
					}
				}
			}
		}
	}

	public static void adminStudentPasswordChange (ArrayList<String>studentID,ArrayList<String>studentNum) {
		Scanner input = new Scanner(System.in);
		boolean x = true;
		while (x) {
			System.out.println("Enter Registration Number: ");
			String num1 = input.nextLine();
			String num = num1.toUpperCase();
			int index = studentID.indexOf(num);
			if (index == -1) {
				System.out.println("Not Found.");
				boolean x1 = true;
				while (x1) {
					try {
						System.out.println("1. Try Another\n2. Back");
						int a = input.nextInt();
						if (a == 1) {
							x1 = false;
							input.nextLine();
						} else if (a == 2) {
							x = x1 = false;
						} else {
							System.out.println("You have entered an invalid choice");
							System.out.println("Try Again...");
						}
					} catch (InputMismatchException ex) {
						System.out.println("You have entered an invalid input");
						System.out.println("Try Again...");
						input.nextLine();
					}
				}
			} else {
				studentChangePassword(index, studentNum);
				x = false;
			}
		}
	}

	public static void loginSettings (int index, ArrayList<String>adminLogin, ArrayList<String> adminPassword, ArrayList<String>studentID,ArrayList<String>studentNum) {
		Scanner input = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("\n============================================");
				System.out.println("<<<<<<<<<<<<<<<  LOGIN MENU  >>>>>>>>>>>>>>>");
				System.out.println("============================================");
				System.out.println("\t\t1 -- Add Admin.");
				System.out.println("\t\t2 -- Change Admin Password.");
				System.out.println("\t\t3 -- Change Student Password.");
				System.out.println("\t\t4 -- Main Menu.");
				System.out.print("\t\tEnter Your Choice: ");
				int choice = input.nextInt();
				if (choice == 1) {
					System.out.println("=====================================================");
					addAdmin(adminLogin, adminPassword);
					System.out.println("Press Enter to Continue.");
					input.nextLine();
					input.nextLine();
				} else if (choice == 2) {
					System.out.println("=====================================================");
					adminChangePassword(index, adminPassword);
					System.out.println("Press Enter to Continue.");
					input.nextLine();
					input.nextLine();
				} else if (choice == 3) {
					System.out.println("=====================================================");
					adminStudentPasswordChange(studentID, studentNum);
					System.out.println("Press Enter to Continue.");
					input.nextLine();
					input.nextLine();
				} else if (choice == 4) {
					break;
				} else {
					System.out.println("You have entered an invalid choice");
					System.out.println("Try Again...");
				}
			} catch (InputMismatchException ex) {
				System.out.println("You have entered an invalid input");
				System.out.println("Try Again...");
				input.nextLine();
			}
		}
	}

}