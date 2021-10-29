package dickys.todo.app.helper.validation

import org.springframework.stereotype.Component
import javax.validation.ConstraintViolationException
import javax.validation.Validator

@Component
class ValidationUtil(val validator: Validator) {

    fun validate(any: Any) {
        val violation = validator.validate(any)
        if (violation.size != 0) {
            throw ConstraintViolationException(violation)
        }
    }
}