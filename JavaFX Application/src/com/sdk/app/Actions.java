package com.sdk.app;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Actions {

	public static void drawRect(Pane root, MouseEvent event) {
		if(GlobalComp.isLeftKeyPressed()) {
			Rectangle prevrect = GlobalComp.getPrevrect();
			if(prevrect!=null)
				root.getChildren().remove(prevrect);
			
			Rectangle rect = new Rectangle(GlobalComp.getX(), GlobalComp.getY(), event.getX() - GlobalComp.getX(), event.getY() - GlobalComp.getY());
			rect.setFill(Color.TRANSPARENT);
			rect.setStroke(Color.CORAL);
			root.getChildren().add(rect);
			GlobalComp.setPrevrect(rect);
		}
	}
	
	
	
	public static synchronized void saveRect(MouseEvent event, Pane root) {
		GlobalComp.setLeftKeyPressed(true);
		GlobalComp.setLeftKeyReleased(true);
		GlobalComp.setXY(event.getX(), event.getY());
		
		Rectangle currrect = GlobalComp.getPrevrect();
		if(currrect!=null && currrect.getWidth()<150) {
			currrect.setWidth(150);
		}
		if(currrect!=null && currrect.getHeight()<200) {
			currrect.setHeight(200);
		}
		
		if(currrect!=null && currrect.getX()< (currrect.getWidth()+event.getX()) && currrect.getY()<(currrect.getHeight()+event.getY())) {
			if(GlobalComp.getRectlist().size()>0) {
				int size = GlobalComp.getRectlist().size();
				boolean intersect = false;
				
				
				for(int i=0;i<size;i++) {
					Rectangle rect = GlobalComp.getRectlist().get(i).getRectangle();
					if(rect.getBoundsInParent().intersects(currrect.getBoundsInParent())) {
						intersect = true;
					}
				}
				
				if(intersect) {
					root.getChildren().remove(currrect);
				} else {
					GlobalComp.addRect(currrect, root);
				}
			} else {
				GlobalComp.addRect(currrect, root);
			}
		}
		
		
//		System.out.println("No Of Rects "+GlobalComp.getRectlist().size());
		GlobalComp.setPrevrect(null);
	}
}
