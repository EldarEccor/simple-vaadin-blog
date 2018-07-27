package de.eldar.simplevaadinblog.route;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

import de.eldar.simplevaadinblog.pojo.BlogPost;
import de.eldar.simplevaadinblog.repository.BlogPostRepository;
import de.eldar.simplevaadinblog.view.ListBlogPostsView;
import de.eldar.simplevaadinblog.view.MainLayout;

@Route(value = "", layout = MainLayout.class)
public class ListBlogPostRoute extends Div {

	private static final long serialVersionUID = -7336737691960160002L;

	private ListBlogPostsView view;
	
	public ListBlogPostRoute(@Autowired BlogPostRepository blogPostRepository) {
		List<BlogPost> allPosts = blogPostRepository.findAll();
		view = new ListBlogPostsView(allPosts);
		add(view);
	}
}
