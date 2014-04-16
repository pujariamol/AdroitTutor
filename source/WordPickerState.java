public interface WordPickerState  
{
    int MOVE_INTERVAL = 10;
    int MAX_TOP = 100;
    int WORD_MOVE_INTERVAL = 35;
    
	public void moveUp(Option word);
	public void moveDown();
	public void isIntersectingWord();
}
