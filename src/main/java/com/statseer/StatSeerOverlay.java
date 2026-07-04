package com.statseer;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.client.plugins.itemstats.ItemStatOverlay;

class StatSeerOverlay extends ItemStatOverlay
{
	@Inject
	private StatSeerPlugin plugin;

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInspecting())
		{
			return null;
		}

		return super.render(graphics);
	}
}
