package LibraryManagementSystem;

public class mainDriver {

	public static void main(String[] args) {
		
		
		
		
		
		//creating book object
		Book book1 = new Book("Java","James Gosh",true);
		Book book2 = new Book("Python","Ramar",true);
		Book book3 = new Book("C++","Kunal",true);
		
		//creating user objects
		User user1 = new User("Sharan","101");
		User user2 = new User("Shwe","102");
		User user3 = new User("Arvind","103");
		
		Library library = new Library();
		
		//adding books to bookList;
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		
		//adding users to Library
		library.addUser(user1);
		library.addUser(user2);
		library.addUser(user3);
		
		//Borrowing Book from the Library
		library.borrow("101", "Java"); // sharan borrowing java book
		library.borrow("102", "Python");
		library.borrow("102", "Python");
		
		
		library.displayBook();// Displaying book
		
		library.returnBook("101", "Java");//sharan returning the book
		
		library.displayBook();
		
	}

}
