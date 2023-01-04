package testcypher;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import randomcipher.CipherMethod;

public class Test {
    @FXML
    private TextField CipherTextField;

    @FXML
    private TextField TxtToEnDeCryptField;

    @FXML
    private TextField OutputField;

    @FXML
    private Button EncryptButton;

    @FXML
    private Button DecryptButton;

    @FXML
    private Button QuitButton;


    @FXML
    private void handleDecryptButton (ActionEvent event){
        CipherMethod cipherMethod = new CipherMethod();
        OutputField.setText(cipherMethod.decrypt(TxtToEnDeCryptField.getText(), CipherTextField.getText()));
    }

    @FXML
    private void handleEncryptButton (ActionEvent event){
        CipherMethod cipherMethod = new CipherMethod();
        OutputField.setText(cipherMethod.encrypt(TxtToEnDeCryptField.getText(), CipherTextField.getText()));
    }

    @FXML
    public void handleQuitButton(ActionEvent event) {
        Platform.exit();
    }
}
