create table BLOG_POST(
	id BIGINT auto_increment PRIMARY KEY,
	author VARCHAR(128) not null,
	body VARCHAR(128) not null,
	creation_date TIMESTAMP not null
);