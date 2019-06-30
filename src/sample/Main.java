package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    int currentAbsIndex = 0;
    //public static int CURRSTATE = 0;
    int currentStateIndex = 0;
    List<Rule> rules =  new ArrayList<Rule>();

    List<Integer> inputValues=new ArrayList<Integer>(){{
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

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        rules.add(rule0);
        rules.add(rule1);
        rules.add(rule2);
        rules.add(rule3);

        States states = new States(2, rules);

        while(true){
            currentAbsIndex = states.executeState(currentStateIndex, currentAbsIndex, inputValues);
            currentStateIndex = states.getCurrstate();
        }
        /*
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        */

        //primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
