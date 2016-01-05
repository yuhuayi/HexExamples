package com.hexdo.hexexamples.model;

import java.util.List;

/**
 * Created by ttuo on 11/01/15.
 */
public class GitHubRepositorySearchResults {
    final private List<GitHubRepository> items;

    public GitHubRepositorySearchResults(final List<GitHubRepository> items) {
        this.items = items;
    }

    public List<GitHubRepository> getItems() {
        return items;
    }
}
