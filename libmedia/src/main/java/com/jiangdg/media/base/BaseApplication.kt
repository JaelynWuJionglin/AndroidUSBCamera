/*
 * Copyright 2017-2022 Jiangdg
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jiangdg.media.base

import android.app.Application
import com.jiangdg.media.utils.Logger
import com.jiangdg.media.utils.ToastUtils

/** Base Application
 *
 * @author Created by jiangdg on 2022/2/28
 */
open class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Logger.init(this)
        ToastUtils.init(this)
    }
}