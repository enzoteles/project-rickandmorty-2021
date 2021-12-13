package com.example.project_rickandmorty_base.presentation.ui.screen.ui_tests

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.core.app.ApplicationProvider
import coil.annotation.ExperimentalCoilApi
import com.example.project_rickandmorty_base.MainActivity
import com.example.project_rickandmorty_base.R
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

@ExperimentalMaterialApi
@HiltAndroidTest
@UninstallModules(AppModule::class)
class CharacterEndToEndTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @ExperimentalComposeUiApi
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
    fun lookforACharacterInTheAPI(){

        val context = ApplicationProvider.getApplicationContext<Context>()
        val buttonFilter = context.getString(R.string.icon_filter_unselected)

        composeRule.onNodeWithContentDescription(buttonFilter).performClick()

        // insert fields
        composeRule
            .onNodeWithTag(TestTags.BS_NAME_TEXT_FIELD)
            .performTextInput("rick sanchez")

        composeRule
            .onNodeWithTag(TestTags.BS_STATUS_TEXT_FIELD)
            .performTextInput("alive")

        composeRule
            .onNodeWithTag(TestTags.BS_SPECIES_TEXT_FIELD)
            .performTextInput("human")

        composeRule
            .onNodeWithTag(TestTags.BS_TYPE_TEXT_FIELD)
            .performTextInput("parasite")

        composeRule
            .onNodeWithTag(TestTags.BS_GENDER_TEXT_FIELD)
            .performTextInput("male")

        // clean fields
        composeRule.onNodeWithContentDescription("clear name").performClick()
        composeRule.onNodeWithContentDescription("clear status").performClick()
        composeRule.onNodeWithContentDescription("clear species").performClick()
        composeRule.onNodeWithContentDescription("clear type").performClick()
        composeRule.onNodeWithContentDescription("clear gender").performClick()

        // insert fields again
        composeRule
            .onNodeWithTag(TestTags.BS_NAME_TEXT_FIELD)
            .performTextInput("rick sanchez")

        composeRule
            .onNodeWithTag(TestTags.BS_STATUS_TEXT_FIELD)
            .performTextInput("alive")

        composeRule
            .onNodeWithTag(TestTags.BS_SPECIES_TEXT_FIELD)
            .performTextInput("human")

        composeRule
            .onNodeWithTag(TestTags.BS_TYPE_TEXT_FIELD)
            .performTextInput("parasite")

        composeRule
            .onNodeWithTag(TestTags.BS_GENDER_TEXT_FIELD)
            .performTextInput("male")

        //click in button clean filter
        composeRule
            .onNodeWithTag(TestTags.BTN_BOTTOM_SHEET_CHARACTER_CLEAN)
            .performClick()


        // insert fields again
        composeRule
            .onNodeWithTag(TestTags.BS_NAME_TEXT_FIELD)
            .performTextInput("rick sanchez")

        composeRule
            .onNodeWithTag(TestTags.BS_STATUS_TEXT_FIELD)
            .performTextInput("alive")

        composeRule
            .onNodeWithTag(TestTags.BS_SPECIES_TEXT_FIELD)
            .performTextInput("human")

        composeRule
            .onNodeWithTag(TestTags.BS_TYPE_TEXT_FIELD)
            .performTextInput("parasite")

        composeRule
            .onNodeWithTag(TestTags.BS_GENDER_TEXT_FIELD)
            .performTextInput("male")


        //click in filter button
        composeRule
            .onNodeWithTag(TestTags.BTN_BOTTOM_SHEET_CHARACTER_FILTER)
            .performClick()


        //show the character list screen
        composeRule.onNodeWithTag(TestTags.TITLE_LIST_CHARACTER_BAR).assertIsDisplayed()


    }
}