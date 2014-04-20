import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class GameScreen here.
 * 
 * @author Amol Pujari
 * @version (a version number or a date)
 */
public class GamePlayScreen extends Screen
{    
    IScreenHandler nextScreen = null;
    
    public GamePlayScreen(AdroitTutorWorld world){
        super(world);
    }
    
    public void showScreen(ScreenType screenType){
        if(screenType == ScreenType.GAMEPLAY){
            showGamePlayScreen();
        }else if(this.nextScreen != null){
            System.out.println("Game Play Screen to next Screen ");
            this.nextScreen.showScreen(screenType);
            
        }
    }
    
    public void setNextScreen(IScreenHandler nextScreen){
        this.nextScreen = nextScreen;
    }
    
    private void showGamePlayScreen()
    {
        System.out.println("Game Play Screen");
        
        GreenfootImage greenfootImage = new GreenfootImage("./images/game_screen_bg.png");
        this.world.setBackground(greenfootImage);
        
        showTools();
        showOptions();
        showQuestions();
        showScoreBoard();
        
    }
    
    private void showScoreBoard(){
        ScoreBoard scoreBoard = new ScoreBoard();
        this.world.addObject(scoreBoard, 980, 500);
    }
    
    private void showQuestions(){
        Question ques = new Question();
        ques.setQuestion("Whats the question");
        ArrayList<String> options = new ArrayList<String>();
        options.add("Vishal");
        options.add("Mahesh");
        options.add("Jayesh");
        options.add("Amit");
        ques.setAnswerOptions(options);

        QuestionActor question = new QuestionActor(ques);
        this.world.addObject(question,1080,300);      
    }
    
    private void showOptions(){
        for(int i=0; i < 4; i++)
        {
            Option answerOption = new Option("" + (i + 1));
            this.world.addObject(answerOption, 100 + (i * 200), 550);
        }
    }
    
    private void showTools(){
        this.world.addObject(this.world.wordPicker, 530, 100);
    }
    
}
