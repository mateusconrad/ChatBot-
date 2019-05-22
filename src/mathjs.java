import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class mathjs {


    @SuppressWarnings("deprecation")
    public static String sendGet(String expressao) {
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL("http://api.mathjs.org/v1/?expr=" + URLEncoder.encode(expressao));
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            return result.toString();
        } catch (Exception a) {
            return "Não entendi o que quis dizer, isso não me parece uma conta matemática.";
        }
    }
}