---
title: Verwendung
description: Faktoren im laufenden Spiel mit /mobcapmultiplier oder kurz /mcm anzeigen, ändern und zurücksetzen.
order: 30
slug: verwendung
section: Benutzung
---

Alle Befehle gibt es in zwei Schreibweisen: lang als `/mobcapmultiplier` und kurz als `/mcm`. Sie brauchen
Operator-Rechte ab Stufe 2 (im Einzelspieler: Cheats aktiviert).

## Befehle

| Befehl                         | Wirkung                                                    |
|--------------------------------|------------------------------------------------------------|
| `/mcm list`                    | zeigt alle Kategorien mit ihrem Faktor                      |
| `/mcm get <kategorie>`         | zeigt den Faktor einer Kategorie                            |
| `/mcm set <kategorie> <wert>`  | setzt den Faktor einer Kategorie (0 bis 100), sofort wirksam |
| `/mcm reset`                   | setzt alle Kategorien auf `1.0` (Vanilla) zurück             |

Die Kategorien heißen wie in der [Konfiguration](configuration.md): `monster`, `creature`, `ambient`, `axolotls`,
`undergroundWaterCreature`, `waterCreature`, `waterAmbient`, `misc`. Die Tab-Taste vervollständigt sie.

## Beispiele

Doppelt so viele Monster, etwa während du an einer Mobfarm baust:

```text
/mcm set monster 2
```

Keine Fledermäuse mehr in Höhlen:

```text
/mcm set ambient 0
```

Alles zurück auf Vanilla:

```text
/mcm reset
```

> [!NOTE]
> Mobs, die schon da sind, bleiben stehen. Ein kleinerer Faktor wirkt erst, wenn Mobs despawnen oder sterben und die
> Grenze unterschritten wird. Werte, die dauerhaft gelten sollen, trägst du am besten in die Konfigurationsdatei ein.
