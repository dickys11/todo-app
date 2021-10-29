package dickys.todo.app.service

import dickys.todo.app.model.request.CreateTaskRequest
import dickys.todo.app.model.request.ListTaskRequest
import dickys.todo.app.model.response.TaskResponse

interface TaskService {

    fun create(request: CreateTaskRequest): TaskResponse

    fun list(request: ListTaskRequest): List<TaskResponse>

    fun get(id: Int): TaskResponse
}