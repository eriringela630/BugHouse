package app.nickname.myoji.bughouse

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(
    private val context: Context,
    private val itemClickListener: ItemClickListener
) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
    val items: MutableList<Task> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_task_cell, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.nameTextView.setOnClickListener {
            itemClickListener.onItemClick(position)
        }
        holder.nameTextView.text = item.name

    }
    //これは最初からList<Task>をrecyclerviewに追加するための関数
    fun addAll(items: List<Task>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }
    //add buttonを押したときに書いた文字だけを追加する関数
    fun add(todoname: Task){
        this.items.add(todoname)
        notifyDataSetChanged()
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val container: View = view.findViewById(R.id.container)
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
    }

    interface ItemClickListener {
        fun onItemClick(position: Int)

    }
}