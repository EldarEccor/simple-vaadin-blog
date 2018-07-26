package de.eldar.simplevaadinblog.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout{

	private static final long serialVersionUID = -7336737691960160002L;

	public MainView() {
		add(new Button("Click me softly", e -> Notification.show("You had me at button-down")));
	}	
}
