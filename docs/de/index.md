---
title: Überblick
description: NeoForge-Mod, die das Mob-Cap von Minecraft je Kategorie mit einem Faktor verändert – mehr Monster, weniger Fische oder gar keine Fledermäuse.
order: 0
section: Einstieg
---

Minecraft begrenzt, wie viele Mobs einer Kategorie gleichzeitig um die Spieler herum natürlich spawnen dürfen – das
**Mob-Cap**. Bei einem einzelnen Spieler sind das zum Beispiel 70 Monster, 10 Tiere und 15 Fledermäuse. Ist die Grenze
erreicht, spawnt nichts mehr nach, bis wieder Platz ist.

`mob-cap-multiplier` multipliziert diese Grenzen je Kategorie mit einem Faktor:

- `2.0` verdoppelt die Grenze, etwa für eine ergiebigere Mobfarm
- `0.5` halbiert sie, etwa für einen Server mit schwacher Hardware
- `0` schaltet das natürliche Spawnen der Kategorie ganz ab, zum Beispiel keine Fledermäuse mehr

Die Faktoren stehen in der Server-Konfiguration und lassen sich im laufenden Spiel per Befehl ändern – ohne Neustart.
Spawner, Züchten, Spawn-Eier und Befehle wie `/summon` bleiben unberührt; die Mod verändert nur das natürliche Spawnen.

Zusammen mit [minecraft-entity-view](https://www.marco-starker.de/de/projekte/minecraft-entity-view) siehst du live auf
der Karte und in der Statistik, wie sich eine Änderung auswirkt.

## Kompatibilität

| Spiel                    | Loader                        |
|--------------------------|-------------------------------|
| Minecraft 1.21.8 (genau) | NeoForge 21.8.33 oder neuer   |

## Status

> [!IMPORTANT]
> Die Mod wird nicht mehr weiterentwickelt. Sie funktioniert mit Minecraft 1.21.8, Anpassungen an neuere Versionen
> sind nicht geplant. Der Code bleibt öffentlich – Forks sind willkommen.

## Weiter

- [Installation](installation.md): Mod bauen oder herunterladen
- [Konfiguration](configuration.md): alle Kategorien mit ihren Vanilla-Werten
- [Verwendung](usage.md): Befehle im Spiel

## Verwandte Projekte

- [minecraft-api](https://www.marco-starker.de/de/projekte/minecraft-api): liefert Spieler, Chunks und Entities eines
  Servers als JSON.
- [minecraft-entity-view](https://www.marco-starker.de/de/projekte/minecraft-entity-view): Live-Karte und Statistik
  aller Entities.
