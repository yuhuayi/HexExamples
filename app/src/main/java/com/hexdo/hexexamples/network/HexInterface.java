/*
 * Copyright (C) 2015 Drakeet <drakeet.me@gmail.com>
 *
 * This file is part of Meizhi
 *
 * Meizhi is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Meizhi is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Meizhi.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.hexdo.hexexamples.network;

import com.hexdo.hexexamples.model.GitHubRepository;
import com.hexdo.hexexamples.model.GitHubRepositorySearchResults;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.QueryMap;
import rx.Observable;

import java.util.Map;

/**
 * Created by drakeet on 8/9/15.
 */
public interface HexInterface {


    @GET("/search/repositories") Observable<GitHubRepositorySearchResults> search(@QueryMap Map<String, String> search);

    @GET("/repositories/{id}") Observable<GitHubRepository> getRepository(@Path("id") Integer id);

  /*
    ex:  Call<User> call = userService.me();
          User user = call.execute().body();

          @GET("/router?method=UserService.login") Call<ResultWrap<ResposeWrap<UserBean>>> login(@Query("userAccount") String userAccount, @Query("password") String password
            , @Query("androidID") String androidID, @Query("timestamp") String timestamp);

            */


    //           ---   user    end ---//


}
