package by.example.briefcases.presentation.ui.briefcases

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import by.example.briefcases.data.entities.Briefcase
import by.example.briefcases.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BriefcaseViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    val briefcases: LiveData<List<Briefcase>>
    init {
        briefcases = repository.getAllBriefcases()
    }

}