package com.example.fruitdemo0306.Service;

import com.example.fruitdemo0306.bean.Article;
import com.example.fruitdemo0306.utils.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

public interface ArticleService {

    //博客内容写入
    Article createArticle(Article article,Integer authId);
}
