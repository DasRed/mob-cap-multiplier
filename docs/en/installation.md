---
title: Installation
description: Download mob-cap-multiplier as a JAR or build it yourself and put it into the mods folder.
order: 10
section: Getting started
---

The mod takes effect where the world runs: on the server or – in single player – in the client. It needs no other mods
besides NeoForge.

## Requirements

- Minecraft 1.21.8 with NeoForge 21.8.33 or newer
- Java 21

## Download the JAR

[Releases](https://github.com/DasRed/mob-cap-multiplier/releases) has the ready-made file
`mobcapmultiplier-<version>.jar`. Put it into the `mods/` folder and restart the server or the game.

## Build it yourself

```bash
git clone https://github.com/DasRed/mob-cap-multiplier.git
cd mob-cap-multiplier
./gradlew build
```

The file is then in `build/libs/mobcapmultiplier-<version>.jar`.

## Check

As an operator in game:

```text
/mcm list
```

The command shows all categories with their factor, `1.0` everywhere after installation.
