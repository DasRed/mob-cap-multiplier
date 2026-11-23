---
title: Configuration
description: The factors for all eight Minecraft mob categories in the server config of mob-cap-multiplier, with their vanilla limits and how the mob cap is calculated.
order: 20
slug: configuration
section: Setup
---

The mod has a server configuration. NeoForge creates it when a world starts for the first time, at
`<world>/serverconfig/mobcapmultiplier-server.toml`. Every factor is between `0.0` and `100.0`, the default is `1.0`
(vanilla).

## Factors

| Name                                  | Default | Description                                                       | Vanilla limit |
|---------------------------------------|---------|-------------------------------------------------------------------|---------------|
| `multiplier.monster`                  | `1.0`   | monsters: zombies, skeletons, creepers, spiders, endermen …       | 70            |
| `multiplier.creature`                 | `1.0`   | land animals: cows, sheep, pigs, chickens …                       | 10            |
| `multiplier.ambient`                  | `1.0`   | bats                                                              | 15            |
| `multiplier.axolotls`                 | `1.0`   | axolotls                                                          | 5             |
| `multiplier.undergroundWaterCreature` | `1.0`   | glow squids                                                       | 5             |
| `multiplier.waterCreature`            | `1.0`   | squids and dolphins                                               | 5             |
| `multiplier.waterAmbient`             | `1.0`   | fish: cod, salmon, tropical fish, pufferfish                      | 20            |
| `multiplier.misc`                     | `1.0`   | miscellaneous – does not spawn naturally in vanilla, the factor has no effect | –     |

```toml
[multiplier]
	monster = 2.0
	creature = 1.0
	ambient = 0.0
	axolotls = 1.0
	undergroundWaterCreature = 1.0
	waterCreature = 1.0
	waterAmbient = 0.5
	misc = 1.0
```

With these values twice as many monsters spawn, no bats and half as many fish.

## How it is calculated

The new limit is `vanilla limit × factor`, rounded to a whole number and never below 0. With `1.5`, 70 monsters become
105; with `0.3`, 5 axolotls become 2.

The vanilla limits apply to one player. When several players play far apart, Minecraft scales the limit up for the
additionally loaded chunks as usual – the factor applies to that value as well.

> [!TIP]
> Large factors cost performance: the server has to process every additional entity in every tick. Raise them in small
> steps and keep an eye on the TPS.
