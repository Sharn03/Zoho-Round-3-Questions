package LibraryManagementSystem;

public class Book {

	
	
		private String bookName;
		private String bookAuthor;
		private boolean isAvailable;
		
		public Book(String bookName,String bookAuthor,boolean isAvailable)
		{
			this.bookName = bookName;
			this.bookAuthor = bookAuthor;
			this.isAvailable = isAvailable;
		}

		public String getBookName() {
			return bookName;
		}

		public void setBookName(String bookName) {
			this.bookName = bookName;
		}

		public String getBookAuthor() {
			return bookAuthor;
		}

		public void setBookAuthor(String bookAuthor) {
			this.bookAuthor = bookAuthor;
		}
		
		
		public boolean isAvailable() {
			return isAvailable;
		}

		public void setAvailable(boolean isAvailable) {
			this.isAvailable = isAvailable;
		}

		//Method for borrow
		public void Borrow()
		{
			if(isAvailable)
			{
				isAvailable = false;
				System.out.println("Book borrowed Successfully");
			}
			
			else
			{
				System.out.println("Book is not available");
			}
			
		}
		
		//Method for Returning Book
		public void returnBook()
		{
			if(!isAvailable)
			{
				isAvailable = true;
				System.out.println("Book returned Successfully");
			}
			else
			{
				System.out.println("Book is already there");
			}
		}
	 
		

	

}
