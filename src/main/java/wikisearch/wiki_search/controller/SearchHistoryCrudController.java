package wikisearch.wiki_search.controller;

import org.springframework.web.bind.annotation.*;
import wikisearch.wiki_search.entity.SearchHistory;
import wikisearch.wiki_search.service.WikiService;
import java.util.List;

@RestController
@RequestMapping("/api/histories")
public class SearchHistoryCrudController {
    private final WikiService wikiService;

    public SearchHistoryCrudController(WikiService wikiService) {
        this.wikiService = wikiService;
    }

    @GetMapping
    public List<SearchHistory> getAll() {
        return wikiService.getAllHistories();
    }

    @GetMapping("/{id}")
    public SearchHistory getById(@PathVariable Long id) {
        return wikiService.getHistoryById(id);
    }

    @PostMapping
    public SearchHistory create(@RequestBody SearchHistory history) {
        return wikiService.saveHistoryWithArticles(history);
    }

    @PutMapping("/{id}")
    public SearchHistory update(@PathVariable Long id, @RequestBody SearchHistory history) {
        history.setId(id);
        return wikiService.saveHistoryWithArticles(history);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        wikiService.deleteHistory(id);
    }
}
