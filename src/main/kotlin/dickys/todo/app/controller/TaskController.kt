package dickys.todo.app.controller

import dickys.todo.app.model.WebResponse
import dickys.todo.app.model.request.CreateTaskRequest
import dickys.todo.app.model.request.ListTaskRequest
import dickys.todo.app.model.response.TaskResponse
import dickys.todo.app.service.TaskService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

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

    @GetMapping(
        value = ["/api/task"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun listTask(
        @RequestParam(value = "size", defaultValue = "10") size: Int,
        @RequestParam(value = "page", defaultValue = "0") page: Int
    ): WebResponse<List<TaskResponse>> {
        val request = ListTaskRequest(page = page, size = size)
        val tasksResponse = taskService.list(request)

        return WebResponse(
            code = 200,
            status = "OK",
            data = tasksResponse
        )
    }
}