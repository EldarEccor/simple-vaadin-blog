package de.eldar.simplevaadinblog.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

import de.eldar.simplevaadinblog.pojo.BlogPost;

public class CreateBlogPostView extends VerticalLayout{

	private static final long serialVersionUID = -7527646128662889567L;

	private final H2 titleField = new H2("Blogpost erstellen");

	private TextField author = new TextField("Author");
	private TextArea body = new TextArea("Beitrag");
	private Button submit = new Button("Speichern");

	private Binder<BlogPost> binder;

	private final FormLayout formLayout = new FormLayout();
	private final HorizontalLayout buttonBar = new HorizontalLayout(submit);

	public CreateBlogPostView(BlogPost formBean) {
		add(titleField);
		initFormLayout();		
		initButtonBar();
		initBinder();
		setBean(formBean);
	}
	
	private void initFormLayout() {
		formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1), new FormLayout.ResponsiveStep("25em", 2));
		Div div = new Div(formLayout);
		div.addClassName("has-padding");
		add(div);
		add(author);
		add(body);	
	}

	private void initBinder() {
		binder = new Binder<BlogPost>();
		binder.forField(author).bind(BlogPost::getAuthor,
				BlogPost::setAuthor);
		binder.forField(body).bind(BlogPost::getBody, BlogPost::setBody);
	}

	public void setBean(BlogPost blogPost) {
		binder.setBean(blogPost);
	}

	private void initButtonBar() {
		submit.setAutofocus(true);
		submit.getElement().setAttribute("theme", "primary");		
		buttonBar.setClassName("buttons");
		buttonBar.setSpacing(true);
		add(buttonBar);
	}

	public Button getSubmit() {
		return submit;
	}
}
