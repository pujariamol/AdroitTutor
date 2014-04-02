import java.util.List;
import java.util.ArrayList;

public class Player implements Subject  
{
    /** Life must be either of these so using enum **/
	public static enum Life{ZERO, ONE, TWO, THREE};

	private int score;
	private Life life;
	private List<Reward> rewards;
	private ArrayList<Observer> observers = new ArrayList<Observer>() ;
	
	public Player() {
		setScore(0);
		setLife(Life.THREE);
		rewards = new ArrayList<Reward>();
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
		notifyObservers();
	}
	
	public Life getLife() {
		return life;
	}
	
	public int getLives() {
		switch(getLife()) {
		case THREE:
			return 3;
			
		case TWO:
			return 2;
			
		case ONE:
			return 1;
			
		case ZERO:
			return 0;
		}
		return 0;
	}
	
	public void setLife(final Life life) {
		this.life = life;
		notifyObservers();
	}
	
	public void decretementLife() {
		switch(getLife()) {
			case THREE:
				setLife(Life.TWO);
				break;
				
			case TWO:
				setLife(Life.ONE);
				break;
				
			case ONE:
				setLife(Life.ZERO);
				break;
				
			default:
				setLife(Life.ZERO);
				break;
		}
	}
	
	public void addReward(Reward reward) {
	    rewards.add(reward);
	}
	
	public List<Reward> getRewards() {
	    return rewards;
	}

	public void attach(Observer obj) {
        observers.add(obj) ;
    }
    
    public void detach(Observer obj) {
        observers.remove(obj) ;
    }
    
    public void notifyObservers() {
        for (Observer obj  : observers)
        {
            obj.update();
        }
    }

}
