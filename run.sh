#!/bin/sh
set -e
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
javac -d "$SCRIPT_DIR/target" "$SCRIPT_DIR"/src/main/java/dev/bootcraft/tinygit/*.java
exec java -cp "$SCRIPT_DIR/target" dev.bootcraft.tinygit.Main "$@"
