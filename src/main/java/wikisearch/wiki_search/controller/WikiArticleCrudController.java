package wikisearch.wiki_search.controller;

import org.springframework.web.bind.annotation.*;
import wikisearch.wiki_search.entity.WikiArticle;
import wikisearch.wiki_search.service.WikiArticleService;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class WikiArticleCrudController {
    private final WikiArticleService articleService;

    public WikiArticleCrudController(WikiArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<WikiArticle> getAll() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public WikiArticle getById(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    @PostMapping
    public WikiArticle create(@RequestBody WikiArticle article) {
        return articleService.saveArticle(article);
    }

    @PutMapping("/{id}")
    public WikiArticle update(@PathVariable Long id, @RequestBody WikiArticle article) {
        article.setId(id);
        return articleService.saveArticle(article);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }
}
