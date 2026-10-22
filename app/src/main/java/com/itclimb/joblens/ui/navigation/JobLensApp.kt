package com.itclimb.joblens.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.itclimb.joblens.ui.addjob.AddJobScreen
import com.itclimb.joblens.ui.jobdetails.JobDetailsScreen
import com.itclimb.joblens.ui.jobs.JobsRoute
import com.itclimb.joblens.ui.jobs.fakeJobs
import com.itclimb.joblens.ui.profile.ProfileScreen

@Composable
fun JobLensApp() {
    val backStack = rememberNavBackStack(JobLensDestination.Jobs)
    val currentDestination = backStack.lastOrNull()
    val showTopLevelBar = currentDestination is JobLensDestination.Jobs ||
        currentDestination is JobLensDestination.Profile

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (showTopLevelBar) {
                JobLensTopLevelBar(
                    currentDestination = currentDestination,
                    onJobsClick = { backStack.showTopLevel(JobLensDestination.Jobs) },
                    onProfileClick = { backStack.showTopLevel(JobLensDestination.Profile) },
                )
            }
        },
    ) { innerPadding ->
        NavDisplay(
            backStack = backStack,
            modifier = Modifier.padding(innerPadding),
            onBack = { backStack.removeLastOrNull() },
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator(),
            ),
            entryProvider = entryProvider {
                entry<JobLensDestination.Jobs> {
                    JobsRoute(
                        onJobClick = { jobId ->
                            backStack.add(JobLensDestination.JobDetails(jobId))
                        },
                        onAddJobClick = { backStack.add(JobLensDestination.AddJob) },
                        modifier = Modifier.fillMaxSize(),
                    )
                }
                entry<JobLensDestination.AddJob> {
                    AddJobScreen(
                        onBack = { backStack.removeLastOrNull() },
                        modifier = Modifier.fillMaxSize(),
                    )
                }
                entry<JobLensDestination.JobDetails> { destination ->
                    val job = fakeJobs().find { it.id == destination.jobId }
                    JobDetailsScreen(
                        job = job,
                        onBack = { backStack.removeLastOrNull() },
                        modifier = Modifier.fillMaxSize(),
                    )
                }
                entry<JobLensDestination.Profile> {
                    ProfileScreen(modifier = Modifier.fillMaxSize())
                }
            },
        )
    }
}

@Composable
private fun JobLensTopLevelBar(
    currentDestination: NavKey?,
    onJobsClick: () -> Unit,
    onProfileClick: () -> Unit,
) {
    NavigationBar {
        NavigationBarItem(
            selected = currentDestination is JobLensDestination.Jobs,
            onClick = onJobsClick,
            icon = { Icon(Icons.Filled.Home, contentDescription = null) },
            label = { Text("Jobs") },
        )
        NavigationBarItem(
            selected = currentDestination is JobLensDestination.Profile,
            onClick = onProfileClick,
            icon = { Icon(Icons.Filled.Person, contentDescription = null) },
            label = { Text("Profile") },
        )
    }
}

private fun NavBackStack<NavKey>.showTopLevel(destination: JobLensDestination) {
    if (lastOrNull() == destination) return
    add(destination)
    while (size > 1) {
        removeAt(0)
    }
}
