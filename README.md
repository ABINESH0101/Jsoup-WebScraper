# QuoteScraper Java

QuoteScraper Java is a Java-based web scraping application that extracts quotes, authors, and tags from websites and stores them in a SQLite database. Built with Jsoup and SQLite JDBC, this project demonstrates practical skills in web data extraction, database management, and modular Java development.

## Features
- Extracts quote text, author, and tags from websites
- Stores data in a SQLite database for easy access and analysis
- Modular and extensible code, allowing scraping of other structured web content
- Ideal for learning Java, web scraping, and database integration

## Prerequisites
- Java 17 or higher
- Maven for dependency management
- SQLite for viewing the database (optional)

## Installation
1. Clone the repository
   git clone https://github.com/yourusername/QuoteScraper-Java.git
2. Open the project in IntelliJ IDEA or your preferred IDE
3. Build the project with Maven
   mvn clean install

## Usage
1. Run the Scraper class
   java -cp target/webscraper-1.0-SNAPSHOT.jar com.example.webscraper.Scraper
2. The program will scrape quotes from the target website and save them in scraped.db

## Extending the Project
- Change the URL and HTML selectors in Scraper.java to scrape other websites
- Can be adapted to collect blogs, portfolios, or any structured web data with minimal changes

## Dependencies
- Jsoup for HTML parsing
- SQLite JDBC for database connectivity
- SLF4J for logging

## License
This project is licensed under the MIT License
