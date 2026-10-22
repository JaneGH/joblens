package com.itclimb.joblens.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface JobLensDestination : NavKey {
    @Serializable
    data object Jobs : JobLensDestination

    @Serializable
    data object AddJob : JobLensDestination

    @Serializable
    data class JobDetails(val jobId: Long) : JobLensDestination

    @Serializable
    data object Profile : JobLensDestination
}
