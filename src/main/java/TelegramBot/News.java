package TelegramBot;

import com.rometools.rome.feed.synd.SyndEntry;
import rssChannel.FeedReader;

import java.util.Iterator;
import java.util.LinkedList;

public class News {
    public static LinkedList<String> getNews(String URL){
        FeedReader feedReader = new FeedReader();
        LinkedList<SyndEntry> newsblock = new LinkedList<>();
        newsblock.addAll(feedReader.getNewsBlock(URL));
        LinkedList<String> news = new LinkedList<>();

        Iterator<SyndEntry> iterator = newsblock.iterator();
        while(iterator.hasNext()) {
            SyndEntry syndEntry = iterator.next();
            news.offer(syndEntry.getTitle() + "\n" + syndEntry.getLink());
        }
        return news;
    }
}
