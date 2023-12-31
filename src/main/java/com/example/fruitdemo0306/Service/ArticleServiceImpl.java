package com.example.fruitdemo0306.Service;
import com.example.fruitdemo0306.bean.Article;
import com.example.fruitdemo0306.utils.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private final ArticleRepository articleRepository;
    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    //博客内容写入
    @Override
    public Article createArticle(Article article, Integer authId) {
        String authName = articleRepository.findUserNameById(authId);
        article.setCreate_time(new Date());
        article.setAuth_name(authName);
        System.out.println(authName);
        articleRepository.save(article);
        return article;
    }
}
