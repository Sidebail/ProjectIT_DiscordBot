package darktheme.commands;

import org.javacord.api.event.message.MessageCreateEvent;

import java.util.Random;

public class FlipCoinCommand implements Command{

    @Override
    public void process(MessageCreateEvent event) {
        Random random = new Random();

        int randomCoin = random.nextInt(2) + 1;

        if(randomCoin == 1)
            event.getChannel().sendMessage("Tails");
        else
            event.getChannel().sendMessage("Head");

    }
}
