package darktheme.listeners;

import darktheme.commands.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.util.HashMap;

public class CommandHandler implements MessageCreateListener {
    private HashMap<String, Command> commands = new HashMap<>();
    private Logger logger = LogManager.getLogger();

    public CommandHandler() {
        commands.put("ping", new PingPongCommand());
        commands.put("timer", new CountdownTimerCommand());
        commands.put("flip", new FlipCoinCommand());
        commands.put("userinfo", new UserInfoCommand());
        commands.put("clear", new ClearCommand());
        commands.put("time", new TimeCommand());
        commands.put("ban", new BanCommand());
        commands.put("kick", new KickCommand());
    }

    @Override
    public void onMessageCreate(MessageCreateEvent event) {

        // make sure prefix starts message command
        String prefix = "!";
        if (event.getMessageContent().startsWith(prefix)) {
            // remove prefix from string and anything after
            String command = event.getMessageContent().substring(1).split(" ")[0].toLowerCase();
            // check if original command name
            if (commands.containsKey(command)){
                commands.get(command).process(event);
            }

            logger.info(event.getMessageAuthor().getDiscriminatedName() + " invoked: " + command);
        }
    }
}
