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

package com.example.android.architecture.blueprints.todoapp.data.source;

import android.support.annotation.NonNull;

import com.example.android.architecture.blueprints.todoapp.data.Task;

import java.util.List;

/**
 * Main entry point for accessing tasks data.
 * <p>
 * For simplicity, only getTasks() and getTask() have callbacks. Consider adding callbacks to other
 * methods to inform the user of network/database errors or successful operations.
 * For example, when a new task is created, it's synchronously stored in cache but usually every
 * operation on database or network should be executed in a different thread.
 */
public interface TasksDataSource {

    interface LoadTasksCallback {

        void onTasksLoaded(List<Task> tasks);

        void onDataNotAvailable();
    }

    interface GetTaskCallback {

        void onTaskLoaded(Task task);

        void onDataNotAvailable();
    }

    /**
     * 从对应的数据源（本地或者服务器）中获取所有数据的方法
     *
     * @param callback 获取数据的之后的回调接口
     */
    void getTasks(@NonNull LoadTasksCallback callback);

    /**
     * 从对应的数据源（本地或者服务器）中获取指定 taskId 数据的方法
     *
     * @param taskId   指定数据的 taskId
     * @param callback 获取数据之后的回调接口
     */
    void getTask(@NonNull String taskId, @NonNull GetTaskCallback callback);

    /**
     * 保存数据的方法
     *
     * @param task
     */
    void saveTask(@NonNull Task task);

    /**
     * 将task的状态设置为 complete
     *
     * @param task
     */
    void completeTask(@NonNull Task task);

    /**
     * 将 id 为 taskId 的task的状态设置为 completed
     *
     * @param taskId
     */
    void completeTask(@NonNull String taskId);

    /**
     * 将task的状态设置为 active
     *
     * @param task
     */
    void activateTask(@NonNull Task task);

    /**
     * 将 id 为 taskId 的task的状态设置为 active
     *
     * @param taskId
     */
    void activateTask(@NonNull String taskId);

    /**
     * 清除所有状态值为 completed 的task
     */
    void clearCompletedTasks();

    /**
     * 刷新
     */
    void refreshTasks();

    /**
     * 删除所有task
     */
    void deleteAllTasks();

    /**
     * 删除制定 taskId 的task
     *
     * @param taskId
     */
    void deleteTask(@NonNull String taskId);
}
