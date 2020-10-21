import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class Utils {

    static Logger log = Logger.getLogger(Utils.class.getName());

    public int getIntInStr(String str) {
        int res = 0;
        List<String> list = new LinkedList<>();
        for (String c : str.split(" ")) {
            if (c.matches("\\d+")) list.add(c);
        }
        StringBuilder strInt = new StringBuilder();
        for (String s : list) {
            strInt.append(s);
        }

        res = Integer.parseInt(String.valueOf(strInt));
        return res;
    }

    public String formatUrl(String url) {
        URL urlFormat = null;
        try {
            urlFormat = new URL(url);
        } catch (MalformedURLException e) {
            log.warning("Format URL" + e);
            e.printStackTrace();
        }
        return urlFormat.getHost();
    }

    public String dateFormat(String date) {
        String dateF = date.split(" ")[2];
        dateF = dateF.split("T")[0];
        return dateF;
    }
    //production / 2020-05-24T15:25:02+00:00
}
