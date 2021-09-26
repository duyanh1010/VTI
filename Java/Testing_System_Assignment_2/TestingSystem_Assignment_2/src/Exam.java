import java.time.LocalDateTime;

public class Exam {
	int examId;
	String	code;
	String title;
	CategoryQuestion category;
	byte duration ;
	Account creator;
	LocalDateTime createDate;
	Question[] questions;
	
}
