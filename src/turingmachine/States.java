package turingmachine;


import java.util.List;
import java.util.Map;

public class States {

    private List<Rule> rules;
    private int currState;
    private Map<Integer, String> memoryTape;

    public States() {
        this.rules = null;
        this.currState = 0;
        this.memoryTape = null;
    }

    public States(List<Rule> rules, int initialState, Map<Integer, String> input) {
        this.rules = rules;
        this.currState = initialState;
        this.memoryTape = input;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public Map<Integer, String> getMemoryTape() {
        return memoryTape;
    }

    public void setMemoryTape(Map<Integer, String> input) {
        this.memoryTape = input;
    }

    public int executeState(int stateIndex, int currentInputIndex) {
        for (Rule rule: this.rules) {
            if(rule.getStateIndex() == stateIndex && rule.getInputValue() == Integer.parseInt(memoryTape.get(currentInputIndex))){
                int absoluteIndex = currentInputIndex;
                switch (rule.getActionLRN()) {
                    case "L":
                        if(rule.getActionRW().equals("")) {
                            setCurrState(rule.getNextStateIndex());
                            absoluteIndex--;
                            return absoluteIndex;
                        }
                        else {
                            memoryTape.put(absoluteIndex, rule.getActionRW());
                            setCurrState(rule.getNextStateIndex());
                            absoluteIndex--;
                            return absoluteIndex;
                        }
                    case "R":
                        if(rule.getActionRW().equals("")) {
                            setCurrState(rule.getNextStateIndex());
                            absoluteIndex++;
                            return absoluteIndex;
                        }
                        else {
                            memoryTape.put(absoluteIndex, rule.getActionRW());
                            setCurrState(rule.getNextStateIndex());
                            absoluteIndex++;
                            return absoluteIndex;
                        }
                    case "N":
                        if(rule.getActionRW().equals("")) {
                            setCurrState(rule.getNextStateIndex());
                            return absoluteIndex;
                        }
                        else {
                            memoryTape.put(absoluteIndex, rule.getActionRW());
                            setCurrState(rule.getNextStateIndex());
                            return absoluteIndex;
                        }
                }
            }
        }
        return currentInputIndex;
    }

    public void setCurrState(int nextState) {
        this.currState = nextState;
    }

    public int getCurrState() {
        return currState;
    }
}
