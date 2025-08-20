package com.example.scraper;

import com.example.db.Database;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuoteScraper {
    private static final Logger logger = LoggerFactory.getLogger(QuoteScraper.class);
    private final String url;

    public QuoteScraper(String url) {
        this.url = url;
    }

    public void scrape() {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements quotes = doc.select(".quote");

            try (Connection conn = Database.getConnection()) {
                String sql = "INSERT INTO quotes(quote, author) VALUES(?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);

                for (Element quote : quotes) {
                    String text = quote.select(".text").text();
                    String author = quote.select(".author").text();

                    pstmt.setString(1, text);
                    pstmt.setString(2, author);
                    pstmt.executeUpdate();

                    logger.info("Saved quote: {} — {}", text, author);
                }
            }
        } catch (Exception e) {
            logger.error("Error during scraping", e);
        }
    }
}
