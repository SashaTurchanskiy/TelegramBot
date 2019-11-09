package mvc.dao.entity;

import java.util.Objects;

public class User {
    private long id;
    private long chatID;
    private String firstname;
    private String category;
    private String feedURL;
    private long interval;
    private long numberofNews;

    public User(long id, long chatID, String firstname, String category, String feedURL, long interval, long numberofNews) {
        this.id = id;
        this.chatID = chatID;
        this.firstname = firstname;
        this.category = category;
        this.feedURL = feedURL;
        this.interval = interval;
        this.numberofNews = numberofNews;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getChatID() {
        return chatID;
    }

    public void setChatID(long chatID) {
        this.chatID = chatID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFeedURL() {
        return feedURL;
    }

    public void setFeedURL(String feedURL) {
        this.feedURL = feedURL;
    }

    public long getInterval() {
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }

    public long getNumberofNews() {
        return numberofNews;
    }

    public void setNumberofNews(long numberofNews) {
        this.numberofNews = numberofNews;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", chatID=" + chatID +
                ", firstname='" + firstname + '\'' +
                ", category='" + category + '\'' +
                ", feedURL='" + feedURL + '\'' +
                ", interval=" + interval +
                ", numberofNews=" + numberofNews +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                chatID == user.chatID &&
                interval == user.interval &&
                numberofNews == user.numberofNews &&
                Objects.equals(firstname, user.firstname) &&
                Objects.equals(category, user.category) &&
                Objects.equals(feedURL, user.feedURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chatID, firstname, category, feedURL, interval, numberofNews);
    }
}




