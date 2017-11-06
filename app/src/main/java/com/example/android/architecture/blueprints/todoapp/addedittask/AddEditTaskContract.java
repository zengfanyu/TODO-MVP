/*
 * Copyright 2016, The Android Open Source Project
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

package com.example.android.architecture.blueprints.todoapp.addedittask;

import com.example.android.architecture.blueprints.todoapp.BasePresenter;
import com.example.android.architecture.blueprints.todoapp.BaseView;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface AddEditTaskContract {

    interface View extends BaseView<Presenter> {
        /**
         * 既没有填写title也没有填写desc时,点击fab回调
         */
        void showEmptyTaskError();

        /**
         * 结束此页面,回到 Task 展示页面中 的回调
         */
        void showTasksList();

        /**
         * 设置Title内容的回调
         *
         * @param title title
         */
        void setTitle(String title);

        /**
         * 展示Desc的回调
         *
         * @param description desx
         */
        void setDescription(String description);

        /**
         * 判断Fragment当前状态的回调
         * @return true fragment被添加到activity上  false 没有在Activity上了
         */
        boolean isActive();
    }

    interface Presenter extends BasePresenter {
        /**
         * 保存或更新当前Task的回调
         * @param title title
         * @param description desc
         */
        void saveTask(String title, String description);

        void populateTask();

        /**
         * Task数据是否丢失的回调
         * @return
         */
        boolean isDataMissing();
    }
}
