package dickys.todo.app.repository

import dickys.todo.app.entity.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository: JpaRepository<Task, Int>