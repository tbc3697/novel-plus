import java.util.regex.Pattern;

public class PatternTest {
    public static void main(String[] args) {
        String url = "https://www.biqudao.com/bo1ok/10/bo2ok/00/bo3ok/00/bo4ok/0001.html";
        String regex = "/bo(\\d+)ok/";
        var pattern = Pattern.compile(regex);
        var matcher = pattern.matcher(url);
        while (matcher.find()) {
            var s = matcher.group(1);
            System.out.println(s);
        }
        System.out.println("end......");
    }
}
