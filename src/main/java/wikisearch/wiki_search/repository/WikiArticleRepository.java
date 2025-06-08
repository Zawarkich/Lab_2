package wikisearch.wiki_search.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wikisearch.wiki_search.entity.WikiArticle;

public interface WikiArticleRepository extends JpaRepository<WikiArticle, Long> {
}