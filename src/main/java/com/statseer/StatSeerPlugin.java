package com.statseer;

import com.google.inject.Provides;
import java.awt.event.KeyEvent;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.gameval.VarClientID;
import net.runelite.client.config.Keybind;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.KeyListener;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.itemstats.ItemStatConfig;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "Stat Seer",
	description = "Hold a hotkey while hovering items to show equipment stats",
	tags = {"item", "stats", "equipment", "gear", "hover", "compare"}
)
public class StatSeerPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private StatSeerConfig config;

	@Inject
	private KeyManager keyManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private StatSeerOverlay overlay;

	private boolean hotkeyDown;

	private final KeyListener hotkeyListener = new KeyListener()
	{
		@Override
		public void keyTyped(KeyEvent event)
		{
		}

		@Override
		public void keyPressed(KeyEvent event)
		{
			final Keybind hotkey = config.hotkey();
			if (!hotkey.matches(event))
			{
				return;
			}

			if (isTyping())
			{
				hotkeyDown = false;
				return;
			}

			if (hotkeyDown)
			{
				return;
			}

			hotkeyDown = true;
		}

		@Override
		public void keyReleased(KeyEvent event)
		{
			if (config.hotkey().matches(event))
			{
				hotkeyDown = false;
			}
		}

		@Override
		public void focusLost()
		{
			hotkeyDown = false;
		}
	};

	@Override
	protected void startUp()
	{
		keyManager.registerKeyListener(hotkeyListener);
		overlayManager.add(overlay);
		log.debug("Stat Seer started");
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay);
		keyManager.unregisterKeyListener(hotkeyListener);
		hotkeyDown = false;
		log.debug("Stat Seer stopped");
	}

	boolean isInspecting()
	{
		return hotkeyDown;
	}

	private boolean isTyping()
	{
		return client.getFocusedInputFieldWidget() != null
			|| client.getVarcIntValue(VarClientID.WORLDMAP_SEARCHING) != 0;
	}

	@Provides
	StatSeerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(StatSeerConfig.class);
	}

	@Provides
	ItemStatConfig provideItemStatConfig()
	{
		return new ItemStatConfig()
		{
			@Override
			public boolean consumableStats()
			{
				return false;
			}

			@Override
			public boolean equipmentStats()
			{
				return true;
			}

			@Override
			public boolean geStats()
			{
				return false;
			}
		};
	}
}
