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

package com.example.android.architecture.blueprints.todoapp.taskdetail;

import com.example.android.architecture.blueprints.todoapp.BasePresenter;
import com.example.android.architecture.blueprints.todoapp.BaseView;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface TaskDetailContract {

    interface View extends BaseView<Presenter> {
        /**
         * 设置数据加载状态
         *
         * @param active true 正在加载 false 没有加载
         */
        void setLoadingIndicator(boolean active);

        /**
         * 处理加载失败情况
         */
        void showMissingTask();

        /**
         * 隐藏待办事项Title
         */
        void hideTitle();

        /**
         * 显示待办事项Title
         *
         * @param title TO DO Title
         */
        void showTitle(String title);

        /**
         * 隐藏详情描述
         */
        void hideDescription();

        /**
         * 显示详情描述
         *
         * @param description 详细描述的内容
         */
        void showDescription(String description);

        /**
         * 显示完成的状态
         *
         * @param complete true 完成 false 未完成
         */
        void showCompletionStatus(boolean complete);

        /**
         * 显示编辑页面任务
         *
         * @param taskId 任务Id
         */
        void showEditTask(String taskId);

        /**
         * 显示删除页面任务
         */
        void showTaskDeleted();

        /**
         * 当TODO列表中的条目 checkBox 从true到false 时调用
         */
        void showTaskMarkedComplete();

        /**
         * 显示TODO条目 checkBox 从false 到 true 时调用
         */
        void showTaskMarkedActive();

        /**
         * 当前活跃状态
         *
         * @return true 活跃 false 销亡
         */
        boolean isActive();
    }

    interface Presenter extends BasePresenter {
        /**
         * 编辑当前的Task
         */
        void editTask();

        /**
         * 删除当前Task
         */
        void deleteTask();

        /**
         * 将当前Task设置为完成的状态
         */
        void completeTask();

        /**
         * 将当前的Task设置为活跃的状态
         */
        void activateTask();
    }
}
