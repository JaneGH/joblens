package com.itclimb.joblens.ui.jobs

import com.itclimb.joblens.domain.model.Job

data class JobsUiState(
    val jobs: List<Job> = emptyList(),
)
