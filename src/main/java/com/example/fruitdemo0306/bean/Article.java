package com.example.fruitdemo0306.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Data
@Table(name = "article")
//@AllArgsConstructor
//@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String title;
    private String content;
    private Integer author_id;
    private Date create_time;
    private String auth_name;


    public Article(BigInteger id, String title, String content, Integer author_id, Date create_time,String auth_name) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author_id = author_id;
        this.create_time = create_time;
        this.auth_name = auth_name;
    }
    public Article(BigInteger id, String title, String content, Integer author_id, Date create_time) {
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

    public BigInteger getId(BigInteger id) {
        return this.id;
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

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
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
