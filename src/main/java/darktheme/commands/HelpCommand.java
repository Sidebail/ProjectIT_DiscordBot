/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package darktheme.commands;

import org.javacord.api.event.message.MessageCreateEvent;

/**
 *
 * @author seunghwankim
 */
public class HelpCommand implements Command{

    @Override
    public void process(MessageCreateEvent event) {
        event.getChannel().sendMessage("!ping: Display the word 'Pong!' ");
        event.getChannel().sendMessage("!timer with number and h,m,s : Set the timer that how much time user want");
        event.getChannel().sendMessage("!flip: Display the words between 'Head' or 'Tails'");
        event.getChannel().sendMessage("!userinfo: Display the user's information with name, ID, and Discriminator");
        event.getChannel().sendMessage("!clear + numbers: Delete the message");
        event.getChannel().sendMessage("!time: Check the local date time");
    }
}
