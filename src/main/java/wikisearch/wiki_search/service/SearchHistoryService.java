package wikisearch.wiki_search.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wikisearch.wiki_search.entity.SearchHistory;
import wikisearch.wiki_search.repository.SearchHistoryRepository;
import java.util.List;

@Service
public class SearchHistoryService {
    private final SearchHistoryRepository historyRepo;

    public SearchHistoryService(SearchHistoryRepository historyRepo) {
        this.historyRepo = historyRepo;
    }

    public List<SearchHistory> getAllHistories() {
        return historyRepo.findAll();
    }

    public SearchHistory getHistoryById(Long id) {
        return historyRepo.findById(id).orElse(null);
    }

    @Transactional
    public SearchHistory saveHistoryWithArticles(SearchHistory history) {
        history.getArticles().forEach(article -> article.setHistory(history));
        return historyRepo.save(history);
    }

    public void deleteHistory(Long id) {
        historyRepo.deleteById(id);
    }
}
