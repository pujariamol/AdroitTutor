import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;

public class Text extends Actor
{
    private String wordText;
    
    public Text(String wordText)
    {
        this.setWordText(wordText);
        GreenfootImage greenfootImage = new GreenfootImage(wordText, 25, Color.RED, Color.WHITE);
        setImage(greenfootImage);
    }
    
    public void act() 
    {
        // Add your action code here.
    }

	public String getWordText()
	{
		return wordText;
	}

	public void setWordText(String wordText)
	{
		this.wordText = wordText;
	}

}
