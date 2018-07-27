package de.eldar.simplevaadinblog.view;

import java.util.List;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import de.eldar.simplevaadinblog.pojo.BlogPost;

public class ListBlogPostsView extends VerticalLayout {

	private static final long serialVersionUID = 4845944002036741666L;

	public ListBlogPostsView(List<BlogPost> posts) {
		setClassName("view-container");
		setAlignItems(Alignment.STRETCH);

		posts.forEach(bp -> add(new BlogPostView(bp)));
	}

}
