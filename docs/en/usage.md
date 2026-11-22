---
title: Usage
description: Show, change and reset the factors in game with /mobcapmultiplier or the short /mcm.
order: 30
slug: usage
section: Usage
---

Every command comes in two spellings: long as `/mobcapmultiplier` and short as `/mcm`. They need operator permission
level 2 or higher (in single player: cheats enabled).

## Commands

| Command                        | Effect                                                     |
|--------------------------------|------------------------------------------------------------|
| `/mcm list`                    | shows all categories with their factor                      |
| `/mcm get <category>`          | shows the factor of one category                            |
| `/mcm set <category> <value>`  | sets the factor of one category (0 to 100), effective at once |
| `/mcm reset`                   | resets all categories to `1.0` (vanilla)                    |

The categories are named as in the [configuration](configuration.md): `monster`, `creature`, `ambient`, `axolotls`,
`undergroundWaterCreature`, `waterCreature`, `waterAmbient`, `misc`. The tab key completes them.

## Examples

Twice as many monsters, for example while you build a mob farm:

```text
/mcm set monster 2
```

No more bats in caves:

```text
/mcm set ambient 0
```

Everything back to vanilla:

```text
/mcm reset
```

> [!NOTE]
> Mobs that are already there stay. A smaller factor only takes effect once mobs despawn or die and the count drops below
> the limit. Values that should stay in place are best put into the configuration file.
