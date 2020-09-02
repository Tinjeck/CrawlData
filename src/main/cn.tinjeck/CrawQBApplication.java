import service.CrawlQB;

public class CrawQBApplication {
    public void run(){
        CrawlQB run = new CrawlQB();
        try {
            run.saveCrawlQb();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
