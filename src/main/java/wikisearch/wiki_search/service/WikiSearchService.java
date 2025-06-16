package wikisearch.wiki_search.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import wikisearch.wiki_search.entity.WikiArticle;

@Service
public class WikiSearchService {
    private final RestTemplate restTemplate = new RestTemplate();

    public WikiArticle search(String term) {
        String url = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=extracts&exintro=true&explaintext=true&titles=" + term;
        String response = restTemplate.getForObject(url, String.class);
        String extract;
        System.out.println("started wiki req");
        if (response != null && response.contains("extract")) {
            extract = response.split("\"extract\":\"")[1].split("\"")[0];
        } else {
            extract = "No results found";
        }
        WikiArticle article = new WikiArticle(term, extract);
        System.out.println("cpmpleted wiki req");
        System.out.println(article);
        return article;
    }
}
