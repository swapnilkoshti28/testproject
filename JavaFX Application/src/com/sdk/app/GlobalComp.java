package com.sdk.app;

import java.util.ArrayList;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class GlobalComp {

	private static Rectangle prevrect;
	private static double X,Y;
	private static boolean leftKeyPressed,leftKeyReleased;
	private static List<RectComponent> rectlist = new ArrayList<>();
	private static RectComponent activRect = null;
	
	public static Rectangle getPrevrect() {
		return prevrect;
	}

	public static void setPrevrect(Rectangle prevrect1) {
		prevrect = prevrect1;
	}

	public static double getX() {
		return X;
	}

	public static void setX(double x) {
		X = x;
	}

	public static double getY() {
		return Y;
	}

	public static void setY(double y) {
		Y = y;
	}
	
	public static void setXY(double x, double y) {
		Y = y;
		X = x;
	}

	public static boolean isLeftKeyPressed() {
		return leftKeyPressed;
	}

	public static void setLeftKeyPressed(boolean leftKeyPressed1) {
		leftKeyPressed = leftKeyPressed1;
	}

	public static boolean isLeftKeyReleased() {
		return leftKeyReleased;
	}

	public static void setLeftKeyReleased(boolean leftKeyReleased1) {
		leftKeyReleased = leftKeyReleased1;
	}

	public static List<RectComponent> getRectlist() {
		return rectlist;
	}

	public static void addRect(Rectangle rect, Pane root) {
		Line line = new Line(rect.getX(), rect.getY()+25, rect.getX()+rect.getWidth(), rect.getY()+25);
		line.setStroke(Color.CORAL);
		line.setStrokeWidth(1);
		root.getChildren().add(line);
		rect.setFill(Color.ALICEBLUE);
		RectComponent rectcomp = new RectComponent(rect, line);
		rect.addEventFilter(MouseEvent.MOUSE_ENTERED, RectEvents.getMouseEnteredEventHandler(rectcomp, root));
		rect.addEventFilter(MouseEvent.MOUSE_EXITED, RectEvents.getMouseExitedEventHandler(rectcomp, root));
		rect.addEventFilter(MouseEvent.MOUSE_CLICKED, RectEvents.getMouseClickedEventHandler(rectcomp, root));
		rect.addEventFilter(KeyEvent.KEY_RELEASED, RectEvents.getKeyEventHandler(rectcomp, root));
		
		ContextMenu contextmenu = new ContextMenu();
		MenuItem mi1 = new MenuItem("\tFile\t");
		MenuItem mi2 = new MenuItem("\tEdit\t");
		contextmenu.getItems().addAll(mi1,mi2);
		rect.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {

			@Override
			public void handle(ContextMenuEvent event) {
				contextmenu.show(rect,event.getX(), event.getY());
				
			}
		});
		rectlist.add(rectcomp);
	}

	public static RectComponent getActivRect() {
		return activRect;
	}

	public static void setActivRect(RectComponent activRect) {
		GlobalComp.activRect = activRect;
	}

}
