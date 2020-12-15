package com.programming.practice.problems.misc;

import java.util.*;

/**
 * Design an in-memory file system to simulate the following functions:
 *
 * <p>ls: Given a path in string format. If it is a file path, return a list that only contains this
 * file's name. If it is a directory path, return the list of file and directory names in this
 * directory. Your output (file and directory names together) should in lexicographic order.
 *
 * <p>mkdir: Given a directory path that does not exist, you should make a new directory according
 * to the path. If the middle directories in the path don't exist either, you should create them as
 * well. This function has void return type.
 *
 * <p>addContentToFile: Given a file path and file content in string format. If the file doesn't
 * exist, you need to create that file containing given content. If the file already exists, you
 * need to append given content to original content. This function has void return type.
 *
 * <p>readContentFromFile: Given a file path, return its content in string format.
 *
 * <pre>
 * Example:
 *
 * Input:
 * ["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
 * [[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
 *
 * Output:
 * [null,[],null,null,["a"],"hello"]
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/design-in-memory-file-system/">Design In-Memory
 *     File System</a>
 */
public class FileSystem {

  private class Directory {
    public final Map<String, String> files;
    public final Map<String, Directory> dirs;

    Directory() {
      this.files = new HashMap<>();
      this.dirs = new HashMap<>();
    }
  }

  private final Directory parent;

  public FileSystem() {
    this.parent = new Directory();
  }

  public List<String> ls(final String path) {

    Directory currentDirectory = parent;
    if (!path.equals("/")) {
      final String[] directoryPath = path.substring(1).split("\\/");

      for (final String directory : directoryPath) {
        if (currentDirectory.dirs.containsKey(directory)) {
          currentDirectory = currentDirectory.dirs.get(directory);
        } else if (currentDirectory.files.containsKey(directory)) {
          // This condition is introduced when the path contains the file at the end. In such
          // scenario we need to return the file.
          return Arrays.asList(directory);
        }
      }
    }

    final List<String> directoryContents = new ArrayList<>();
    directoryContents.addAll(new ArrayList<>(currentDirectory.files.keySet()));
    directoryContents.addAll(new ArrayList<>(currentDirectory.dirs.keySet()));

    Collections.sort(directoryContents);
    return directoryContents;
  }

  public void mkdir(final String path) {
    final String[] directoryPath = path.substring(1).split("\\/");

    Directory currentDirectory = parent;
    for (final String directory : directoryPath) {
      if (!currentDirectory.dirs.containsKey(directory)) {
        currentDirectory.dirs.put(directory, new Directory());
      }

      currentDirectory = currentDirectory.dirs.get(directory);
    }
  }

  public void addContentToFile(final String filePath, final String content) {
    final String[] directoryPath = filePath.substring(1).split("\\/");

    Directory currentDirectory = parent;
    for (int i = 0; i < directoryPath.length - 1; ++i) {
      currentDirectory = currentDirectory.dirs.get(directoryPath[i]);
    }

    final String fileName = directoryPath[directoryPath.length - 1];

    currentDirectory.files.put(
        fileName, currentDirectory.files.getOrDefault(fileName, "") + content);
  }

  public String readContentFromFile(final String filePath) {
    final String[] directoryPath = filePath.substring(1).split("\\/");

    Directory currentDirectory = parent;
    for (int i = 0; i < directoryPath.length - 1; ++i) {
      currentDirectory = currentDirectory.dirs.get(directoryPath[i]);
    }

    final String fileName = directoryPath[directoryPath.length - 1];
    return currentDirectory.files.get(fileName);
  }
}
