import service.CrawlQB;

public class ApplicationRun {
    public static void main(String[] args) {
        CrawlQB run = new CrawlQB();
        try {
            run.saveCrawlQb();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
