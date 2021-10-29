package dickys.todo.app.model.request

import javax.validation.constraints.NotBlank

data class UpdateTaskRequest(

    @field:NotBlank
    val name: String?,

    val description: String?
)
