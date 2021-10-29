package dickys.todo.app.model.request

data class CreateTaskRequest(

    val name: String,

    val description: String?
)