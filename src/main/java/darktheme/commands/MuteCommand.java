package darktheme.commands;

import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;

public class MuteCommand implements Command{
    /**
     * This command will mute a user in the server when someone types '!mute <User>' in a channel
     * @param event
     */
    public void process(MessageCreateEvent event) {
        //Check if user has permission to mute users
        if (event.getMessageAuthor().canManageRolesOnServer() && event.getMessageAuthor().canMuteMembersOnServer()){
            //Verify the user entered the command correctly
            if (!event.getMessage().getMentionedUsers().isEmpty()){
                User user = event.getMessage().getMentionedUsers().get(0);
                Role muteRole = event.getApi().getRoleById("606504491013111839").get();
                if(!user.isMuted(event.getServer().get()) && !user.getRoles(event.getServer().get()).contains(muteRole)){
                    event.getServer().get().addRoleToUser(user, muteRole);
                    event.getServer().get().muteUser(user);
                    event.getChannel().sendMessage(user.getMentionTag() + " has been muted!");
                }else{
                    event.getChannel().sendMessage(user.getMentionTag() + " is already muted!");
                }
            }else{
                event.getChannel().sendMessage("`Error: Mute usage -> !mute @userToMute`");
            }
        }else{
            event.getChannel().sendMessage(event.getMessageAuthor().asUser().get().getMentionTag() +" you don't have the required permissions to use this command!");
        }

    }
}
