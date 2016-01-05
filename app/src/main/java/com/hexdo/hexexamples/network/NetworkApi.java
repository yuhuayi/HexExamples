package com.hexdo.hexexamples.network;

import com.hexdo.hexexamples.model.GitHubRepositorySearchResults;
import rx.Observable;

import java.util.Map;

/**
 * Created by ttuo on 06/01/15.
 */
public class NetworkApi {

    public static void search(Map<String, String> search) {
        Observable<GitHubRepositorySearchResults> searchResult = HexFactory.getSingleton().search(search);
    }

    public void getRepository(int id) {
        HexFactory.getSingleton().getRepository(id);
    }
}
