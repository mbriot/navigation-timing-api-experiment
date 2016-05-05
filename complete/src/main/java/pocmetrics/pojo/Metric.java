package pocmetrics.pojo;

/**
 * Created by manu on 01/05/2016.
 */
public class Metric {

    private String pathname;
    private int dnsLookup;
    private int handshake;
    private int ttfb;
    private int downloadPage;
    private int renderingProcess;

    public String getPathname() {
        return pathname;
    }

    public int getDnsLookup() {
        return dnsLookup;
    }

    public int getHandshake() {
        return handshake;
    }

    public int getTtfb() {
        return ttfb;
    }

    public int getDownloadPage() {
        return downloadPage;
    }

    public int getRenderingProcess() {
        return renderingProcess;
    }
}
