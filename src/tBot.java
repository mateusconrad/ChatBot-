import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class tBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        //capta calculo e devolve resultado

        if (update.hasMessage() && update.getMessage().hasText()) {
            String resultado;

            String texto = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            if(verificarMensagemInicio(texto)){
                resultado = "Olá, " + update.getMessage().getFrom().getFirstName() + ". Eu sou o " + getBotUsername() + " e estou aqui para te auxiliar.";
                resultado += "\nInsira suas contas ou expressões abaixo para que eu possa calcular. Eu também posso converter unidades.";
            }
            else{
                resultado = mathjs.sendGet(texto);
            }


            SendMessage message = new SendMessage()
                    .setChatId(chat_id)
                    .setText(resultado);
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean verificarMensagemInicio(String texto){
        Pattern pattern = Pattern.compile("(?i)(start|come[çc]ar|iniciar|ol[aá]|oi|ea[ie]|da[ie])");
        Matcher matcher = pattern.matcher(texto);

        return (matcher.find());
    }


    @Override
    public String getBotUsername() {

        return "Bot Matemático";
    }

    @Override
    public String getBotToken() {

        return "368890808:AAG-jIswPVIZNHqq7tVRKYgy16kJ_o4Gx9I";
    }

}