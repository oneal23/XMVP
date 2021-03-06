/*
 * Copyright 2016 XuJiaji
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.xujiaji.sample.model;

import android.app.Activity;

import java.util.List;

import io.xujiaji.sample.contract.HomeContract;
import io.xujiaji.sample.model.entity.FileEntity;
import io.xujiaji.sample.util.FileHelper;

/**
 * Created by jiana on 13/12/16.
 */
public class HomeModel implements HomeContract.Model {
    @Override
    public void scanFile(final Activity activity, final FileHelper.Listener<List<FileEntity>> listener) {
        new Thread() {
            @Override
            public void run() {
                final FileHelper fileHelper = new FileHelper();
                fileHelper.unzip(activity, listener);
            }
        }.start();
    }
}
