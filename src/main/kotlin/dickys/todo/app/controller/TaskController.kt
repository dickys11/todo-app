package dickys.todo.app.controller

import dickys.todo.app.model.WebResponse
import dickys.todo.app.model.request.CreateTaskRequest
import dickys.todo.app.model.response.TaskResponse
import dickys.todo.app.service.TaskService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TaskController(val taskService: TaskService) {

    @PostMapping(
        value = ["/api/task"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createTask(
        @RequestBody createTaskRequest: CreateTaskRequest
    ): WebResponse<TaskResponse>{
        val taskResponse = taskService.create(createTaskRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = taskResponse
        )
    }
}