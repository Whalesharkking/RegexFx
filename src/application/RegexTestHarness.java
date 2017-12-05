package application;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RegexTestHarness {
    Controller controller;

    public RegexTestHarness() {
        this.controller = new Controller();
    }

    @FXML
    private TextField textFieldRegex;
    @FXML
    private TextField textFieldString;
    @FXML
    private TextArea textAreaResult;
    @FXML
    private TextField textFieldFlag;

    @FXML
    private void regexCalc() {
        if (!textFieldRegex.getText().isEmpty() && !textFieldString.getText().isEmpty()) {
            final List<String> matches = controller.makeRegexAndTestIt(textFieldFlag.getText(), textFieldRegex.getText(), textFieldString.getText());
            boolean found = false;
            textAreaResult.clear();
            if (!matches.isEmpty()) {
                matches.forEach(match -> {
                    textAreaResult.insertText(0, match);
                });
                found = true;
            }
            if (!found) {
                textAreaResult.clear();
                textAreaResult.insertText(0, "No match found");
            }
        }
    }
}