---
title: Installation
description: mob-cap-multiplier für Minecraft 1.21.8 mit NeoForge als JAR herunterladen oder selbst bauen, in den mods-Ordner legen und prüfen, ob die Mod geladen wird.
order: 10
section: Einstieg
---

Die Mod wirkt dort, wo die Welt läuft: auf dem Server oder – im Einzelspieler – im Client. Außer NeoForge braucht sie
keine weiteren Mods.

## Voraussetzungen

- Minecraft 1.21.8 mit NeoForge 21.8.33 oder neuer
- Java 21

## JAR herunterladen

Unter [Releases](https://github.com/DasRed/mob-cap-multiplier/releases) liegt die fertige Datei
`mobcapmultiplier-<version>.jar`. Lege sie in den Ordner `mods/` und starte Server oder Spiel neu.

## Selbst bauen

```bash
git clone https://github.com/DasRed/mob-cap-multiplier.git
cd mob-cap-multiplier
./gradlew build
```

Die Datei liegt danach in `build/libs/mobcapmultiplier-<version>.jar`.

## Prüfen

Als Operator im Spiel:

```text
/mcm list
```

Der Befehl zeigt alle Kategorien mit ihrem Faktor, nach der Installation überall `1.0`.
