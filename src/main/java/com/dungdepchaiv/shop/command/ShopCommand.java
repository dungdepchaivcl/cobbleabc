package com.dungdepchaiv.shop.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class ShopCommand {
	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal("shop")
			.executes(ctx -> {
				ServerCommandSource source = ctx.getSource();

				if (source.getEntity() instanceof net.minecraft.entity.player.PlayerEntity player) {
					if (player instanceof net.minecraft.server.network.ServerPlayerEntity serverPlayer) {
						source.sendFeedback(() -> Text.literal("§6§l🛒 Opening Shop...§r"), false);
					}
					return 1;
				}

				return 0;
			}));
	}
}