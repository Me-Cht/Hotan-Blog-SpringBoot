package com.example.fruitdemo0306.controller;

import com.example.fruitdemo0306.bean.Article;
import com.example.fruitdemo0306.utils.ArticleRepository;
import com.example.fruitdemo0306.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/article")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @GetMapping("/findAll")
    public List<Article> getAllArticle(){
        return articleRepository.findAll();
    }

//    @PostMapping("/write")
//    public Article Write(@RequestBody Article article){
//        return articleRepository.save(article);
//    }

    // 提交博客API
    @PostMapping("/write")
    public Result Write(@RequestBody Article article){
        articleRepository.save(article);
        return Result.success(article,"数据写入成功！");
    }
    // 查询对应用户个人博客API
    @GetMapping("/myblog/{id}")
    public Result myBlog(@PathVariable BigInteger id){
        List<Article> articleByUserId = articleRepository.findArticleByUserId(id);


        return Result.success(articleByUserId,"获取成功");
    }




}
