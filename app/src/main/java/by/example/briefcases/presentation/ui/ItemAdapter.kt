package by.example.briefcases.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.example.briefcases.databinding.ListItemImageAndTextBinding

class ItemsAdapter(
private val imageResource: Int,
) : RecyclerView.Adapter<MyViewHolder>() {

    private var list = emptyList<String>()
    private lateinit var clickListener: onItemClickItemListener


    fun setOnItemClickListener(listener: onItemClickItemListener) {
        clickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ListItemImageAndTextBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position], imageResource)
    }

    override fun getItemCount() = list.size

    internal fun setListData(newList: List<String>) {
        this.list = newList
        notifyDataSetChanged()
    }
}

class MyViewHolder(
    private val binding: ListItemImageAndTextBinding,
    listener: onItemClickItemListener
) : RecyclerView.ViewHolder(binding.root) {
    init {
        itemView.setOnClickListener {
            listener.onItemClick(absoluteAdapterPosition)
        }
    }

    fun bind(item: String, imageResource: Int) {
        binding.listItemTextView.text = item
        binding.ImageListItem.setImageResource(imageResource)
    }
}

interface onItemClickItemListener {
    fun onItemClick(absoluteAdapterPosition: Int)
}
