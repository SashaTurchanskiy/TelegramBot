package TelegramBot;

import java.util.HashMap;
import java.util.Map;

public class FeedMap {
    HashMap<String, String> newsURL = new HashMap<String, String>();
    public Map<String,String> getNewsURL() {
        getNews();
        return newsURL;
    }

    public void addNewsURL(String name,String URL) {
        newsURL.put(name, URL);
    }

    public void deleteNewsURl(String name,String URL) {
        newsURL.remove(name, URL);
    }

    private void getNews()
    {
        newsURL.put("Репортер", "http://report.if.ua/feed/");
        newsURL.put("Правда", "https://pravda.if.ua/sample-page/feed/");
        newsURL.put("Zaxid.net", "https://zaxid.net/rss/1.xml");
        newsURL.put("Галицький кореспондент", "http://gk-press.if.ua/feed/");
        newsURL.put("Radio svoboda", "https://www.radiosvoboda.org/api/zrqiteuuir");
        newsURL.put("Українські новини", "https://ukranews.com/rss-gen/Sub=2&Sub=3&Sub=4&Sub=5&Sub=6&Sub=7&Sub=8&Sub=9&Sub=10&Sub=599&Sub=610&Sub=611&Sub=612&Sub=614&Sub=615&Sub=616&Sub=617&Sub=618&Sub=619&Sub=620&Sub=621&Sub=622&Sub=623&Sub=624&Sub=625&Sub=626&Sub=627&Sub=628&Sub=629&Sub=630&Sub=631&Sub=632&Sub=633&Sub=718&Sub=719&Sub=720&Sub=721&Sub=722&Sub=723&Sub=724&Sub=725&Sub=726&Reg=40");
        newsURL.put("Кориспондент", "http://k.img.com.ua/rss/ua/all_news2.0.xml");
        newsURL.put("Тиждень", "https://tyzhden.ua/RSS/News/");
        newsURL.put("5 канал", "https://www.5.ua/novyny/rss");
    }

}
