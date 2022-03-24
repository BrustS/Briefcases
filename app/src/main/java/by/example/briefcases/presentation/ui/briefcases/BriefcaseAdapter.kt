package by.example.briefcases.presentation.ui.briefcases

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.example.briefcases.data.entities.Briefcase
import by.example.briefcases.databinding.BriefcaseItemBinding
import by.example.briefcases.presentation.ui.onItemClickItemListener
class BriefcaseAdapter : RecyclerView.Adapter<BriefcaseViewHolder>() {

    private var briefcases = listOf<Briefcase>()
    private lateinit var clickListener: onItemClickItemListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BriefcaseViewHolder {
        val binding =
            BriefcaseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BriefcaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BriefcaseViewHolder, position: Int) {
        holder.bind(briefcase = briefcases[position])
    }

    override fun getItemCount(): Int {
        return briefcases.size
    }

    fun setData(list: List<Briefcase>) {
        briefcases = list
    }


    fun setOnItemClickListener(listener: onItemClickItemListener) {
        clickListener = listener
    }
}

class BriefcaseViewHolder(private val binding: BriefcaseItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(briefcase: Briefcase) {
        binding.apply {
            vesselTextView.text = briefcase.vessel
            inspectionSourceTextView.text = briefcase.inspectionSource
            inspectionTypeTextView.text = briefcase.inspectionType
            portTextView.text = briefcase.port

        }
    }
}
