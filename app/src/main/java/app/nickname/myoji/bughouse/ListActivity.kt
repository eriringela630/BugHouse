package app.nickname.myoji.bughouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {
    private val taskList: List<Task> = listOf(
        Task("Task 1"),
        Task("Task 2"),
        Task("Task 3")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val adapter = TaskAdapter(this, object : TaskAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {

                val intent = Intent(this@ListActivity,DetailActivity::class.java)
                intent.putExtra("TODO_NAME", taskList[position].name)
                startActivity(intent)
            }

        })


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.addAll(taskList)

//        fun toTask(name:Task) {
//            val addname: Task = name
//        }

        addButton.setOnClickListener {
            val name: String = editText.text.toString()
            val todoname:Task = toTask(addname)
            save(todoname)
            adapter.add(todoname)

        }


    }


    fun toTask(name:String) Task {
            val addname: Task = Task(name)
            return addname
    }


    fun save(name: Task) {

    }
}
