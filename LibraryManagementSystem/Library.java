package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.Objects;

public class Library {

	private ArrayList<Book>bookList;
	private ArrayList<User>userList;
	
	
	public ArrayList<Book> getBookList() {
		return bookList;
	}
	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}
	public ArrayList<User> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
	
	//Constructor
	public Library() {
		
		this.bookList = new ArrayList<>();
		this.userList = new ArrayList<>();
	}
	
	
	
	
	
	
	//addBook
	public void addBook(Book book)
	{
		if(!Objects.isNull(book))
		{
			bookList.add(book);
		}
		
	}
	
	//addUser
	public void addUser(User user)
	{
		if(!Objects.isNull(user))
		{
			userList.add(user);
		}
	}
	
	
	//Borrow Method
	public void borrow(String userId,String bookName)
	{
		Book book = findBook(bookName);
		User user = findUser(userId);
		
		if(book != null && user != null)
		{
			user.borrowBook(book);
			
			
		}
		else
		{
			System.out.println("UserId:"+ userId+'\n'+"Book Data:"+bookName+'\n'+ "not found");
		}
	}
	
	
	//ReturnBook Method
		public void returnBook(String userId,String bookName)
		{
			Book book = findBook(bookName);
			User user = findUser(userId);
			
			if(book != null && user != null)
			{
				//removed book from the user Book collection
				user.returnBook(book);
				
				
			}
			else
			{
				System.out.println("UserId:"+ userId+'\n'+"Book Data:"+bookName+'\n'+ "not found");
			}
		}
	
	//Find User
	private User findUser(String userId) {
		for(User user:userList)
		{
			if(user.getUserId() == userId)
			{
				return user;
			}
		}
		return null;
	}
	
	//Find Book
	private Book findBook(String bookName) {
		
		
		for(Book book:bookList)
		{
			if(book.getBookName() == bookName)
			{
				return book;
			}
		}
		return null;
	}
	
	//Display Book
	public void displayBook()
	{
		for(Book book:bookList)
		{
			if(book.isAvailable())
			{
				System.out.println("Book Name:"+book.getBookName()+"And Author Name:"+book.getBookAuthor());	
			}
			
		}
	}
	

	
}
