package sample;


import java.util.List;

public class States {
    private int numOfStates;
    private List<Rule> rules;
    private int currstate;

    public States() {
        this.numOfStates = 0;
        this.rules = null;
        this.currstate = 0;
    }

    public States(int numOfStates, List<Rule> rules) {
        this.numOfStates = numOfStates;
        this.rules = rules;
        this.currstate = 0;
    }

    public int getNumOfStates() {
        return numOfStates;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setNumOfStates(int numOfStates) {
        this.numOfStates = numOfStates;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public int executeState(int stateIndex, int currentInputIndex, List<Integer> input) {
        for (Rule rule: this.rules) {
            if(rule.getStateIndex() == stateIndex && rule.getInputValue() == input.get(currentInputIndex)){
                int absoluteIndex = currentInputIndex;
                switch (rule.getActionLRN()) {
                    case "Left":

                        if(rule.getActionRW() == "Null") {
                            setCurrState(rule.getNextStateIndex());
                            absoluteIndex--;
                            return absoluteIndex;
                        }
                        else {
                            input.set(absoluteIndex, Integer.parseInt(rule.getActionRW()));
                            setCurrState(rule.getNextStateIndex());
                            absoluteIndex--;
                            return absoluteIndex;
                        }
                    case "Right":
                        if(rule.getActionRW() == "Null") {
                            setCurrState(rule.getNextStateIndex());
                            absoluteIndex++;
                            return absoluteIndex;
                        }
                        else {
                            input.set(absoluteIndex, Integer.parseInt(rule.getActionRW()));
                            setCurrState(rule.getNextStateIndex());
                            absoluteIndex++;
                            return absoluteIndex;
                        }
                    case "Null":
                        if(rule.getActionRW() == "Null") {
                            setCurrState(rule.getNextStateIndex());
                            return absoluteIndex;
                        }
                        else {
                            input.set(absoluteIndex, Integer.parseInt(rule.getActionRW()));
                            setCurrState(rule.getNextStateIndex());
                            return absoluteIndex;
                        }
                }
            }
        }
        setCurrState(1000);
        return currentInputIndex;
    }

    public void setCurrState(int nextState) {
        this.currstate = nextState;
    }

    public int getCurrstate() {
        return this.currstate;
    }
}
