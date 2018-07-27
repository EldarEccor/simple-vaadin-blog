package de.eldar.simplevaadinblog.route;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

import de.eldar.simplevaadinblog.layout.MainLayout;
import de.eldar.simplevaadinblog.pojo.BlogPost;
import de.eldar.simplevaadinblog.repository.BlogPostRepository;

@Route(value = "create", layout = MainLayout.class)
public class CreateBlogPostView extends VerticalLayout {

	private static final long serialVersionUID = 345147266116144856L;

	private BlogPostRepository blogPostRepository;

	public CreateBlogPostView(@Autowired BlogPostRepository blogPostRepository) {
		this.blogPostRepository = blogPostRepository;
		add(titleField);
		initFormLayout();
		initButtonBar();		
	}

	private final H2 titleField = new H2("Blogpost erstellen");

	private TextField author = new TextField("Author");
	private TextArea body = new TextArea("Beitrag");
	private Button submit = new Button("Speichern");

	private Binder<BlogPost> binder;
	private BlogPost currentItem = new BlogPost();

	private final FormLayout formLayout = new FormLayout();
	private final HorizontalLayout buttonBar = new HorizontalLayout(submit);

	private void initFormLayout() {
		formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1), new FormLayout.ResponsiveStep("25em", 2));
		Div div = new Div(formLayout);
		div.addClassName("has-padding");
		add(div);
		add(author);
		add(body);

		binder = new Binder<BlogPost>();
		binder.forField(author).bind(BlogPost::getAuthor,
				BlogPost::setAuthor);
		binder.forField(body).bind(BlogPost::getBody, BlogPost::setBody);
		binder.setBean(currentItem);
	}

	private void initButtonBar() {
		submit.setAutofocus(true);
		submit.getElement().setAttribute("theme", "primary");
		submit.addClickListener(e -> {
			currentItem.setCreationDate(new Date());
			blogPostRepository.save(currentItem);
		});
		buttonBar.setClassName("buttons");
		buttonBar.setSpacing(true);
		add(buttonBar);
	}

}
