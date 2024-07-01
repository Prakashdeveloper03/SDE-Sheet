cmake_minimum_required(VERSION 3.28.3)

project(CodeChecker)

file(GLOB_RECURSE source_files
    "Hashing/**/*.cpp"
    "Searching and Sorting/**/*.cpp"
    "String/**/*.cpp"
)

add_custom_target(check_compile ALL
    COMMENT "Checking compilation of all source files"
)

foreach(source_file ${source_files})
    get_filename_component(file_name ${source_file} NAME_WE)
    add_custom_command(
        TARGET check_compile
        COMMAND ${CMAKE_COMMAND} -E cmake_echo_color --blue "Checking ${source_file}"
        COMMAND ${CMAKE_CXX_COMPILER} ${source_file} -o ${CMAKE_BINARY_DIR}/${file_name}.o -c ${CMAKE_CXX_FLAGS}
        COMMAND ${CMAKE_COMMAND} -E rm -f ${CMAKE_BINARY_DIR}/${file_name}.o
        DEPENDS ${source_file}
        WORKING_DIRECTORY ${CMAKE_SOURCE_DIR}
        COMMENT "Compiling ${source_file}"
    )
endforeach()

find_program(CLANG_FORMAT "clang-format")

if (CLANG_FORMAT)
    add_custom_target(format
        COMMAND ${CLANG_FORMAT} -i -style=Google ${source_files}
        COMMENT "Formatting all source files"
    )
else()
    message(WARNING "clang-format not found!")
endif()