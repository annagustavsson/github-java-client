package com.spotify.github.v3;

import static com.google.common.io.Resources.getResource;
import static java.nio.charset.Charset.defaultCharset;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import com.google.common.io.Resources;
import com.spotify.github.jackson.Json;
import com.spotify.github.v3.git.TreeItem;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class TreeItemTest {

  private String fixture;
  public static final void assertTreeItem(final TreeItem treeItem) {
    assertThat(treeItem.path(), is("README.md"));
    assertThat(treeItem.mode(), is("100644"));
    assertThat(treeItem.type(), is("blob"));
    assertThat(treeItem.size(), is(12));
  }

  @Before
  public void setUp() throws Exception {
    fixture = Resources.toString(getResource(this.getClass(), "treeItem.json"), defaultCharset());
  }

  @Test
  public void testDeserialization() throws IOException {
    final TreeItem treeItem = Json.create().fromJson(fixture, TreeItem.class);
    assertTreeItem(treeItem);
  }


}