package statepattern.contextchange;

/**
 * 环境类  环境类控制反转
 * Created by zfz on 2017/12/17.
 */
public class Screen {

    private State normalState, largeState, largestState, currentState;

    public Screen() {
        normalState = new NormalState();
        largeState = new LargeState();
        largestState = new LargestState();
        currentState = normalState;
        currentState.display();
    }

    public void doClick() {
        if (currentState == normalState) {
            setCurrentState(largeState);
            currentState.display();
        } else if (currentState == largeState) {
            setCurrentState(largestState);
            currentState.display();
        }else if(currentState == largestState){
            setCurrentState(normalState);
            currentState.display();
        }
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
}
