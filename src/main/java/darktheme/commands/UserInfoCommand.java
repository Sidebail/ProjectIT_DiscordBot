package darktheme.commands;

import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

public class UserInfo implements Command {
    @Override
    public void process(MessageCreateEvent event) {
        MessageAuthor author = event.getMessageAuthor();
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("User Information")
                .addField("Name", author.getDisplayName(), true)
                .addField("Discriminator", author.getDiscriminatedName(), true)
                .addField("User ID", author.getIdAsString(), true)
                .setAuthor(author);

        event.getChannel().sendMessage(embed);
    }
}
