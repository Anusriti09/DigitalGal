
public class Book {
	public String book_name;
	public String author_name;
	public String book_url;
	public int no_of_pages;
	public String publication;
	
	public Book(String book_name, String author_name) {
		this.book_name=book_name;
		this.author_name=author_name;
	}
	
	public Book(String book_name,String author_name,int n,String publication){
		this.book_name=book_name;
		this.author_name=author_name;
		this.no_of_pages=n;
		this.publication=publication;
	}
	
	
	public Book(String book_name,String author_name,String url,int n,String publication){
		this.book_name=book_name;
		this.author_name=author_name;
		this.book_url=url;
		this.no_of_pages=n;
		this.publication=publication;
	}
	public String get_bookName() {
		return this.book_name;
	}
	public String get_authorName() {
		return this.author_name;
	}
	public String get_urlName() {
		return this.book_url;
	}
	public int get_pages() {
		return this.no_of_pages;
	}
	public String get_publication() {
		return this.publication;
	}
}
