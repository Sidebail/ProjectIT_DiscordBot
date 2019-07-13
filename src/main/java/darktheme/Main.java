package darktheme;


import darktheme.listeners.CommandHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;

public class Main {

    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        //Enable debugging, if no slf4j logger was found
        FallbackLoggerConfiguration.setDebug(true);

        //Store the token (the first argument of the program)
        String token = System.getenv("DISCORD_API_KEY");

        //Login to Discord
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        //Add listeners for commands
        api.addMessageCreateListener(new CommandHandler());

        //Log the bot invite url
        logger.info("You can invite me by using the following url: " + api.createBotInvite());

        //Log a message when the bot leaves a server
        api.addServerLeaveListener(event -> logger.info("Left server " + event.getServer().getName()));
    }
}

