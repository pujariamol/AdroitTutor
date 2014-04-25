public interface WordPickerState  
{
    int WORD_MOVE_INTERVAL = 35;
    
	public void moveUp(Option word);
	public void moveDown();
	public void intersectingWord();
}
