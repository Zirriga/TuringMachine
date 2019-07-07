package turingmachine;

public class Rule {
    private int stateIndex;
    private int inputValue;
    private String actionRW;
    private String actionLRN;
    private int nextStateIndex;

    public Rule() {

    }

    public Rule(int stateIndex, int inputValue, String actionRW, String actionLRN, int nextStateIndex) {
        this.stateIndex = stateIndex;
        this.inputValue = inputValue;
        this.actionRW = actionRW;
        this.actionLRN = actionLRN;
        this.nextStateIndex = nextStateIndex;
    }

    public int getStateIndex(){
        return this.stateIndex;
    }

    public int getInputValue(){
        return this.inputValue;
    }

    public String getActionRW(){
        return this.actionRW;
    }

    public String getActionLRN() {
        return this.actionLRN;
    }

    public int getNextStateIndex(){
        return nextStateIndex;
    }
}
