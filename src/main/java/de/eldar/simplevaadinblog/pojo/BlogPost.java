package de.eldar.simplevaadinblog.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="BLOG_POST")
@Data
@NoArgsConstructor
public class BlogPost implements Serializable{
	
	private static final long serialVersionUID = 5868211068486984843L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "author", nullable = false)
	private String author;
	
	@Column(name = "body", nullable = false)
	private String body;
	
	@Column(name = "creation_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
}
