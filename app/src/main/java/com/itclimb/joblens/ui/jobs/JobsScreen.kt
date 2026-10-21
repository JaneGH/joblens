package com.itclimb.joblens.ui.jobs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.itclimb.joblens.domain.model.Job
import com.itclimb.joblens.ui.theme.JobLensTheme

@Composable
fun JobsRoute(
    modifier: Modifier = Modifier,
    viewModel: JobsViewModel = viewModel { JobsViewModel(fakeJobs()) },
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    JobsScreen(
        uiState = uiState,
        modifier = modifier,
    )
}

@Composable
fun JobsScreen(
    uiState: JobsUiState,
    modifier: Modifier = Modifier,
) {
    if (uiState.jobs.isEmpty()) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Text("No saved jobs")
        }
    } else {
        LazyColumn(modifier = modifier.fillMaxSize()) {
            items(
                items = uiState.jobs,
                key = { job -> job.id },
            ) { job ->
                JobRow(job)
                HorizontalDivider()
            }
        }
    }
}

@Composable
private fun JobRow(job: Job) {
    val details = listOfNotNull(job.company, job.status.name).joinToString(" · ")
    ListItem(
        headlineContent = { Text(job.title ?: "Untitled job") },
        supportingContent = { Text(details) },
    )
}

@Preview(showBackground = true)
@Composable
private fun JobsScreenPreview() {
    JobLensTheme {
        JobsScreen(uiState = JobsUiState(jobs = fakeJobs()))
    }
}
