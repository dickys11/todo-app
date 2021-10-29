package dickys.todo.app.service

import dickys.todo.app.entity.Task
import dickys.todo.app.model.request.CreateTaskRequest
import dickys.todo.app.model.request.ListTaskRequest
import dickys.todo.app.model.response.TaskResponse
import dickys.todo.app.repository.TaskRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.stream.Collectors


@Service
class TaskServiceImpl(val taskRepository: TaskRepository): TaskService {
    override fun create(request: CreateTaskRequest): TaskResponse {
        val task = Task(
            name = request.name,
            description = request.description
        )

        taskRepository.save(task)

        return generateTaskResponse(task)
    }

    override fun list(request: ListTaskRequest): List<TaskResponse> {
        val page = taskRepository.findAll(PageRequest.of(request.page, request.size))

        val tasks: List<Task> = page.get().collect(Collectors.toList())

        return tasks.map { generateTaskResponse(it) }
    }

    private fun generateTaskResponse(task: Task): TaskResponse{
        return TaskResponse(
            id = task.id,
            name = task.name,
            description = task.description
        )
    }
}