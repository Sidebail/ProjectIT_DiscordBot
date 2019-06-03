package darktheme.commands;

import org.javacord.api.event.message.MessageCreateEvent;

import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimerCommand implements Command {

    @Override
    public void process(MessageCreateEvent event) {
        String countdown=event.getMessageContent().substring(4);

        try {
            // sample valid input: 1:30 for 90 sec
            int minutes = Integer.valueOf(countdown.substring(0, countdown.indexOf(":")));
            int seconds =Integer.valueOf(countdown.substring(countdown.indexOf(":")+1));
            if (minutes>=0 && minutes<=59 && seconds>=0 && seconds<=59) {
                TimerTask task = new TimerTask() {
                    public void run() {
                        event.getChannel().sendMessage("It's time!");
                    }
                };

                Timer timer = new Timer();
                timer.schedule(task, minutes * 60000 + seconds * 1000);
            }else{
                event.getChannel().sendMessage("Invalid format! Please follow this format. 1:30 for 90 seconds.");
            }
        }catch (NumberFormatException e){
            event.getChannel().sendMessage("Invalid format! Please follow this format. 1:30 for 90 seconds.");
        }

    }
}
