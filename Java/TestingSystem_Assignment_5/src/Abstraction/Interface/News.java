package Abstraction.Interface;

public class News implements INews {
	int Id;
	String title;
	String publishDate;
	String Author;
	String Content;
	float AverageRate;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public float getAverageRate() {
		return AverageRate;
	}
	@Override
	public void Display() {
		System.out.println("Title:"+getTitle());
		System.out.println("PublishDate:"+getPublishDate());
		System.out.println("Author:"+getAuthor());
		System.out.println("Content:"+getContent());
		System.out.println("AverageRate"+getAverageRate());
		
	}
	@Override
	public float Calculate() {
		float averageRate=0;
		int[] rates= {3,6,9};
		averageRate=(rates[0]+rates[1]+rates[2])/3;
		return averageRate;
	}
	

	

}
