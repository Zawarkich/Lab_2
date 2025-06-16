package wikisearch.wiki_search.controller;

import org.springframework.web.bind.annotation.*;
import wikisearch.wiki_search.entity.WikiArticle;
import wikisearch.wiki_search.service.WikiService;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class WikiArticleCrudController {
    private final WikiService wikiService;

    public WikiArticleCrudController(WikiService wikiService) {
        this.wikiService = wikiService;
    }

    @GetMapping
    public List<WikiArticle> getAll() {
        return wikiService.getAllArticles();
    }

    @GetMapping("/{id}")
    public WikiArticle getById(@PathVariable Long id) {
        return wikiService.getArticleById(id);
    }

    @PostMapping
    public WikiArticle create(@RequestBody WikiArticle article) {
        return wikiService.saveArticle(article);
    }

    @PutMapping("/{id}")
    public WikiArticle update(@PathVariable Long id, @RequestBody WikiArticle article) {
        article.setId(id);
        return wikiService.saveArticle(article);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        wikiService.deleteArticle(id);
    }
}
