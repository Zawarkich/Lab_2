package wikisearch.wiki_search.controller;

import org.springframework.web.bind.annotation.*;
import wikisearch.wiki_search.entity.WikiArticle;
import wikisearch.wiki_search.repository.WikiArticleRepository;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class WikiArticleCrudController {
    private final WikiArticleRepository articleRepo;

    public WikiArticleCrudController(WikiArticleRepository articleRepo) {
        this.articleRepo = articleRepo;
    }

    @GetMapping
    public List<WikiArticle> getAll() {
        return articleRepo.findAll();
    }

    @GetMapping("/{id}")
    public WikiArticle getById(@PathVariable Long id) {
        return articleRepo.findById(id).orElse(null);
    }

    @PostMapping
    public WikiArticle create(@RequestBody WikiArticle article) {
        return articleRepo.save(article);
    }

    @PutMapping("/{id}")
    public WikiArticle update(@PathVariable Long id, @RequestBody WikiArticle article) {
        article.setId(id);
        return articleRepo.save(article);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        articleRepo.deleteById(id);
    }
}
