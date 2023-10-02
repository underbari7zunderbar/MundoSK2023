package com.pie.tlatoani.Achievement;

import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

import org.bukkit.event.Event;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

public class CondHasAch extends SimpleExpression<Boolean>{
	private Expression<Player> player;
	private Expression<Advancement> ach;

	@Override
	public Class<? extends Boolean> getReturnType() {
		// TODO Auto-generated method stub
		return Boolean.class;
	}

	@Override
	public boolean isSingle() {
		// TODO Auto-generated method stub
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] expr, int matchedPattern, Kleenean arg2, ParseResult arg3) {
		// TODO Auto-generated method stub
		player = (Expression<Player>) expr[0];
		ach = (Expression<Advancement>) expr[1];
		return true;
	}

	@Override
	public String toString(@Nullable Event event, boolean arg1) {
		// TODO Auto-generated method stub
		return "border length of world";
	}

	@Override
	protected Boolean[] get(Event event) {
		return new Boolean[]{player.getSingle(event).getAdvancementProgress(ach.getSingle(event)).isDone()};
	}


}