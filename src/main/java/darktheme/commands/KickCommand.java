package darktheme.commands;

import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;

public class KickCommand implements Command {
    /**
     * This command will kick a user from the server when someone types '!kick <User>' in a channel
     * @param event
     */
    public void process(MessageCreateEvent event) {
        //Check if user has permission to kick users
        if (event.getMessageAuthor().canKickUsersFromServer()){
            //Verify the user entered the command correctly
            if (!event.getMessage().getMentionedUsers().isEmpty()){
                User user = event.getMessage().getMentionedUsers().get(0);
                event.getServer().get().kickUser(user);
                event.getChannel().sendMessage(user.getMentionTag() + " has been kicked from the server!");
            }else{
                event.getChannel().sendMessage("`Error: Kick usage -> !kick @userToKick`");
            }
        }else{
            event.getChannel().sendMessage(event.getMessageAuthor().asUser().get().getMentionTag() +" you don't have the required permissions to use this command!");
        }
    }
}
