package com.sdk.app;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class MouseEventListener {

	public static EventHandler<MouseEvent> getClickEventHandler() {
		
		EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				
				Rectangle currrect = new Rectangle(event.getX(), event.getY(), 1, 1);
				
				int size = GlobalComp.getRectlist().size();
				boolean intersect = false;
				
				
				for(int i=0;i<size;i++) {
					Rectangle rect = GlobalComp.getRectlist().get(i).getRectangle();
					if(rect.getBoundsInParent().intersects(currrect.getBoundsInParent())) {
						intersect = true;
					}
				}
				
				if(!intersect) {
					for(RectComponent rec : GlobalComp.getRectlist()) {
						rec.delesectRect();
					}
				}
			}
		};
		
		return handler;
	}
	
	
	
	
	
	
	public static EventHandler<MouseEvent> getPressedEventHandler() {
		
		EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				
				if(event.getButton() == MouseButton.PRIMARY) {
					GlobalComp.setLeftKeyPressed(true);
					GlobalComp.setLeftKeyReleased(false);
					GlobalComp.setXY(event.getX(), event.getY());
					
				}
			}
		};
		
		return handler;
	}
	
	
	
	
	public static EventHandler<MouseEvent> getReleasedEventHandler(Pane root) {
		
		EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				
				if(event.getButton() == MouseButton.PRIMARY) {
					Actions.saveRect(event,root);
				}
			}
		};
		
		return handler;
	}


	
	
	public static EventHandler<MouseEvent> getDraggedEventHandler(Pane root) {
		
		EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				
				Actions.drawRect(root, event);
			}
		};
		
		return handler;
	}

	
	
	public static EventHandler<KeyEvent> getKeyEventHandler(Pane root) {
		
		EventHandler<KeyEvent> handler = new EventHandler<KeyEvent>() {
			
			@Override
			public void handle(KeyEvent event) {
				System.out.println(event.getCode());
				
			}
		};
		
		return handler;
	}
}
