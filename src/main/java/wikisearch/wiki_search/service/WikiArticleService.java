package wikisearch.wiki_search.service;

import org.springframework.stereotype.Service;
import wikisearch.wiki_search.entity.WikiArticle;
import wikisearch.wiki_search.repository.WikiArticleRepository;
import java.util.List;

@Service
public class WikiArticleService {
    private final WikiArticleRepository articleRepo;

    public WikiArticleService(WikiArticleRepository articleRepo) {
        this.articleRepo = articleRepo;
    }

    public List<WikiArticle> getAllArticles() {
        return articleRepo.findAll();
    }

    public WikiArticle getArticleById(Long id) {
        return articleRepo.findById(id).orElse(null);
    }

    public WikiArticle saveArticle(WikiArticle article) {
        return articleRepo.save(article);
    }

    public void deleteArticle(Long id) {
        articleRepo.deleteById(id);
    }
}
