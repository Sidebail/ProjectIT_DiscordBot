/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package darktheme.commands;

import java.time.LocalDateTime;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.embed.EmbedBuilder;

/**
 *
 * @author seunghwankim
 */
public class TimeCommand implements Command{

    @Override
    public void process(MessageCreateEvent event) {
        MessageAuthor author = event.getMessageAuthor();
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Barrie")
                .addField("Time", String.valueOf(LocalDateTime.now()), true)
                .setAuthor(author);
        
        event.getChannel().sendMessage(embed);
    }
    
}
