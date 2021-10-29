package dickys.todo.app.model.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CreateTaskRequest(

    @field:NotBlank
    val name: String?,

    val description: String?
)