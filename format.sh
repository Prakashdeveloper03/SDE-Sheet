#!/bin/bash

if [ ! -f "google-java-format-1.22.0-all-deps.jar" ]; then
    echo "google-java-format JAR file not found. Please download it using:"
    exit 1
fi

find . -name "*.java" -print0 | while IFS= read -r -d '' file; do
    echo "Formatting $file"
    java -jar google-java-format-1.22.0-all-deps.jar -i "$file"
done
