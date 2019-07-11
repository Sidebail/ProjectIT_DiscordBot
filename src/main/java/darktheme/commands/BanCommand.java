package darktheme.commands;

import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;

public class BanCommand implements Command {
    /**
     * This command will ban a user from the server when someone types '!ban <User>' in a channel
     * @param event
     */
    public void process(MessageCreateEvent event) {
        //Check if user has permission to ban users
        if (event.getMessageAuthor().canBanUsersFromServer()){
            //Verify the user entered the command correctly
            if (!event.getMessage().getMentionedUsers().isEmpty()){
                User user = event.getMessage().getMentionedUsers().get(0);
                event.getServer().get().banUser(user);
                event.getChannel().sendMessage(user.getMentionTag() + " has been banned from the server!");
            }else{
                event.getChannel().sendMessage("`Error: Ban usage -> !ban @userToBan`");
            }
        }else{
            event.getChannel().sendMessage(event.getMessageAuthor().asUser().get().getMentionTag() +" you don't have the required permissions to use this command!");
        }

    }
}
