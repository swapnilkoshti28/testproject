package com.sdk.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainApplication extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Pane root = new Pane();
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFX Test Application");
		primaryStage.setMaximized(true);
		primaryStage.show();
		
		
		root.addEventFilter(MouseEvent.MOUSE_PRESSED, MouseEventListener.getPressedEventHandler());
		root.addEventFilter(MouseEvent.MOUSE_RELEASED, MouseEventListener.getReleasedEventHandler(root));
		root.addEventFilter(MouseEvent.MOUSE_DRAGGED, MouseEventListener.getDraggedEventHandler(root));
		root.addEventFilter(MouseEvent.MOUSE_CLICKED, MouseEventListener.getClickEventHandler());
		root.addEventFilter(KeyEvent.KEY_PRESSED, MouseEventListener.getKeyEventHandler(root));
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

	
}
