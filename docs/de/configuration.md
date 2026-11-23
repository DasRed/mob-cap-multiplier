---
title: Konfiguration
description: Die Faktoren für alle acht Mob-Kategorien von Minecraft in der Server-Konfiguration von mob-cap-multiplier, mit Vanilla-Grenzen und der Berechnung des Mob-Caps.
order: 20
slug: konfiguration
section: Einrichtung
---

Die Mod hat eine Server-Konfiguration. NeoForge legt sie beim ersten Start einer Welt an unter
`<welt>/serverconfig/mobcapmultiplier-server.toml`. Jeder Faktor liegt zwischen `0.0` und `100.0`, Standard ist `1.0`
(Vanilla).

## Faktoren

| Name                                  | Standard | Beschreibung                                                     | Vanilla-Grenze |
|---------------------------------------|----------|------------------------------------------------------------------|----------------|
| `multiplier.monster`                  | `1.0`    | Monster: Zombies, Skelette, Creeper, Spinnen, Endermen …         | 70             |
| `multiplier.creature`                 | `1.0`    | Tiere an Land: Kühe, Schafe, Schweine, Hühner …                  | 10             |
| `multiplier.ambient`                  | `1.0`    | Fledermäuse                                                      | 15             |
| `multiplier.axolotls`                 | `1.0`    | Axolotl                                                          | 5              |
| `multiplier.undergroundWaterCreature` | `1.0`    | Leuchttintenfische                                               | 5              |
| `multiplier.waterCreature`            | `1.0`    | Tintenfische und Delfine                                         | 5              |
| `multiplier.waterAmbient`             | `1.0`    | Fische: Kabeljau, Lachs, Tropenfische, Kugelfische               | 20             |
| `multiplier.misc`                     | `1.0`    | Sonstiges – spawnt in Vanilla nicht natürlich, der Faktor hat keine Wirkung | –    |

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

Mit diesen Werten spawnen doppelt so viele Monster, keine Fledermäuse und halb so viele Fische.

## So wird gerechnet

Die neue Grenze ist `Vanilla-Grenze × Faktor`, auf eine ganze Zahl gerundet und nie kleiner als 0. Aus 70 Monstern
werden mit `1.5` also 105, aus 5 Axolotln mit `0.3` gerundet 2.

Die Vanilla-Grenzen gelten für einen Spieler. Spielen mehrere Spieler weit auseinander, rechnet Minecraft die Grenze
wie gewohnt für die zusätzlich geladenen Chunks hoch – der Faktor wirkt auf diesen Wert mit.

> [!TIP]
> Große Faktoren kosten Leistung: Jede zusätzliche Entity muss der Server in jedem Tick berechnen. Erhöhe in kleinen
> Schritten und beobachte die TPS.
