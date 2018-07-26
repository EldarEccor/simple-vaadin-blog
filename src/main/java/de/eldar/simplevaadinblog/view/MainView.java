package de.eldar.simplevaadinblog.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import de.eldar.simplevaadinblog.pojo.BlogPost;
import de.eldar.simplevaadinblog.repository.BlogPostRepository;

@Route
public class MainView extends VerticalLayout  {

	private static final long serialVersionUID = -7336737691960160002L;

	private BlogPostRepository blogPostRepository;

	public MainView(@Autowired BlogPostRepository blogPostRepository) {
		this.blogPostRepository = blogPostRepository;
		listAllBlogPosts();		
	}

	private void listAllBlogPosts() {
		List<BlogPost> allPosts = blogPostRepository.findAll();
		allPosts.forEach(bp -> add(new BlogPostView(bp)));		
	}
}
