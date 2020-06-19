import config.MainConfig;
import service.*;
import service.parse.ParserHtml;

import java.io.IOException;
import java.util.Map;


public class Main {

    public static void main(String[] args) throws IOException {
        String url = "https://www.simbirsoft.com/";
        ServiceHandler serviceHandler = MainConfig.getServiceHandler(url);
        String responseFromTheSite = serviceHandler.getResponseFromTheSite();
        FileHandler handler = MainConfig.getFileHandler(responseFromTheSite);
        handler.writeFile();
        String htmlTextReadFile = handler.readFile();
        ParserHtml parserHtml = MainConfig.getParserHtml();
        String[] parseText = parserHtml.parseHtmlInContent(htmlTextReadFile);
        CounterWord counterWord = MainConfig.getCounterWord();
        Map<String, Integer> count = counterWord.count(parseText);
        count.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
