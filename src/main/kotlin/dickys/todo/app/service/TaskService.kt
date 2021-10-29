package dickys.todo.app.service

import dickys.todo.app.model.request.CreateTaskRequest
import dickys.todo.app.model.response.TaskResponse

interface TaskService {

    fun create(request: CreateTaskRequest): TaskResponse
}