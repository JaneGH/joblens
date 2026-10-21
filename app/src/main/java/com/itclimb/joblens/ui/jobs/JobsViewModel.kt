package com.itclimb.joblens.ui.jobs

import androidx.lifecycle.ViewModel
import com.itclimb.joblens.domain.model.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class JobsViewModel(
    jobs: List<Job>,
) : ViewModel() {
    private val _uiState = MutableStateFlow(JobsUiState(jobs = jobs))
    val uiState: StateFlow<JobsUiState> = _uiState.asStateFlow()
}
