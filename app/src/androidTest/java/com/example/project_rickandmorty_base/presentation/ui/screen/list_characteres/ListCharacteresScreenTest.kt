package com.example.project_rickandmorty_base.presentation.ui.screen.list_characteres

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import coil.annotation.ExperimentalCoilApi
import com.example.project_rickandmorty_base.MainActivity
import com.example.project_rickandmorty_base.commons.utils.TestTags
import com.example.project_rickandmorty_base.presentation.di.AppModule
import com.example.project_rickandmorty_base.presentation.ui.screen.MainNavGraph
import com.example.projeto_marvel.presentation.ui.theme.ProjetoRickAndMorkTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(AppModule::class)
class ListCharacteresScreenTest{

    @get:Rule (order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule (order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @ExperimentalCoilApi
    @ExperimentalFoundationApi
    @Before
    fun setup(){
        hiltRule.inject()
        composeRule.setContent {
            ProjetoRickAndMorkTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainNavGraph()
                }
            }
        }
    }


    @Test
    fun textTopBar(){
        composeRule.onNodeWithTag(TestTags.TITLE_LIST_CHARACTER_BAR).assertIsDisplayed()
    }

    @ExperimentalCoilApi
    @ExperimentalFoundationApi
    @Test
    fun testItemClick() {
        composeRule.onNodeWithTag(TestTags.CHARACTER_ITEM_SELECTED).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.CHARACTER_ITEM_SELECTED).performClick()
    }
}