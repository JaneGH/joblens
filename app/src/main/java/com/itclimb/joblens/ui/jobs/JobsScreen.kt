package com.itclimb.joblens.ui.jobs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.itclimb.joblens.domain.model.Job
import com.itclimb.joblens.ui.theme.JobLensTheme

@Composable
fun JobsRoute(
    onJobClick: (jobId: Long) -> Unit,
    onAddJobClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: JobsViewModel = viewModel { JobsViewModel(fakeJobs()) },
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    JobsScreen(
        uiState = uiState,
        onJobClick = onJobClick,
        onAddJobClick = onAddJobClick,
        modifier = modifier,
    )
}

@Composable
fun JobsScreen(
    uiState: JobsUiState,
    onJobClick: (jobId: Long) -> Unit,
    onAddJobClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxSize()) {
        TextButton(
            onClick = onAddJobClick,
            modifier = Modifier.padding(horizontal = 8.dp),
        ) {
            Text("Add job")
        }
        if (uiState.jobs.isEmpty()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text("No saved jobs")
            }
        } else {
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(
                    items = uiState.jobs,
                    key = { job -> job.id },
                ) { job ->
                    JobRow(
                        job = job,
                        onClick = { onJobClick(job.id) },
                    )
                    HorizontalDivider()
                }
            }
        }
    }
}

@Composable
private fun JobRow(
    job: Job,
    onClick: () -> Unit,
) {
    val details = listOfNotNull(job.company, job.status.name).joinToString(" · ")
    ListItem(
        headlineContent = { Text(job.title ?: "Untitled job") },
        supportingContent = { Text(details) },
        modifier = Modifier.clickable(onClick = onClick),
    )
}

@Preview(showBackground = true)
@Composable
private fun JobsScreenPreview() {
    JobLensTheme {
        JobsScreen(
            uiState = JobsUiState(jobs = fakeJobs()),
            onJobClick = {},
            onAddJobClick = {},
        )
    }
}
