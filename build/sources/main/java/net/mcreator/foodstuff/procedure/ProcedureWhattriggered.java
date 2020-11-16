package net.mcreator.foodstuff.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;

import net.mcreator.foodstuff.ElementsFoodstuff;

@ElementsFoodstuff.ModElement.Tag
public class ProcedureWhattriggered extends ElementsFoodstuff.ModElement {
	public ProcedureWhattriggered(ElementsFoodstuff instance) {
		super(instance, 39);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Whattriggered!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Whattriggered!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Whattriggered!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Whattriggered!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote && world.getMinecraftServer() != null) {
			world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
				@Override
				public String getName() {
					return "";
				}

				@Override
				public boolean canUseCommand(int permission, String command) {
					return true;
				}

				@Override
				public World getEntityWorld() {
					return world;
				}

				@Override
				public MinecraftServer getServer() {
					return world.getMinecraftServer();
				}

				@Override
				public boolean sendCommandFeedback() {
					return false;
				}

				@Override
				public BlockPos getPosition() {
					return new BlockPos((int) x, (int) y, (int) z);
				}

				@Override
				public Vec3d getPositionVector() {
					return new Vec3d(x, y, z);
				}
			}, "give @p written_book 1 0 {pages:[\"{\\\"text\\\":\\\"recipes and more\\\\n\\\\n\\\\nrecipe number 1, bread\\\\n you take dough and put in a straght line\\\\n\\\\nrecipe number 2, dough\\\\nto make it you take flower and mix it with water bottle (wait...)\\\\n\\\\nrecipe number 3, flower (extended edition)\\\"}\",\"{\\\"text\\\":\\\"you take grinders and mix it with wheat, to mace grinders you take some grinding stones and mix it with sand\\\\n(do NOT eat grinding stones, well y'know try)\\\\nto make grinding stones take 5 cobbletones and tadadada!\\\\n\\\\ndoughnut recipe! yay!\\\\ntake 3 dough (what?)\\\\nand try adding chocolate atop\\\"}\",\"{\\\"text\\\":\\\"note - you can eat 'em anytime while acting like overpowerd mario - tuntuntuntuntun\\\\n\\\\nsalted sausage\\\\nyou mix pork and salt (no not the block, powder)\\\\n\\\\npepper sand\\\\nQaA - pepper is a little plant thhat can grow on \\\\u0020\\\\\\\"hoed\\\\\\\" dirt with water\\\"}\",\"{\\\"text\\\":\\\"to make it take the drop from crop and then mix it with salt (don't try eating it...)\\\\n\\\\npizza!1111oneoneone\\\\ntake 3 doughs (wuuuut?) and a sousage and end it with a little on pepper sand \\\\n\\\\nboiled rice! \\\\ntry mixing 8 rice spoons and wix it with water bottle \\\\n\\\\n \\\"}\",\"{\\\"text\\\":\\\"sushi epic1111111oneoneone\\\\nmix 4 spoons of boiled rice, any fish and bamboo rolles wich can be created via filling all 9 \\\\\\\"holes\\\\\\\" with bamboo, a high \\\\\\\"on dirt\\\\\\\" growing....tree...?\\\\n\\\\nso that was some of main recipes, hope it helps \\\"}\"],title:\"recipe  book\",author:\"me (ingenious)\",display:{Lore:[\"thou shall reed da book, u take u make\"]}}");
		}
	}
}
