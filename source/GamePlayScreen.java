import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class GameScreen here.
 * 
 * @author Amol Pujari
 * @version (a version number or a date)
 */
public class GamePlayScreen extends Screen
{    
    private IScreenHandler nextScreen = null;
    private Question question = null;
    private QuestionActor questionActor = null;
    List<Option> exisitingOptions = new ArrayList<Option>();
    
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
        this.adroitTutorWorld.setBackground(greenfootImage);
       
        this.question = this.adroitTutorWorld.getGameEngine().getQuestionSetIterator().currentQuestion();
        
        showTools();
        showOptions();
        showQuestions();
        showScoreBoard();
        
    }
    
    private void showScoreBoard(){
        ScoreBoard scoreBoard = new ScoreBoard();
        this.adroitTutorWorld.addObject(scoreBoard, 980, 500);
    }
    
    private void showQuestions(){
System.out.println("---------------------Inside show questions");
        if(questionActor == null){
            questionActor = new QuestionActor(this.question);
        }
        questionActor.displayQuestion(this.question);
        this.adroitTutorWorld.setQuestionActor(questionActor);
        this.adroitTutorWorld.addObject(questionActor,1080,300);      
    }
    
    private void showOptions(){
        List<String> answerOptions= this.question.getAnswerOptions();
        System.out.println("---------------------Inside show options");
        for(int i=0; i < answerOptions.size(); i++)
        {
            Option answerOption = new Option(answerOptions.get(i));
            exisitingOptions.add(answerOption);
            this.adroitTutorWorld.addObject(answerOption, 100 + (i * 200), 550);
        }
    }
    
    private void clearOptions()
    {
        int optionsSize = exisitingOptions.size();
        
        if(optionsSize != 0){
            do
            {
                this.adroitTutorWorld.removeObject(exisitingOptions.get(0));
                exisitingOptions.remove(0);
            } while(exisitingOptions.size() > 0);
        }
    }
    
    private void showTools(){
        this.adroitTutorWorld.addObject(this.adroitTutorWorld.wordPicker, 530, 100);
    }
    
    public void updateQuestion(Question question)
    {
        this.question=question;
        showQuestions();
        clearOptions();
        showOptions();
    }
    
}
