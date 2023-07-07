package com.example.fruitdemo0306.utils;

import com.example.fruitdemo0306.bean.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
@Repository
public interface ArticleRepository extends JpaRepository<Article,BigInteger> {
    List<Article> findAll();

    @Query("SELECT NEW Article (id, title, content, author_id, create_time) " +
            "FROM Article " +
            "WHERE author_id = :userId")
    List<Article> findArticleByUserId(@Param("userId") BigInteger user);

    // 自定义的保存文章方法
    default void saveArticle(Article article) {
        save(article);
    }
    @Query("SELECT u.name FROM User u WHERE u.id = :userId")
    String findUserNameById(@Param("userId") Integer userId);
}


