import java.util.List;

public class Question {
	
	private String question;
	private List<String> answerOptions;
	private final int correctAnswerIndex;
	
	public Question(String question, List<String> answerOptions, final int correctAnswerIndex) {
		this.question = question;
		this.answerOptions = answerOptions;
		this.correctAnswerIndex = correctAnswerIndex;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	/**
	 * @return List of answer options
	 */
	public List<String> getAnswerOptions() {
		return answerOptions;
	}
	
	
	public void setAnswerOptions(List<String> answerOptions) {
		this.answerOptions = answerOptions;
	}
	
	/**
	 * @return Index of correct answer in the list
	 */
	public int getCorrectAnswerIndex() {
		return correctAnswerIndex;
	}
	
	/**
	 * @return Correct answer
	 */
	public String getCorrectAnswer() {
		return answerOptions.get(correctAnswerIndex);
	}
}
