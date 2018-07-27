package de.eldar.simplevaadinblog.route;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import de.eldar.simplevaadinblog.layout.BlogPostLayout;
import de.eldar.simplevaadinblog.layout.MainLayout;
import de.eldar.simplevaadinblog.pojo.BlogPost;
import de.eldar.simplevaadinblog.repository.BlogPostRepository;

@Route(value = "", layout = MainLayout.class)
public class ListBlogPostView extends VerticalLayout {

	private static final long serialVersionUID = -7336737691960160002L;

	private BlogPostRepository blogPostRepository;

	public ListBlogPostView(@Autowired BlogPostRepository blogPostRepository) {
		this.blogPostRepository = blogPostRepository;
		listAllBlogPosts();
		setClassName("view-container");
		setAlignItems(Alignment.STRETCH);
	}

	private void listAllBlogPosts() {
		List<BlogPost> allPosts = blogPostRepository.findAll();
		allPosts.forEach(bp -> add(new BlogPostLayout(bp)));
	}
}
