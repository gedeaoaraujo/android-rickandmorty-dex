package com.acmelabs.rickandmortydex.presentation.home

sealed interface HomeScreenActions {
    data object OnDialogTryAgain : HomeScreenActions
}