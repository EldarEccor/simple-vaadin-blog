package de.eldar.simplevaadinblog.route;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

import de.eldar.simplevaadinblog.pojo.BlogPost;
import de.eldar.simplevaadinblog.repository.BlogPostRepository;
import de.eldar.simplevaadinblog.view.CreateBlogPostView;
import de.eldar.simplevaadinblog.view.MainLayout;

@Route(value = "create", layout = MainLayout.class)
public class CreateBlogPostRoute extends Div {

	private static final long serialVersionUID = 345147266116144856L;

	private CreateBlogPostView view;
	
	private BlogPost currentModel;
	
	public CreateBlogPostRoute(@Autowired BlogPostRepository blogPostRepository) {
		currentModel =  new BlogPost();
		view = new CreateBlogPostView(currentModel);
		add(view);
		view.getSubmit().addClickListener(e -> {
			currentModel.setCreationDate(new Date());
			blogPostRepository.save(currentModel);
			currentModel = new BlogPost();
			view.setBean(currentModel);
		});
	}

}
