package com.example.fruitdemo0306.bean;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String title;
    private String content;
    private BigInteger author_id;
    private Date create_time;
    private String auth_name;


    public Article(BigInteger id, String title, String content, BigInteger author_id, Date create_time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author_id = author_id;
        this.create_time = create_time;
    }

    public Article() {

    }

    public String getAuth_name() {
        return auth_name;
    }

    public void setAuth_name(String auth_name) {
        this.auth_name = auth_name;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BigInteger getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(BigInteger author_id) {
        this.author_id = author_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }


}
