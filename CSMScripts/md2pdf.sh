#!/bin/bash

# ==============================================================================
# Script Name: md2pdf.sh
# Description: Converts a Markdown file to PDF using Pandoc with robust checks.
# ==============================================================================

# Terminal colors for better readability
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[0;33m'
CYAN='\033[0;36m'
NC='\033[0m' # No Color

# ------------------------------------------------------------------------------
# 1. Pre-flight Checks
# ------------------------------------------------------------------------------

# Check if exactly one argument is passed
if [ "$#" -ne 1 ]; then
    echo -e "${RED}Usage: $0 <input_file.md>${NC}"
    exit 1
fi

INPUT_FILE="$1"
# Extract filename without extension and append .pdf
OUTPUT_FILE="${INPUT_FILE%.*}.pdf"

# Check if the input file exists and is a regular file
if [ ! -f "$INPUT_FILE" ]; then
    echo -e "${RED}Error: Input file '${INPUT_FILE}' does not exist or is not a regular file.${NC}"
    exit 1
fi

# Check if the input file is readable
if [ ! -r "$INPUT_FILE" ]; then
    echo -e "${RED}Error: Permission denied. Cannot read '${INPUT_FILE}'.${NC}"
    exit 1
fi

# Check if Pandoc is installed
if ! command -v pandoc &> /dev/null; then
    echo -e "${RED}Error: 'pandoc' is not installed or not in your PATH.${NC}"
    echo -e "Install it using: sudo apt install pandoc (Debian/Ubuntu) or sudo dnf install pandoc (Fedora)"
    exit 1
fi

# Check if the 'file' utility is installed (needed for post-flight validation)
if ! command -v file &> /dev/null; then
    echo -e "${YELLOW}Warning: 'file' command not found. Final MIME type validation will be skipped.${NC}"
    HAS_FILE_CMD=false
else
    HAS_FILE_CMD=true
fi

# ------------------------------------------------------------------------------
# 2. Conversion Process
# ------------------------------------------------------------------------------

echo -e "${CYAN}Starting conversion of '${INPUT_FILE}'...${NC}"

# Run Pandoc. 
# Note: We specify xelatex as the engine because it handles rich Markdown 
# (like Unicode characters and emojis) much better than standard pdflatex.
pandoc "$INPUT_FILE" -o "$OUTPUT_FILE" --pdf-engine=xelatex -V geometry:margin=1in
PANDOC_EXIT_CODE=$?

# ------------------------------------------------------------------------------
# 3. Post-flight Verifications
# ------------------------------------------------------------------------------

# Verification A: Check Pandoc's exit code
if [ $PANDOC_EXIT_CODE -ne 0 ]; then
    echo -e "${RED}Error: Pandoc failed to convert the file. (Exit Code: $PANDOC_EXIT_CODE)${NC}"
    echo -e "${YELLOW}Hint: Ensure you have a PDF engine installed (e.g., texlive-xetex).${NC}"
    exit 1
fi

# Verification B: Check if output file was actually created
if [ ! -f "$OUTPUT_FILE" ]; then
    echo -e "${RED}Error: Pandoc reported success, but output file '${OUTPUT_FILE}' was not found.${NC}"
    exit 1
fi

# Verification C: Check if output file is empty (0 bytes)
if [ ! -s "$OUTPUT_FILE" ]; then
    echo -e "${RED}Error: The output file '${OUTPUT_FILE}' was created but is empty (0 bytes).${NC}"
    exit 1
fi

# Verification D: Check MIME type to ensure it is genuinely a PDF
if [ "$HAS_FILE_CMD" = true ]; then
    MIME_TYPE=$(file -b --mime-type "$OUTPUT_FILE")
    if [ "$MIME_TYPE" != "application/pdf" ]; then
        echo -e "${RED}Error: Output file is not a valid PDF. Detected MIME type: ${MIME_TYPE}${NC}"
        exit 1
    fi
fi

# ------------------------------------------------------------------------------
# 4. Success
# ------------------------------------------------------------------------------

echo -e "${GREEN}Success! Verified PDF created at: ${OUTPUT_FILE}${NC}"
exit 0