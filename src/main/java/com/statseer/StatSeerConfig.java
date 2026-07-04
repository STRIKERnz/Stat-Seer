package com.statseer;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

@ConfigGroup("statseer")
public interface StatSeerConfig extends Config
{
	@ConfigItem(
		keyName = "hotkey",
		name = "Hotkey",
		description = "Hold this key while hovering an item to show equipment stats"
	)
	default Keybind hotkey()
	{
		return Keybind.NOT_SET;
	}
}
