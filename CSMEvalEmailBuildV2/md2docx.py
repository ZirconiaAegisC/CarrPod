#!/usr/bin/env python3
import os
import sys
import shutil
import subprocess

# Define the source formats you want to check for
SUPPORTED_EXTENSIONS = ('.md', '.txt')

def check_dependencies():
    """Ensure pandoc is installed and accessible."""
    if shutil.which("pandoc") is None:
        print("Error: 'pandoc' is not installed or not in your system's PATH.")
        print("You can install it on macOS using Homebrew by running: brew install pandoc")
        sys.exit(1)

def compile_to_docx(root_dir):
    # Recursively walk through directories
    for dirpath, dirnames, filenames in os.walk(root_dir):
        for file in filenames:
            # Check if file is a supported source document
            if file.endswith(SUPPORTED_EXTENSIONS):
                base_name, _ = os.path.splitext(file)
                docx_name = f"{base_name}.docx"
                
                source_path = os.path.join(dirpath, file)
                docx_path = os.path.join(dirpath, docx_name)
                
                # Check if the docx file already exists
                if not os.path.exists(docx_path):
                    print(f"Creating: {docx_path}")
                    # Construct the Pandoc command
                    command = ['pandoc', source_path, '-o', docx_path]
                    
                    # Run Pandoc
                    try:
                        subprocess.run(command, check=True)
                    except subprocess.CalledProcessError as e:
                        print(f"Error converting {file}: {e}")
                else:
                    print(f"Skipping (already exists): {docx_path}")

if __name__ == "__main__":
    # Check if Pandoc is installed before trying to run it
    check_dependencies()
    
    # Allow passing a target directory via the command line, default to current directory ('.')
    target_directory = sys.argv[1] if len(sys.argv) > 1 else '.'
    
    print(f"Starting recursive Pandoc document generation in: '{target_directory}'...")
    compile_to_docx(target_directory)
    print("Done!")