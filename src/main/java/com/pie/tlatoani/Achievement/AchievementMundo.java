package com.pie.tlatoani.Achievement;

import ch.njol.skript.lang.ExpressionType;
import com.pie.tlatoani.Core.Registration.Registration;
import org.bukkit.Achievement;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;

/**
 * Created by Tlatoani on 8/8/17.
 */
public class AchievementMundo {

    public static void load() {
        Registration.registerEnum(Achievement.class, "achievement", Achievement.values())
                .document("Achievement", "1.4.10", "An achievement that a player can get. "
                        + "Note that achievements were removed in Minecraft 1.12 and thus this syntax will not work if you are running Bukkit/Spigot 1.12 and above.");
        Registration.registerEvent("Achievement Award", EvtAchAward.class, PlayerAchievementAwardedEvent.class, "achieve[ment] [%-achievement%] award", "award of achieve[ment] [%-achievement%]")
                .document("Achievement Award", "1.4.10", "Called when a player is awarded either the specified achievement or any achievement. "
                        + "Note that achievements were removed in Minecraft 1.12 and thus this syntax will not work if you are running Bukkit/Spigot 1.12 and above.")
                .eventValue(Achievement.class, "1.4.10", "The achievement that was awarded.");
        Registration.registerEventValue(PlayerAchievementAwardedEvent.class, Achievement.class, PlayerAchievementAwardedEvent::getAchievement);
        Registration.registerExpression(ExprParentAch.class,Achievement.class, ExpressionType.PROPERTY,"parent of achieve[ment] %achievement%")
                .document("Parent of Achievement", "1.4.10", "An expression for the parent achievement of the specified achievement. "
                        + "Note that achievements were removed in Minecraft 1.12 and thus this syntax will not work if you are running Bukkit/Spigot 1.12 and above.");
        Registration.registerExpressionCondition(CondHasAch.class,ExpressionType.PROPERTY,"%player% has achieve[ment] %achievement%")
                .document("Player has Achievement", "1.4.10", "Checks whether the specified player has the specified achievement.");
    }

}