package service.parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ParserHtml {

    public String[] parseHtmlInContent(String html) {
        Document document = Jsoup.parse(html);
        String titleText = document.title();
        String bodyText = document.body().text();
        String fullText = titleText + bodyText;
        return fullText.split("[\\s\\]\\[,.!)?(\";:\\n\\r\\t]");
    }
}
