package com.itclimb.joblens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.itclimb.joblens.ui.navigation.JobLensApp
import com.itclimb.joblens.ui.theme.JobLensTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JobLensTheme {
                JobLensApp()
            }
        }
    }
}
