---
title: Overview
description: NeoForge mod that scales the Minecraft mob cap per category by a factor, for more monsters, fewer fish or no bats at all. Compatibility, status and next steps.
order: 0
section: Getting started
---

Minecraft limits how many mobs of a category may spawn naturally around the players at the same time – the
**mob cap**. With a single player that is, for example, 70 monsters, 10 animals and 15 bats. Once the limit is reached,
nothing new spawns until there is room again.

`mob-cap-multiplier` multiplies these limits per category by a factor:

- `2.0` doubles the limit, for example for a more productive mob farm
- `0.5` halves it, for example for a server on weak hardware
- `0` turns off natural spawning of the category completely, for example no more bats

The factors live in the server configuration and can be changed in game with a command – no restart needed. Spawners,
breeding, spawn eggs and commands like `/summon` are not affected; the mod only changes natural spawning.

Together with [minecraft-entity-view](https://www.marco-starker.de/en/projects/minecraft-entity-view) you see live on the
map and in the statistics what a change does.

## Compatibility

| Game                       | Loader                        |
|----------------------------|-------------------------------|
| Minecraft 1.21.8 (exactly) | NeoForge 21.8.33 or newer     |

## Status

> [!IMPORTANT]
> The mod is no longer developed. It works with Minecraft 1.21.8; updates for newer versions are not planned. The code
> stays public – forks are welcome.

## Next

- [Installation](installation.md): build or download the mod
- [Configuration](configuration.md): all categories with their vanilla values
- [Usage](usage.md): commands in game

## Related projects

- [minecraft-api](https://www.marco-starker.de/en/projects/minecraft-api): serves the players, chunks and entities of a
  server as JSON.
- [minecraft-entity-view](https://www.marco-starker.de/en/projects/minecraft-entity-view): live map and statistics of
  all entities.
