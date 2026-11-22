# mob-cap-multiplier

NeoForge mod that scales the Minecraft mob cap per category by a factor – twice as many monsters for a mob farm, half
as many fish, or no bats at all. Factors live in the server config and can be changed in game with `/mcm`.

**Documentation:** https://www.marco-starker.de/en/projects/mob-cap-multiplier/docs
(German: https://www.marco-starker.de/de/projekte/mob-cap-multiplier/doku)

## Compatibility

- Minecraft 1.21.8
- NeoForge 21.8.33 or newer
- Java 21

## Status

This mod is **no longer developed**. It works with Minecraft 1.21.8; there are no plans to port it to newer versions.
Forks are welcome.

## Quick start

1. Download `mobcapmultiplier-<version>.jar` from [Releases](https://github.com/DasRed/mob-cap-multiplier/releases) or
   build it with `./gradlew build` (output in `build/libs/`).
2. Put it into the `mods/` folder of the server (or of the client for single player).
3. As an operator in game:

   ```text
   /mcm set monster 2
   /mcm set ambient 0
   /mcm list
   /mcm reset
   ```

Categories: `monster`, `creature`, `ambient`, `axolotls`, `undergroundWaterCreature`, `waterCreature`, `waterAmbient`,
`misc`. Values from `0` (no natural spawning) to `100`, default `1.0` (vanilla). Persistent values go into
`<world>/serverconfig/mobcapmultiplier-server.toml`.

## License

[MIT](LICENSE)
