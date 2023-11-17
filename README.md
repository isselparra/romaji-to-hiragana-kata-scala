# Romaji to Hiragana Kata

Imagine that you love the japanese culture and you are currently learning japanese. Just for the fun, you decided to
develop a tiny program that transcripts romaji to hiragana.

### Manual Installation
For a manual installation, you require the following:
- Java 17
- sbt

### Using Nix
Instead of a manual installation you an opt for Nix, you require the following:
- Install [Nix](https://nixos.org/download.html)
- Run `nix-shell` in the root of the project. Every required dependency will be installed in the shell.

### Tests
To run the tests:

```sbt test```