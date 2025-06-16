package wikisearch.wiki_search.controller;

import org.springframework.web.bind.annotation.*;
import wikisearch.wiki_search.entity.SearchHistory;
import wikisearch.wiki_search.service.SearchHistoryService;
import java.util.List;

@RestController
@RequestMapping("/api/histories")
public class SearchHistoryCrudController {
    private final SearchHistoryService historyService;

    public SearchHistoryCrudController(SearchHistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    public List<SearchHistory> getAll() {
        return historyService.getAllHistories();
    }

    @GetMapping("/{id}")
    public SearchHistory getById(@PathVariable Long id) {
        return historyService.getHistoryById(id);
    }

    @PostMapping
    public SearchHistory create(@RequestBody SearchHistory history) {
        return historyService.saveHistoryWithArticles(history);
    }

    @PutMapping("/{id}")
    public SearchHistory update(@PathVariable Long id, @RequestBody SearchHistory history) {
        history.setId(id);
        return historyService.saveHistoryWithArticles(history);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        historyService.deleteHistory(id);
    }
}
