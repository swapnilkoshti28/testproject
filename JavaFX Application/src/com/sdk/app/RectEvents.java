package com.sdk.app;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class RectEvents {

	public static EventHandler<MouseEvent> getMouseEnteredEventHandler(RectComponent rect, Pane root) {
		
		EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
//				rect.setStyle(Color.BROWN, 2);
				rect.selectRect();
			}
		};
		
		return handler;
	}
	
	
	
	
	
	
	
	public static EventHandler<KeyEvent> getKeyEventHandler(RectComponent rect, Pane root) {
		
		EventHandler<KeyEvent> handler = new EventHandler<KeyEvent>() {
			
			@Override
			public void handle(KeyEvent event) {
				System.out.println(event.getCode());
				
			}
		};
		
		return handler;
	}


	public static EventHandler<MouseEvent> getMouseExitedEventHandler(RectComponent rect, Pane root) {
		
		EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				if(GlobalComp.getActivRect()!=rect) {
					rect.delesectRect();
				}
				
			}
		};
		
		return handler;
	}
	
	
	
	
	
	public static EventHandler<MouseEvent> getMouseClickedEventHandler(RectComponent rect, Pane root) {
		
		EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				if(GlobalComp.getActivRect()!=null ) {
					
					if(rect!=GlobalComp.getActivRect()) {
						rect.selectRect();
						GlobalComp.setActivRect(rect);
						for(RectComponent rectangle : GlobalComp.getRectlist()) {
							if(rectangle!=rect) {
								rectangle.delesectRect();
							}
						}
					} else {
						rect.selectRect();
						GlobalComp.setActivRect(rect);
					}
					
					
				} else {
					rect.selectRect();
					GlobalComp.setActivRect(rect);
				}
				
			}
		};
		
		return handler;
	}


}
