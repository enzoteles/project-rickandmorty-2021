package com.example.project_rickandmorty_base.presentation.ui.screen

sealed class Screen(val route:String){
    object ListCharactersScreen: Screen(route = "list_characters_screen")
    object CharacterDetailScreen: Screen(route = "detail_character_screen")
    object FilterCharacterBottomSheetScreen: Screen(route = "filter_character_bottom_sheet_screen")
}
