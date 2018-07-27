package de.eldar.simplevaadinblog.layout;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.InitialPageSettings;
import com.vaadin.flow.server.PageConfigurator;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import de.eldar.simplevaadinblog.route.CreateBlogPostView;
import de.eldar.simplevaadinblog.route.ListBlogPostView;

@Theme(Lumo.class)
@HtmlImport("styles/shared-styles.html") // the application specific styles
public class MainLayout extends Div implements RouterLayout,
        AfterNavigationObserver, PageConfigurator {

	private static final long serialVersionUID = -8010913032698387595L;

	public MainLayout() {
        H2 title = new H2("The simple blog.");
        title.addClassName("main-layout_title");

        RouterLink postList = new RouterLink(null, ListBlogPostView.class);        
        postList.add(new Icon(VaadinIcon.LIST), new Text("View posts"));
        postList.addClassName("main-layout_nav-item");
        // Only show as active for the exact URL, but not for sub paths
        postList.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink createPost = new RouterLink(null, CreateBlogPostView.class);
        createPost.add(new Icon(VaadinIcon.ADD_DOCK), new Text("Create post"));
        createPost.addClassName("main-layout_nav-item");
        // Only show as active for the exact URL, but not for sub paths
        createPost.setHighlightCondition(HighlightConditions.sameLocation());
        
        Div navigation = new Div(postList,createPost);
        navigation.addClassName("main-layout_nav");

        Div header = new Div(title, navigation);
        header.addClassName("main-layout_header");
        add(header);

        addClassName("main-layout");
    }

	
	@Override
	public void afterNavigation(AfterNavigationEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configurePage(InitialPageSettings settings) {
		// TODO Auto-generated method stub
		
	}

}