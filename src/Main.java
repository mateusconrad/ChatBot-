import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
public class Main {
    public static void main(String[] args) {

        // Inicializa API

        ApiContextInitializer.init();

        // Inicializa API do Bot

        TelegramBotsApi calcbot = new TelegramBotsApi();

        // Registra o bot

        try {
            calcbot.registerBot(new tBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}


