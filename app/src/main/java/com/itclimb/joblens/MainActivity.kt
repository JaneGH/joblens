package com.itclimb.joblens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.itclimb.joblens.ui.jobs.JobsRoute
import com.itclimb.joblens.ui.theme.JobLensTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JobLensTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    JobsRoute(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
