package turingmachine;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainWindowController {
    private static Map<Integer, String> memoryMap = new HashMap<>();
    private int currentAbsIndex = 0;
    private int currentStateIndex = 0;
    private MemoryBuffer buffer = new MemoryBuffer();

    private Object lastChosenRow = null;

    /*
    Rule rule0 = new Rule(0, 1, "0", "Right", 1);
    Rule rule1 = new Rule(0, 0, "1", "Right", 1);
    Rule rule2 = new Rule(1, 1, "1", "Left", 0);
    Rule rule3 = new Rule(1, 0, "0", "Left", 0);
    */

    private ObservableList<MemoryBuffer> memoryTapeObservableList = FXCollections.observableArrayList();
    @FXML
    private TableView<MemoryBuffer> memoryTapeTable1View;
    @FXML
    private TableColumn<MemoryBuffer, String> t1C0TableColumn;
    @FXML
    private TableColumn<MemoryBuffer, String> t1C1TableColumn;
    @FXML
    private TableColumn<MemoryBuffer, String> t1C2TableColumn;
    @FXML
    private TableColumn<MemoryBuffer, String> t1C3TableColumn;
    @FXML
    private TableColumn<MemoryBuffer, String> t1C4TableColumn;
    @FXML
    private TableColumn<MemoryBuffer, String> t1C5TableColumn;
    @FXML
    private TableColumn<MemoryBuffer, String> t1C6TableColumn;
    @FXML
    private TableColumn<MemoryBuffer, String> t1C7TableColumn;
    @FXML
    private TableColumn<MemoryBuffer, String> t1C8TableColumn;
    @FXML
    private TableColumn<MemoryBuffer, String> t1C9TableColumn;
    @FXML
    private TableColumn<MemoryBuffer, String> t1C10TableColumn;

    private ObservableList<Rule> rulesObservableList = FXCollections.observableArrayList();
    @FXML
    private TableView<Rule> rulesTable2View;
    @FXML
    private TableColumn<Rule, String> t2StateTableColumn;
    @FXML
    private TableColumn<Rule, String> t2ReadTableColumn;
    @FXML
    private TableColumn<Rule, String> t2WriteTableColumn;
    @FXML
    private TableColumn<Rule, String> t2MoveTableColumn;
    @FXML
    private TableColumn<Rule, String> t2NextStateTableColumn;

    @FXML
    private TextField stateTextField;
    @FXML
    private TextField writeVal;
    @FXML
    private TextField moveHere;
    @FXML
    private TextField nextState;
    @FXML
    private TextField valueSet;
    @FXML
    private TextField abc;
    @FXML
    private TextField readVal;

    @FXML
    private TextField errorLabel;

    @FXML
    private TextField currentStateTextField;
    @FXML
    private TextField headPositionTextField;


    public MainWindowController() {
    }

    @FXML
    private void initialize() {
    }

    public void init() {
        t1C0TableColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().C0));
        t1C1TableColumn.setCellValueFactory(cell -> new SimpleStringProperty((cell.getValue().C1)));
        t1C2TableColumn.setCellValueFactory(cell -> new SimpleStringProperty((cell.getValue().C2)));
        t1C3TableColumn.setCellValueFactory(cell -> new SimpleStringProperty((cell.getValue().C3)));
        t1C4TableColumn.setCellValueFactory(cell -> new SimpleStringProperty((cell.getValue().C4)));
        t1C5TableColumn.setCellValueFactory(cell -> new SimpleStringProperty((cell.getValue().C5)));
        t1C6TableColumn.setCellValueFactory(cell -> new SimpleStringProperty((cell.getValue().C6)));
        t1C7TableColumn.setCellValueFactory(cell -> new SimpleStringProperty((cell.getValue().C7)));
        t1C8TableColumn.setCellValueFactory(cell -> new SimpleStringProperty((cell.getValue().C8)));
        t1C9TableColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().C9));
        t1C10TableColumn.setCellValueFactory(cell -> new SimpleStringProperty((cell.getValue().C10)));

        t2StateTableColumn.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getStateIndex())));
        t2ReadTableColumn.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getInputValue())));
        t2WriteTableColumn.setCellValueFactory(cell -> new SimpleStringProperty((cell.getValue().getActionRW())));
        t2MoveTableColumn.setCellValueFactory(cell -> new SimpleStringProperty((cell.getValue().getActionLRN())));
        t2NextStateTableColumn.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getNextStateIndex())));

        t1C0TableColumn.setText("-5");
        t1C1TableColumn.setText("-4");
        t1C2TableColumn.setText("-3");
        t1C3TableColumn.setText("-2");
        t1C4TableColumn.setText("-1");
        t1C5TableColumn.setText("0");
        t1C6TableColumn.setText("1");
        t1C7TableColumn.setText("2");
        t1C8TableColumn.setText("3");
        t1C9TableColumn.setText("4");
        t1C10TableColumn.setText("5");

        currentStateTextField.setText("0");
        headPositionTextField.setText("0");

        rulesTable2View.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    lastChosenRow = newValue;
                });

        memoryTapeObservableList.add(buffer);
        memoryTapeTable1View.setItems(memoryTapeObservableList);
    }

    @FXML
    public void onMoveRightTapeButtonClicked() {
        t1C0TableColumn.setText(String.valueOf(Integer.parseInt(t1C0TableColumn.getText()) + 1));
        t1C1TableColumn.setText(String.valueOf(Integer.parseInt(t1C1TableColumn.getText()) + 1));
        t1C2TableColumn.setText(String.valueOf(Integer.parseInt(t1C2TableColumn.getText()) + 1));
        t1C3TableColumn.setText(String.valueOf(Integer.parseInt(t1C3TableColumn.getText()) + 1));
        t1C4TableColumn.setText(String.valueOf(Integer.parseInt(t1C4TableColumn.getText()) + 1));
        t1C5TableColumn.setText(String.valueOf(Integer.parseInt(t1C5TableColumn.getText()) + 1));
        t1C6TableColumn.setText(String.valueOf(Integer.parseInt(t1C6TableColumn.getText()) + 1));
        t1C7TableColumn.setText(String.valueOf(Integer.parseInt(t1C7TableColumn.getText()) + 1));
        t1C8TableColumn.setText(String.valueOf(Integer.parseInt(t1C8TableColumn.getText()) + 1));
        t1C9TableColumn.setText(String.valueOf(Integer.parseInt(t1C9TableColumn.getText()) + 1));
        t1C10TableColumn.setText(String.valueOf(Integer.parseInt(t1C10TableColumn.getText()) + 1));

        currentAbsIndex = Integer.parseInt(t1C5TableColumn.getText());

        headPositionTextField.setText(String.valueOf(Integer.parseInt(headPositionTextField.getText()) + 1));

        onUpdateTapeValues();
    }

    @FXML
    public void onMoveLeftTapeButtonClicked() {
        t1C0TableColumn.setText(String.valueOf(Integer.parseInt(t1C0TableColumn.getText()) - 1));
        t1C1TableColumn.setText(String.valueOf(Integer.parseInt(t1C1TableColumn.getText()) - 1));
        t1C2TableColumn.setText(String.valueOf(Integer.parseInt(t1C2TableColumn.getText()) - 1));
        t1C3TableColumn.setText(String.valueOf(Integer.parseInt(t1C3TableColumn.getText()) - 1));
        t1C4TableColumn.setText(String.valueOf(Integer.parseInt(t1C4TableColumn.getText()) - 1));
        t1C5TableColumn.setText(String.valueOf(Integer.parseInt(t1C5TableColumn.getText()) - 1));
        t1C6TableColumn.setText(String.valueOf(Integer.parseInt(t1C6TableColumn.getText()) - 1));
        t1C7TableColumn.setText(String.valueOf(Integer.parseInt(t1C7TableColumn.getText()) - 1));
        t1C8TableColumn.setText(String.valueOf(Integer.parseInt(t1C8TableColumn.getText()) - 1));
        t1C9TableColumn.setText(String.valueOf(Integer.parseInt(t1C9TableColumn.getText()) - 1));
        t1C10TableColumn.setText(String.valueOf(Integer.parseInt(t1C10TableColumn.getText()) - 1));

        currentAbsIndex = Integer.parseInt(t1C5TableColumn.getText());

        headPositionTextField.setText(String.valueOf(Integer.parseInt(headPositionTextField.getText()) - 1));

        onUpdateTapeValues();
    }

    @FXML
    private void onUpdateTapeValues() {
        memoryTapeObservableList.removeAll(memoryTapeObservableList);
        List<String> tempValueContainer = new ArrayList<String>();
        int leftmostTapeIndex = Integer.parseInt(t1C0TableColumn.getText());
        for (int i = 0; i < 11; i++) {
            if (memoryMap.containsKey(leftmostTapeIndex)) {
                tempValueContainer.add(memoryMap.get(leftmostTapeIndex));
            } else {
                tempValueContainer.add("0");
            }
            leftmostTapeIndex++;
        }
        MemoryBuffer buffTemp = new MemoryBuffer(tempValueContainer);
        memoryTapeObservableList.add(buffTemp);
        memoryTapeTable1View.setItems(memoryTapeObservableList);
    }

    @FXML
    public void setVoidButtonClicked() {
        int selectedIndex = (Integer.parseInt(t1C0TableColumn.getText()) + Integer.parseInt(t1C10TableColumn.getText())) / 2;
        buffer.C5 = "0";
        memoryMap.put(selectedIndex, "0");

        onUpdateTapeValues();
    }

    private boolean isHere(String alphabet, String val) {
        List<String> valueList = Arrays.asList(alphabet.split(","));
        return valueList.contains(val);
    }

    @FXML
    public void setValueButtonClicked() {
        int selectedIndex = (Integer.parseInt(t1C0TableColumn.getText()) + Integer.parseInt(t1C10TableColumn.getText())) / 2;
        if (valueSet.getText().isEmpty()) {
            errorLabel.setText("Empty value");
            return;
        } else {
            if (!isHere(abc.getText(), valueSet.getText())) {
                errorLabel.setText("Unexpected value");
                return;
            }
            buffer.C5 = valueSet.getText();
            memoryMap.put(selectedIndex, valueSet.getText());
        }

        onUpdateTapeValues();
    }

    @FXML
    public void addRuleButtonClicked() {
        if (stateTextField.getText().isEmpty() || writeVal.getText().isEmpty()
                || moveHere.getText().isEmpty() || nextState.getText().isEmpty()) {
            errorLabel.setText("Fill Up All Fields!");
            return;
        }
        if ((isHere(abc.getText(), readVal.getText())) && (isHere(abc.getText(), writeVal.getText()))) {
            if (!moveHere.getText().equals("L") && !moveHere.getText().equals("R") && !moveHere.getText().equals("N")) {
                errorLabel.setText("You can only move L, R or N!");
            } else {
                Rule newRule1 = new Rule(Integer.parseInt(stateTextField.getText()), Integer.parseInt(readVal.getText()), writeVal.getText(), moveHere.getText(), Integer.parseInt(nextState.getText()));

                rulesObservableList.add(newRule1);

                rulesTable2View.setItems(rulesObservableList);

                errorLabel.setText("New Rules Added!");

                stateTextField.clear();
                writeVal.clear();
                readVal.clear();
                moveHere.clear();
                nextState.clear();
            }

        } else {
            errorLabel.setText("Unexpected value");
        }
    }

    @FXML
    public void setCurrentStateButtonClicked() {
        if (!currentStateTextField.getText().isEmpty() && currentStateTextField.getText().matches("^[-+]?\\d+(\\.\\d+)?$")) {
            currentStateIndex = Integer.parseInt(currentStateTextField.getText());
            errorLabel.setText("Initial State is set!");
        } else {
            errorLabel.setText("Initial State must be an Integer!");
        }
    }

    @FXML
    public void setHeadPositionButtonClicked() {
        if (!headPositionTextField.getText().isEmpty() && headPositionTextField.getText().matches("^[-+]?\\d+(\\.\\d+)?$")) {
            currentAbsIndex = Integer.parseInt(headPositionTextField.getText());
            while (currentAbsIndex != Integer.parseInt(t1C5TableColumn.getText())) {
                if (currentAbsIndex > Integer.parseInt(t1C5TableColumn.getText())) {
                    onMoveRightTapeButtonClicked();
                    headPositionTextField.setText(String.valueOf(Integer.parseInt(headPositionTextField.getText()) - 1));
                } else {
                    onMoveLeftTapeButtonClicked();
                    headPositionTextField.setText(String.valueOf(Integer.parseInt(headPositionTextField.getText()) + 1));
                }
            }
            errorLabel.setText("Head position is set!");
        } else {
            errorLabel.setText("Head Position must be an Integer!");
        }
    }

    @FXML
    public void deleteRuleButtonClicked() {
        if (lastChosenRow != null) {
            rulesObservableList.remove((Rule) lastChosenRow);
            rulesTable2View.setItems(rulesObservableList);
        } else {
            errorLabel.setText("You must select the Rule from the table!");
        }
    }

    @FXML
    public void executeStepButtonClicked() {
        List<Rule> rules = new ArrayList<Rule>(rulesObservableList);
        States states = new States(rules, currentStateIndex, memoryMap);
        currentAbsIndex = states.executeState(currentStateIndex, currentAbsIndex);
        currentStateIndex = states.getCurrState();
        memoryMap = states.getMemoryTape();

        //update UI
        headPositionTextField.setText(String.valueOf(currentAbsIndex));

        while (currentAbsIndex != Integer.parseInt(t1C5TableColumn.getText())) {
            if (currentAbsIndex > Integer.parseInt(t1C5TableColumn.getText())) {
                onMoveRightTapeButtonClicked();
                headPositionTextField.setText(String.valueOf(Integer.parseInt(headPositionTextField.getText()) - 1));
            } else {
                onMoveLeftTapeButtonClicked();
                headPositionTextField.setText(String.valueOf(Integer.parseInt(headPositionTextField.getText()) + 1));
            }
        }

        currentStateTextField.setText(String.valueOf(currentStateIndex));
        onUpdateTapeValues();
    }

    @FXML
    public void runButtonClicked() {
        final ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        ses.scheduleWithFixedDelay(this::executeStepButtonClicked, 0, 1, TimeUnit.SECONDS);
    }
}
