package com.programming.practice.problems.misc;

import java.util.Arrays;
import java.util.Collections;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link FileSystem}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class FileSystemTest {

  @Test
  public void testScenario1() {
    final FileSystem obj = new FileSystem();
    Assert.assertEquals(Collections.EMPTY_LIST, obj.ls("/"));

    obj.mkdir("/a/b/c");
    obj.addContentToFile("/a/b/c/d", "hello");

    Assert.assertEquals(Arrays.asList("a"), obj.ls("/"));
    Assert.assertEquals("hello", obj.readContentFromFile("/a/b/c/d"));
  }

  @Test
  public void testingScenario2() {
    final FileSystem obj = new FileSystem();
    Assert.assertEquals(Collections.EMPTY_LIST, obj.ls("/"));

    obj.mkdir("/a/b/c");
    obj.addContentToFile("/a/b/c/d", "hello world");

    Assert.assertEquals(Arrays.asList("a"), obj.ls("/"));
    Assert.assertEquals("hello world", obj.readContentFromFile("/a/b/c/d"));

    obj.addContentToFile("/a/b/c/d", "hello hello world");
    Assert.assertEquals("hello worldhello hello world", obj.readContentFromFile("/a/b/c/d"));
  }

  @Test
  public void testingScenario3() {
    final FileSystem obj = new FileSystem();
    Assert.assertEquals(Collections.EMPTY_LIST, obj.ls("/"));

    obj.mkdir("/a/b/c");

    Assert.assertEquals(Arrays.asList("c"), obj.ls("/a/b"));
  }

  @Test
  public void testingScenario4() {
    final FileSystem obj = new FileSystem();
    obj.mkdir("/goowmfn");

    Assert.assertEquals(Arrays.asList("goowmfn"), obj.ls("/"));
    Assert.assertEquals(Collections.EMPTY_LIST, obj.ls("/goowmfn"));

    obj.mkdir("/z");
    Assert.assertEquals(Arrays.asList("goowmfn", "z"), obj.ls("/"));
    Assert.assertEquals(Arrays.asList("goowmfn", "z"), obj.ls("/"));

    obj.addContentToFile("/goowmfn/c", "shetopcy");

    Assert.assertEquals(Collections.EMPTY_LIST, obj.ls("/z"));
    Assert.assertEquals(Arrays.asList("c"), obj.ls("/goowmfn/c"));

    Assert.assertEquals(Arrays.asList("c"), obj.ls("/goowmfn/c"));
  }

  @Test
  public void testingScenario5() {
    final FileSystem obj = new FileSystem();
    obj.addContentToFile("/a", "");
    obj.addContentToFile("/a", "");

    Assert.assertEquals("", obj.readContentFromFile("/a"));
  }
}
