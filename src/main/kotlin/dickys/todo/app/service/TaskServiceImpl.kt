package dickys.todo.app.service

import dickys.todo.app.entity.Task
import dickys.todo.app.model.request.CreateTaskRequest
import dickys.todo.app.model.response.TaskResponse
import dickys.todo.app.repository.TaskRepository
import org.springframework.stereotype.Service


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

    private fun generateTaskResponse(task: Task): TaskResponse{
        return TaskResponse(
            id = task.id,
            name = task.name,
            description = task.description
        )
    }
}