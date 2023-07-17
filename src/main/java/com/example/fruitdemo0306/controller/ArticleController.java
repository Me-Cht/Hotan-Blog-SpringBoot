package com.example.fruitdemo0306.controller;
import com.example.fruitdemo0306.Service.ArticleService;
import com.example.fruitdemo0306.bean.Article;
import com.example.fruitdemo0306.utils.ArticleRepository;
import com.example.fruitdemo0306.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/article")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleService articleService;

    @GetMapping("/findAll")
    public List<Article> getAllArticle(){
        List<Article> all = articleRepository.findAll();
        System.out.println(all);

        return articleRepository.findAll();
    }
//    @GetMapping("/findArticleById")
//    public Result findArticleById(@PathVariable BigInteger id) {
//        List<Article> articleByUserId = articleRepository.findArticleByUserId(id);
//        return Result.success(articleByUserId,"获取成功！");
//
//    }

    // 提交博客API
    @PostMapping("/write")
        public Result Write(@RequestBody Article article) {
        Integer authorIdInteger = article.getAuthor_id();
        System.out.println(authorIdInteger);
        Article newArticle = articleService.createArticle(article, authorIdInteger);
        return Result.success(newArticle,"数据写入成功！");
    }

    // 查询对应用户个人博客API
    @GetMapping("/myblog/{id}")
    public Result myBlog(@PathVariable String id) {

        List<Article> articleByUserId = articleRepository.findArticleByUserId(Integer.valueOf(id));
        System.out.println(articleByUserId);
        return Result.success(articleByUserId, "获取成功");
    }

}
