package wikisearch.wiki_search.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wikisearch.wiki_search.entity.*;
import wikisearch.wiki_search.repository.*;
import java.util.List;

@Service
public class WikiService {
    private final SearchHistoryRepository historyRepo;
    private final WikiArticleRepository articleRepo;
    
    public WikiService(SearchHistoryRepository historyRepo, 
                     WikiArticleRepository articleRepo) {
        this.historyRepo = historyRepo;
        this.articleRepo = articleRepo;
    }
    
    public WikiArticle search(String term) {
        WikiArticle article = new WikiArticle(term, "Content about " + term);
        articleRepo.save(article);
        return article;
    }
    
    @Transactional
    public SearchHistory saveHistoryWithArticles(SearchHistory history) {
        history.getArticles().forEach(article -> article.setHistory(history));
        return historyRepo.save(history);
    }
    
    public List<SearchHistory> getAllHistories() {
        return historyRepo.findAll();
    }
}