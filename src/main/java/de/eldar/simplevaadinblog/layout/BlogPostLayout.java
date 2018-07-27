package de.eldar.simplevaadinblog.layout;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import de.eldar.simplevaadinblog.pojo.BlogPost;

public class BlogPostLayout extends VerticalLayout {

	private static final long serialVersionUID = 3316505466501001318L;

	private HorizontalLayout header;

	private Div body;

	public BlogPostLayout(BlogPost toDisplay) {
		setClassName("blogpost");

		Date creationDate = toDisplay.getCreationDate();

		body = new Div();
		body.setSizeFull();
		body.setClassName("blogpost_body");
		Span bodySpan = new Span();
		bodySpan.setText(toDisplay.getBody());
		bodySpan.setSizeFull();
		body.add(bodySpan);

		header = new HorizontalLayout();
		header.setClassName("blogpost_header");
		header.setAlignItems(Alignment.START);
		header.setSizeFull();
		header.add(new Span(toDisplay.getAuthor() + "  " + new SimpleDateFormat("dd.MM.yyy").format(creationDate)));
		
		add(header);
		add(body);
	}
}
