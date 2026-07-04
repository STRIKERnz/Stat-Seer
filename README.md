# Stat Seer

Stat Seer is a small RuneLite plugin for quickly checking equipment stats only when you need them.

Set a hotkey, hold it while hovering an equippable item, and Stat Seer shows the equipment stat tooltip using RuneLite's built-in Item Stats overlay. Release the hotkey and the extra tooltip disappears.

## Features

- Hold-to-preview equipment stat bonuses while hovering items
- Compare hovered equipment against your currently equipped gear
- Works with inventory, worn equipment, and supported bank item tooltips
- Reuses RuneLite's Item Stats equipment-tooltip rendering
- Does not consume the hotkey while typing in chat or focused input fields
- Shows equipment stats without needing to keep Item Stats tooltips always enabled

## Setup

1. Install and enable Stat Seer.
2. Open the Stat Seer configuration.
3. Set a hotkey.
4. Hold the hotkey while hovering an equippable item.

## Notes

Stat Seer intentionally does not add a toggle mode. If you want equipment stats visible all the time, RuneLite's built-in Item Stats plugin already covers that use case. Stat Seer is for temporary, on-demand checks.

Stat Seer uses its own hotkey setting and enables the equipment-stat tooltip for its temporary overlay. You do not need to enable RuneLite's Item Stats plugin separately.

## Troubleshooting

If your hotkey does not work, try a different key or key combination. Some keys, especially bare modifier keys like `Alt`, may be intercepted by the operating system, window manager, RuneLite, or another plugin before Stat Seer sees them.

If no equipment tooltip appears, confirm that you are hovering an equippable item and holding the configured hotkey.

## Version history

# Changelog

All notable changes to this project will be documented here

## [1.0 Release]
- Initial release on to plugin hub
