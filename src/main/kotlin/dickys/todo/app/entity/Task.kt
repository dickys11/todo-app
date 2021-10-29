package dickys.todo.app.entity

import javax.persistence.*

@Entity
@Table(name = "task")
data class Task(

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id : Int? = null,

    @Column(name = "task_name")
    var name : String?,

    @Column(name = "task_description")
    var description: String? = null,

)
