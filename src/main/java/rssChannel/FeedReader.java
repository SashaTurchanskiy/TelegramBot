package rssChannel;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import javax.sql.RowSetInternal;
import javax.sql.rowset.WebRowSet;


import java.io.File;
import java.io.Reader;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

public class FeedReader {


    public static ArrayList<SyndEntry> getNewsBlock(String URL) {
        boolean ok = false;
        ArrayList<SyndEntry> newBlock = new ArrayList<>();
        try {
            URL feedURl = new URL(URL);

            SyndFeedInput input = new SyndFeedInput();
            XmlReader xmlReader = new XmlReader(feedURl);
            SyndFeed feed = input.build(xmlReader);
            newBlock = (ArrayList<SyndEntry>) feed.getEntries();
            ok = true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ERROR: "+ex.getMessage());
            return null;
        }

        if (!ok) {
            System.out.println();
            System.out.println("FeedReader reads and prints any RSS/Atom feed type.");
            System.out.println("The first parameter must be the URL of the feed to read.");
            System.out.println();
        }
        return newBlock;
    }
}


