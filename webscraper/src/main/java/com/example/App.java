package com.example;

import com.example.db.Database;
import com.example.scraper.QuoteScraper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Starting web scraper...");

        // Step 1: Setup DB
        Database.init();

        // Step 2: Scrape quotes.toscrape.com
        QuoteScraper scraper = new QuoteScraper("https://quotes.toscrape.com/");
        scraper.scrape();

        logger.info("Scraping finished. Data saved in scraped.db");
    }
}
