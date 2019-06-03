package darktheme.commands;

import org.javacord.api.event.message.MessageCreateEvent;

public interface Command {
    void process(MessageCreateEvent event);
}
