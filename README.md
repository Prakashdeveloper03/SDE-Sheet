# GeeksforGeeks SDE List

![C++](https://custom-icon-badges.herokuapp.com/badge/C++-9C033A.svg?logo=cpp2&logoColor=white)
![LLVM](https://img.shields.io/badge/LLVM-4D4D4D.svg?logo=LLVM&logoColor=white)
![Fedora](https://img.shields.io/badge/Fedora-51A2DA.svg?logo=Fedora&logoColor=white)
![Vim](https://img.shields.io/badge/Neovim-57A143?logo=Neovim&logoColor=white)

This repository contains GeeksforGeeks SDE list solutions source code in C++ programming language.

## Installation
1. **Clone the repository:**
   ```
   git clone <repository_url>
   cd <repository_directory>
   ```

2. **Create a build directory:**
   ```
   mkdir build
   cd build
   ```

3. **Run CMake to generate build files:**
   ```
   cmake ..
   ```

4. **Build the project:**
   ```
   cmake --build .
   ```

## Usage

### Checking Compilation

To check if all C++ files compile correctly without generating executable files:

```
cmake --build . --target check_compile
```

### Formatting Code

To format all C++ source files using `clang-format`:

```
cmake --build . --target format
```