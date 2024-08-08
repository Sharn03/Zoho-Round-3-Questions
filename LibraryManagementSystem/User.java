package LibraryManagementSystem;

import java.util.ArrayList;

public class User {
	private String userName;
	private String userId;
	private ArrayList<Book>borrowedBook;
	
	
	public User(String userName, String userId) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.borrowedBook = new ArrayList<>();
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}


	public ArrayList<Book> getBorrowedBook() {
		return borrowedBook;
	}


	public void setBorrowedBook(ArrayList<Book> borrowedBook) {
		this.borrowedBook = borrowedBook;
	}
	
	
	public void borrowBook(Book book)
	{
		if(!book.isAvailable())
		{
			System.out.println(book.getBookName()+"is Not available");
		}
		else if(borrowedBook.size()>=3)
		{
			System.out.println("You should return a book to borrow the another book");
		}
		else
		{
			borrowedBook.add(book);
			book.Borrow();// to make the borrowed book unavailable
		}
	}
	
	public void returnBook(Book book)
	{
		//When we return a book the status of the book is unavailable because someone have borrowed it 
		if(borrowedBook.contains(book))
		{
			borrowedBook.remove(book);
			book.returnBook();
		}
		else
		{
			System.out.println("Book is already available");
		}
	}
	
	
}
