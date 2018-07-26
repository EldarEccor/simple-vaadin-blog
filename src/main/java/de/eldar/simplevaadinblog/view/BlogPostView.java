package de.eldar.simplevaadinblog.view;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;

import de.eldar.simplevaadinblog.pojo.BlogPost;


public class BlogPostView extends VerticalLayout{
	
	private static final long serialVersionUID = 3316505466501001318L;

	private Label authorField;
	
	private Label creationDateField;
	
	private TextArea bodyArea;
	
	public BlogPostView(BlogPost toDisplay) {
		authorField = new Label("Author");
		authorField.setText(toDisplay.getAuthor());
		
		Instant creationInstant = toDisplay.getCreationDate().toInstant();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(creationInstant,ZoneId.systemDefault());
		creationDateField = new Label("Erstellt am");
		creationDateField.setText(localDateTime.toString());
		
		bodyArea = new TextArea("Beitrag");
		bodyArea.setValue(toDisplay.getBody());
		bodyArea.setReadOnly(true);
	
		
		HorizontalLayout upperLayout = new HorizontalLayout(authorField,creationDateField);
		add(upperLayout);
		add(bodyArea);
	}
}
