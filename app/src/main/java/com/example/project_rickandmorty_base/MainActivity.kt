package com.example.project_rickandmorty_base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import coil.annotation.ExperimentalCoilApi
import com.example.project_rickandmorty_base.presentation.ui.screen.MainNavGraph
import com.example.projeto_marvel.presentation.ui.theme.ProjetoRickAndMorkTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: ComponentActivity() {

    @ExperimentalMaterialApi
    @ExperimentalCoilApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjetoRickAndMorkTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainNavGraph()
                }
            }
        }
    }
}





