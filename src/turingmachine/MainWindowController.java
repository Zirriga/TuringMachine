package turingmachine;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.List;

public class MainWindowController {

    private int currentAbsIndex = 0;
    private int currentStateIndex = 0;
    private List<Rule> rules =  new ArrayList<Rule>();

    private List<Integer> inputValues = new ArrayList<Integer>(){{
        add(0);
        add(1);
        add(1);
        add(0);
        add(1);
    }};

    Rule rule0 = new Rule(0, 1, "0", "Right", 1);
    Rule rule1 = new Rule(0, 0, "1", "Right", 1);
    Rule rule2 = new Rule(1, 1, "1", "Left", 0);
    Rule rule3 = new Rule(1, 0, "0", "Left", 0);

    private ObservableList<Integer> memoryTapeObservableList = FXCollections.observableArrayList();
    @FXML private TableView<Integer> memoryTapeTable1View;
    @FXML private TableColumn<Integer, Integer> t1C0TableColumn;
    @FXML private TableColumn<Integer, Integer> t1C1TableColumn;
    @FXML private TableColumn<Integer, Integer> t1C2TableColumn;
    @FXML private TableColumn<Integer, Integer> t1C3TableColumn;
    @FXML private TableColumn<Integer, Integer> t1C4TableColumn;
    @FXML private TableColumn<Integer, Integer> t1C5TableColumn;
    @FXML private TableColumn<Integer, Integer> t1C6TableColumn;
    @FXML private TableColumn<Integer, Integer> t1C7TableColumn;
    @FXML private TableColumn<Integer, Integer> t1C8TableColumn;
    @FXML private TableColumn<Integer, Integer> t1C9TableColumn;
    @FXML private TableColumn<Integer, Integer> t1C10TableColumn;

    public MainWindowController() {
    }

    @FXML
    private void initialize() {
    }

    public void init() {
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
    }
}
