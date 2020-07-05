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
            // Listに追加できるのはTask型だから引数の型をTask型にする
            override fun onItemClick(position: Task) {

                val intent = Intent(this@ListActivity,DetailActivity::class.java)
                intent.putExtra("TODO_NAME", position.name)
                startActivity(intent)
            }

        })


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.addAll(taskList)

        addButton.setOnClickListener {
            var name: String = editText.text.toString()
            save(name)
            val nameTask = Task(name)
            //taskadapterで作った関数addでadapterに変数nametaskを追加する
            adapter.add(nameTask)

        }
    }
    //task adapterに書き込んだ文字を入れるためsaveする
    fun save(name: String) {}
}