package darktheme.commands;

import org.javacord.api.event.message.MessageCreateEvent;

import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimerCommand implements Command {

    @Override
    public void process(MessageCreateEvent event) {
        String countdown = event.getMessageContent().substring(7);
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        // sample valid input: 0h6m5s
        try {
            if (countdown.contains("h")) {
                hours = Integer.valueOf(countdown.substring(0, countdown.indexOf("h")));
                countdown = countdown.substring(countdown.indexOf("h") + 1);
            }
            if (countdown.contains("m")) {
                minutes = Integer.valueOf(countdown.substring(0, countdown.indexOf("m")));
                countdown = countdown.substring(countdown.indexOf("m") + 1);
            }
            if (countdown.contains("s")) {
                seconds = Integer.valueOf(countdown.substring(0,countdown.indexOf("s")));
            }

            if (hours >= 0 && minutes >= 0 && minutes <= 59 && seconds >= 0 && seconds <= 59) {
                TimerTask task = new TimerTask() {
                    public void run() {
                        event.getChannel().sendMessage("It's time!");
                    }
                };
                Timer timer = new Timer();
                timer.schedule(task, (hours * 60 * 60 + minutes * 60 + seconds) * 1000);
            } else {
                event.getChannel().sendMessage("Invalid format! Minutes and seconds should be between 0 and 59");
            }
        } catch (NumberFormatException e) {
            event.getChannel().sendMessage("Invalid format! Please follow this format: <hours>h<minutes>m<seconds>s (e.g. 1h30m15s)");
        }
    }
}
