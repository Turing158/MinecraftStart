package Controller;

import Launch.LaunchMC;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import util.EffectAnimation;

public class PlayerSettingController {
    @FXML
    public ComboBox<String> selectFunc;
    @FXML
    public TextField playerUser;
    @FXML
    public TextField playerPassword;
    @FXML
    public Button playerVerify;
    @FXML
    public Button playerMicrosoft;
    @FXML
    public AnchorPane outline;
    @FXML
    public AnchorPane online;
    @FXML
    public AnchorPane Microsoft;
    @FXML
    public AnchorPane microsoftVerify;
    @FXML
    TextField playerName;
    @FXML
    Button exit;
    @FXML
    public void initialize(){
        selectFunc.getItems().addAll("离线登录","正版登录","微软登录");
        selectFunc.setOnAction(event -> {
            if(selectFunc.getValue().equals("离线登录")){
                outline.setVisible(true);
                online.setVisible(false);
                Microsoft.setVisible(false);
                LaunchMC.playerFunc = "outline";
            }
            else  if(selectFunc.getValue().equals("正版登录")){
                outline.setVisible(false);
                online.setVisible(true);
                Microsoft.setVisible(false);
                LaunchMC.playerFunc = "online";
            }
            else  if(selectFunc.getValue().equals("微软登录")){
                outline.setVisible(false);
                online.setVisible(false);
                Microsoft.setVisible(true);
                LaunchMC.playerFunc = "microsoft";
            }
            else {
                System.out.println("选择登录方式");
            }
        });
    }
    public void microsoftLogin() {
        EffectAnimation effect =  new EffectAnimation();
        microsoftVerify.getChildren().setAll(new Frame().verifyMicrosoft());
        effect.fadeEmergeVanish(0.2,true,microsoftVerify);
    }
    public void close(){
        LaunchMC.username = playerName.getText();
        EffectAnimation effect = new EffectAnimation();
        effect.fadeEmergeVanish(0.2,false,exit.getParent().getParent().getParent());
        effect.switchPage(exit.getParent().getParent(),0.2,25,425,false).play();
        StartFrameController.playerFlag = false;
    }
}
