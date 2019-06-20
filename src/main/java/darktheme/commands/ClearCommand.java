package darktheme.commands;

import org.javacord.api.event.message.MessageCreateEvent;

import java.util.concurrent.ExecutionException;

public class ClearCommand implements Command{

    @Override
    public void process(MessageCreateEvent event) {
        if(event.getMessageAuthor().isBotOwner()){
            String command = event.getMessageContent().substring(5);
            if(command.equals("r")) {
                try {
                    event.getChannel().getMessagesBefore(100, event.getMessage()).get().deleteAll();
                    event.getChannel().sendMessage("Maximum 100 of message was deleted");
                } catch (ExecutionException | InterruptedException ex) {
                    event.getChannel().sendMessage("Something wrong..");
                }
            }
            else {
                String numOfMessage = event.getMessageContent().substring(7);
                int count = Integer.valueOf(numOfMessage);
                try {
                    event.getChannel().getMessagesBefore(count, event.getMessage()).get().deleteAll();
                    event.getChannel().sendMessage("Message was deleted");
                } catch (ExecutionException | InterruptedException ex) {
                    event.getChannel().sendMessage("Something wrong..");
                }
            }
        } else {
            event.getChannel().sendMessage("You don't have sufficient permissions to use this command.");
        }
    }
}
